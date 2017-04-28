package io.quangvu.fcare.gui;

import io.quangvu.fcare.bean.FriendCareByUidCampaign;

public class FriendCareByUidUpdateDialog extends AbstractDialog {
	
	public FriendCareByUidUpdateDialog(DashboardFrame container, String title, int width, int height, FriendCareByUidCampaign campaign) {
		super(title, width, height);
		
		this.getContentPane().add(new FriendCareByUidUpdatePanel(this, container, campaign));
	}
}
