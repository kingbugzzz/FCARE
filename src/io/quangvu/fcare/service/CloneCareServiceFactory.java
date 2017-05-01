package io.quangvu.fcare.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.text.BadLocationException;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

import io.quangvu.fcare.counter.CloneCareCampaignCounter;
import io.quangvu.fcare.helper.NumberHelper;

public class CloneCareServiceFactory implements Runnable {

	private Thread t;
	private String threadName;
	boolean suspended = false;

	JProgressBar progressBar;
	JEditorPane editorPane;
	private DateFormat dateFormat;

	private CloneCareCampaignCounter counter;
	private int limitJob = 110;

	public CloneCareServiceFactory(String name, JProgressBar bar, JEditorPane editor, CloneCareCampaignCounter counter) {
		threadName = name;
		progressBar = bar;
		progressBar.setMinimum(0);
		progressBar.setMaximum(limitJob);
		editorPane = editor;
		this.counter = counter;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		int minimum = progressBar.getMinimum();
		int maximum = progressBar.getMaximum();
		
		// for (int i = minimum; i <= maximum; i++) {
		do {
			try {
				synchronized (this) {
					while (suspended) {
						wait();
					}
					
					care();
				}
			} catch(InterruptedException interruped) {
				interruped.printStackTrace();
				continue;
			} catch (BadLocationException e) {
				e.printStackTrace();
				continue;
			} 
		} while (counter.getValue() <= limitJob);

		System.out.println("Thread " + threadName + " exiting.");
		try {
			stop();
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
					"\n" + threadName + " finished.", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void care() throws BadLocationException, InterruptedException {
		System.out.println(threadName + " > raised JOBS: " + counter.getValue());
		editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
				threadName + " > raised JOBS: " + counter.getValue() + "\n", null);
		
		counter.count();
		Thread.sleep(NumberHelper.getRandomInt(3000, 1000));
		
		// update progress bar
		progressBar.setValue(counter.getValue());
	}
	
	public void start() {
		counter.setValue(0);
		progressBar.setValue(0);
		editorPane.setText("");
		System.out.println("Starting " + threadName);

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public void stop() {
		System.out.println(threadName + " is stopping...");
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
					"\n" + threadName + " is stopping", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		suspended = true;
		t = null;
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\n" + threadName + " stopped.",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(threadName + " stopped.");
	}

	public void suspend() {
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
					"\n" + threadName + " is suppending...", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		suspended = true;
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
					"\n" + threadName + " suppended", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized void resume() {
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(),
					"\n" + threadName + " is resuming...", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		suspended = false;
		notify();
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\n" + threadName + " resumed.",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}