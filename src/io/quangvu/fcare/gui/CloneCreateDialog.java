package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class CloneCreateDialog extends AbstractDialog {
	
	public CloneCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new CloneCreatePanel(this, container));
	}
}
