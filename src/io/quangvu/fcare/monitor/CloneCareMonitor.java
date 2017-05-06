package io.quangvu.fcare.monitor;

import java.util.ArrayList;

public class CloneCareMonitor implements Runnable {
	
	private volatile boolean stop = false;
	
	private ArrayList<Thread> threadStack;
	
	public CloneCareMonitor(ArrayList<Thread> threadStack) {
		this.threadStack = threadStack;
	}
	
	public void run() {
		while(!stop) {
			for(Thread thread : this.threadStack) {
				thread.start();
			}
			this.terminate();
		}
	}
	
	public void terminate() {
		stop = true;
	}
}
