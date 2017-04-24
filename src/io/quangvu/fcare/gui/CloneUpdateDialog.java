package io.quangvu.fcare.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;

public class CloneUpdateDialog extends AbstractDialog {
	
	public CloneUpdateDialog(DashboardFrame container, String title, int width, int height, Clone clone) {
		super(title, width, height);
		
		this.getContentPane().add(new CloneUpdatePanel(this, container, clone));
	}
}