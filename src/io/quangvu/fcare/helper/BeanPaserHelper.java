package io.quangvu.fcare.helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.bean.FriendCareCampaign;
import io.quangvu.fcare.bean.GroupCareCampaign;
import io.quangvu.fcare.bean.GroupJoinCampaign;
import io.quangvu.fcare.bean.RStatus;
import io.quangvu.fcare.bean.Tag;

public class BeanPaserHelper {
	
	public static Tag parseTag(ResultSet rs) {
		try {
			Tag tag = new Tag();
			while (rs.next()) {
				tag.setName(rs.getString("name"));
				tag.setDescription(rs.getString("description"));
			}
			return tag;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<Tag> parseTags(ResultSet rs) {
		try {
			ArrayList<Tag> tags = new ArrayList<Tag>();
			Tag tag = null;
			while (rs.next()) {
				tag = new Tag();
				tag.setName(rs.getString("name"));
				tag.setDescription(rs.getString("description"));
				tags.add(tag);
			}
			return tags;
		}catch(Exception ex) {
			return null;
		}
	}

	public static Clone parseClone(ResultSet rs) {
		try {
			Clone clone = new Clone();
			while (rs.next()) {
				clone.setTag(rs.getString("tag"));
				clone.setOwner(rs.getString("owner"));
				clone.setId(rs.getString("id"));
				clone.setPassword(rs.getString("password"));
				clone.setName(rs.getString("name"));
				clone.setUserAgent(rs.getString("user_agent"));
				clone.setCookie(rs.getString("cookie"));
				clone.setToken(rs.getString("token"));
				clone.setNumFriend(Integer.parseInt(rs.getString("num_friend")));
				clone.setNumFriendReq(Integer.parseInt(rs.getString("num_friend_req")));
				clone.setNumFriendAcp(Integer.parseInt(rs.getString("num_friend_acp")));
				clone.setNumLike(Integer.parseInt(rs.getString("num_like")));
				clone.setNumShare(Integer.parseInt(rs.getString("num_share")));
				clone.setNumComment(Integer.parseInt(rs.getString("num_comment")));
				clone.setNumGma(Integer.parseInt(rs.getString("num_gma")));
				clone.setNumPll(Integer.parseInt(rs.getString("num_pll")));
				clone.setStatus(rs.getString("status"));
				clone.setCreatedAt(rs.getString("created_at"));
				clone.setUpdateAt(rs.getString("updated_at"));
			}
			return clone;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<Clone> parseClones(ResultSet rs) {
		ArrayList<Clone> list = new ArrayList<Clone>();
		try {
			Clone clone = null;
			while (rs.next()) {
				clone = new Clone();
				clone.setTag(rs.getString("tag"));
				clone.setOwner(rs.getString("owner"));
				clone.setId(rs.getString("id"));
				clone.setPassword(rs.getString("password"));
				clone.setName(rs.getString("name"));
				clone.setUserAgent(rs.getString("user_agent"));
				clone.setCookie(rs.getString("cookie"));
				clone.setToken(rs.getString("token"));
				clone.setNumFriend(Integer.parseInt(rs.getString("num_friend")));
				clone.setNumFriendReq(Integer.parseInt(rs.getString("num_friend_req")));
				clone.setNumFriendAcp(Integer.parseInt(rs.getString("num_friend_acp")));
				clone.setNumLike(Integer.parseInt(rs.getString("num_like")));
				clone.setNumShare(Integer.parseInt(rs.getString("num_share")));
				clone.setNumComment(Integer.parseInt(rs.getString("num_comment")));
				clone.setNumGma(Integer.parseInt(rs.getString("num_gma")));
				clone.setNumPll(Integer.parseInt(rs.getString("num_pll")));
				clone.setStatus(rs.getString("status"));
				clone.setCreatedAt(rs.getString("created_at"));
				clone.setUpdateAt(rs.getString("updated_at"));
				list.add(clone);
			}
			return list;
		}catch(Exception ex) {
			return null;
		}
	}

	public static CloneCareCampaign parseCloneCareCampaign(ResultSet rs) {
		try {
			CloneCareCampaign clonecc = new CloneCareCampaign();
			while (rs.next()) {
				clonecc.setOwner(rs.getString("owner"));
				clonecc.setId(rs.getInt("id"));
				clonecc.setName(rs.getString("name"));
				clonecc.setCloneIdList(rs.getString("clone_ids"));
				clonecc.setStatusType(rs.getString("status_type"));
				clonecc.setMinLike(rs.getInt("min_like"));
				clonecc.setMaxLike(rs.getInt("max_like"));
				clonecc.setWaitLike(rs.getInt("wait_like"));
				clonecc.setWaitCloneLike(rs.getInt("wait_clone_like"));
				clonecc.setMinComment(rs.getInt("min_comment"));
				clonecc.setMaxComment(rs.getInt("max_comment"));
				clonecc.setWaitComment(rs.getInt("wait_comment"));
				clonecc.setWaitCloneComment(rs.getInt("wait_clone_comment"));
				clonecc.setMinShare(rs.getInt("min_share"));
				clonecc.setMaxShare(rs.getInt("max_share"));
				clonecc.setWaitShare(rs.getInt("wait_share"));
				clonecc.setWaitCloneShare(rs.getInt("wait_clone_share"));
				clonecc.setNumThread(rs.getInt("num_thread"));
				clonecc.setStatus(rs.getString("status"));
				clonecc.setCreatedAt(rs.getString("created_at"));
				clonecc.setUpdatedAt(rs.getString("updated_at"));
			}
			return clonecc;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<CloneCareCampaign> parseCloneCareCampaigns(ResultSet rs) {
		try {
			ArrayList<CloneCareCampaign> cloneCCList = new ArrayList<CloneCareCampaign>();
			CloneCareCampaign clonecc = null;
			while (rs.next()) {
				clonecc = new CloneCareCampaign();
				clonecc.setOwner(rs.getString("owner"));
				clonecc.setId(rs.getInt("id"));
				clonecc.setName(rs.getString("name"));
				clonecc.setCloneIdList(rs.getString("clone_ids"));
				clonecc.setStatusType(rs.getString("status_type"));
				clonecc.setMinLike(rs.getInt("min_like"));
				clonecc.setMaxLike(rs.getInt("max_like"));
				clonecc.setWaitLike(rs.getInt("wait_like"));
				clonecc.setWaitCloneLike(rs.getInt("wait_clone_like"));
				clonecc.setMinComment(rs.getInt("min_comment"));
				clonecc.setMaxComment(rs.getInt("max_comment"));
				clonecc.setWaitComment(rs.getInt("wait_comment"));
				clonecc.setWaitCloneComment(rs.getInt("wait_clone_comment"));
				clonecc.setMinShare(rs.getInt("min_share"));
				clonecc.setMaxShare(rs.getInt("max_share"));
				clonecc.setWaitShare(rs.getInt("wait_share"));
				clonecc.setWaitCloneShare(rs.getInt("wait_clone_share"));
				clonecc.setNumThread(rs.getInt("num_thread"));
				clonecc.setStatus(rs.getString("status"));
				clonecc.setCreatedAt(rs.getString("created_at"));
				clonecc.setUpdatedAt(rs.getString("updated_at"));
				cloneCCList.add(clonecc);
			}
			return cloneCCList;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static FriendCareCampaign parseFriendCareCampaign(ResultSet rs) {
		try {
			FriendCareCampaign fcc = new FriendCareCampaign();
			while (rs.next()) {
				fcc.setOwner(rs.getString("owner"));
				fcc.setId(rs.getInt("id"));
				fcc.setName(rs.getString("name"));
				fcc.setCloneIdList(rs.getString("clone_ids"));
				
				fcc.setMinReq(rs.getInt("min_req"));
				fcc.setMaxReq(rs.getInt("max_req"));
				fcc.setWaitReq(rs.getInt("wait_req"));
				fcc.setWaitCloneReq(rs.getInt("wait_clone_req"));
				
				fcc.setMinAcp(rs.getInt("min_acp"));
				fcc.setMaxAcp(rs.getInt("max_acp"));
				fcc.setWaitAcp(rs.getInt("wait_acp"));
				fcc.setWaitCloneAcp(rs.getInt("wait_clone_acp"));
				
				fcc.setNumThread(rs.getInt("num_thread"));
				fcc.setStatus(rs.getString("status"));
				fcc.setCreatedAt(rs.getString("created_at"));
				fcc.setUpdatedAt(rs.getString("updated_at"));
			}
			return fcc;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<FriendCareCampaign> parseFriendCareCampaigns(ResultSet rs) {
		try {
			ArrayList<FriendCareCampaign> fccList = new ArrayList<FriendCareCampaign>();
			FriendCareCampaign fcc = null;
			while (rs.next()) {
				fcc = new FriendCareCampaign();
				fcc.setOwner(rs.getString("owner"));
				fcc.setId(rs.getInt("id"));
				fcc.setName(rs.getString("name"));
				fcc.setCloneIdList(rs.getString("clone_ids"));
				
				fcc.setMinReq(rs.getInt("min_req"));
				fcc.setMaxReq(rs.getInt("max_req"));
				fcc.setWaitReq(rs.getInt("wait_req"));
				fcc.setWaitCloneReq(rs.getInt("wait_clone_req"));
				
				fcc.setMinAcp(rs.getInt("min_acp"));
				fcc.setMaxAcp(rs.getInt("max_acp"));
				fcc.setWaitAcp(rs.getInt("wait_acp"));
				fcc.setWaitCloneAcp(rs.getInt("wait_clone_acp"));
				
				fcc.setNumThread(rs.getInt("num_thread"));
				fcc.setStatus(rs.getString("status"));
				fcc.setCreatedAt(rs.getString("created_at"));
				fcc.setUpdatedAt(rs.getString("updated_at"));
				fccList.add(fcc);
			}
			return fccList;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static GroupCareCampaign parseGroupCareCampaign(ResultSet rs) {
		try {
			GroupCareCampaign gcc = new GroupCareCampaign();
			while (rs.next()) {
				gcc.setOwner(rs.getString("owner"));
				gcc.setId(rs.getInt("id"));
				gcc.setName(rs.getString("name"));
				gcc.setCloneIdList(rs.getString("clone_ids"));
				gcc.setGroupIds(rs.getString("group_ids"));
				
				gcc.setMinMem(rs.getInt("min_mem"));
				gcc.setMaxMem(rs.getInt("max_mem"));
				gcc.setWaitMem(rs.getInt("wait_mem"));
				gcc.setWaitClone(rs.getInt("wait_clone"));
				
				gcc.setNumThread(rs.getInt("num_thread"));
				gcc.setStatus(rs.getString("status"));
				gcc.setCreatedAt(rs.getString("created_at"));
				gcc.setUpdatedAt(rs.getString("updated_at"));
			}
			return gcc;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<GroupCareCampaign> parseGroupCareCampaigns(ResultSet rs) {
		try {
			ArrayList<GroupCareCampaign> gccList = new ArrayList<GroupCareCampaign>();
			GroupCareCampaign gcc = null;
			while (rs.next()) {
				gcc = new GroupCareCampaign();
				gcc.setOwner(rs.getString("owner"));
				gcc.setId(rs.getInt("id"));
				gcc.setName(rs.getString("name"));
				gcc.setCloneIdList(rs.getString("clone_ids"));
				gcc.setGroupIds(rs.getString("group_ids"));
				
				gcc.setMinMem(rs.getInt("min_mem"));
				gcc.setMaxMem(rs.getInt("max_mem"));
				gcc.setWaitMem(rs.getInt("wait_mem"));
				gcc.setWaitClone(rs.getInt("wait_clone"));
				
				gcc.setNumThread(rs.getInt("num_thread"));
				gcc.setStatus(rs.getString("status"));
				gcc.setCreatedAt(rs.getString("created_at"));
				gcc.setUpdatedAt(rs.getString("updated_at"));
				gccList.add(gcc);
			}
			return gccList;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static GroupJoinCampaign parseGroupJoinCampaign(ResultSet rs) {
		try {
			GroupJoinCampaign gcc = new GroupJoinCampaign();
			while (rs.next()) {
				gcc.setOwner(rs.getString("owner"));
				gcc.setId(rs.getInt("id"));
				gcc.setName(rs.getString("name"));
				gcc.setCloneIdList(rs.getString("clone_ids"));
				gcc.setGroupIds(rs.getString("group_ids"));
				
				gcc.setMinWait(rs.getInt("min_wait"));
				gcc.setMaxWait(rs.getInt("max_wait"));
				gcc.setWaitClone(rs.getInt("wait_clone"));
				
				gcc.setNumThread(rs.getInt("num_thread"));
				gcc.setStatus(rs.getString("status"));
				gcc.setCreatedAt(rs.getString("created_at"));
				gcc.setUpdatedAt(rs.getString("updated_at"));
			}
			return gcc;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<GroupJoinCampaign> parseGroupJoinCampaigns(ResultSet rs) {
		try {
			ArrayList<GroupJoinCampaign> gccList = new ArrayList<GroupJoinCampaign>();
			GroupJoinCampaign gcc = null;
			while (rs.next()) {
				gcc = new GroupJoinCampaign();
				gcc.setOwner(rs.getString("owner"));
				gcc.setId(rs.getInt("id"));
				gcc.setName(rs.getString("name"));
				gcc.setCloneIdList(rs.getString("clone_ids"));
				gcc.setGroupIds(rs.getString("group_ids"));
				
				gcc.setMinWait(rs.getInt("min_wait"));
				gcc.setMaxWait(rs.getInt("max_wait"));
				gcc.setWaitClone(rs.getInt("wait_clone"));
				
				gcc.setNumThread(rs.getInt("num_thread"));
				gcc.setStatus(rs.getString("status"));
				gcc.setCreatedAt(rs.getString("created_at"));
				gcc.setUpdatedAt(rs.getString("updated_at"));
				gccList.add(gcc);
			}
			return gccList;
		}catch(Exception ex) {
			return null;
		}
	}

	public static RStatus parseRStatus(ResultSet rs) {
		try {
			RStatus status = new RStatus();
			while (rs.next()) {
				status.setOwner(rs.getString("owner"));
				status.setTag(rs.getString("tag"));
				status.setId(rs.getInt("id"));
				status.setName(rs.getString("name"));
				status.setSrc(rs.getString("src_file"));
			}
			return status;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static ArrayList<RStatus> parseAllRStatus(ResultSet rs) {
		try {
			ArrayList<RStatus> list = new ArrayList<RStatus>();
			RStatus status = null;
			while (rs.next()) {
				status =  new RStatus();
				status.setOwner(rs.getString("owner"));
				status.setTag(rs.getString("tag"));
				status.setId(rs.getInt("id"));
				status.setName(rs.getString("name"));
				status.setSrc(rs.getString("src_file"));
				list.add(status);
			}
			return list;
		}catch(Exception ex) {
			return null;
		}
	}
}
