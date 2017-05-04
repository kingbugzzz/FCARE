package io.quangvu.fcare.bean;

public class FriendCareCampaign {

	private String owner;
	private int id;
	private String name, cloneIdList;
	private int minReq, maxReq, minReqWait, maxReqWait;
	private int minAcp, maxAcp, minAcpWait, maxAcpWait;
	private String createdAt, updatedAt, status;

	public FriendCareCampaign() {
	}

	public FriendCareCampaign(String owner, int id, String name, String cloneIdList, int minReq, int maxReq,
			int minReqWait, int maxReqWait, int minAcp, int maxAcp, int minAcpWait, int maxAcpWait, String createdAt,
			String updatedAt, String status) {
		super();
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.cloneIdList = cloneIdList;
		this.minReq = minReq;
		this.maxReq = maxReq;
		this.minReqWait = minReqWait;
		this.maxReqWait = maxReqWait;
		this.minAcp = minAcp;
		this.maxAcp = maxAcp;
		this.minAcpWait = minAcpWait;
		this.maxAcpWait = maxAcpWait;
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

	public int getMinReqWait() {
		return minReqWait;
	}

	public void setMinReqWait(int minReqWait) {
		this.minReqWait = minReqWait;
	}

	public int getMaxReqWait() {
		return maxReqWait;
	}

	public void setMaxReqWait(int maxReqWait) {
		this.maxReqWait = maxReqWait;
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

	public int getMinAcpWait() {
		return minAcpWait;
	}

	public void setMinAcpWait(int minAcpWait) {
		this.minAcpWait = minAcpWait;
	}

	public int getMaxAcpWait() {
		return maxAcpWait;
	}

	public void setMaxAcpWait(int maxAcpWait) {
		this.maxAcpWait = maxAcpWait;
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
				+ ", minReq=" + minReq + ", maxReq=" + maxReq + ", minReqWait=" + minReqWait + ", maxReqWait="
				+ maxReqWait + ", minAcp=" + minAcp + ", maxAcp=" + maxAcp + ", minAcpWait=" + minAcpWait
				+ ", maxAcpWait=" + maxAcpWait + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status="
				+ status + "]";
	}
}
