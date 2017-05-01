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
	int stackNumber = 0;

	public CloneCareThreadManager(JProgressBar bar, JEditorPane editor, CloneCareCampaignCounter counter,
			String campId) {
		this.controller = new CloneCareCampaignController();
		this.campaign = this.controller.get(campId);
		System.out.println(campaign.toString());

		String[] cloneIds = campaign.getCloneIdList().split(",");
		this.limitJobs = cloneIds.length;

		System.out.println("limitjobs: " + this.limitJobs);

		if (this.limitJobs > 0) {
			this.cloneCareThreadList = new ArrayList<CloneCareThread>();
			CloneCareThread cct = null;
			for (String cloneId : cloneIds) {
				cct = new CloneCareThread(this.campaign.getName(), bar, editor, counter, this.limitJobs, cloneId);
				this.cloneCareThreadList.add(cct);
			}
		}
	}

	public void start() {

		int cloneSize = this.cloneCareThreadList.size();
		int clonePerOneThread = this.campaign.getNumThread();
		int numStack = cloneSize / clonePerOneThread;
		
		
		for(int i=0; i<3; i++) {
			this.cloneCareThreadList.get(i).start();
		}
		
//		ArrayList<ArrayList<CloneCareThread>> stackers = this.chopIntoParts(this.cloneCareThreadList, numStack);
//		
//		System.out.println("stack size = " + stackers.size());
//
//		int numTurn = 1;
//		
//		for (ArrayList<CloneCareThread> list : stackers) {
//			System.out.println("turn: " + numTurn);
//			for (CloneCareThread cct : list) {
//				System.out.println(cct.getName());
//				cct.start();
//			}
//			numTurn++;
//		}
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
