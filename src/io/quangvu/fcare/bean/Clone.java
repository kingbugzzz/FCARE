package io.quangvu.fcare.bean;

public class Clone {
	
	private String owner, tag, id, password, name, userAgent, cookie, token, status, createdAt, updateAt;
	private int numFriend, numFriendReq, numFriendAcp, numLike, numShare, numComment, numGma, numPll;

	public Clone(){}
	
	public Clone(String id) {
		
	}
	
	public Clone(String owner, String tag, String id, String password, String name, String userAgent, String cookie,
			String token, String status, String createdAt, String updateAt, int numFriend, int numFriendReq,
			int numFriendAcp, int numLike, int numShare, int numComment, int numGma, int numPll) {
		super();
		this.owner = owner;
		this.tag = tag;
		this.id = id;
		this.password = password;
		this.name = name;
		this.userAgent = userAgent;
		this.cookie = cookie;
		this.token = token;
		this.status = status;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.numFriend = numFriend;
		this.numFriendReq = numFriendReq;
		this.numFriendAcp = numFriendAcp;
		this.numLike = numLike;
		this.numShare = numShare;
		this.numComment = numComment;
		this.numGma = numGma;
		this.numPll = numPll;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public int getNumFriend() {
		return numFriend;
	}

	public void setNumFriend(int numFriend) {
		this.numFriend = numFriend;
	}

	public int getNumFriendReq() {
		return numFriendReq;
	}

	public void setNumFriendReq(int numFriendReq) {
		this.numFriendReq = numFriendReq;
	}

	public int getNumFriendAcp() {
		return numFriendAcp;
	}

	public void setNumFriendAcp(int numFriendAcp) {
		this.numFriendAcp = numFriendAcp;
	}

	public int getNumLike() {
		return numLike;
	}

	public void setNumLike(int numLike) {
		this.numLike = numLike;
	}

	public int getNumShare() {
		return numShare;
	}

	public void setNumShare(int numShare) {
		this.numShare = numShare;
	}

	public int getNumComment() {
		return numComment;
	}

	public void setNumComment(int numComment) {
		this.numComment = numComment;
	}

	public int getNumGma() {
		return numGma;
	}

	public void setNumGma(int numGma) {
		this.numGma = numGma;
	}

	public int getNumPll() {
		return numPll;
	}

	public void setNumPll(int numPll) {
		this.numPll = numPll;
	}

	@Override
	public String toString() {
		return "Clone [owner=" + owner + ", tag=" + tag + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", userAgent=" + userAgent + ", cookie=" + cookie + ", token=" + token + ", status=" + status
				+ ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", numFriend=" + numFriend + ", numFriendReq="
				+ numFriendReq + ", numFriendAcp=" + numFriendAcp + ", numLike=" + numLike + ", numShare=" + numShare
				+ ", numComment=" + numComment + ", numGma=" + numGma + ", numPll=" + numPll + "]";
	}
}
