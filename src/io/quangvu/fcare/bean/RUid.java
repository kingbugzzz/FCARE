package io.quangvu.fcare.bean;

public class RUid {
	
	private int id;
	private String owner, tag, name, src;
	
	public RUid() {
		super();
	}

	public RUid(int id, String owner, String tag, String name, String src) {
		super();
		this.id = id;
		this.owner = owner;
		this.tag = tag;
		this.name = name;
		this.src = src;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "RUid [id=" + id + ", owner=" + owner + ", tag=" + tag + ", name=" + name + ", src=" + src
				+ "]";
	}
}
