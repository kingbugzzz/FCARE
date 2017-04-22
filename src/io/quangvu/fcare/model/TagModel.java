package io.quangvu.fcare.model;

import java.util.ArrayList;

import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;

public class TagModel  {
	
	public TagModel() {
	}
	
	public Tag get(int id) {
		Tag tag = null;
		String query = "SELECT * FROM tags WHERE id=" + id ;
		System.out.println(query);
		DBHelper.cnt();
		tag = BeanPaserHelper.parseTag(DBHelper.executeQuery(query));
		DBHelper.disconnect();
		return tag;
	}
	
	public ArrayList<Tag> all() {
		String query = "SELECT * FROM tags";
		System.out.println(query);
		DBHelper.cnt();
		ArrayList<Tag> tags = BeanPaserHelper.parseTags(DBHelper.executeQuery(query));
		DBHelper.disconnect();
		return tags;
	}
	
	public boolean add(Tag tag) {
		return false;
	}
	
	public boolean update(Tag oldTag, Tag newTag) {
		return false;
	}
	
	public boolean delete(int id) {
		return false;
	}
	
	public void deleteAll() {
		
	}
}
