package io.quangvu.fcare.main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.selenium.WebDriverManager;

public class Debugger {

	public static void main(String[] args) {
		
		String id = "0988031665@likechich3.com";  // "0988102926@likechich3.com"   "0988129071@likechich3.com"
		String pass = "ndtnht123";
		
		String userAgent = "Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Galaxy Nexus Build/IML74K) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Mobile Safari/535.7";
		
		PhantomJSDriver driver = WebDriverManager.getInstance().getPhantomJSDriver(userAgent);
		System.out.println(">>>login<<<");
		driver.get("https://mbasic.facebook.com/");
		System.out.println(driver.getTitle() + "-" + driver.getCurrentUrl());
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(id);
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		if (driver.getCurrentUrl().contains("checkpoint")) {
			System.out.println("Checkpoint");
		} else {
			System.out.println("login successful!");
		}
	}
}
