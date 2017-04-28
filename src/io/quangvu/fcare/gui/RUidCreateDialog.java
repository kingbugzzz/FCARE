package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class RUidCreateDialog extends AbstractDialog {
	
	public RUidCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new RUidCreatePanel(this, container));
	}
}