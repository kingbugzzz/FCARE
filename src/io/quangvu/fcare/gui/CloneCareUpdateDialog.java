package io.quangvu.fcare.gui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.CloneCareCampaign;

public class CloneCareUpdateDialog extends AbstractDialog {
	
	public CloneCareUpdateDialog(DashboardFrame container, String title, int width, int height, CloneCareCampaign campaign) {
		super(title, width, height);
		
		this.getContentPane().add(new CloneCareUpdatePanel(this, container, campaign));
	}
}
