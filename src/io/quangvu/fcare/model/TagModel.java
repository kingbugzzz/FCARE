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

	public Tag get(String name) {
		String query = "SELECT * FROM tags WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseTag(DBHelper.executeQuery(query));
	}

	public ArrayList<Tag> all() {
		String query = "SELECT * FROM tags WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<Tag> tags = BeanPaserHelper.parseTags(DBHelper.executeQuery(query));
		return tags;
	}

	public boolean add(Tag tag) {
		String query = "INSERT INTO tags(owner, name, description) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + tag.getName() + "','" + tag.getDescription() + "')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(Tag newTag) {
		String query = "UPDATE tags SET description='" + newTag.getDescription() + "' WHERE name = '"
				+ newTag.getName() + "' AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String name) {
		String query = "DELETE FROM tags WHERE name='" + name + "'";
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
			row.add(tag.getName());
			row.add(tag.getDescription());
			data.add(row);
		}
		return data;
	}
}
