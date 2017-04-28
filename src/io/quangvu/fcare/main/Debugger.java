package io.quangvu.fcare.main;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
class BarThread extends Thread {
  private static int DELAY = 500;

  JProgressBar progressBar;

  public BarThread(JProgressBar bar) {
    progressBar = bar;
  }

  public void run() {
    int minimum = progressBar.getMinimum();
    int maximum = progressBar.getMaximum();
    for (int i = minimum; i < maximum; i++) {
      try {
        int value = progressBar.getValue();
        progressBar.setValue(value + 1);

        Thread.sleep(DELAY);
      } catch (InterruptedException ignoredException) {
      }
    }
  }
}
public class Debugger {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    JProgressBar aJProgressBar = new JProgressBar(0, 50);
    aJProgressBar.setStringPainted(true);

    JButton aJButton = new JButton("Start");

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        aJButton.setEnabled(false);
        Thread stepper = new BarThread(aJProgressBar);
        stepper.start();
      }
    };
    aJButton.addActionListener(actionListener);
    frame.add(aJProgressBar, BorderLayout.NORTH);
    frame.add(aJButton, BorderLayout.SOUTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}