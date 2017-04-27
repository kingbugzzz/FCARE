package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RStatus;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class RStatusModel {

	public RStatusModel() {
	}

	public RStatus get(String name) {
		String query = "SELECT * FROM resource_status WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseRStatus(DBHelper.executeQuery(query));
	}

	public ArrayList<RStatus> all() {
		String query = "SELECT * FROM resource_status WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<RStatus> resource_status = BeanPaserHelper.parseAllRStatus(DBHelper.executeQuery(query));
		return resource_status;
	}

	public boolean add(RStatus rstatus) {
		String query = "INSERT INTO resource_status(owner, tag, name, src_file) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + rstatus.getTag() + "','" + rstatus.getName() + "','"  + rstatus.getSrc() +"')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(RStatus rstatus) {
		String query = "UPDATE resource_status SET tag='" + rstatus.getTag() + "', name='" + rstatus.getName() + "', src_file='" + rstatus.getSrc() + "' ";
		query += "WHERE id =" + rstatus.getId() + " AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String id) {
		String query = "DELETE FROM resource_status WHERE id in (" + id + ")   AND owner='" + SessionHelper.getSessionUser() + "'";
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
		ArrayList<RStatus> resource_status = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (RStatus rstatus : resource_status) {
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
