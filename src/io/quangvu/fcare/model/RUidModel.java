package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RUid;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class RUidModel {

	public RUidModel() {
	}

	public RUid get(String name) {
		String query = "SELECT * FROM resource_uid WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseRUid(DBHelper.executeQuery(query));
	}

	public ArrayList<RUid> all() {
		String query = "SELECT * FROM resource_uid WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<RUid> resource_uid = BeanPaserHelper.parseAllRUid(DBHelper.executeQuery(query));
		return resource_uid;
	}

	public boolean add(RUid rstatus) {
		String query = "INSERT INTO resource_uid(owner, tag, name, src_file) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + rstatus.getTag() + "','" + rstatus.getName() + "','"  + rstatus.getSrc() +"')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(RUid rstatus) {
		String query = "UPDATE resource_uid SET tag='" + rstatus.getTag() + "', name='" + rstatus.getName() + "', src_file='" + rstatus.getSrc() + "' ";
		query += "WHERE id =" + rstatus.getId() + " AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String id) {
		String query = "DELETE FROM resource_uid WHERE id in (" + id + ")   AND owner='" + SessionHelper.getSessionUser() + "'";
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
		ArrayList<RUid> resource_uid = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (RUid rstatus : resource_uid) {
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
