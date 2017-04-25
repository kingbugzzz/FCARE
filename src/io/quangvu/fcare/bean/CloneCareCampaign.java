package io.quangvu.fcare.bean;

public class CloneCareCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList;
	private int minLike, maxLike, waitLike, waitCloneLike;
	private int minComment, maxComment, waitComment, waitCloneComment;
	private int minShare, maxShare, waitShare, waitCloneShare;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public CloneCareCampaign() {}

	public CloneCareCampaign(String cloneIdList, int id, String owner, String name, int minLike, int maxLike,
			int waitLike, int waitCloneLike, int minComment, int maxComment, int waitComment, int waitCloneComment,
			int minShare, int maxShare, int waitShare, int waitCloneShare, int numThread, String createdAt,
			String updatedAt, String status) {
		super();
		this.cloneIdList = cloneIdList;
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.minLike = minLike;
		this.maxLike = maxLike;
		this.waitLike = waitLike;
		this.waitCloneLike = waitCloneLike;
		this.minComment = minComment;
		this.maxComment = maxComment;
		this.waitComment = waitComment;
		this.waitCloneComment = waitCloneComment;
		this.minShare = minShare;
		this.maxShare = maxShare;
		this.waitShare = waitShare;
		this.waitCloneShare = waitCloneShare;
		this.numThread = numThread;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public String getCloneIdList() {
		return cloneIdList;
	}

	public void setCloneIdList(String cloneIdList) {
		this.cloneIdList = cloneIdList;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinLike() {
		return minLike;
	}

	public void setMinLike(int minLike) {
		this.minLike = minLike;
	}

	public int getMaxLike() {
		return maxLike;
	}

	public void setMaxLike(int maxLike) {
		this.maxLike = maxLike;
	}

	public int getWaitLike() {
		return waitLike;
	}

	public void setWaitLike(int waitLike) {
		this.waitLike = waitLike;
	}

	public int getWaitCloneLike() {
		return waitCloneLike;
	}

	public void setWaitCloneLike(int waitCloneLike) {
		this.waitCloneLike = waitCloneLike;
	}

	public int getMinComment() {
		return minComment;
	}

	public void setMinComment(int minComment) {
		this.minComment = minComment;
	}

	public int getMaxComment() {
		return maxComment;
	}

	public void setMaxComment(int maxComment) {
		this.maxComment = maxComment;
	}

	public int getWaitComment() {
		return waitComment;
	}

	public void setWaitComment(int waitComment) {
		this.waitComment = waitComment;
	}

	public int getWaitCloneComment() {
		return waitCloneComment;
	}

	public void setWaitCloneComment(int waitCloneComment) {
		this.waitCloneComment = waitCloneComment;
	}

	public int getMinShare() {
		return minShare;
	}

	public void setMinShare(int minShare) {
		this.minShare = minShare;
	}

	public int getMaxShare() {
		return maxShare;
	}

	public void setMaxShare(int maxShare) {
		this.maxShare = maxShare;
	}

	public int getWaitShare() {
		return waitShare;
	}

	public void setWaitShare(int waitShare) {
		this.waitShare = waitShare;
	}

	public int getWaitCloneShare() {
		return waitCloneShare;
	}

	public void setWaitCloneShare(int waitCloneShare) {
		this.waitCloneShare = waitCloneShare;
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
		return "CloneCareCampaign [cloneIdList=" + cloneIdList + ", id=" + id + ", owner=" + owner + ", name=" + name
				+ ", minLike=" + minLike + ", maxLike=" + maxLike + ", waitLike=" + waitLike + ", waitCloneLike="
				+ waitCloneLike + ", minComment=" + minComment + ", maxComment=" + maxComment + ", waitComment="
				+ waitComment + ", waitCloneComment=" + waitCloneComment + ", minShare=" + minShare + ", maxShare="
				+ maxShare + ", waitShare=" + waitShare + ", waitCloneShare=" + waitCloneShare + ", numThread="
				+ numThread + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status + "]";
	}
	
}
