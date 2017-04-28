package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class RPageCreateDialog extends AbstractDialog {
	
	public RPageCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new RPageCreatePanel(this, container));
	}
}