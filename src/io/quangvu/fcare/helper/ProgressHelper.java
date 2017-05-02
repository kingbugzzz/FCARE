package io.quangvu.fcare.helper;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressHelper implements Runnable {

	private JProgressBar pBar;
	private int value = 0;
	
	public ProgressHelper(JProgressBar bar) {
		this.pBar = bar;
	}
	
	@Override
	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				pBar.setValue(value);
			}
		});
	}

	public JProgressBar getpBar() {
		return pBar;
	}

	public void setpBar(JProgressBar pBar) {
		this.pBar = pBar;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
