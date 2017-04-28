package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class RImageCreateDialog extends AbstractDialog {
	
	public RImageCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new RImageCreatePanel(this, container));
	}
}