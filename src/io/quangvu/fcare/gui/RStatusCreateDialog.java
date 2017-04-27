package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class RStatusCreateDialog extends AbstractDialog {
	
	public RStatusCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new RStatusCreatePanel(this, container));
	}
}