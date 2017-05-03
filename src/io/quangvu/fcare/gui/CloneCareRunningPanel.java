package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		container.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Đóng?",
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					activity.cancel(true);
					container.dispose();
				}
			}
		});
		
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
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Stop?",
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					activity.cancel(true);
				}
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
		
		public void work() throws InterruptedException {
			System.out.println(" logging...");
			Thread.sleep(500);

			System.out.println(" posting status...");
			Thread.sleep(500);

			System.out.println(" like...");
			Thread.sleep(500);

			System.out.println(" share...");
			Thread.sleep(500);

			System.out.println(" comment...");
			Thread.sleep(500);

			System.out.println(" finished.");
		}

		protected Void doInBackground() throws Exception {

			while (current < target) {
				work();
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
//			JOptionPane.showMessageDialog(null, "Done!");
		}

		private int current;
		private int target;
	}
}
