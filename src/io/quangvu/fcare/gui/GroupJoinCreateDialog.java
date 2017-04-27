package io.quangvu.fcare.gui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

public class GroupJoinCreateDialog extends AbstractDialog {
	
	public GroupJoinCreateDialog(DashboardFrame container, String title, int width, int height, Vector<String> cloneIds) {
		super(title, width, height);
		
		this.getContentPane().add(new GroupJoinCreatePanel(this, container, cloneIds));
	}
}
