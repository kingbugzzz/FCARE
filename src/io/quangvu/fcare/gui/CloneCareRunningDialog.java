package io.quangvu.fcare.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CloneCareRunningDialog extends JDialog {
	
	public CloneCareRunningDialog(DashboardFrame container, String title, String campaignId) {
		
		this.getContentPane().add(new CloneCareRunningPanel(this, container, campaignId));
		
		this.setTitle(title);
		this.setSize(610, 450);
		this.setResizable(false);	
		
	}

	public void display() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}