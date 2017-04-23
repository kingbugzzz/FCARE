package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class TagModel {

	public TagModel() {
	}

	public Tag get(int id) {
		Tag tag = null;
		String query = "SELECT * FROM tags WHERE id=" + id;
		System.out.println(query);
		tag = BeanPaserHelper.parseTag(DBHelper.executeQuery(query));
		return tag;
	}

	public ArrayList<Tag> all() {
		String query = "SELECT * FROM tags WHERE username = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<Tag> tags = BeanPaserHelper.parseTags(DBHelper.executeQuery(query));
		return tags;
	}

	public boolean add(Tag tag) {
		String query = "INSERT INTO tags(username, code, name) VALUES('" + SessionHelper.getSessionUser() + "','"
				+ tag.getCode() + "','" + tag.getName() + "')";
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(Tag newTag) {
		String query = "UPDATE tags SET code='" + newTag.getCode() + "', name='" + newTag.getName() + "' WHERE id = " + newTag.getId();
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(int id) {
		String query = "DELETE FROM tags WHERE id=" + id;
		return DBHelper.execute(query);
	}

	public void deleteAll() {

	}

	public Vector<Vector<String>> getTagTableDataModel() {
		ArrayList<Tag> tags = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (Tag tag : tags) {
			row = new Vector<String>();
			row.add(tag.getId() + "");
			row.add(tag.getCode());
			row.add(tag.getName());
			data.add(row);
		}
		return data;
	}
}
