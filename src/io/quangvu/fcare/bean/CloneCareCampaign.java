package io.quangvu.fcare.bean;

public class CloneCareCampaign {
	
	private String owner;
	private int id;
	private String name, cloneIdList, statusType;
	private int minLike, maxLike, minLikeWait, maxLikeWait;
	private int minComment, maxComment, minCommentWait, maxCommentWait;
	private int minShare, maxShare, minShareWait, maxShareWait;
	private int numThread;
	private String createdAt, updatedAt, status;
	
	public CloneCareCampaign() {}

	public CloneCareCampaign(String cloneIdList, int id, String owner, String name, int minLike, int maxLike,
			int minLikeWait, int maxLikeWait, int minComment, int maxComment, int minCommentWait, int maxCommentWait,
			int minShare, int maxShare, int minShareWait, int maxShareWait, int numThread, String createdAt,
			String updatedAt, String status) {
		super();
		this.cloneIdList = cloneIdList;
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.minLike = minLike;
		this.maxLike = maxLike;
		this.minLikeWait = minLikeWait;
		this.maxLikeWait = maxLikeWait;
		this.minComment = minComment;
		this.maxComment = maxComment;
		this.minCommentWait = minCommentWait;
		this.maxCommentWait = maxCommentWait;
		this.minShare = minShare;
		this.maxShare = maxShare;
		this.minShareWait = minShareWait;
		this.maxShareWait = maxShareWait;
		this.numThread = numThread;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}
	
	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
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

	public int getMinLikeWait() {
		return minLikeWait;
	}

	public void setMinLikeWait(int minLikeWait) {
		this.minLikeWait = minLikeWait;
	}

	public int getMaxLikeWait() {
		return maxLikeWait;
	}

	public void setMaxLikeWait(int maxLikeWait) {
		this.maxLikeWait = maxLikeWait;
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

	public int getMinCommentWait() {
		return minCommentWait;
	}

	public void setMinCommentWait(int minCommentWait) {
		this.minCommentWait = minCommentWait;
	}

	public int getMaxCommentWait() {
		return maxCommentWait;
	}

	public void setMaxCommentWait(int maxCommentWait) {
		this.maxCommentWait = maxCommentWait;
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

	public int getMinShareWait() {
		return minShareWait;
	}

	public void setMinShareWait(int minShareWait) {
		this.minShareWait = minShareWait;
	}

	public int getMaxShareWait() {
		return maxShareWait;
	}

	public void setMaxShareWait(int maxShareWait) {
		this.maxShareWait = maxShareWait;
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
		return "CloneCareCampaign [owner=" + owner + ", id=" + id + ", name=" + name + ", cloneIdList=" + cloneIdList
				+ ", statusType=" + statusType + ", minLike=" + minLike + ", maxLike=" + maxLike + ", minLikeWait="
				+ minLikeWait + ", maxLikeWait=" + maxLikeWait + ", minComment=" + minComment + ", maxComment="
				+ maxComment + ", minCommentWait=" + minCommentWait + ", maxCommentWait=" + maxCommentWait + ", minShare="
				+ minShare + ", maxShare=" + maxShare + ", minShareWait=" + minShareWait + ", maxShareWait="
				+ maxShareWait + ", numThread=" + numThread + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", status=" + status + "]";
	}

}
