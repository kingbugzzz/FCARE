package io.quangvu.fcare.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import io.quangvu.fcare.helper.IOHelper;
import io.quangvu.fcare.helper.NumberHelper;

public class TestService extends Thread {

	private static int DELAY = 100;
	
	private int cursor = 0;

	JProgressBar progressBar;
	JEditorPane editorPane;
	JButton btnStop;
	private DateFormat dateFormat;

	public TestService(JProgressBar bar, JEditorPane editor, JButton stop) {
		progressBar = bar;
		editorPane = editor;
		btnStop = stop;
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Stop chiến dịch tại đây?",
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					try {
						editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\nuser-stop!", null);
						interrupt();
						editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\ndone!!", null);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}
			}
		});
	}

	public void run() {
		int minimum = progressBar.getMinimum();
		int maximum = progressBar.getMaximum();
		for (int i = minimum; i < maximum; i++) {
			try {
				if(cursor==progressBar.getMaximum()) {
					editorPane.getDocument().insertString(editorPane.getDocument().getLength(),"\ninterrupting...", null);
					interrupt();
					editorPane.getDocument().insertString(editorPane.getDocument().getLength(),"\ndone!", null);
					break;
				}
				doSomething();
				Thread.sleep(DELAY);
			} catch (Exception ignoredException) {
				continue;
			}
		}
	}

	private void doSomething() {
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date now =  new Date();
		try {
			if (cursor < progressBar.getMaximum()) {
				now.setTime(System.currentTimeMillis());
				String strLog = uid[NumberHelper.getRandomInt(uid.length-1, 0)];
				strLog += " " + actions[NumberHelper.getRandomInt(actions.length-1, 0)];
				strLog += " " + targets[NumberHelper.getRandomInt(targets.length-1, 0)];
				
				editorPane.getDocument().insertString(editorPane.getDocument().getLength(), strLog + "\n" , null);
				Thread.sleep(NumberHelper.getRandomInt(30000, 10000)); // a method is working...
				now.setTime(System.currentTimeMillis());
//				editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\nA method is changing value..." , null);
				cursor = NumberHelper.getRandomInt(progressBar.getMaximum()+1, cursor++); //new value is updated
				now.setTime(System.currentTimeMillis());
//				editorPane.getDocument().insertString(editorPane.getDocument().getLength(), "\ncurrent value: " + cursor + "%", null);
				progressBar.setValue(cursor);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	String[] actions = {"share 1 bài từ", "like page", "like", "join group", "comment trên"};
	
	String[] uid = {"<100016395071313>", "<100016405390227>", "<100016383018168>", "<100016414809043>", "<100016431217027>",
			"<100016395071313>", "<100016405390227>", "<100016383018168>", "<100016414809043>", "<100016431217027>",
			};
	
	String[] targets = {"<100016413638900>", "<100016446425687>", "<100016379538528>", "<100016493281550>", "<100016450175428>",
			"<100016435896715>", "<100016423208068>", "<100016470153433>", "<100016425697900>", "<100016431217027>",
			};
}
