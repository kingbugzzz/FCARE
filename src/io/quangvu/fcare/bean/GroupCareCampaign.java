package io.quangvu.fcare.bean;

public class GroupCareCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList, groupIds;
	private int minMem, maxMem, waitMem, waitClone;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public GroupCareCampaign(){}
	
	

	public GroupCareCampaign(String owner, int id, String name, String cloneIdList, String groupIds, int minMem,
			int maxMem, int waitMem, int waitClone, int numThread, String createdAt, String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.groupIds = groupIds;
		this.minMem = minMem;
		this.maxMem = maxMem;
		this.waitMem = waitMem;
		this.waitClone = waitClone;
		this.numThread = numThread;
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
	
	public String getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(String groupIds) {
		this.groupIds = groupIds;
	}

	public void setCloneIdList(String cloneIdList) {
		this.cloneIdList = cloneIdList;
	}

	public int getMinMem() {
		return minMem;
	}

	public void setMinMem(int minMem) {
		this.minMem = minMem;
	}

	public int getMaxMem() {
		return maxMem;
	}

	public void setMaxMem(int maxMem) {
		this.maxMem = maxMem;
	}

	public int getWaitMem() {
		return waitMem;
	}

	public void setWaitMem(int waitMem) {
		this.waitMem = waitMem;
	}

	public int getWaitClone() {
		return waitClone;
	}

	public void setWaitClone(int waitClone) {
		this.waitClone = waitClone;
	}

	public int getNumThread() {
		return numThread;
	}

	public void setNumThread(int numThread) {
		this.numThread = numThread;
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
		return "GroupCareCampaign [owner=" + owner + ", id=" + id + ", name=" + name + ", cloneIdList=" + cloneIdList
				+ ", groupIds=" + groupIds + ", minMem=" + minMem + ", maxMem=" + maxMem + ", waitMem=" + waitMem
				+ ", waitClone=" + waitClone + ", numThread=" + numThread + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", status=" + status + "]";
	}
}
