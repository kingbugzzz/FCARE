package io.quangvu.fcare.bean;

public class GroupCareCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList;
	private int minAdd, maxAdd, waitAdd, waitCloneAdd;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public GroupCareCampaign(){}
	
	public GroupCareCampaign(String owner, int id, String name, String cloneIdList, int minAdd, int maxAdd, int waitAdd,
			int waitCloneAdd, int numThread, String createdAt, String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.minAdd = minAdd;
		this.maxAdd = maxAdd;
		this.waitAdd = waitAdd;
		this.waitCloneAdd = waitCloneAdd;
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

	public void setCloneIdList(String cloneIdList) {
		this.cloneIdList = cloneIdList;
	}

	public int getMinAdd() {
		return minAdd;
	}

	public void setMinAdd(int minAdd) {
		this.minAdd = minAdd;
	}

	public int getMaxAdd() {
		return maxAdd;
	}

	public void setMaxAdd(int maxAdd) {
		this.maxAdd = maxAdd;
	}

	public int getWaitAdd() {
		return waitAdd;
	}

	public void setWaitAdd(int waitAdd) {
		this.waitAdd = waitAdd;
	}

	public int getWaitCloneAdd() {
		return waitCloneAdd;
	}

	public void setWaitCloneAdd(int waitCloneAdd) {
		this.waitCloneAdd = waitCloneAdd;
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
				+ ", minAdd=" + minAdd + ", maxAdd=" + maxAdd + ", waitAdd=" + waitAdd + ", waitCloneAdd="
				+ waitCloneAdd + ", numThread=" + numThread + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", status=" + status + "]";
	}
}
