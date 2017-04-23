package io.quangvu.fcare.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.Tag;

public class TagUpdateDialog extends AbstractDialog {
	
	public TagUpdateDialog(DashboardFrame container, String title, int width, int height, Tag tag) {
		super(title, width, height);
		
		this.getContentPane().add(new TagUpdatePanel(this, container, tag));
	}
}