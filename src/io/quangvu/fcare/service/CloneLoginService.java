package io.quangvu.fcare.service;

import org.openqa.selenium.By;
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
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.name("xc_message")).sendKeys("this is a test message");
			driver.findElement(By.name("view_post")).click();
			System.out.println("post!");
		}
		driver.quit();
	}
}
