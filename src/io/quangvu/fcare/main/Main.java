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
import io.quangvu.fcare.service.CloneServiceCenter;

public class Main {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		this.start();
		//this.cloneServiceDebugger();
	}
	
	private void start() {
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
		CloneServiceCenter cloneCareService = new CloneServiceCenter(clone);
		cloneCareService.login();
		
		//cloneCareService.changeAvatar(IOHelper.getRandomImagePath("resource/avatar/girls"));
		
		//cloneCareService.addFriendByUid("phong.tran.2010");
		
		//cloneCareService.addSuggesFriends(5);
		
//		cloneCareService.acceptFriends(5);
		
		//cloneCareService.postImageStatus(IOHelper.getRandomImagePath("resource/img/tha-thinh"), "Em buồn em nhớ, một ngày trong veo...");
		
//		cloneCareService.postLinkStatus("https://www.youtube.com/watch?v=JhWmRVwNhO4&t=2355s",
//									"Trong Người Phán Xử Tập 7, Kẻ giấu mặt đã đứng sau vụ ám sát Phan Quân sẽ xuất hiện. Đó là một nhân vật khét tiếng trong giới giang hồ.");
		
		cloneCareService.logout();
		
		DBHelper.disconnect();
	}
}
