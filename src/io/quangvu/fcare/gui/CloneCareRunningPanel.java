package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneCareCampaignModel;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JProgressBar progressBar;
	private JTextArea textArea;

	private String runningStatus = "STOP";
	CloneCareCampaign cloneCareCampaign;
	private SimulatedActivity activity;

	public CloneCareRunningPanel(JDialog container, DashboardFrame dashboardFrame, String campaignId) {
		setLayout(null);

		model = new CloneCareCampaignModel();

		cloneCareCampaign = this.model.get(campaignId);
		campaign = new JLabel(cloneCareCampaign.getName());
		campaign.setBounds(40, 22, 432, 14);
		add(campaign);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 85, 432, 114);
		add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		progressBar.setForeground(new Color(0, 100, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(40, 47, 432, 27);
		add(progressBar);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activity.cancel(true);
			}
		});
		btnStop.setBounds(197, 215, 89, 23);
		add(btnStop);

		this.start();
	}

	private void start() {
		
		System.out.println("Campaign: " + this.cloneCareCampaign.getName());
		int numClones = this.cloneCareCampaign.getCloneIdList().split(",").length;
		System.out.println("Total clone: " + numClones);
		
		progressBar.setMaximum(0);
		progressBar.setMaximum(numClones);
		
		activity = new SimulatedActivity(numClones);
		activity.execute();
				
		runningStatus = "RUNNING";
	}
	
	class SimulatedActivity extends SwingWorker<Void, Integer> {
		
		public SimulatedActivity(int t) {
			current = 0;
			target = t;
		}

		protected Void doInBackground() throws Exception {

			while (current < target) {

				MyTask mytask = new MyTask("Task" + current);
				mytask.work();
				current++;
				publish(current);
			}

			return null;
		}

		protected void process(List<Integer> chunks) {
			for (Integer chunk : chunks) {
				textArea.append(chunk + "\n");
				progressBar.setValue(chunk);
			}
		}

		protected void done() {
		}

		private int current;
		private int target;
	}
}

class MyTask {

	private String name;

	public MyTask(String name) {
		this.name = name;
		System.out.println("Hi, my name is " + this.name);
	}

	public void work() {
		try {
			System.out.println(this.name + " logging...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " posting status...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " like...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " share...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " comment...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " finished.");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
