package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.GroupCareCampaign;
import io.quangvu.fcare.model.GroupCareCampaignModel;

public class GroupCareCampaignController {
	
	private GroupCareCampaignModel model;

	public GroupCareCampaignController(){
		this.model = new GroupCareCampaignModel();
	}

	public GroupCareCampaign get(String id) {
		return this.model.get(id);
	}

	public ArrayList<GroupCareCampaign> all() {
		return this.model.all();
	}

	public boolean update(GroupCareCampaign gcc) {
		return this.model.update(gcc);
	}

	public boolean delete(int id) {
		return this.model.delete(id);
	}

	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}

	public boolean add(GroupCareCampaign gcc) {
		return this.model.add(gcc);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}

	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
