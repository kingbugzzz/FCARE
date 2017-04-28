package io.quangvu.fcare.bean;

public class FriendCareByUidCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList, friendIdsSourceFile;
	private int minWait, maxWait, waitClone;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public FriendCareByUidCampaign(){}

	public FriendCareByUidCampaign(String owner, int id, String name, String cloneIdList, String friendIdsSourceFile, int minWait,
			int maxWait, int waitClone, int numThread, String createdAt, String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.friendIdsSourceFile = friendIdsSourceFile;
		this.minWait = minWait;
		this.maxWait = maxWait;
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

	public void setCloneIdList(String cloneIdList) {
		this.cloneIdList = cloneIdList;
	}

	public String getFriendIdsSourceFile() {
		return friendIdsSourceFile;
	}

	public void setFriendIdsSourceFile(String friendIdsSourceFile) {
		this.friendIdsSourceFile = friendIdsSourceFile;
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
		return "FriendCareByUidCampaign [owner=" + owner + ", id=" + id + ", name=" + name + ", cloneIdList="
				+ cloneIdList + ", friendIdsSourceFile=" + friendIdsSourceFile + ", minWait=" + minWait + ", maxWait="
				+ maxWait + ", waitClone=" + waitClone + ", numThread=" + numThread + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}
}
