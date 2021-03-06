package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.controller.CloneController;
import io.quangvu.fcare.counter.Counter;
import io.quangvu.fcare.model.CloneCareCampaignModel;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.worker.CloneCareCampaignWorker;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JProgressBar progressBar;
	private JTextArea textArea;

	private CloneCareCampaign cloneCareCampaign;
	private ArrayList<Thread> threadStack;
	private ArrayList<CloneCareCampaignWorker> workers;
	private Counter counter;

	public CloneCareRunningPanel(JDialog container, DashboardFrame dashboardFrame, String campaignId) {
		
		setLayout(null);
		
		container.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Đóng?",
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					container.dispose();
				}
			}
		});
		
		model = new CloneCareCampaignModel();
		cloneCareCampaign = this.model.get(campaignId);
		
		campaign = new JLabel(cloneCareCampaign.getName());
		campaign.setBounds(40, 22, 527, 14);
		add(campaign);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 118, 527, 223);
		add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		progressBar.setForeground(new Color(0, 100, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(40, 60, 527, 27);
		add(progressBar);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Stop?",
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					container.dispose();
				}
			}
		});
		btnStop.setBounds(255, 367, 89, 23);
		add(btnStop);
		
		this.init();
		this.start();
	}
	
	private void init() {
		String[] cloneIds = this.cloneCareCampaign.getCloneIdList().split(",");
		this.prepareIds(cloneIds);
		CloneController cloneController = new CloneController();
		ArrayList<Clone> cloneList = cloneController.get(cloneIds);
		counter = new Counter(0, cloneList.size());
		threadStack = new ArrayList<Thread>();
		this.workers = new ArrayList<CloneCareCampaignWorker>();
		CloneCareCampaignWorker worker = null;
		for(int i=0; i<cloneList.size(); i++) {
			worker = new CloneCareCampaignWorker(this.cloneCareCampaign, cloneList.get(i) , counter, progressBar, textArea);
			this.workers.add(worker);
			threadStack.add(new Thread(worker));
		}
	}
	
	private void start() {
		for(Thread t : this.threadStack) {
			t.start();
		}
	}
		
	private void prepareIds(String[] ids) {
		for(int i=0; i<ids.length; i++) {
			ids[i] = "'" + ids[i] + "'";
		}
	}
}
