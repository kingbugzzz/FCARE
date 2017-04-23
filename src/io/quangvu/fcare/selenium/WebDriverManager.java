package io.quangvu.fcare.selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.quangvu.fcare.config.AppConfig;



public class WebDriverManager {

	private static WebDriverManager instance = null;

	private PhantomJSDriver phantomjsDriver = null;
	// private FirefoxDriver firefoxDriver = null;

	private WebDriverManager() {
	}

	public static WebDriverManager getInstance() {
		if (instance == null) {
			instance = new WebDriverManager();
		}
		return instance;
	}

	public PhantomJSDriver getNewInstanceOfPhantomJSDriver() {
		DesiredCapabilities desireCaps = DesiredCapabilities.phantomjs();
		desireCaps.setJavascriptEnabled(true);
		desireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				AppConfig.get("phantomjs_execution_path"));
		return new PhantomJSDriver(desireCaps);
	}

	public PhantomJSDriver getPhantomJSDriver() {
		if (phantomjsDriver == null) {
			DesiredCapabilities desireCaps = DesiredCapabilities.phantomjs();
			desireCaps.setJavascriptEnabled(true);
			desireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					AppConfig.get("phantomjs_execution_path"));
			phantomjsDriver = new PhantomJSDriver(desireCaps);
			phantomjsDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return phantomjsDriver;
	}

	public PhantomJSDriver getPhantomJSDriver(String referer, String userAgent, ArrayList<String> cliArgsCap) {
		if (phantomjsDriver == null) {
			DesiredCapabilities desireCaps = DesiredCapabilities.phantomjs();
			desireCaps.setJavascriptEnabled(true);
			desireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					AppConfig.get("phantomjs_execution_path"));

			if (referer != null) {
				desireCaps.setCapability("phantomjs.page.customHeaders.Referer", referer);
			}

			if (userAgent != null) {
				desireCaps.setCapability("phantomjs.page.settings.userAgent", userAgent);
			}

			if (cliArgsCap != null) {
				desireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
			}

			phantomjsDriver = new PhantomJSDriver(desireCaps);
		}
		return phantomjsDriver;
	}

	public FirefoxDriver getFirefoxDriver(String profileName) {
		if (!profileName.equals(null) || !profileName.equals("")) {
			System.setProperty("webdriver.gecko.driver", AppConfig.get("gecko_driver"));
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile(profileName);
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxDriver.PROFILE, myprofile);
			FirefoxDriver driver = new FirefoxDriver(cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
		return null;
	}
	
	public FirefoxDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", AppConfig.get("gecko_driver"));
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
