package io.quangvu.fcare.counter;

public class CloneCareCampaignCounter {
	
	private int count;
	
	public CloneCareCampaignCounter() {}
	
	public void count() {
		this.count++;
	}
	
	public void setValue(int value) {
		this.count = count;
	}
	public int getValue() {
		return this.count;
	}
}
