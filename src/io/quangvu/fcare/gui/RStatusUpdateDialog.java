package io.quangvu.fcare.gui;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.RStatus;


public class RStatusUpdateDialog extends AbstractDialog {
	
	public RStatusUpdateDialog(DashboardFrame container, String title, int width, int height, RStatus rstatus) {
		super(title, width, height);
		
		this.getContentPane().add(new RStatusUpdatePanel(this, container, rstatus));
	}
}