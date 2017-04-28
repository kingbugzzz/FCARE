package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RComment;
import io.quangvu.fcare.model.RCommentModel;

public class RCommentController {
	
	private RCommentModel model;
	
	public RCommentController() {
		this.model = new RCommentModel();
	}
	
	public RComment get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<RComment> all() {
		return this.model.all();
	}
	
	public boolean add(RComment status) {
		return this.model.add(status);
	}
	
	public boolean update(RComment status) {
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
