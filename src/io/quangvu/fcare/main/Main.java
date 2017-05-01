package io.quangvu.fcare.main;

import java.awt.EventQueue;
import java.util.Random;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.gui.KeyCheckerFrame;
import io.quangvu.fcare.gui.LoginFrame;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.helper.KeyHelper;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.thread.CloneCareThread;

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
	
}
