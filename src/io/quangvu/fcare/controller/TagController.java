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
	
	public Tag get(String name) {
		return this.model.get(name);
	}
	
	public ArrayList<Tag> all() {
		return this.model.all();
	}
	
	public boolean add(Tag tag) {
		return this.model.add(tag);
	}
	
	public boolean update(Tag tag) {
		return this.model.update(tag);
	}
	
	public boolean delete(String name) {
		return this.model.delete(name);
	}
	
	public Vector<Vector<String>> getTagTableDataModel() {
		return this.model.getTagTableDataModel();
	}
}
