package io.quangvu.fcare.gui;

import io.quangvu.fcare.bean.GroupCareCampaign;

public class GroupCareUpdateDialog extends AbstractDialog {
	
	public GroupCareUpdateDialog(DashboardFrame container, String title, int width, int height, GroupCareCampaign campaign) {
		super(title, width, height);
		
		this.getContentPane().add(new GroupCareUpdatePanel(this, container, campaign));
	}
}
