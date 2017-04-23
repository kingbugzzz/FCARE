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
	
	public ArrayList<Clone> all() {
		return this.model.all();
	}
	
	public boolean update(Clone clone) {
		return this.model.update(clone);
	}
	
	public boolean updateStringField(String field, String value) {
		return this.model.updateStringField(field, value);
	}
	
	public boolean updateField(String field, String value) {
		return this.model.updateField(field, value);
	}
	
	public boolean delete(String id) {
		return this.model.delete(id);
	}

	public Vector<String> getTableHeader() {
		return this.model.getTableHeader();
	}
	
	public Vector<Vector<String>> getTableDataModel() {
		return this.model.getTableDataModel();
	}
}
