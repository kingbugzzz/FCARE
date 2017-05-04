package io.quangvu.fcare.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.helper.BeanPaserHelper;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SessionHelper;

public class CloneCareCampaignModel {
	
	public CloneCareCampaignModel(){}
	
	public CloneCareCampaign get(String id) {
		String query = "SELECT * FROM clone_care_campaigns WHERE id=" + id + " AND owner = '" + SessionHelper.getSessionUser()
				+ "'";
		System.out.println(query);
		return BeanPaserHelper.parseCloneCareCampaign(DBHelper.executeQuery(query));
	}

	public ArrayList<CloneCareCampaign> all() {
		String query = "SELECT * FROM clone_care_campaigns WHERE owner = '" + SessionHelper.getSessionUser() + "' order by created_at";
		System.out.println(query);
		return BeanPaserHelper.parseCloneCareCampaigns(DBHelper.executeQuery(query));
	}
	
	public boolean add(CloneCareCampaign cloneCC) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "INSERT INTO clone_care_campaigns(owner, name, clone_ids, status_type, min_like, max_like, min_like_wait, max_like_wait,";
		query += "min_comment, max_comment, min_comment_wait, max_comment_wait,";
		query += "min_share, max_share, min_share_wait, max_share_wait,";
		query += "status, created_at) VALUES(";
		
		query += "'" + SessionHelper.getSessionUser() + "',";
		query += "'" + cloneCC.getName() + "',";
		query += "'" + cloneCC.getCloneIdList() + "',";
		query += "'" + cloneCC.getStatusType() + "',";
		
		query +=  cloneCC.getMinLike() + ",";
		query +=  cloneCC.getMaxLike() + ",";
		query +=  cloneCC.getMinLikeWait() + ",";
		query +=  cloneCC.getMaxLikeWait() + ",";
		
		query +=  cloneCC.getMinComment() + ",";
		query +=  cloneCC.getMaxComment() + ",";
		query +=  cloneCC.getMinCommentWait() + ",";
		query +=  cloneCC.getMaxCommentWait() + ",";
		
		query +=  cloneCC.getMinShare() + ",";
		query +=  cloneCC.getMaxShare() + ",";
		query +=  cloneCC.getMinShareWait() + ",";
		query +=  cloneCC.getMaxShareWait() + ",";
		
		query +=  "'" + cloneCC.getStatus() + "',";
		query +=  "'" + dateFormater.format(now)  + "'";
		
		query += ")";
		
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean update(CloneCareCampaign cloneCC) {
		Date now =  new Date();
		DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		String query = "UPDATE clone_care_campaigns SET ";
		query += "name='" + cloneCC.getName() + "',";
		query += "clone_ids='" + cloneCC.getCloneIdList() + "',";
		query += "status_type='" + cloneCC.getStatusType() + "',";
		
		query +=  "min_like=" + cloneCC.getMinLike() + ",";
		query +=  "max_like=" + cloneCC.getMaxLike() + ",";
		query +=  "min_like_wait=" + cloneCC.getMinLikeWait() + ",";
		query +=  "max_like_wait=" + cloneCC.getMaxLikeWait() + ",";
		
		query +=  "min_comment=" + cloneCC.getMinComment() + ",";
		query +=  "max_comment=" + cloneCC.getMaxComment() + ",";
		query +=  "min_comment_wait=" + cloneCC.getMinCommentWait() + ",";
		query +=  "max_comment_wait=" + cloneCC.getMaxCommentWait() + ",";
		
		query +=  "min_share=" + cloneCC.getMinShare() + ",";
		query +=  "max_share=" + cloneCC.getMaxShare() + ",";
		query +=  "min_share_wait=" + cloneCC.getMinShareWait() + ",";
		query +=  "max_share_wait=" + cloneCC.getMaxShareWait() + ",";
		
		query +=  "status='" + cloneCC.getStatus() + "'";
		//query +=  "updated_at='" + dateFormater.format(now)  + "'";
		
		query += " WHERE id=" + cloneCC.getId() + " AND owner ='" + SessionHelper.getSessionUser() + "'";
		
		System.out.println(query);
		
		return DBHelper.execute(query);
	}
	
	public boolean updateStringField(int id, String field, String value) {
		String query = "UPDATE clone_care_campaigns SET " + field + "='" + value + "' WHERE id=" + id + " ADN owner = '"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}

	public boolean updateField(int id, String field, String value) {
		String query = "UPDATE clone_care_campaigns SET " + field + "=" + value + " WHERE id=" + id + " ADN owner = '"
				+ SessionHelper.getSessionUser() + "'";
		System.out.println(query);
		return DBHelper.execute(query);
	}
	
	public boolean delete(int id) {
		String query = "DELETE FROM clone_care_campaigns WHERE id=" + id + " AND owner='" + SessionHelper.getSessionUser() + "'";
		return DBHelper.execute(query);
	}
	
	public void delete(ArrayList<String> ids) {
		String strIds = "";
		for(String id : ids) {
			strIds += "" + id + ",";
		}
		System.out.println(strIds);
		strIds = strIds.substring(0, strIds.length()-1);
		String query = "DELETE FROM clone_care_campaigns WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		String query = "UPDATE clone_care_campaigns set status='" + status + "' WHERE id in (" + strIds + ") AND owner='" + SessionHelper.getSessionUser() + "'";
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
		header.add("kiểu status");
		
		header.add("min_like");
		header.add("max_like");
		header.add("min_like_wait");
		header.add("max_like_wait");
		
		header.add("min_comment");
		header.add("max_comment");
		header.add("min_comment_wait");
		header.add("max_comment_wait");
		
		header.add("min_share");
		header.add("max_share");
		header.add("min_share_wait");
		header.add("max_share_wait");
		
		return header;
	}

	public Vector<Vector<String>> getTableDataModel() {
		ArrayList<CloneCareCampaign> campaigns = this.all();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		for (CloneCareCampaign cloneCC : campaigns) {
			row = new Vector<String>();
			row.add(String.valueOf(cloneCC.getId()));  //id
			row.add(cloneCC.getName()); //name
			row.add(String.valueOf(cloneCC.getCloneIdList().split(",").length)); //number of clone
			row.add(cloneCC.getCreatedAt());
			row.add(cloneCC.getUpdatedAt());
			row.add(cloneCC.getStatus());
			row.add(String.valueOf(cloneCC.getStatusType()));

			row.add(String.valueOf(cloneCC.getMinLike()));
			row.add(String.valueOf(cloneCC.getMaxLike()));
			row.add(String.valueOf(cloneCC.getMinLikeWait()));
			row.add(String.valueOf(cloneCC.getMaxLikeWait()));
			
			row.add(String.valueOf(cloneCC.getMinComment()));
			row.add(String.valueOf(cloneCC.getMaxComment()));
			row.add(String.valueOf(cloneCC.getMinCommentWait()));
			row.add(String.valueOf(cloneCC.getMaxCommentWait()));
			
			row.add(String.valueOf(cloneCC.getMinShare()));
			row.add(String.valueOf(cloneCC.getMaxShare()));
			row.add(String.valueOf(cloneCC.getMinShareWait()));
			row.add(String.valueOf(cloneCC.getMaxShareWait()));
			
			data.add(row);
		}
		return data;
	}
}
