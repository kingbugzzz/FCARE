package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.model.CloneCareCampaignModel;
import io.quangvu.fcare.worker.CloneCareWorker;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JProgressBar progressBar;
	private JTextArea textArea;

	CloneCareCampaign cloneCareCampaign;
	private CloneCareWorker activity;

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
					activity.cancel(true);
				}
			}
		});
		btnStop.setBounds(255, 367, 89, 23);
		add(btnStop);

		this.activity = new CloneCareWorker(this.cloneCareCampaign, this.textArea, this.progressBar);
		this.activity.execute();
	}
}
