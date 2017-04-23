package io.quangvu.fcare.controller;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.model.TagModel;

public class TagController {
	
	private TagModel model;
	
	public TagController() {
		this.model = new TagModel();
	}
	
	public Tag get(int id) {
		return this.model.get(id);
	}
	
	public boolean add(Tag tag) {
		return this.model.add(tag);
	}
	
	
	public boolean update(Tag tag) {
		return this.model.update(tag);
	}
	
	public ArrayList<Tag> all() {
		return this.model.all();
	}
	
	public Vector<Vector<String>> getTagTableDataModel() {
		return this.model.getTagTableDataModel();
	}
	
	public boolean delete(int id) {
		return this.model.delete(id);
	}
}
