package io.quangvu.fcare.service;

public class CheckLiveService implements Runnable {
	
	public Thread t;
	private String threadName;
	boolean suspended = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start() {
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
}
