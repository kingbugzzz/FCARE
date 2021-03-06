package io.quangvu.fcare.model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class CloneModel {

	public CloneModel() {

	}

	public Clone get(String id) {
		String query = "SELECT * FROM clones WHERE id='" + id + "' AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseClone(DBHelper.executeQuery(query));
	}
	
	public ArrayList<Clone> get(String[] ids) {
		
		String stringIds = "";
		for(String id : ids) {
			stringIds += id + ",";
		}
		
		stringIds = stringIds.substring(0, stringIds.length()-1);
		
		String query = "SELECT * FROM clones WHERE id IN (" + stringIds + ") AND owner = '" + SessionHelper.getSessionUser()
		+ "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseClones(DBHelper.executeQuery(query));
	}
	
	public ArrayList<Clone> all() {
		String query = "SELECT * FROM clones WHERE owner = '" + SessionHelper.getSessionUser()
				+ "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseClones(DBHelper.executeQuery(query));
	}

	public boolean add(Clone clone) {
		Date now = new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		String query = "INSERT INTO clones(owner, tag, id, password, name, user_agent, cookie, token, status, created_at) VALUES('"
				+ SessionHelper.getSessionUser() + "','" + clone.getTag() + "','" + clone.getId() + "','"
				+ clone.getPassword() + "','" + clone.getName() + "','" + clone.getUserAgent() + "','"
				+ clone.getCookie() + "','" + clone.getToken() + "','" + clone.getStatus() + "','"
				+ dateFormater.format(now) + "')";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean update(Clone clone) {
		String query = "UPDATE clones SET ";
		query += "tag='" + clone.getTag() + "',";
		query += "password='" + clone.getPassword() + "',";
		query += "name='" + clone.getName() + "',";
		query += "user_agent='" + clone.getUserAgent() + "',";
		query += "cookie='" + clone.getCookie() + "',";
		query += "token='" + clone.getToken() + "',";
		query += "status='" + clone.getStatus() + "'";
		query += " WHERE id='" + clone.getId() + "' AND owner ='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean updateTags(String ids, String tag) {
		String query = "UPDATE clones SET tag='" + tag + "' WHERE id IN(" + ids + ") AND owner = '"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean delete(String id) {
		String query = "DELETE FROM clones WHERE id='" + id + "' AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}

	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for (String id : ids) {
			strIds += "'" + id + "',";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length() - 1);
		String query = "DELETE FROM clones WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		DBHelper.execute(query);
	}

	public void updateStatus(ArrayList<String> ids, String status) {
		String strIds = "";
		for (String id : ids) {
			strIds += "'" + id + "',";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length() - 1);
		String query = "UPDATE clones set status='" + status + "' WHERE id in (" + strIds + ") AND owner='"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		DBHelper.execute(query);
	}

	public Vector<String> getTableHeader() {
		Vector<String> header = new Vector<String>();
		header.add("stt");
		header.add("tag");
		header.add("id");
		header.add("tên");
		header.add("status");
		header.add("cookie");
		header.add("token");
		header.add("user_agent");
		header.add("friend");
		header.add("f.req");
		header.add("f.acp");
		header.add("số like");
		header.add("số share");
		header.add("số comment");
		header.add("số mem add");
		header.add("số page load");
		header.add("ngày vào tool");
		header.add("lần hoạt động cuối");
		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<Clone> clones = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		int count = 1;
		for (Clone clone : clones) {
			row = new Vector<String>();
			row.add(String.valueOf(count));
			row.add(clone.getTag()); // tag
			row.add(clone.getId());// id
			row.add(clone.getName());// name
			row.add(clone.getStatus()); // status
			row.add(clone.getCookie());// cookie
			row.add(clone.getToken());// token
			row.add(clone.getUserAgent());// user_agent
			row.add(String.valueOf(clone.getNumFriend())); // num friend
			row.add(String.valueOf(clone.getNumFriendReq())); // f.req
			row.add(String.valueOf(clone.getNumFriendAcp())); // f.acp
			row.add(String.valueOf(clone.getNumLike())); // số like
			row.add(String.valueOf(clone.getNumShare())); // số share
			row.add(String.valueOf(clone.getNumComment()));// số comment
			row.add(String.valueOf(clone.getNumGma())); // số gma
			row.add(String.valueOf(clone.getNumPll()));// số pl
			row.add(clone.getCreatedAt());// created at
			row.add(clone.getUpdateAt());// last active
			data.add(row);
			count++;
		}
		return data;
	}

	public Vector<String> getCloneUpdateCampaignUid(String uid) {
		Vector<String> listUid = new Vector<String>();
		String paramQuery = "";
		String temp[] = uid.split(",");
		for (String id : temp) {
			paramQuery += "'" + id + "',";
		}
		paramQuery = paramQuery.substring(0, paramQuery.length() - 1);
		String query = "SELECT name, id from clones WHERE id in (" + paramQuery + ")";
		ResultSet rs = DBHelper.executeQuery(query);
		try {
			while (rs.next()) {
				listUid.add(rs.getString("name") + "<" + rs.getString("id") + ">");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listUid;
	}
}
