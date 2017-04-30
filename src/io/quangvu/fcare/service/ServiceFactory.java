package io.quangvu.fcare.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;

import io.quangvu.fcare.helper.NumberHelper;

public class ServiceFactory implements Runnable {

	public Thread t;
	private String threadName;
	boolean suspended = false;

	private int cursor = 0;

	JProgressBar progressBar;
	JEditorPane editorPane;
	private DateFormat dateFormat;

	public ServiceFactory(String name, JProgressBar bar, JEditorPane editor) {
		threadName = name;
		progressBar = bar;
		editorPane = editor;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		int minimum = progressBar.getMinimum();
		int maximum = progressBar.getMaximum();
		
		for (int i = minimum; i < maximum; i++) {
			try {
				
				doSomething();
				synchronized (this) {
					while (suspended) {
						wait();
					}
				}
			} catch (Exception ignoredException) {
				continue;
			}
			try {
				if (cursor == progressBar.getMaximum()) {
					suspend();
					editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\ndone!", null);
					break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		cursor = 0;
		progressBar.setValue(0);
		editorPane.setText("");
		
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public void suspend() {
		System.out.println("suppending...");
		suspended = true;
	}

	public synchronized void resume() {
		suspended = false;
		System.out.println("resuming...");
		notify();
	}

	private void doSomething() {
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date now = new Date();
		String[] actions = { "share 1 bài từ", "like page", "like", "join group", "comment trên" };

		String[] uid = { "<100016395071313>", "<100016405390227>", "<100016383018168>", "<100016414809043>",
				"<100016431217027>", "<100016395071313>", "<100016405390227>", "<100016383018168>", "<100016414809043>",
				"<100016431217027>", };

		String[] targets = { "<100016413638900>", "<100016446425687>", "<100016379538528>", "<100016493281550>",
				"<100016450175428>", "<100016435896715>", "<100016423208068>", "<100016470153433>", "<100016425697900>",
				"<100016431217027>", };
		try {
			if (cursor < progressBar.getMaximum()) {
				
				// a method is working...
				String strLog = uid[NumberHelper.getRandomInt(uid.length - 1, 0)];
				strLog += " " + actions[NumberHelper.getRandomInt(actions.length - 1, 0)];
				strLog += " " + targets[NumberHelper.getRandomInt(targets.length - 1, 0)];
				editorPane.getDocument().insertString(editorPane.getDocument().getLength(), strLog + "\n", null);
				Thread.sleep(NumberHelper.getRandomInt(2000, 1000));
				
				//new value is added
				int incree = NumberHelper.getRandomInt(3, 1);	
				
				//update progress bar
				System.out.println("value was changed by " + threadName);
				cursor = progressBar.getValue() + incree;
				progressBar.setValue(cursor);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
}
