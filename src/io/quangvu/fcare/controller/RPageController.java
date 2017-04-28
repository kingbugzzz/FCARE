package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RPage;
import io.quangvu.fcare.model.RPageModel;

public class RPageController {
	
	private RPageModel model;
	
	public RPageController() {
		this.model = new RPageModel();
	}
	
	public RPage get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<RPage> all() {
		return this.model.all();
	}
	
	public boolean add(RPage status) {
		return this.model.add(status);
	}
	
	public boolean update(RPage status) {
		return this.model.update(status);
	}
	
	public boolean delete(String name) {
		return this.model.delete(name);
	}
	
	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}
	
	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
