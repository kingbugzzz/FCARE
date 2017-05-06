package io.quangvu.fcare.counter;

public class Counter {
	
	private int count;
	private int max;
	
	public Counter(int count, int max) {
		this.count = count;
		this.max = max;
	}
	
	public void count() {
		this.count++;
	}
	
	public void setValue(int value) {
		this.count = count;
	}
	
	public int getValue() {
		return this.count;
	}
	
	public int max() {
		return this.max;
	}
}
