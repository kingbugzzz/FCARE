package io.quangvu.fcare.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.selenium.WebDriverManager;

public class CloneLoginService {
	
	public static void login(String id, String password, String cookie) {
		String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36 Windows";
		PhantomJSDriver driver = WebDriverManager.getInstance().getPhantomJSDriver();
		driver.get("https://mbasic.facebook.com/");
		System.out.println(driver.getTitle() + "-" + driver.getCurrentUrl());
		
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(id);
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		if(driver.getCurrentUrl().contains("checkpoint")) {
			System.out.println("got checkpoint!");
		}
		else {
			/**upload avatar
			driver.get("https://mbasic.facebook.com/profile_picture/?returnuri=profile.php");
			System.out.println(driver.getCurrentUrl());
			String path = "C:/Users/quang/Downloads/avatar.jpg";
			WebElement fileInput = driver.findElement(By.name("pic"));
			fileInput.sendKeys(path);
			WebElement submit = driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div[1]/div[3]/form/ol/li[2]/input");
			submit.click();
			try{
				Thread.sleep(5000);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			*/
			
			/**post text status
			driver.findElement(By.name("xc_message")).sendKeys("this is a test message");
			driver.findElement(By.name("view_post")).click();
			System.out.println("post!");
			*/
			
			/** post image status
			System.out.println("preparing to upload image");
			driver.findElementByXPath("//*[@id='mbasic_inline_feed_composer']/form/div[2]/span/div[1]/table/tbody/tr/td[2]/input").click();
			
			String path = "C:/Users/quang/Downloads/dog.jpg";
			WebElement fileInput = driver.findElement(By.name("file1"));
			System.out.println("choosing image to upload");
			fileInput.sendKeys(path);
			System.out.println("uploading...");
			driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/form/div[3]/input[1]").click();
			System.out.println("Writing status");
			String statusContent = "Đúng là đại gia có khác, tiền nhiều họ cũng tự tạo ra cho mình thú vui riêng. ";
			driver.findElement(By.name("xc_message")).sendKeys(statusContent);
			System.out.println("posting...");
			driver.findElementByXPath("//*[@id='root']/table/tbody/tr/td/div/form/input[18]").click();
			System.out.println("done!");
			*/
			
			/** add suggestion friend*/
			driver.get("https://mbasic.facebook.com/friends/center/suggestions/?fb_ref=psa&_rdr");
			System.out.println(driver.getTitle());
			List<WebElement> addFriendButtons = driver.findElementsByXPath("//*[@id='friends_center_main']/div[1]/div/table/tbody/tr/td[2]/div[2]/a[1]");
			System.out.println(addFriendButtons.size());
			
			for(WebElement addButton : addFriendButtons) {
				System.out.println("add a friend");
				addButton.click();
				System.out.println("ok");
				System.out.println("waiting 3 second for next one");
				try{
					Thread.sleep(3000);
				}catch(Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}
		}
		driver.quit();
	}
}
