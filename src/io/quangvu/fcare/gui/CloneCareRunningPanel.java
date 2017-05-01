package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.counter.CloneCareCampaignCounter;
import io.quangvu.fcare.model.CloneCareCampaignModel;
import io.quangvu.fcare.thread.CloneCareThreadManager;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JEditorPane editorPane;
	private JProgressBar progressBar;
	private JButton btnRun, btnStop, btnPause;

	private CloneCareCampaignCounter counter;
	private CloneCareThreadManager cloneCareThreadManager;
	private String runningStatus = "STOP";
	CloneCareCampaign cloneCareCampaign;

	public CloneCareRunningPanel(JDialog container, DashboardFrame dashboardFrame, String campaignId) {
		setLayout(null);

		model = new CloneCareCampaignModel();

		cloneCareCampaign = this.model.get(campaignId);
		campaign = new JLabel(cloneCareCampaign.getName());
		campaign.setBounds(40, 22, 432, 14);
		add(campaign);

		btnRun = new JButton("");
		btnRun.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/play.png")));
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
				btnRun.setEnabled(false);
				btnPause.setEnabled(true);
				btnStop.setEnabled(true);
			}
		});
		btnRun.setBounds(216, 217, 56, 23);
		add(btnRun);

		btnPause = new JButton("");
		btnPause.setIcon(
				new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/pause.png")));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (runningStatus.equalsIgnoreCase("RUNNING")) {
					cloneCareThreadManager.pause();
					btnRun.setEnabled(true);
					btnPause.setEnabled(false);
					btnStop.setEnabled(true);
					runningStatus = "PAUSE";
				}
			}
		});
		btnPause.setBounds(150, 217, 56, 23);
		add(btnPause);

		btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/stop.png")));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!runningStatus.equalsIgnoreCase("STOP")) {
					cloneCareThreadManager.stop();
					counter = null;
					runningStatus = "STOP";
					btnRun.setEnabled(true);
					btnPause.setEnabled(true);
					btnStop.setEnabled(false);
				}
			}
		});
		btnStop.setBounds(282, 217, 49, 23);
		add(btnStop);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 85, 432, 114);
		add(scrollPane);

		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		progressBar = new JProgressBar();

		progressBar.setForeground(new Color(0, 100, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(40, 47, 432, 27);
		add(progressBar);

		this.start();
	}

	private void start() {
		counter = new CloneCareCampaignCounter();
		System.out.println(String.valueOf(cloneCareCampaign.getId()));
		cloneCareThreadManager = new CloneCareThreadManager(progressBar, editorPane, counter, String.valueOf(cloneCareCampaign.getId()));
		cloneCareThreadManager.start();
		runningStatus = "RUNNING";
	}
}
