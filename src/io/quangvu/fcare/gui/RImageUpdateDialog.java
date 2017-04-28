package io.quangvu.fcare.gui;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.RImage;


public class RImageUpdateDialog extends AbstractDialog {
	
	public RImageUpdateDialog(DashboardFrame container, String title, int width, int height, RImage rstatus) {
		super(title, width, height);
		
		this.getContentPane().add(new RImageUpdatePanel(this, container, rstatus));
	}
}