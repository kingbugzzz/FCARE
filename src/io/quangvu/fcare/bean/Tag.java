package io.quangvu.fcare.bean;

public class Tag {
	
	private int id;
	private String code, name;
	
	public Tag(){}
	
	public Tag(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Tag(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
}
