package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RUid;
import io.quangvu.fcare.model.RUidModel;

public class RUidController {
	
	private RUidModel model;
	
	public RUidController() {
		this.model = new RUidModel();
	}
	
	public RUid get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<RUid> all() {
		return this.model.all();
	}
	
	public boolean add(RUid status) {
		return this.model.add(status);
	}
	
	public boolean update(RUid status) {
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
