package io.quangvu.fcare.gui;

import javax.swing.JFrame;


public class StatusDatasourceCreateDialog extends AbstractDialog {
	
	public StatusDatasourceCreateDialog(DashboardFrame container, String title, int width, int height) {
		super(title, width, height);
		
		this.getContentPane().add(new StatusDatasourceCreatePanel(this, container));
	}
}