package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class RCommentCreateDialog extends AbstractDialog {
	
	public RCommentCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new RCommentCreatePanel(this, container));
	}
}