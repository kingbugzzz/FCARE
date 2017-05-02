package io.quangvu.fcare.demo;

/*
This program is a part of the companion code for Core Java 8th ed.
(http://horstmann.com/corejava)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import io.quangvu.fcare.helper.NumberHelper;

/**
 * This program demonstrates the use of a progress bar to monitor the progress
 * of a thread.
 * 
 * @version 1.04 2007-08-01
 * @author Cay Horstmann
 */
public class ProgressBarTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ProgressBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A frame that contains a button to launch a simulated activity, a progress
 * bar, and a text area for the activity output.
 */
class ProgressBarFrame extends JFrame {
	public ProgressBarFrame() {
		setTitle("ProgressBarTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// this text area holds the activity output
		textArea = new JTextArea();

		// set up panel with button and progress bar

		final int MAX = 20;
		JPanel panel = new JPanel();
		startButton = new JButton("Start");
		progressBar = new JProgressBar(0, MAX);
		progressBar.setStringPainted(true);
		panel.add(startButton);
		panel.add(progressBar);

		checkBox = new JCheckBox("indeterminate");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				progressBar.setIndeterminate(checkBox.isSelected());
				progressBar.setStringPainted(!progressBar.isIndeterminate());
			}
		});
		panel.add(checkBox);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		// set up the button action

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				startButton.setEnabled(false);
				activity = new SimulatedActivity(MAX);
				activity.execute();
			}
		});
	}

	private JButton startButton;
	private JProgressBar progressBar;
	private JCheckBox checkBox;
	private JTextArea textArea;
	private SimulatedActivity activity;

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;

	class SimulatedActivity extends SwingWorker<Void, Integer> {
		/**
		 * Constructs the simulated activity that increments a counter from 0 to
		 * a given target.
		 * 
		 * @param t
		 *            the target value of the counter.
		 */
		public SimulatedActivity(int t) {
			current = 0;
			target = t;
		}

		protected Void doInBackground() throws Exception {

			while (current < target) {

				MyTask mytask = new MyTask("Task" + current);
				mytask.work();
				current++;
				publish(current);
			}

			return null;
		}

		protected void process(List<Integer> chunks) {
			for (Integer chunk : chunks) {
				textArea.append(chunk + "\n");
				progressBar.setValue(chunk);
			}
		}

		protected void done() {
			startButton.setEnabled(true);
		}

		private int current;
		private int target;
	}
}

class MyTask {

	private String name;

	public MyTask(String name) {
		this.name = name;
		System.out.println("Hi, my name is " + this.name);
	}

	public void work() {
		try {
			System.out.println(this.name + " logging...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " posting status...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " like...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " share...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " comment...");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

			System.out.println(this.name + " finished.");
			Thread.sleep(NumberHelper.getRandomInt(3000, 1000));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
