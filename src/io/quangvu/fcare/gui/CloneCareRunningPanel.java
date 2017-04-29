package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.helper.KeyHelper;
import io.quangvu.fcare.model.CloneCareCampaignModel;
import io.quangvu.fcare.service.ServiceFactory;
import io.quangvu.fcare.service.TestService;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JEditorPane editorPane;
	private JProgressBar progressBar;
	private JButton btnStop, btnResume;
	
	private ServiceFactory serv;

	public CloneCareRunningPanel(JDialog container, DashboardFrame dashboardFrame, String campaignId) {
		setLayout(null);

		model = new CloneCareCampaignModel();

		CloneCareCampaign ccc = this.model.get(campaignId);
		campaign = new JLabel(ccc.getName());
		campaign.setBounds(40, 22, 432, 14);
		add(campaign);

		JButton btnNewButton = new JButton("");
		btnNewButton
				.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/play.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		btnNewButton.setBounds(216, 217, 56, 23);
		add(btnNewButton);

		JButton btnPause = new JButton("");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serv.suspend();
			}
		});
		btnPause.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/pause.png")));
		btnPause.setBounds(150, 217, 56, 23);
		add(btnPause);

		btnStop = new JButton("");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStop.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/stop.png")));
		btnStop.setBounds(282, 217, 49, 23);
		add(btnStop);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 85, 432, 114);
		add(scrollPane);

		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setForeground(new Color(0, 100, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(40, 47, 432, 27);
		add(progressBar);
		
		btnResume = new JButton("resume");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serv.resume();
			}
		});
		btnResume.setBounds(345, 217, 89, 23);
		add(btnResume);

	}

	private void start() {
		serv = new ServiceFactory("Demo nuoi clone",progressBar, editorPane);
		serv.start();
	}
}

