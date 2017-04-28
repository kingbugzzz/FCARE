package io.quangvu.fcare.gui;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.RPage;


public class RPageUpdateDialog extends AbstractDialog {
	
	public RPageUpdateDialog(DashboardFrame container, String title, int width, int height, RPage rstatus) {
		super(title, width, height);
		
		this.getContentPane().add(new RPageUpdatePanel(this, container, rstatus));
	}
}