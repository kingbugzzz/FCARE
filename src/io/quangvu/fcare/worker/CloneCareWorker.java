package io.quangvu.fcare.worker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.helper.NumberHelper;
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
		
		//service.login();
		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] logged in\n";
		Thread.sleep(500);
		
//		service.changeAvatar("");
//		info += "---[" + this.dateFormat.format(System.currentTimeMillis()) + "] changed avatar\n";
//		Thread.sleep(500);
//		
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
			textArea.append(chunk.split("#")[1]);
		}
	}

	protected void done() {
		System.out.println("Done.");
		textArea.append("Done.");
	}

}