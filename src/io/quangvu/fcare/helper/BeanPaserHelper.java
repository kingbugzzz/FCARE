package io.quangvu.fcare.helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import io.quangvu.fcare.bean.Clone;
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
				clone.setId(rs.getString("id"));
				clone.setName(rs.getString("name"));
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
				clone.setId(rs.getString("id"));
				clone.setName(rs.getString("name"));
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
}
