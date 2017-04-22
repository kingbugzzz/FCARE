package io.quangvu.fcare.controller;

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
}
