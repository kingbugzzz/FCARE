package io.quangvu.fcare.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.model.CloneModel;

public class FriendCareService {

	private Clone clone;
	private CloneModel cloneModel;
	private PhantomJSDriver driver;
	private boolean isLoggedIn = false;
	
	public FriendCareService(String cloneId) {
		this.cloneModel = new CloneModel();
		this.clone = this.cloneModel.get(cloneId);
	}
	
	public void addSuggesFriends(int limit) {
		System.out.println(">>>add suggest friends<<<");
		int count = 0;
		for (String uid : this.getSuggestionFriendsUid()) {
			if (count == limit) {
				System.out.println("reached to limit [" + limit + "]-> done!");
				break;
			} else {
				this.addFriendByUid(uid);
				count++;
				System.out.println("wait 5 seconds for next one");
				try {
					Thread.sleep(5000);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}
		}
	}
	
	private ArrayList<String> getSuggestionFriendsUid() {
		this.driver.get("https://mbasic.facebook.com/friends/center/suggestions/?fb_ref=psa&_rdr");
		ArrayList<String> suggestionListId = new ArrayList<String>();
		List<WebElement> addLinks = driver
				.findElementsByXPath("//*[@id='friends_center_main']/div[1]/div/table/tbody/tr/td[2]/a");
		for (WebElement link : addLinks) {
			String uid = ((link.getAttribute("href").split("uid=")[1]).split("&"))[0];
			suggestionListId.add(uid);
		}
		return suggestionListId;
	}
	
	public void addFriendsByUid(ArrayList<String> listId) {
		System.out.println("Preparing to add " + listId.size() + " friends");
		for (String uid : listId) {
			this.addFriendByUid(uid);
			try {
				System.out.println("wait 5 seconds for next one");
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
		System.out.println("finished");
	}

	public void addFriendByUid(String uid) {
		System.out.println("adding friend[" + uid + "]");
		driver.get("https://mbasic.facebook.com/" + uid);
		driver.findElementByXPath("//*[@id='root']/div[1]/div[1]/div[3]/table/tbody/tr/td[1]/a").click();
		System.out.println("added");
	}
	
	public void acceptFriends(int limit) {
		System.out.println(">>>accept friends<<<");
		int count = 0;
		int rounds = limit / 10;
		System.out.println(limit + " friends will be accepted, number rounds = " + rounds + 1);
		if (rounds >= 1) {
			for (int i = 0; i < rounds + 1; i++) {
				for (String uid : this.getAcceptFriendUid()) {
					if (count == limit) {
						System.out.println("reached to limit [" + limit + "]-> done!");
						break;
					} else {
						this.acceptFriendByUid(uid);
						count++;
						System.out.println("wait 5 seconds for next one");
						try {
							Thread.sleep(5000);
						} catch (Exception ex) {
							ex.printStackTrace();
							continue;
						}
					}
					System.out.println("count = " + count);
				}
			}
		}
	}
	
	public void acceptFriendByUid(String uid) {
		System.out.println("accept friend[" + uid + "]");
		driver.get("https://mbasic.facebook.com/" + uid);
		driver.findElementByXPath("//*[@id='root']/div[1]/div[1]/div[3]/table/tbody/tr/td[1]/a").click();
		System.out.println("accept");
	}

	private ArrayList<String> getAcceptFriendUid() {
		this.driver.get("https://mbasic.facebook.com/friends/center/requests/#friends_center_main");
		ArrayList<String> listUid = new ArrayList<String>();
		List<WebElement> addLinks = driver
				.findElementsByXPath("//*[@id='friends_center_main']/div[1]/div/table/tbody/tr/td[2]/div[2]/a[1]");
		for (WebElement link : addLinks) {
			String uid = ((link.getAttribute("href").split("confirm=")[1]).split("&"))[0];
			listUid.add(uid);
		}
		return listUid;
	}
}
