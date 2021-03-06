package io.quangvu.fcare.thread;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.text.BadLocationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.counter.CloneCareCampaignCounter;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.selenium.WebDriverManager;

public class CloneCareThread extends AbstractThread {

	private Clone clone;
	private CloneModel cloneModel;
	private PhantomJSDriver driver;
	private boolean isLoggedIn = false;

	public CloneCareThread(String name, JProgressBar bar, JEditorPane editor, CloneCareCampaignCounter counter,
			int limitJobs, String cloneId) {
		super(name, bar, editor, counter, limitJobs);
		this.cloneModel = new CloneModel();
		this.clone = cloneModel.get(cloneId);
		this.name = this.name + " > " + this.clone.getName();
	}

	public void care() throws InterruptedException, BadLocationException {
		
		System.out.println(this.name + " logging in...");
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " logging in...",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(10000);
		System.out.println(this.name + " logged in");
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " logged in",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(this.name + " posting status...");
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " posting status...",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(10000);
		
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " doing like...",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(this.name + " doing like...");
		Thread.sleep(10000);
		
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " doing comment...",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(this.name + " doing comment...");
		Thread.sleep(20000);

		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " doing share...",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(this.name + " doing share...");
		Thread.sleep(10000);
			
		try {
			this.editorPane.getDocument().insertString(this.editorPane.getDocument().getLength(), "\n" + this.name + " finished carring job",
					null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(this.name  + " finished carring job");
		
		counter.count();
		
		// update progress bar
		progressBar.setValue(counter.getValue());
		
		this.stop();
	}

	public boolean login() {
		System.out.println(clone.toString());
		System.out.println(">>>login<<<");
		this.driver = WebDriverManager.getInstance().getPhantomJSDriver(this.clone.getUserAgent());
		this.driver.get("https://mbasic.facebook.com/");
		System.out.println(this.driver.getTitle() + "-" + this.driver.getCurrentUrl());
		this.driver.findElement(By.name("email")).clear();
		this.driver.findElement(By.name("email")).sendKeys(this.clone.getId());
		this.driver.findElement(By.name("pass")).clear();
		this.driver.findElement(By.name("pass")).sendKeys(this.clone.getPassword());
		this.driver.findElement(By.name("login")).click();
		if (this.driver.getCurrentUrl().contains("checkpoint")) {
			System.out.println(this.clone.getName() + "[id:" + this.clone.getId() + "] got checkpoint!");
			return false;
		} else {
			System.out.println(this.clone.getName() + " login successful!");
			this.isLoggedIn = true;
			return true;
		}
	}

	public void changeAvatar(String avataPath) {
		System.out.println(">>>change avatar<<<");
		System.out.println(avataPath);
		this.driver.get("https://mbasic.facebook.com/profile_picture/?returnuri=profile.php");
		System.out.println(driver.getCurrentUrl());
		WebElement fileInput = driver.findElement(By.name("pic"));
		fileInput.sendKeys(avataPath);
		WebElement submit = driver
				.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div[1]/div[3]/form/ol/li[2]/input");
		submit.click();
		System.out.println("avatar changed");
	}

	public void postPlainTextStatus(String content) {
		driver.findElement(By.name("xc_message")).sendKeys(content);
		driver.findElement(By.name("view_post")).click();
		System.out.println("post!");
	}

	public void postLinkStatus(String link, String content) {
		driver.findElement(By.name("xc_message")).sendKeys(content + "\n\n" + link);
		driver.findElement(By.name("view_post")).click();
		System.out.println("post!");
	}

	public void postImageStatus(String imagePath, String content) {
		System.out.println("preparing to upload image");
		driver.findElementByXPath(
				"//*[@id='mbasic_inline_feed_composer']/form/div[2]/span/div[1]/table/tbody/tr/td[2]/input").click();
		WebElement fileInput = driver.findElement(By.name("file1"));
		System.out.println("choosing image to upload");
		fileInput.sendKeys(imagePath);
		System.out.println(imagePath);
		System.out.println("uploading...");
		driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/form/div[3]/input[1]").click();
		System.out.println("Writing status");
		driver.findElement(By.name("xc_message")).sendKeys(content);
		System.out.println("posting...");
		driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div/form/input[18]").click();
		System.out.println("done!");
	}

	public void addMemGroup(String groupId, int maxMem) {
		int count = 0;
		for (int i = 0; i < 50; i++) {
			System.out.println("turn " + i + 1);
			driver.get("https://mbasic.facebook.com/groups/members/search/?group_id=1403352583092360");
			System.out.println(driver.getCurrentUrl());
			List<WebElement> checkboxes = driver.findElementsByXPath(
					"//*[@id='root']/table/tbody/tr/td/div[1]/div[1]/form/div/div/div/label/input");
			System.out.println(checkboxes.size() + " mem will be add in thisround");

			System.out.println("found" + checkboxes.size());
			for (WebElement cb : checkboxes) {
				cb.click();
				count++;
			}
			System.out.println("adding " + checkboxes.size() + " mem...");
			driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div[1]/div[1]/form/div/input[2]").click();
			System.out.println("done!");

			if (checkboxes.size() < 8) {
				System.out.println("added " + count + " mem -> finished");
				break;
			} else {
				System.out.println(" Wait 3 seconds for next round...");
			}

			if (count == maxMem) {
				System.out.println("reached to 20 mem ->finished");
				break;
			}

			try {
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
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

	public void getCookie() {
		System.out.println();
	}

	public void logout() {
		this.driver.quit();
	}

}
