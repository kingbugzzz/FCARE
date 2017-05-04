package io.quangvu.fcare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.GroupJoinCampaign;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class GroupJoinCampaignModel {
	
	public GroupJoinCampaignModel(){}
	
	public GroupJoinCampaign get(String id) {
		String query = "SELECT * FROM group_join_campaigns WHERE id=" + id + " AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseGroupJoinCampaign(DBHelper.executeQuery(query));
	}

	public ArrayList<GroupJoinCampaign> all() {
		String query = "SELECT * FROM group_join_campaigns WHERE owner = '" + SessionHelper.getSessionUser() + "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseGroupJoinCampaigns(DBHelper.executeQuery(query));
	}
	
	public boolean add(GroupJoinCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "INSERT INTO group_join_campaigns(owner, name, clone_ids, group_ids, min_wait, max_wait,";
		query += "status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + gcc.getName() + "',";
		query += "'" + gcc.getCloneIdList() + "',";
		query += "'" + gcc.getGroupIds() + "',";
		query +=  gcc.getMinWait() + ",";
		query +=  gcc.getMaxWait() + ",";
		
		query +=  "'" + gcc.getStatus() + "',";
		query +=  "'" + dateFormater.format(now)  + "'";
		
		query += ")";
		
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(GroupJoinCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "UPDATE group_join_campaigns SET ";
		query += "name='" + gcc.getName() + "',";
		query += "clone_ids='" + gcc.getCloneIdList() + "',";
		query += "group_ids='" + gcc.getGroupIds() + "',";
		
		query +=  "min_wait=" + gcc.getMinWait() + ",";
		query +=  "max_wait=" + gcc.getMaxWait() + ",";
		
		query +=  "status='" + gcc.getStatus() + "'";
		//query +=  "updated_at='" + dateFormater.format(now)  + "'";
		
		query += " WHERE id=" + gcc.getId() + " AND owner ='" + SessionHelper.getSessionUser() + "'";
		
		System.out.println(query);
		
		return DBHelper.execute(query);
	}
	
	public boolean delete(int id) {
		String query = "DELETE FROM group_join_campaigns WHERE id=" + id + " AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}
	
	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "DELETE FROM group_join_campaigns WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		DBHelper.execute(query);
	}
	
	public void updateStatus(ArrayList<String> ids, String status) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "UPDATE group_join_campaigns set status='" + status + "' WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		DBHelper.execute(query);
	}
	
	public Vector<String> getTableHeader() {
		Vector<String> header = new Vector<String>();
		header.add("id");
		header.add("campaign");
		header.add("số clone");
		header.add("số group");
		header.add("ngày tạo");
		header.add("lần chạy cuối");
		header.add("hiện trạng");
		
		header.add("min_wait");
		header.add("max_wait");
	
		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<GroupJoinCampaign> campaigns = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (GroupJoinCampaign gcc : campaigns) {
			row = new Vector<String>();
			row.add(String.valueOf(gcc.getId()));  //id
			row.add(gcc.getName()); //name
			row.add(String.valueOf(gcc.getCloneIdList().split(",").length)); //number of clone
			row.add(String.valueOf(gcc.getGroupIds().split(",").length)); //name
			row.add(gcc.getCreatedAt());
			row.add(gcc.getUpdatedAt());
			row.add(gcc.getStatus());

			row.add(String.valueOf(gcc.getMinWait()));
			row.add(String.valueOf(gcc.getMaxWait()));
					
			data.add(row);
		}
		return data;
	}
}
