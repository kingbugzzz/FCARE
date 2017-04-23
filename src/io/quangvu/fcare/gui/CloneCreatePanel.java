package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CloneCreatePanel extends JPanel {
	
	private JTextField textField;
	private JLabel lblCookie;
	private JPasswordField passwordField;
	
	public CloneCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		
		setLayout(null);
		
		JLabel lblCloneId = new JLabel("Clone ID");
		lblCloneId.setBounds(36, 34, 96, 14);
		add(lblCloneId);
		
		textField = new JTextField();
		textField.setBounds(123, 34, 355, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 62, 77, 14);
		add(lblPassword);
		
		lblCookie = new JLabel("Cookie");
		lblCookie.setBounds(36, 90, 96, 14);
		add(lblCookie);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(123, 93, 355, 42);
		add(editorPane);
		
		JButton btnCheckLive = new JButton("Check live");
		btnCheckLive.setBounds(123, 148, 160, 23);
		add(btnCheckLive);
		
		String[] tags = {"fashion", "food", "music", "sport", "movie", "trading", "dogs", "cats"};
		
		JLabel lblTags = new JLabel("Tag");
		lblTags.setBounds(36, 197, 46, 14);
		add(lblTags);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 238, 160, 20);
		comboBox.addItem("Active");
		comboBox.addItem("Deactive");
		add(comboBox);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(36, 238, 77, 14);
		add(lblTrngThi);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.dispose();
				dashboardFrame.loadPanel(new CloneMainPanel(dashboardFrame), "Quản lý clone");
			}
		});
		btnNewButton_2.setBounds(123, 289, 160, 23);
		add(btnNewButton_2);
		
		JButton btnReset = new JButton("Nhập lại");
		btnReset.setBounds(304, 289, 174, 23);
		add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 59, 355, 20);
		add(passwordField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(123, 197, 355, 20);
		add(comboBox_1);
		
		JButton btnNewCookie = new JButton("New cookie");
		btnNewCookie.setBounds(304, 148, 174, 23);
		add(btnNewCookie);

	}
}
