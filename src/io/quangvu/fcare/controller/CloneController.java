package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.model.CloneModel;

public class CloneController {
	
	private CloneModel model;
	
	public CloneController(){
		this.model = new CloneModel();
	}
	
	public boolean add(Clone clone) {
		return this.model.add(clone);
	}
	
	public Clone get(String id) {
		return this.model.get(id);
	}
	
	public ArrayList<Clone> get(String[] ids) {
		return this.model.get(ids);
	}
	
	public ArrayList<Clone> all() {
		return this.model.all();
	}
	
	public boolean update(Clone clone) {
		return this.model.update(clone);
	}
		
	public void updateStatus(ArrayList<String> ids, String status) {
		this.model.updateStatus(ids, status);
	}
	
	public boolean updateTags(String ids, String tag) {
		return this.model.updateTags(ids, tag);
	}
	
	public boolean delete(String id) {
		return this.model.delete(id);
	}
	
	public void delete(ArrayList<String> ids) {
		this.model.delete(ids);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}
	
	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
