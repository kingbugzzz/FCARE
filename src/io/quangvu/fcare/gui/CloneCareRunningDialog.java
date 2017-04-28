package io.quangvu.fcare.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;

public class CloneCareRunningDialog extends AbstractDialog {
	
	public CloneCareRunningDialog(DashboardFrame container, String title, int width, int height, String campaignId) {
		super(title, width, height);
		
		this.getContentPane().add(new CloneCareRunningPanel(this, container, campaignId));
	}
}