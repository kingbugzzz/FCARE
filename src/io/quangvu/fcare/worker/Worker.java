package io.quangvu.fcare.worker;

import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.quangvu.fcare.counter.Counter;
import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.selenium.WebDriverManager;

public class Worker {
	
	private String name;
	private PhantomJSDriver driver;
	private JProgressBar progressBar;
	private JTextArea textArea;
	private Counter counter;
	
	public Worker(String name, Counter counter, JProgressBar progressBar, JTextArea textArea) {
		this.name = name;
		this.counter = counter;
		this.textArea = textArea;
		this.progressBar = progressBar;
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(this.counter.max());
	}
	

}
