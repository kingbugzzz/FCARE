package io.quangvu.fcare.main;

import java.awt.EventQueue;

import io.quangvu.fcare.gui.KeyCheckerFrame;
import io.quangvu.fcare.gui.LoginFrame;
import io.quangvu.fcare.helper.KeyHelper;
import io.quangvu.fcare.service.CloneLoginService;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {		
//				if (KeyHelper.validKey()) {
//					new LoginFrame();
//				} else {
//					new KeyCheckerFrame();
//				}
				
				CloneLoginService.login("100016383018168", "Lol686868", "");
				
				
			}
		});
	}
}
