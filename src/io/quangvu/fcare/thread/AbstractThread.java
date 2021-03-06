
package io.quangvu.fcare.thread;

import java.text.DateFormat;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.text.BadLocationException;

import io.quangvu.fcare.counter.CloneCareCampaignCounter;
import io.quangvu.fcare.helper.NumberHelper;

public abstract class AbstractThread implements Runnable {
	
	protected Thread thread;
	protected String name;
	protected boolean suspended = false;
	protected boolean isStop = false; 

	protected JProgressBar progressBar;
	protected JEditorPane editorPane;
	
	protected CloneCareCampaignCounter counter;
	protected int limitJobs = 0;
	protected ThreadMonitor monitor;
	
	public AbstractThread(String name, JProgressBar bar, JEditorPane editor, CloneCareCampaignCounter counter, int limitJobs) {
		this.name = name;
		this.limitJobs = limitJobs;
		this.progressBar = bar;
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(this.limitJobs);
		this.editorPane = editor;
		this.counter = counter;
		this.monitor = monitor;
//		System.out.println("Creating " + name);
	}
	
	public void run() {
		System.out.println("Running " + this.name);
		int minimum = this.progressBar.getMinimum();
		int maximum = this.progressBar.getMaximum();
		do {
			try {
				synchronized (this) {
					while (this.suspended) {
						this.wait();
					}
					// main job
					this.care();
				}
			} catch(InterruptedException interruped) {
				interruped.printStackTrace();
				continue;
			} catch (BadLocationException e) {
				e.printStackTrace();
				continue;
			} 
		} while (this.counter.getValue() <= this.limitJobs);
	}

	public void care() throws InterruptedException, BadLocationException {
		System.out.println("Non implement method from AbstractThread");
	}
	
	public void start() {		
		if (this.thread == null) {
			this.thread = new Thread(this, name);
			this.thread.start();
		}
		System.out.println(this.name + " started");
//		this.counter.setValue(this.counter.getValue());
//		this.progressBar.setValue(this.progressBar.getValue());
////		this.editorPane.setText("");
	}

	public void stop() {
		this.suspended = true;
		this.thread = null;
//		try {
//			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " stopped.",
//					null);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		System.out.println(this.name + " stopped.");
		
		this.isStop = true;
	}

	public void suspend() {
		
		this.suspended = true;
//		try {
//			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(),
//					"\n" + this.name + " this.suppended", null);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		System.out.println(this.name + " paused.");
	}

	public synchronized void resume() {
		
		this.suspended = false;
		this.notify();
//		try {
//			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " resumed.",
//					null);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		System.out.println(this.name + " resumed.");
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isStop() {
		return this.isStop;
	}
}
