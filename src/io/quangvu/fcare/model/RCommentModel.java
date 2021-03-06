package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RComment;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class RCommentModel {

	public RCommentModel() {
	}

	public RComment get(String name) {
		String query = "SELECT * FROM resource_comments WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseRComment(DBHelper.executeQuery(query));
	}

	public ArrayList<RComment> all() {
		String query = "SELECT * FROM resource_comments WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<RComment> resource_comments = BeanPaserHelper.parseAllRComment(DBHelper.executeQuery(query));
		return resource_comments;
	}

	public boolean add(RComment rstatus) {
		String query = "INSERT INTO resource_comments(owner, tag, name, src_file) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + rstatus.getTag() + "','" + rstatus.getName() + "','"  + rstatus.getSrc() +"')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(RComment rstatus) {
		String query = "UPDATE resource_comments SET tag='" + rstatus.getTag() + "', name='" + rstatus.getName() + "', src_file='" + rstatus.getSrc() + "' ";
		query += "WHERE id =" + rstatus.getId() + " AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String id) {
		String query = "DELETE FROM resource_comments WHERE id in (" + id + ")   AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public Vector<String> getTableHeader() {
		Vector<String> header = new Vector<String>();
		header.add("id");
		header.add("tag");
		header.add("mô tả");
		header.add("file nguồn");
		return header;
	}
	
	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<RComment> resource_comments = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (RComment rstatus : resource_comments) {
			row = new Vector<String>();
			row.add(String.valueOf(rstatus.getId()));
			row.add(rstatus.getTag());
			row.add(rstatus.getName());
			row.add(rstatus.getSrc());
			data.add(row);
		}
		return data;
	}
}
