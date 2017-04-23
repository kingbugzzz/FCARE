package io.quangvu.fcare.bean;

public class Tag {
	
	private String owner, name, description;
	
	public Tag(){}
	
	public Tag(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", description=" + description + "]";
	}
}
