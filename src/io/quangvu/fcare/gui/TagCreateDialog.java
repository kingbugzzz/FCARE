package io.quangvu.fcare.gui;

import javax.swing.JFrame;

public class TagCreateDialog extends AbstractDialog {
	
	public TagCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new TagCreatePanel(this, container));
	}
}