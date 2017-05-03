package io.quangvu.fcare.service;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.model.CloneModel;

public class GroupCareService {
	
	private Clone clone;
	private CloneModel cloneModel;
	private PhantomJSDriver driver;
	private boolean isLoggedIn = false;
	
	public GroupCareService(String cloneId) {
		this.cloneModel = new CloneModel();
		this.clone = this.cloneModel.get(cloneId);
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
}
