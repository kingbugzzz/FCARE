package io.quangvu.fcare.bean;

public class GroupJoinCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList, groupIds;
	private int minWait, maxWait;
	private String createdAt, updatedAt, status;
	
	public GroupJoinCampaign(){}

	public GroupJoinCampaign(String owner, int id, String name, String cloneIdList, String groupIds, int minWait,
			int maxWait, String createdAt, String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.groupIds = groupIds;
		this.minWait = minWait;
		this.maxWait = maxWait;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCloneIdList() {
		return cloneIdList;
	}

	public void setCloneIdList(String cloneIdList) {
		this.cloneIdList = cloneIdList;
	}

	public String getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(String groupIds) {
		this.groupIds = groupIds;
	}

	public int getMinWait() {
		return minWait;
	}

	public void setMinWait(int minWait) {
		this.minWait = minWait;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GroupJoinCampaign [owner=" + owner + ", id=" + id + ", name=" + name + ", cloneIdList=" + cloneIdList
				+ ", groupIds=" + groupIds + ", minWait=" + minWait + ", maxWait=" + maxWait + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}
	
}
