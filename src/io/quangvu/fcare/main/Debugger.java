package io.quangvu.fcare.main;

import java.util.ArrayList;
import java.util.List;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.thread.CloneCareThread;

public class Debugger {
	
	public Debugger() {
		KF kf =  new KF();
		kf.start();
		
	}
	
	public static void main(String args[]) {
		new Debugger();
	}
}

class KF {
	 
	String[] keo1 = {"k1", "k2", "k3", "k4"};
	String[] keo2 = {"k5", "k6", "k7", "k8"};
	String[] keo3 = {"k9", "k10", "k11", "k12"};
	
	ArrayList<String[]> kho = new ArrayList<String[]>(); 
	
	public KF() {
		kho.add(keo1);
		kho.add(keo2);
		kho.add(keo3);
	}
	
	public void start() {
		int count = 0;
		int turn = this.kho.size();
		System.out.println("#Number turm will be executed:" + turn);
		KM km = null;
		System.out.println("#start\n");
		
		while(count < turn) {
			System.out.println("#Turn " + (count+1));
			km = new KM(this.kho.get(count));
			if(km.work()) {
				count++;
				if(count<turn) {
					try{
						System.out.println("#sleep 5 second for next turn\n");
						Thread.sleep(5000);
					}catch(Exception ex) {
						
					}
				}else {
					System.out.println("\n*** job done! ***");
				}
			}
		}
	}

}

class KM {
	
	String[] keo;
	
	int count = 0;
	
	boolean done = false;
	
	public KM(String[] keo) {
		System.out.println("-I am KM");
		this.keo = keo;
	}
	
	public void setKeo(String[] keo) {
		this.keo = keo;
	}
	
	public String[] getKeo() {
		return this.keo;
	}
	
	public void count() {
		this.count++;
	}
	
	public int value() {
		return this.count;
	}
	
	public boolean work() {
		System.out.println("--KM is working now ");
		KE ke = new KE(this);
		for(String k : this.keo) {
			ke.ek(k);
		}
		done = true;
		System.out.println("--KM finished job");
		return true;
	}
	
	public boolean isDone() {
		if(this.count == keo.length) {
			return true;
		}
		return false;
	}
	
}

class KE {
	
	private KM km;
	
	public KE(KM km) {
		System.out.println("---I am KE!");
		this.km = km;
	}
	
	public void ek(String k) {
		System.out.println("----KE is eating " + k + " now");
		this.km.count();
	}
}

