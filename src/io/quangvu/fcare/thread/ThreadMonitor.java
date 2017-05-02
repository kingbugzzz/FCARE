package io.quangvu.fcare.thread;

import java.util.ArrayList;

public class ThreadMonitor {
	
	ArrayList<CloneCareThread> list;
	
	int count = 0;
	
	boolean done = false;
	
	public ThreadMonitor(ArrayList<CloneCareThread> arrayList) {
		this.list = arrayList;
	}
	
	public void setListThreads(ArrayList<CloneCareThread> list) {
		this.list = list;
	}
	
	public void count() {
		this.count++;
	}
	
	public int value() {
		return this.count;
	}
	
	public boolean isDone() {
		for( CloneCareThread thread : this.list) {
			if(thread.isStop) {
				this.count++;
			}
		}
		
		if(this.count == this.list.size()) {
			return true;
		}
		return false;
	}
}
