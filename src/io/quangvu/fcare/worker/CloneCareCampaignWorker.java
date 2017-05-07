package io.quangvu.fcare.worker;

import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

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
	
	public CloneCareCampaignWorker(String name, Counter counter, JProgressBar progressBar, JTextArea textArea) {
		this.name = name;
		this.counter = counter;
		this.textArea = textArea;
		this.progressBar = progressBar;
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(this.counter.max());
	}
	
	public void run() {
		System.out.println(this.name + " started");
		while(!stop) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.phantomJobs();
			this.terminate();
			this.counter.count();
			this.progressBar.setValue(this.counter.getValue());
		}
		System.out.println(this.name + " finished");
	}
	
	public void terminate() {
		this.textArea.append("\n" +this.name+ "---is terminating...");
		stop = true;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.driver.quit();
		this.textArea.append("\n" +this.name+ "---terminated");
	}
	
	public void phantomJobs() {
		ArrayList<String> userAgents = IOHelper.readLines("config/uagents.dat");
		String userAgent = userAgents.get(NumberHelper.getRandomInt(userAgents.size(), 0));
		System.out.println(userAgent);
		this.driver = WebDriverManager.getInstance().getPhantomJSDriver(userAgent);
		this.driver.get("http://google.com");
		this.textArea.append("\n" + this.name + "---loading google.com");
		System.out.println(this.name + "---loading google.com");
		System.out.println(this.driver.getTitle());
		this.textArea.append("\n" + this.name + "--- " + this.driver.getTitle());
		System.out.println(this.name + "---sleep 1 second");
		this.textArea.append("\n" +this.name+ "---sleep 1 secon");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.get("http://vnexpress.net");
		System.out.println(this.name + "---loading vnexpress.net");
		this.textArea.append("\n" + this.name + " loading vnexpress.net");
		System.out.println(this.name + "---" + this.driver.getTitle());
		this.textArea.append("\n" + this.name + " - " + this.driver.getTitle());
		System.out.println(this.name + "--- sleep 2 second");
		this.textArea.append("\n" +this.name+ "---sleep 1 secon");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
