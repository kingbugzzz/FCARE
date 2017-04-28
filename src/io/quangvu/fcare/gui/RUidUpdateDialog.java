package io.quangvu.fcare.gui;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.RUid;


public class RUidUpdateDialog extends AbstractDialog {
	
	public RUidUpdateDialog(DashboardFrame container, String title, int width, int height, RUid rstatus) {
		super(title, width, height);
		
		this.getContentPane().add(new RUidUpdatePanel(this, container, rstatus));
	}
}