package io.quangvu.fcare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.GroupCareCampaign;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class GroupCareCampaignModel {
	
	public GroupCareCampaignModel(){}
	
	public GroupCareCampaign get(String id) {
		String query = "SELECT * FROM group_care_campaigns WHERE id=" + id + " AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseGroupCareCampaign(DBHelper.executeQuery(query));
	}

	public ArrayList<GroupCareCampaign> all() {
		String query = "SELECT * FROM group_care_campaigns WHERE owner = '" + SessionHelper.getSessionUser() + "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseGroupCareCampaigns(DBHelper.executeQuery(query));
	}
	
	public boolean add(GroupCareCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "INSERT INTO group_care_campaigns(owner, name, clone_ids, group_ids, min_mem, max_mem, min_wait, max_wait,";
		query += "status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + gcc.getName() + "',";
		query += "'" + gcc.getCloneIdList() + "',";
		query += "'" + gcc.getGroupIds() + "',";
		query +=  gcc.getMinMem() + ",";
		query +=  gcc.getMaxMem() + ",";
		query +=  gcc.getMinWait() + ",";
		query +=  gcc.getMaxWait() + ",";
		
		query +=  "'" + gcc.getStatus() + "',";
		query +=  "'" + dateFormater.format(now)  + "'";
		
		query += ")";
		
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(GroupCareCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "UPDATE group_care_campaigns SET ";
		query += "name='" + gcc.getName() + "',";
		query += "clone_ids='" + gcc.getCloneIdList() + "',";
		query += "group_ids='" + gcc.getGroupIds() + "',";
		
		query +=  "min_mem=" + gcc.getMinMem() + ",";
		query +=  "max_mem=" + gcc.getMaxMem() + ",";
		query +=  "min_wait=" + gcc.getMinWait() + ",";
		query +=  "max_wait=" + gcc.getMaxWait() + ",";
		
		query +=  "status='" + gcc.getStatus() + "'";
		//query +=  "updated_at='" + dateFormater.format(now)  + "'";
		
		query += " WHERE id=" + gcc.getId() + " AND owner ='" + SessionHelper.getSessionUser() + "'";
		
		System.out.println(query);
		
		return DBHelper.execute(query);
	}
	
		
	public boolean delete(int id) {
		String query = "DELETE FROM group_care_campaigns WHERE id=" + id + " AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}
	
	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "DELETE FROM group_care_campaigns WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		String query = "UPDATE group_care_campaigns set status='" + status + "' WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		
		header.add("min_mem");
		header.add("max_mem");
		header.add("min_wait");
		header.add("max_wait");
	
		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<GroupCareCampaign> campaigns = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (GroupCareCampaign gcc : campaigns) {
			row = new Vector<String>();
			row.add(String.valueOf(gcc.getId()));  //id
			row.add(gcc.getName()); //name
			row.add(String.valueOf(gcc.getCloneIdList().split(",").length)); //number of clone
			row.add(String.valueOf(gcc.getGroupIds().split(",").length)); //name
			row.add(gcc.getCreatedAt());
			row.add(gcc.getUpdatedAt());
			row.add(gcc.getStatus());

			row.add(String.valueOf(gcc.getMinMem()));
			row.add(String.valueOf(gcc.getMaxMem()));
			row.add(String.valueOf(gcc.getMinWait()));
			row.add(String.valueOf(gcc.getMaxWait()));
					
			data.add(row);
		}
		return data;
	}
}
