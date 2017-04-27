package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RStatus;
import io.quangvu.fcare.model.RStatusModel;

public class RStatusController {
	
	private RStatusModel model;
	
	public RStatusController() {
		this.model = new RStatusModel();
	}
	
	public RStatus get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<RStatus> all() {
		return this.model.all();
	}
	
	public boolean add(RStatus status) {
		return this.model.add(status);
	}
	
	public boolean update(RStatus status) {
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
