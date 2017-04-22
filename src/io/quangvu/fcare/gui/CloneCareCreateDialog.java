package io.quangvu.fcare.gui;

import javax.swing.JFrame;

public class CloneCareCreateDialog extends AbstractDialog {
	
	public CloneCareCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new CloneCareCreatePanel(this, container));
	}
}
