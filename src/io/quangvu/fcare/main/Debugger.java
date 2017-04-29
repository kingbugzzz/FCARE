package io.quangvu.fcare.main;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.service.CloneCareService;

public class Debugger {
	
	public Debugger() {
		this.testCloneService();
	}
	
	public void testCloneService() {
			DBHelper.cnt();
			
			CloneModel cloneModel = new CloneModel();
			//Test Clone 6 - Ngô Hữu Tường
//			Clone clone = cloneModel.get("100016413638900");
			Clone clone = cloneModel.get("100016488123712");
			CloneCareService cloneCareService = new CloneCareService(clone);
			cloneCareService.login();
			
			cloneCareService.changeAvatar(IOHelper.getRandomImagePath("resource/avatar/girls"));
			
			cloneCareService.addFriendByUid("phong.tran.2010");
			
			//cloneCareService.addSuggesFriends(5);
			
//			cloneCareService.acceptFriends(15);
			
//			cloneCareService.postImageStatus(IOHelper.getRandomImagePath("resource/img/tha-thinh"), "Em buồn em nhớ, một ngày trong veo...");
			
//			cloneCareService.postLinkStatus("https://www.youtube.com/watch?v=JhWmRVwNhO4&t=2355s",
//										"Trong Người Phán Xử Tập 7, Kẻ giấu mặt đã đứng sau vụ ám sát Phan Quân sẽ xuất hiện. Đó là một nhân vật khét tiếng trong giới giang hồ.");
			
			cloneCareService.logout();
			
			DBHelper.disconnect();
	}

	public static void main(String args[]) {
		new Debugger();
	}
}