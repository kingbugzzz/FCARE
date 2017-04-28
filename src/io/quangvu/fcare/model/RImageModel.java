package io.quangvu.fcare.model;

import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.RImage;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class RImageModel {

	public RImageModel() {
	}

	public RImage get(String name) {
		String query = "SELECT * FROM resource_images WHERE name='" + name + "'";
		System.out.println(query);
		return BeanPaserHelper.parseRImage(DBHelper.executeQuery(query));
	}

	public ArrayList<RImage> all() {
		String query = "SELECT * FROM resource_images WHERE owner = '" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		ArrayList<RImage> resource_images = BeanPaserHelper.parseAllRImage(DBHelper.executeQuery(query));
		return resource_images;
	}

	public boolean add(RImage rstatus) {
		String query = "INSERT INTO resource_images(owner, tag, name, src_file) VALUES('" + SessionHelper.getSessionUser() + "','"
				 + rstatus.getTag() + "','" + rstatus.getName() + "','"  + rstatus.getSrc() +"')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(RImage rstatus) {
		String query = "UPDATE resource_images SET tag='" + rstatus.getTag() + "', name='" + rstatus.getName() + "', src_file='" + rstatus.getSrc() + "' ";
		query += "WHERE id =" + rstatus.getId() + " AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean delete(String id) {
		String query = "DELETE FROM resource_images WHERE id in (" + id + ")   AND owner='" + SessionHelper.getSessionUser() + "'";
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
		ArrayList<RImage> resource_images = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (RImage rstatus : resource_images) {
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
