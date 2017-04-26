package io.quangvu.fcare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.FriendCareCampaign;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class FriendCareCampaignModel {
	
	public FriendCareCampaignModel(){}
	
	public FriendCareCampaign get(String id) {
		String query = "SELECT * FROM friend_care_campaigns WHERE id=" + id + " AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseFriendCareCampaign(DBHelper.executeQuery(query));
	}

	public ArrayList<FriendCareCampaign> all() {
		String query = "SELECT * FROM friend_care_campaigns WHERE owner = '" + SessionHelper.getSessionUser() + "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseFriendCareCampaigns(DBHelper.executeQuery(query));
	}
	
	public boolean add(FriendCareCampaign fcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "INSERT INTO friend_care_campaigns(owner, name, clone_ids, min_req, max_req, wait_req, wait_clone_req,";
		query += "min_acp, max_acp, wait_acp, wait_clone_acp,";
		query += "num_thread, status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + fcc.getName() + "',";
		query += "'" + fcc.getCloneIdList() + "',";
		
		query +=  fcc.getMinReq() + ",";
		query +=  fcc.getMaxReq() + ",";
		query +=  fcc.getWaitReq() + ",";
		query +=  fcc.getWaitCloneReq() + ",";
		
		query +=  fcc.getMinAcp() + ",";
		query +=  fcc.getMaxAcp() + ",";
		query +=  fcc.getWaitAcp() + ",";
		query +=  fcc.getWaitCloneAcp() + ",";

		
		query +=  fcc.getNumThread() + ",";
		query +=  "'" + fcc.getStatus() + "',";
		query +=  "'" + dateFormater.format(now)  + "'";
		
		query += ")";
		
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(FriendCareCampaign fcc) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "UPDATE friend_care_campaigns SET ";
		query += "name='" + fcc.getName() + "',";
		query += "clone_ids='" + fcc.getCloneIdList() + "',";
		
		query +=  "min_req=" + fcc.getMinReq() + ",";
		query +=  "max_req=" + fcc.getMaxReq() + ",";
		query +=  "wait_req=" + fcc.getWaitReq() + ",";
		query +=  "wait_clone_req=" + fcc.getWaitCloneReq() + ",";
		
		query +=  "min_acp=" + fcc.getMinAcp() + ",";
		query +=  "max_acp=" + fcc.getMaxAcp() + ",";
		query +=  "wait_acp=" + fcc.getWaitAcp() + ",";
		query +=  "wait_clone_acp=" + fcc.getWaitCloneAcp() + ",";
		
		query +=  "num_thread=" + fcc.getNumThread() + ",";
		query +=  "status='" + fcc.getStatus() + "'";
		//query +=  "updated_at='" + dateFormater.format(now)  + "'";
		
		query += " WHERE id=" + fcc.getId() + " AND owner ='" + SessionHelper.getSessionUser() + "'";
		
		System.out.println(query);
		
		return DBHelper.execute(query);
	}
	
		
	public boolean delete(int id) {
		String query = "DELETE FROM friend_care_campaigns WHERE id=" + id + " AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}
	
	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "DELETE FROM friend_care_campaigns WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		String query = "UPDATE friend_care_campaigns set status='" + status + "' WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		
		header.add("min_req");
		header.add("max_req");
		header.add("wait_req");
		header.add("wait_clone_req");
		
		header.add("min_acp");
		header.add("max_acp");
		header.add("wait_acp");
		header.add("wait_clone_acp");
		
		header.add("số luồng");

		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<FriendCareCampaign> campaigns = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (FriendCareCampaign fcc : campaigns) {
			row = new Vector<String>();
			row.add(String.valueOf(fcc.getId()));  //id
			row.add(fcc.getName()); //name
			row.add(String.valueOf(fcc.getCloneIdList().split(",").length)); //number of clone
			row.add(fcc.getCreatedAt());
			row.add(fcc.getUpdatedAt());
			row.add(fcc.getStatus());

			row.add(String.valueOf(fcc.getMinReq()));
			row.add(String.valueOf(fcc.getMaxReq()));
			row.add(String.valueOf(fcc.getWaitReq()));
			row.add(String.valueOf(fcc.getWaitCloneReq()));
			
			row.add(String.valueOf(fcc.getMinAcp()));
			row.add(String.valueOf(fcc.getMaxAcp()));
			row.add(String.valueOf(fcc.getWaitAcp()));
			row.add(String.valueOf(fcc.getWaitCloneAcp()));
			
			row.add(String.valueOf(fcc.getNumThread()));
			
			data.add(row);
		}
		return data;
	}
}
