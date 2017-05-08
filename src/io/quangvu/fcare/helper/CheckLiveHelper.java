package io.quangvu.fcare.helper;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.selenium.WebDriverManager;

public class CheckLiveHelper {
		
	public static String check(String id, String pass, String userAgent) {
		PhantomJSDriver driver = WebDriverManager.getInstance().getPhantomJSDriver(userAgent);
		driver.get("https://mbasic.facebook.com/");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(id);
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		if (driver.getCurrentUrl().contains("checkpoint")) {
			return "checkpoint";
		} else {
			return CookieHelper.getCookieString(driver);
		}
	}
}
