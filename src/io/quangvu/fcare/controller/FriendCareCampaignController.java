package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.FriendCareCampaign;
import io.quangvu.fcare.model.FriendCareCampaignModel;

public class FriendCareCampaignController {
	
	private FriendCareCampaignModel model;

	public FriendCareCampaignController(){
		this.model = new FriendCareCampaignModel();
	}

	public FriendCareCampaign get(String id) {
		return this.model.get(id);
	}

	public ArrayList<FriendCareCampaign> all() {
		return this.model.all();
	}

	public boolean update(FriendCareCampaign fcc) {
		return this.model.update(fcc);
	}

	public boolean delete(int id) {
		return this.model.delete(id);
	}

	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}

	public boolean add(FriendCareCampaign fcc) {
		return this.model.add(fcc);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}

	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
