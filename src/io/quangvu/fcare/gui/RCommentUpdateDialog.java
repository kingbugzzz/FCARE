package io.quangvu.fcare.gui;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.RComment;


public class RCommentUpdateDialog extends AbstractDialog {
	
	public RCommentUpdateDialog(DashboardFrame container, String title, int width, int height, RComment rstatus) {
		super(title, width, height);
		
		this.getContentPane().add(new RCommentUpdatePanel(this, container, rstatus));
	}
}