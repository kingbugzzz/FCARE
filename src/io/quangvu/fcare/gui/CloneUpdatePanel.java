package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.CloneController;
import io.quangvu.fcare.controller.TagController;

public class CloneUpdatePanel extends JPanel {
	
	private JTextField id;
	private JLabel lblCookie;
	private JComboBox cbTags, status;
	private CloneController controller;
	private JTextField name;
	private JTextField newPass;
	private JPasswordField oldPass;
	
	public CloneUpdatePanel(JDialog container, DashboardFrame dashboardFrame, Clone clone) {
		
		setLayout(null);
		
		this.controller = new CloneController();
		
		JLabel lblCloneId = new JLabel("Clone ID");
		lblCloneId.setBounds(42, 43, 77, 14);
		add(lblCloneId);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setBounds(129, 43, 355, 20);
		id.setText(clone.getId());
		add(id);
		id.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 71, 77, 14);
		add(lblPassword);
		
		lblCookie = new JLabel("Cookie");
		lblCookie.setBounds(42, 142, 77, 14);
		add(lblCookie);
		
		JEditorPane cookie = new JEditorPane();
		cookie.setBounds(129, 146, 355, 36);
		cookie.setText(clone.getCookie());
		add(cookie);
		
		JButton btnCheckLive = new JButton("Check live");
		btnCheckLive.setBounds(129, 260, 355, 23);
		add(btnCheckLive);
		
				
		JLabel lblTags = new JLabel("Tag");
		lblTags.setBounds(42, 355, 46, 14);
		add(lblTags);
		
		status = new JComboBox();
		status.setBounds(129, 396, 160, 20);
		status.addItem("active");
		status.addItem("deactive");
		status.setSelectedItem(clone.getStatus());
		add(status);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(42, 396, 77, 14);
		add(lblTrngThi);
		
		JButton btnAdd = new JButton("Cập nhật");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clone clone = new Clone();
				clone.setId(id.getText());
				if(newPass.getText().equalsIgnoreCase("pass mới")) {
					clone.setPassword(String.valueOf(oldPass.getPassword()));
				}else {
					clone.setPassword(newPass.getText());
				}
				clone.setCookie(cookie.getText());
				clone.setName(name.getText());
				clone.setTag(cbTags.getSelectedItem().toString());
				clone.setStatus(status.getSelectedItem().toString());
				controller.update(clone);
				container.dispose();
				dashboardFrame.loadPanel(new CloneMainPanel(dashboardFrame), "Quản lý clone");
			}
		});
		btnAdd.setBounds(129, 447, 160, 23);
		add(btnAdd);
		
		JButton btnReset = new JButton("Nhập lại");
		btnReset.setBounds(310, 447, 174, 23);
		add(btnReset);
				
		cbTags = new JComboBox();
		TagController tagController = new TagController();
		ArrayList<Tag> tags = tagController.all();
		for(Tag tag : tags) {
			cbTags.addItem(tag.getName());
		}
		cbTags.setSelectedItem(clone.getTag());
		cbTags.setBounds(129, 355, 355, 20);
		add(cbTags);
		
		JLabel lblTnClone = new JLabel("Tên clone");
		lblTnClone.setBounds(42, 312, 77, 14);
		add(lblTnClone);
		
		name = new JTextField();
		name.setText(clone.getName());
		name.setColumns(10);
		name.setBounds(129, 312, 355, 20);
		add(name);
		
		newPass = new JTextField();
		newPass.setText("pass mới");
		newPass.setBounds(310, 68, 174, 20);
		add(newPass);
		newPass.setColumns(10);
		
		oldPass = new JPasswordField();
		oldPass.setEnabled(false);
		oldPass.setText(String.valueOf(clone.getPassword()));
		oldPass.setBounds(129, 68, 160, 20);
		add(oldPass);
		
		JLabel lblToken = new JLabel("Token");
		lblToken.setBounds(42, 201, 77, 14);
		add(lblToken);
		
		JEditorPane token = new JEditorPane();
		token.setText((String) null);
		token.setBounds(129, 201, 355, 36);
		add(token);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 106, 355, 20);
		add(comboBox);
		
		JLabel lblUseragent = new JLabel("UserAgent");
		lblUseragent.setBounds(42, 106, 77, 14);
		add(lblUseragent);

	}
}
