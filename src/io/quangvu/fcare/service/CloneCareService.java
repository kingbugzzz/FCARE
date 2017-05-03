package io.quangvu.fcare.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
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
//		System.out.println(clone.toString());
//		System.out.println(">>>login<<<");
//		this.driver = WebDriverManager.getInstance().getPhantomJSDriver(this.clone.getUserAgent());
//		this.driver.get("https://mbasic.facebook.com/");
//		System.out.println(this.driver.getTitle() + "-" + this.driver.getCurrentUrl());
//		this.driver.findElement(By.name("email")).clear();
//		this.driver.findElement(By.name("email")).sendKeys(this.clone.getId());
//		this.driver.findElement(By.name("pass")).clear();
//		this.driver.findElement(By.name("pass")).sendKeys(this.clone.getPassword());
//		this.driver.findElement(By.name("login")).click();
//		if (this.driver.getCurrentUrl().contains("checkpoint")) {
//			System.out.println(this.clone.getName() + "[id:" + this.clone.getId() + "] got checkpoint!");
//			return false;
//		} else {
//			System.out.println(this.clone.getName() + " login successful!");
//			this.isLoggedIn = true;
//			return true;
//		}
		System.out.println(this.clone.getName() + " s logging in...");
		return true;
	}

	public void changeAvatar(String avataPath) {
//		System.out.println(">>>change avatar<<<");
//		System.out.println(avataPath);
//		this.driver.get("https://mbasic.facebook.com/profile_picture/?returnuri=profile.php");
//		System.out.println(driver.getCurrentUrl());
//		WebElement fileInput = driver.findElement(By.name("pic"));
//		fileInput.sendKeys(avataPath);
//		WebElement submit = driver
//				.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div[1]/div[3]/form/ol/li[2]/input");
//		submit.click();
//		System.out.println("avatar changed");
		
		System.out.println(this.clone.getName() + " is changing avatar...");
	}

	public void postTextLink(String content) {
//		driver.findElement(By.name("xc_message")).sendKeys(content);
//		driver.findElement(By.name("view_post")).click();
//		System.out.println("post!");
		
		System.out.println(this.clone.getName() + " is posting status...");
	}

	public void postImageStatus(String imagePath, String content) {
//		System.out.println("preparing to upload image");
//		driver.findElementByXPath(
//				"//*[@id='mbasic_inline_feed_composer']/form/div[2]/span/div[1]/table/tbody/tr/td[2]/input").click();
//		WebElement fileInput = driver.findElement(By.name("file1"));
//		System.out.println("choosing image to upload");
//		fileInput.sendKeys(imagePath);
//		System.out.println(imagePath);
//		System.out.println("uploading...");
//		driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/form/div[3]/input[1]").click();
//		System.out.println("Writing status");
//		driver.findElement(By.name("xc_message")).sendKeys(content);
//		System.out.println("posting...");
//		driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div/form/input[18]").click();
//		System.out.println("done!");
		
		System.out.println(this.clone.getName() + " is posting image status...");
	}

	public void like() {
		System.out.println(this.clone.getName() + " is doing like...");
	} 
	
	public void comment() {
		System.out.println(this.clone.getName() + " is doing comment...");
	}
	
	public void share() {
		System.out.println(this.clone.getName() + " is doing share...");
	}

	public void logout() {
//		this.driver.quit();
		System.out.println(this.clone.getName() + " finished job.");
	}
	
	public String getName() {
		return this.clone.getName();
	}
}
