package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RImage;
import io.quangvu.fcare.model.RImageModel;

public class RImageController {
	
	private RImageModel model;
	
	public RImageController() {
		this.model = new RImageModel();
	}
	
	public RImage get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<RImage> all() {
		return this.model.all();
	}
	
	public boolean add(RImage status) {
		return this.model.add(status);
	}
	
	public boolean update(RImage status) {
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
