package io.quangvu.fcare.main;

import java.awt.EventQueue;
import java.util.Random;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.gui.KeyCheckerFrame;
import io.quangvu.fcare.gui.LoginFrame;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.helper.KeyHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.service.CloneCareService;

public class Main {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
//		this.run();
		this.cloneServiceDebugger();
	}
	
	private void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (KeyHelper.validKey()) {
					new LoginFrame();
				} else {
					new KeyCheckerFrame();
				}
			}
		});
	}
	
	private void cloneServiceDebugger() {
		DBHelper.cnt();
		
		CloneModel cloneModel = new CloneModel();
		//Test Clone 6 - Ngô Hữu Tường
		Clone clone = cloneModel.get("100016413638900");
		CloneCareService cloneCareService = new CloneCareService(clone);
		cloneCareService.login();
		
		//cloneCareService.changeAvatar(IOHelper.getRandomImagePath("resource/avatar/girls"));
		
		//cloneCareService.addFriendByUid("phong.tran.2010");
		
		cloneCareService.addSuggesFriends(5);
		
		cloneCareService.logout();
		
		DBHelper.disconnect();
	}
}
