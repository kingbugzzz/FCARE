package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RPage;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class RPageModel {

	public RPageModel() {
	}

	public RPage get(String name) {
		String query = "SELECT * FROM resource_pages WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseRPage(DBHelper.executeQuery(query));
	}

	public ArrayList<RPage> all() {
		String query = "SELECT * FROM resource_pages WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<RPage> resource_pages = BeanPaserHelper.parseAllRPage(DBHelper.executeQuery(query));
		return resource_pages;
	}

	public boolean add(RPage rstatus) {
		String query = "INSERT INTO resource_pages(owner, tag, name, src_file) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + rstatus.getTag() + "','" + rstatus.getName() + "','"  + rstatus.getSrc() +"')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(RPage rstatus) {
		String query = "UPDATE resource_pages SET tag='" + rstatus.getTag() + "', name='" + rstatus.getName() + "', src_file='" + rstatus.getSrc() + "' ";
		query += "WHERE id =" + rstatus.getId() + " AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String id) {
		String query = "DELETE FROM resource_pages WHERE id in (" + id + ")   AND owner='" + SessionHelper.getSessionUser() + "'";
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
		ArrayList<RPage> resource_pages = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (RPage rstatus : resource_pages) {
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
