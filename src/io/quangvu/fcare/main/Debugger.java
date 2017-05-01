package io.quangvu.fcare.main;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.model.CloneModel;
import io.quangvu.fcare.thread.CloneCareThread;

public class Debugger {
	
	public Debugger() {
		
		Son son = new Son("An Hoa");
		son.test();
	}
	
	public static void main(String args[]) {
		new Debugger();
	}
}

abstract class Dad {
	
	protected String name = "Quang Vu";
	
	public Dad(){
		System.out.println("I am " + this.name);
	}
	
	public Dad(String name) {
		this.name = name;
		System.out.println("I am " + this.name);
	}
	
	public void printName() {
		System.out.println("I am " + this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void doSomething() {
		System.out.println("I am old, I don't want to do anything.");
	}
	
	public void test() {
		this.doSomething();
	}
}

class Son extends Dad {
	public Son() {
		super();
	}
	
	public Son(String name) {
		super(name);
	}
	
	public void doSomething() {
		System.out.println("I am a young man and I want to change the world!");
	}
}