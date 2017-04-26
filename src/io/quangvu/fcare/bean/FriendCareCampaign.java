package io.quangvu.fcare.bean;

public class FriendCareCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList;
	private int minReq, maxReq, waitReq, waitCloneReq;
	private int minAcp, maxAcp, waitAcp, waitCloneAcp;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public FriendCareCampaign(){}
	
	public FriendCareCampaign(String owner, int id, String name, String cloneIdList, int minReq, int maxReq,
			int waitReq, int waitCloneReq, int minAcp, int maxAcp, int waitAcp, int waitCloneAcp, int numThread,
			String createdAt, String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.minReq = minReq;
		this.maxReq = maxReq;
		this.waitReq = waitReq;
		this.waitCloneReq = waitCloneReq;
		this.minAcp = minAcp;
		this.maxAcp = maxAcp;
		this.waitAcp = waitAcp;
		this.waitCloneAcp = waitCloneAcp;
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

	public int getMinReq() {
		return minReq;
	}

	public void setMinReq(int minReq) {
		this.minReq = minReq;
	}

	public int getMaxReq() {
		return maxReq;
	}

	public void setMaxReq(int maxReq) {
		this.maxReq = maxReq;
	}

	public int getWaitReq() {
		return waitReq;
	}

	public void setWaitReq(int waitReq) {
		this.waitReq = waitReq;
	}

	public int getWaitCloneReq() {
		return waitCloneReq;
	}

	public void setWaitCloneReq(int waitCloneReq) {
		this.waitCloneReq = waitCloneReq;
	}

	public int getMinAcp() {
		return minAcp;
	}

	public void setMinAcp(int minAcp) {
		this.minAcp = minAcp;
	}

	public int getMaxAcp() {
		return maxAcp;
	}

	public void setMaxAcp(int maxAcp) {
		this.maxAcp = maxAcp;
	}

	public int getWaitAcp() {
		return waitAcp;
	}

	public void setWaitAcp(int waitAcp) {
		this.waitAcp = waitAcp;
	}

	public int getWaitCloneAcp() {
		return waitCloneAcp;
	}

	public void setWaitCloneAcp(int waitCloneAcp) {
		this.waitCloneAcp = waitCloneAcp;
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
		return "FriendCareCampaign [owner=" + owner + ", id=" + id + ", name=" + name + ", cloneIdList=" + cloneIdList
				+ ", minReq=" + minReq + ", maxReq=" + maxReq + ", waitReq=" + waitReq + ", waitCloneReq="
				+ waitCloneReq + ", minAcp=" + minAcp + ", maxAcp=" + maxAcp + ", waitAcp=" + waitAcp
				+ ", waitCloneAcp=" + waitCloneAcp + ", numThread=" + numThread + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}
}
