package io.quangvu.fcare.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CloneCareRunningDialog extends JDialog {
	
	public CloneCareRunningDialog(DashboardFrame container, String title, int width, int height, String campaignId) {
		
		this.getContentPane().add(new CloneCareRunningPanel(this, container, campaignId));
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(false);	
		
	}

	public void display() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}