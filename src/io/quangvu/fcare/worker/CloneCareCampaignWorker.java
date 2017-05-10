package io.quangvu.fcare.worker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.counter.Counter;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.selenium.WebDriverManager;

public class CloneCareCampaignWorker implements Runnable {

	private volatile boolean stop = false;
	
	private JProgressBar progressBar;
	private JTextArea textArea;
	private PhantomJSDriver driver;
	private String name;
	private Counter counter;
	private Clone clone;
	CloneCareCampaign campaign;
	
	public CloneCareCampaignWorker(CloneCareCampaign campaign, Clone clone, Counter counter, JProgressBar progressBar, JTextArea textArea) {
		this.campaign = campaign;
		this.clone = clone;
		this.name = this.clone.getName();
		this.counter = counter;
		this.textArea = textArea;
		this.progressBar = progressBar;
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(this.counter.max());
	}
	
	public void run() {
		System.out.println(this.name + " started");
		while(!stop) {
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			this.care();
			this.terminate();
			this.counter.count();
			this.progressBar.setValue(this.counter.getValue());
		}
		System.out.println(this.name + " finished");
	}
	
	public void terminate() {
//		this.textArea.append("\n" +this.name+ "---is terminating...");
		stop = true;		
		this.driver.quit();
		this.textArea.append("\n" +this.name+ "---terminated");
	}
	
	public void care() {
		this.driver = WebDriverManager.getInstance().getPhantomJSDriver(this.clone.getUserAgent());
		try {
			System.out.println("doing job...");
			Thread.sleep(5000);
			System.out.println("stop");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	public boolean isRunning() {
		return !this.stop;
	}
	
	public void logout() {
		this.driver.quit();
		System.out.println(this.clone.getName() + " finished job.");
	}
}
