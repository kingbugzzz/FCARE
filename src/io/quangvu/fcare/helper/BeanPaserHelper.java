package io.quangvu.fcare.helper;

import java.sql.ResultSet;
import java.util.ArrayList;

import io.quangvu.fcare.bean.Tag;

public class BeanPaserHelper {
	
	public static Tag parseTag(ResultSet rs) {
		try {
			Tag tag = new Tag();
			while (rs.next()) {
				tag.setId(Integer.parseInt(rs.getString("id")));
				tag.setCode(rs.getString("code"));
				tag.setName(rs.getString("name"));
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
				tag.setId(Integer.parseInt(rs.getString("id")));
				tag.setCode(rs.getString("code"));
				tag.setName(rs.getString("name"));
				tags.add(tag);
			}
			return tags;
		}catch(Exception ex) {
			return null;
		}
	}

}
