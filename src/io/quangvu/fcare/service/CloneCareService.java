package io.quangvu.fcare.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.selenium.WebDriverManager;

public class CloneCareService {
	
	private Clone clone;
	private CloneModel cloneModel;
	private PhantomJSDriver driver;
	private boolean isLoggedIn = false;

	public CloneCareService(String cloneId) {
		this.cloneModel = new CloneModel();
		this.clone = this.cloneModel.get(cloneId);
	}
		
	public boolean login() {
		System.out.println(">>>login<<<");
		driver = WebDriverManager.getInstance().getPhantomJSDriver(this.clone.getUserAgent());
		driver.get("https://mbasic.facebook.com/");
		System.out.println(driver.getTitle() + "-" + driver.getCurrentUrl());
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(this.clone.getId());
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys(this.clone.getPassword());
		driver.findElement(By.name("login")).click();
		if (driver.getCurrentUrl().contains("checkpoint")) {
			System.out.println("Checkpoint");
			return false;
		} else {
			System.out.println("login successful!");
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

	public void postTextLink(String content) {
		this.driver.get("https://mbasic.facebook.com/home.php");
		driver.findElement(By.name("xc_message")).sendKeys(content);
		driver.findElement(By.name("view_post")).click();
		System.out.println("post!");
	}

	public void postImageStatus(String imagePath, String content) {
		System.out.println("preparing to upload image");
		this.driver.get("https://mbasic.facebook.com/home.php");
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

	public void like(String uid) {
		this.driver.get("https://mbasic.facebook.com/profile.php?id=" + uid);
		List<WebElement> likeLinks = driver.findElementsByXPath("//a[starts-with(@href,'/a/like.php')]");
		likeLinks.get(NumberHelper.getRandomInt(likeLinks.size()-1, 0)).click();
		System.out.println("liked a post of friend <" + uid + ">" );
	}
	
	public void likePage(String pageId) {
		this.driver.get("https://mbasic.facebook.com/" + pageId);
		List<WebElement> likeLinks = driver.findElementsByXPath("//a[starts-with(@href,'/a/like.php')]");
		likeLinks.get(NumberHelper.getRandomInt(likeLinks.size()-1, 0)).click();
		System.out.println("liked a post of page <" + pageId + ">" );
	}

	public void comment(String uid) {
		this.driver.get("https://mbasic.facebook.com/profile.php?id=" + uid);
		List<WebElement> commentLinks = driver.findElementsByXPath("//*[starts-with(@id,'u_0')]/div[2]/div[2]/a[1]");
		commentLinks.get(NumberHelper.getRandomInt(commentLinks.size()-1, 0)).click();
		this.driver.findElementById("composerInput").sendKeys("it's a beautiful day!");
		this.driver.findElementByXPath("//*[starts-with(@id,'u_0')]/tbody/tr/td[2]/div/input").click();
		
		System.out.println("commented on a post of friend <" + uid + ">" );
	}
	
	public void commentPage(String pageId) {
		this.driver.get("https://mbasic.facebook.com/" + pageId);
		List<WebElement> commentLinks = driver.findElementsByXPath("//*[starts-with(@id,'u_0')]/div[2]/div[2]/a[1]");
		commentLinks.get(NumberHelper.getRandomInt(commentLinks.size()-1, 0)).click();
		this.driver.findElementById("composerInput").sendKeys("a hi hi");
		this.driver.findElementByXPath("//*[starts-with(@id,'u_0')]/tbody/tr/td[2]/div/input").click();
		
		System.out.println("commented on a post of friend <" + pageId + ">" );
	}

	public void share(String pageId) {
		this.driver.get("https://mbasic.facebook.com/" + pageId);
		List<WebElement> shareLinks = driver.findElementsByXPath("//*[starts-with(@id,'u_0')]/div[2]/div[2]/a[2]");
		shareLinks.get(NumberHelper.getRandomInt(shareLinks.size()-1, 0)).click();
		this.driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div/form/input[17]").click();
		System.out.println("shared a post of <" + pageId + ">" );
	}

	public void logout() {
		this.driver.quit();
		System.out.println(this.clone.getName() + " finished job.");
	}
	
	public ArrayList<String> getFriendIds() {

		ArrayList<String> friendIds = null;

		this.driver.get("https://mbasic.facebook.com/friends/center/friends");

		List<WebElement> friends = driver
				.findElementsByXPath("//*[@id='friends_center_main']/div[2]/div/table/tbody/tr/td[2]/a");

		if (friends.size() > 0) {
			friendIds = new ArrayList<String>();
			for (int i = 0; i < friends.size(); i++) {
				friendIds.add((friends.get(i).getAttribute("href").split("uid=")[1]).split("&")[0]);
			}
		} else {
			System.out.println("no friends");
		}

		return friendIds;
	}
	
	public String getName() {
		return this.clone.getName();
	}
}
