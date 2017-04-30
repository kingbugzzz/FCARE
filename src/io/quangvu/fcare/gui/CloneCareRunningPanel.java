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

import com.sun.jna.platform.unix.X11.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;

public class CloneCareRunningPanel extends JPanel {

	private JLabel campaign;
	private CloneCareCampaignModel model;
	private JEditorPane editorPane;
	private JProgressBar progressBar;
	private JButton btnRun, btnStop, btnPause;
	
	private String status = "STOP";
	
	private ServiceFactory serv1, serv2, serv3;

	public CloneCareRunningPanel(JDialog container, DashboardFrame dashboardFrame, String campaignId) {
		setLayout(null);

		model = new CloneCareCampaignModel();

		CloneCareCampaign ccc = this.model.get(campaignId);
		campaign = new JLabel(ccc.getName());
		campaign.setBounds(40, 22, 432, 14);
		add(campaign);

		btnRun = new JButton("");
		btnRun
				.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/play.png")));
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
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status.equalsIgnoreCase("RUNNING")) {
					serv1.suspend();
					serv2.suspend();
					serv3.suspend();
					btnRun.setEnabled(true);
					btnPause.setEnabled(false);
					btnStop.setEnabled(true);
					status = "PAUSE";
				}
			}
		});
		btnPause.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/pause.png")));
		btnPause.setBounds(150, 217, 56, 23);
		add(btnPause);

		btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon(CloneCareRunningPanel.class.getResource("/io/quangvu/fcare/gui/icon/stop.png")));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!status.equalsIgnoreCase("STOP")) {
					serv1.stop();
					serv2.stop();
					serv3.stop();
					status = "STOP";
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

	}

	private void start() {
		
		if(status.equalsIgnoreCase("STOP")) {
						
			serv1 = new ServiceFactory("T1",progressBar, editorPane);
			serv2 = new ServiceFactory("T2",progressBar, editorPane);
			serv3 = new ServiceFactory("T3",progressBar, editorPane);
			
			serv1.start();
			serv2.start();
			serv3.start();
			
		}
		
		if(status.equalsIgnoreCase("PAUSE")) {
			serv1.resume();
			serv2.resume();
			serv3.resume();
		}
		
		status = "RUNNING";
	}
}

