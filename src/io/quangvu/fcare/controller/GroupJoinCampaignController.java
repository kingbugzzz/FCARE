package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.GroupJoinCampaign;
import io.quangvu.fcare.model.GroupJoinCampaignModel;

public class GroupJoinCampaignController {
	
	private GroupJoinCampaignModel model;

	public GroupJoinCampaignController(){
		this.model = new GroupJoinCampaignModel();
	}

	public GroupJoinCampaign get(String id) {
		return this.model.get(id);
	}

	public ArrayList<GroupJoinCampaign> all() {
		return this.model.all();
	}

	public boolean update(GroupJoinCampaign gcc) {
		return this.model.update(gcc);
	}

	public boolean delete(int id) {
		return this.model.delete(id);
	}

	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}

	public boolean add(GroupJoinCampaign gcc) {
		return this.model.add(gcc);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}

	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
