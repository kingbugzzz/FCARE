package io.quangvu.fcare.gui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import io.quangvu.fcare.bean.FriendCareCampaign;

public class FriendCareUpdateDialog extends AbstractDialog {
	
	public FriendCareUpdateDialog(DashboardFrame container, String title, int width, int height, FriendCareCampaign campaign) {
		super(title, width, height);
		
		this.getContentPane().add(new FriendCareUpdatePanel(this, container, campaign));
	}
}
