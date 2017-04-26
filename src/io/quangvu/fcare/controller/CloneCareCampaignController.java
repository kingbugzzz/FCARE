package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.model.CloneCareCampaignModel;

public class CloneCareCampaignController {
	
	private CloneCareCampaignModel model;
	
	public CloneCareCampaignController(){
		this.model = new CloneCareCampaignModel();
	}
	
	public CloneCareCampaign get(String id) {
		return this.model.get(id);
	}
	
	public ArrayList<CloneCareCampaign> all() {
		return this.model.all();
	}
	
	public boolean update(CloneCareCampaign cloneCC) {
		return this.model.update(cloneCC);
	}
	
	public boolean delete(int id) {
		return this.model.delete(id);
	}
	
	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}
	
	public boolean add(CloneCareCampaign cloneCC) {
		return this.model.add(cloneCC);
	}
	
	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}
	
	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
