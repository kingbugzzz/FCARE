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
		
		String query = "INSERT INTO group_care_campaigns(owner, name, clone_ids, min_add, max_add, wait_add, wait_clone_add,";
		query += "num_thread, status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + gcc.getName() + "',";
		query += "'" + gcc.getCloneIdList() + "',";
		
		query +=  gcc.getMinAdd() + ",";
		query +=  gcc.getMaxAdd() + ",";
		query +=  gcc.getWaitAdd() + ",";
		query +=  gcc.getWaitCloneAdd() + ",";
		
		query +=  gcc.getNumThread() + ",";
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
		
		query +=  "min_add=" + gcc.getMinAdd() + ",";
		query +=  "max_add=" + gcc.getMaxAdd() + ",";
		query +=  "wait_add=" + gcc.getWaitAdd() + ",";
		query +=  "wait_clone_add=" + gcc.getWaitCloneAdd() + ",";
		
		query +=  "num_thread=" + gcc.getNumThread() + ",";
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
		header.add("ngày tạo");
		header.add("lần chạy cuối");
		header.add("hiện trạng");
		
		header.add("min_add");
		header.add("max_add");
		header.add("wait_add");
		header.add("wait_clone_add");
	
		header.add("số luồng");

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
			row.add(gcc.getCreatedAt());
			row.add(gcc.getUpdatedAt());
			row.add(gcc.getStatus());

			row.add(String.valueOf(gcc.getMinAdd()));
			row.add(String.valueOf(gcc.getMaxAdd()));
			row.add(String.valueOf(gcc.getWaitAdd()));
			row.add(String.valueOf(gcc.getWaitCloneAdd()));
					
			row.add(String.valueOf(gcc.getNumThread()));
			
			data.add(row);
		}
		return data;
	}
}
