package io.quangvu.fcare.gui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

public class FriendCareByUidCreateDialog extends AbstractDialog {
	
	public FriendCareByUidCreateDialog(DashboardFrame container, String title, int width, int height, Vector<String> cloneIds) {
		super(title, width, height);
		
		this.getContentPane().add(new FriendCareByUidCreatePanel(this, container, cloneIds));
	}
}
