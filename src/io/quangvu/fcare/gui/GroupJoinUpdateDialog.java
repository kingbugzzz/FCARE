package io.quangvu.fcare.gui;

import io.quangvu.fcare.bean.GroupJoinCampaign;

public class GroupJoinUpdateDialog extends AbstractDialog {
	
	public GroupJoinUpdateDialog(DashboardFrame container, String title, int width, int height, GroupJoinCampaign campaign) {
		super(title, width, height);
		
		this.getContentPane().add(new GroupJoinUpdatePanel(this, container, campaign));
	}
}
