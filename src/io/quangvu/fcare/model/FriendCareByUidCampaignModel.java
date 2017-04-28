package io.quangvu.fcare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.FriendCareByUidCampaign;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class FriendCareByUidCampaignModel {
	
	public FriendCareByUidCampaignModel(){}
	
	public FriendCareByUidCampaign get(String id) {
		String query = "SELECT * FROM friend_care_by_uid_campaigns WHERE id=" + id + " AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseFriendCareByUidCampaign(DBHelper.executeQuery(query));
	}

	public ArrayList<FriendCareByUidCampaign> all() {
		String query = "SELECT * FROM friend_care_by_uid_campaigns WHERE owner = '" + SessionHelper.getSessionUser() + "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseFriendCareByUidCampaigns(DBHelper.executeQuery(query));
	}
	
	public boolean add(FriendCareByUidCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "INSERT INTO friend_care_by_uid_campaigns(owner, name, clone_ids, friend_ids_source_file, min_wait, max_wait,  wait_clone,";
		query += "num_thread, status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + gcc.getName() + "',";
		query += "'" + gcc.getCloneIdList() + "',";
		query += "'" + gcc.getFriendIdsSourceFile() + "',";
		query +=  gcc.getMinWait() + ",";
		query +=  gcc.getMaxWait() + ",";
		query +=  gcc.getWaitClone() + ",";
		
		query +=  gcc.getNumThread() + ",";
		query +=  "'" + gcc.getStatus() + "',";
		query +=  "'" + dateFormater.format(now)  + "'";
		
		query += ")";
		
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(FriendCareByUidCampaign gcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "UPDATE friend_care_by_uid_campaigns SET ";
		query += "name='" + gcc.getName() + "',";
		query += "clone_ids='" + gcc.getCloneIdList() + "',";
		query += "friend_ids_source_file='" + gcc.getFriendIdsSourceFile() + "',";
		
		query +=  "min_wait=" + gcc.getMinWait() + ",";
		query +=  "max_wait=" + gcc.getMaxWait() + ",";
		query +=  "wait_clone=" + gcc.getWaitClone() + ",";
		
		query +=  "num_thread=" + gcc.getNumThread() + ",";
		query +=  "status='" + gcc.getStatus() + "'";
		//query +=  "updated_at='" + dateFormater.format(now)  + "'";
		
		query += " WHERE id=" + gcc.getId() + " AND owner ='" + SessionHelper.getSessionUser() + "'";
		
		System.out.println(query);
		
		return DBHelper.execute(query);
	}
	
	public boolean delete(int id) {
		String query = "DELETE FROM friend_care_by_uid_campaigns WHERE id=" + id + " AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}
	
	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "DELETE FROM friend_care_by_uid_campaigns WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		String query = "UPDATE friend_care_by_uid_campaigns set status='" + status + "' WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		DBHelper.execute(query);
	}
	
	public Vector<String> getTableHeader() {
		Vector<String> header = new Vector<String>();
		header.add("id");
		header.add("campaign");
		header.add("số clone");
		header.add("file nguồn");
		header.add("ngày tạo");
		header.add("lần chạy cuối");
		header.add("hiện trạng");
		
		header.add("min_wait");
		header.add("max_wait");
		header.add("wait_clone");
	
		header.add("số luồng");

		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<FriendCareByUidCampaign> campaigns = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (FriendCareByUidCampaign gcc : campaigns) {
			row = new Vector<String>();
			row.add(String.valueOf(gcc.getId()));  //id
			row.add(gcc.getName()); //name
			row.add(String.valueOf(gcc.getCloneIdList().split(",").length)); //number of clone
			row.add(gcc.getFriendIdsSourceFile()); //name
			row.add(gcc.getCreatedAt());
			row.add(gcc.getUpdatedAt());
			row.add(gcc.getStatus());

			row.add(String.valueOf(gcc.getMinWait()));
			row.add(String.valueOf(gcc.getMaxWait()));
			row.add(String.valueOf(gcc.getWaitClone()));
					
			row.add(String.valueOf(gcc.getNumThread()));
			
			data.add(row);
		}
		return data;
	}
}
