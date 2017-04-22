package io.quangvu.fcare.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.quangvu.fcare.helper.KeyHelper;

public class KeyCheckerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField textField;

	public KeyCheckerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(KeyCheckerFrame.class.getResource("/io/quangvu/fcare/gui/icon/keychecker.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Your ID");
		lblUsername.setBounds(44, 39, 65, 14);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(44, 64, 319, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Your key");
		lblPassword.setBounds(46, 108, 65, 14);
		contentPane.add(lblPassword);
		
		JButton btnCheck = new JButton("Ok let's go!");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg();
			}
		});
		btnCheck.setBounds(44, 176, 117, 23);
		contentPane.add(btnCheck);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(44, 133, 319, 20);
		contentPane.add(textField);
		
		setTitle("Key Checker");
		setBounds(100, 100, 424, 278);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void reg() {
		if(KeyHelper.reg(this.textField.getText().trim(), this.username.getText().trim())) {
			String ObjButtons[] = { "Login Now", "Exit" };
			int PromptResult = JOptionPane.showOptionDialog(null, "Key is OK. Thank you! Let's make money baby!",
					"Holaaa!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
					ObjButtons, ObjButtons[1]);
			if (PromptResult == JOptionPane.YES_OPTION) {
				dispose();
				LoginFrame login = new LoginFrame();
			}
			if (PromptResult == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Sai key!");
		}
	}
}
