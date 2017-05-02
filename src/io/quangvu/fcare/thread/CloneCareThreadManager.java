package io.quangvu.fcare.thread;

import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.controller.CloneCareCampaignController;
import io.quangvu.fcare.counter.CloneCareCampaignCounter;

public class CloneCareThreadManager {

	private ArrayList<CloneCareThread> cloneCareThreadList;
	private CloneCareCampaign campaign;
	private CloneCareCampaignController controller;
	private int limitJobs = 0;
	private int stackNumber = 0;
	private CloneCareCampaignCounter counter;
	
	public CloneCareThreadManager(JProgressBar bar, JEditorPane editor, String campId) {
		this.controller = new CloneCareCampaignController();
		this.campaign = this.controller.get(campId);
		
		System.out.println(campaign.toString());

		String[] cloneIds = campaign.getCloneIdList().split(",");

		this.limitJobs = cloneIds.length;

		System.out.println("limitjobs: " + this.limitJobs);
		
		this.counter = new CloneCareCampaignCounter();

		if (this.limitJobs > 0) {
			this.cloneCareThreadList = new ArrayList<CloneCareThread>();
			CloneCareThread cct = null;
			for (String cloneId : cloneIds) {
				cct = new CloneCareThread(this.campaign.getName(), bar, editor, this.counter, this.limitJobs, cloneId);
				this.cloneCareThreadList.add(cct);
			}
		}
	}

	public void start() {
		
		int numClone1Time = 5;
		
		int turn = this.cloneCareThreadList.size() /numClone1Time ;
		
		ArrayList<ArrayList<CloneCareThread>> stackers = this.chopIntoParts(this.cloneCareThreadList, turn);
			
		
	}

	public void stop() {
		if (!this.cloneCareThreadList.equals(null)) {

		}
	}

	public void pause() {
		if (!this.cloneCareThreadList.equals(null)) {

		}
	}

	public ArrayList<ArrayList<CloneCareThread>> chopIntoParts(final ArrayList<CloneCareThread> ls, final int iParts) {
		final ArrayList<ArrayList<CloneCareThread>> stackers = new ArrayList<ArrayList<CloneCareThread>>();
		final int iChunkSize = ls.size() / iParts;
		int iLeftOver = ls.size() % iParts;
		int iTake = iChunkSize;
		for (int i = 0, iT = ls.size(); i < iT; i += iTake) {
			if (iLeftOver > 0) {
				iLeftOver--;
				iTake = iChunkSize + 1;
			} else {

				iTake = iChunkSize;
			}
			stackers.add(new ArrayList<CloneCareThread>(ls.subList(i, Math.min(iT, i + iTake))));
		}
		return stackers;
	}

}
