package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.FriendCareByUidCampaign;
import io.quangvu.fcare.model.FriendCareByUidCampaignModel;

public class FriendCareByUidCampaignController {
	
	private FriendCareByUidCampaignModel model;

	public FriendCareByUidCampaignController(){
		this.model = new FriendCareByUidCampaignModel();
	}

	public FriendCareByUidCampaign get(String id) {
		return this.model.get(id);
	}

	public ArrayList<FriendCareByUidCampaign> all() {
		return this.model.all();
	}

	public boolean update(FriendCareByUidCampaign gcc) {
		return this.model.update(gcc);
	}

	public boolean delete(int id) {
		return this.model.delete(id);
	}

	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}

	public boolean add(FriendCareByUidCampaign gcc) {
		return this.model.add(gcc);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}

	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
