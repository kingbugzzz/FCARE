package io.quangvu.fcare.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;

public class AvatarChangeDialog extends AbstractDialog {
	
	public AvatarChangeDialog(DashboardFrame container, String title, int width, int height, String cloneId) {
		super(title, width, height);
		
		this.getContentPane().add(new AvatarSingleChangePanel(this, container, cloneId));
	}
}