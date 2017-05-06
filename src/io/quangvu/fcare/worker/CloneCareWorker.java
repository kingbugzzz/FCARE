package io.quangvu.fcare.worker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.selenium.WebDriverManager;
import io.quangvu.fcare.service.CloneCareService;

public class CloneCareWorker extends SwingWorker<Void, String> {
	
	private int current = 0;
	private int max;
	
	private JTextArea textArea;
	private JProgressBar progressBar;
	private CloneCareCampaign campaign;
	String[] cloneIds = null;
	ArrayList<CloneCareService> careServiceList;
	private SimpleDateFormat dateFormat;
	private PhantomJSDriver driver;
	
	private int minLike, maxLike, minComment, maxComment, minShare, maxShare;
	private int waitLike, waitComment, waitShare, waitClone;
	
	public CloneCareWorker(CloneCareCampaign campaign, JTextArea textarea, JProgressBar progressBar) {
		this.dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		this.campaign = campaign;
		this.cloneIds = this.campaign.getCloneIdList().split(",");
		this.max = this.cloneIds.length;
		
		this.textArea = textarea;
		this.progressBar = progressBar;
		this.progressBar.setMaximum(0);
		this.progressBar.setMaximum(this.max-1);
		
		this.initCareServices();
		
	}
	
	public void initCareServices() {
		
		this.careServiceList = new ArrayList<CloneCareService>();
		CloneCareService careService = null;
		
		for(String cloneId : this.cloneIds) {
			careService = new CloneCareService(cloneId);
			this.careServiceList.add(careService);
		}
	}
	
	public String care(int current) throws InterruptedException {
						
		CloneCareService service = this.careServiceList.get(current);
		
		String info = service.getName() + "\n";
		
		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] turn: " + current + "\n";
		
//		System.out.println("create phantomjs");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] create phantomjs \n";
//		driver = WebDriverManager.getInstance().getPhantomJSDriver();
//		
//		System.out.println("load Google");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] load google web \n";
//		driver.get("google.com");
//		
//		System.out.println("sleep 3 seconds");
//		Thread.sleep(3000);
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] sleep 3 secon \n";
//		
//		System.out.println("load Facebook");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] load facebook web \n";
//		driver.get("facebook.com");
		
		service.login();
		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] logged in\n";
		Thread.sleep(NumberHelper.getRandomInt(6000, 3000));
		
		
//		service.postTextLink("");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] post text status\n";
//		Thread.sleep(500);
//		
//		service.postImageStatus("", "");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] post image status\n";
//		Thread.sleep(500);
//		
//		service.like();
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] like\n";
//		Thread.sleep(500);
//		
//		service.comment();
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] comment\n";
//		Thread.sleep(500);
//		
//		service.share();
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] shared\n";
//		Thread.sleep(500);
//		
//		service.logout();
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] logged out\n\n";
		
		return current + "#" + info;
	}
	
	protected Void doInBackground() throws Exception {
		String careInfo = null;
		while (current <= max) {
			careInfo = care(current);
			current++;
			publish(careInfo);
		}
		return null;
	}

	protected void process(List<String> chunks) {
		for (String chunk : chunks) {
			progressBar.setValue(Integer.parseInt(chunk.split("#")[0]));
			textArea.append(chunk.split("#")[1] + "\n");
		}
	}

	protected void done() {
		System.out.println("Done.");
		textArea.append("Done.");
	}

}