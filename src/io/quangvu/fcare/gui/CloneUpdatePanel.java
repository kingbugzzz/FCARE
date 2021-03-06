package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.CloneController;
import io.quangvu.fcare.controller.TagController;
import io.quangvu.fcare.helper.CheckLiveHelper;
import io.quangvu.fcare.helper.IOHelper;
import javax.swing.JScrollPane;

public class CloneUpdatePanel extends JPanel {
	
	private JTextField id;
	private JComboBox cbTags, status, userAgent;
	private CloneController controller;
	private JTextField name;
	private JTextField newPass;
	private JPasswordField oldPass;
	private JEditorPane token;
	
	private String cookieString;
	
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
		
		JLabel lblToken = new JLabel("Token");
		lblToken.setBounds(42, 279, 77, 14);
		add(lblToken);
		
		JButton btnCheckLive = new JButton("Check live");
		btnCheckLive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String checkResult = CheckLiveHelper.check(id.getText().trim(), String.valueOf(oldPass.getPassword()), userAgent.getSelectedItem().toString());
				if(checkResult.equalsIgnoreCase("checkpoint")) {
					cookieString = "";
					JOptionPane.showMessageDialog(null, "Checkpoint!");
				}else {
					cookieString = checkResult;
					JOptionPane.showMessageDialog(null, "Live!");
				}
			}
		});
		btnCheckLive.setBounds(129, 152, 355, 23);
		add(btnCheckLive);
		
				
		JLabel lblTags = new JLabel("Tag");
		lblTags.setBounds(42, 238, 46, 14);
		add(lblTags);
		
		status = new JComboBox();
		status.setBounds(129, 413, 160, 20);
		status.addItem("active");
		status.addItem("deactive");
		status.setSelectedItem(clone.getStatus());
		add(status);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(42, 413, 77, 14);
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
				clone.setUserAgent(userAgent.getSelectedItem().toString());
				System.out.println(cookieString);
				clone.setCookie(cookieString);
				clone.setToken(token.getText());
				clone.setName(name.getText());
				clone.setTag(cbTags.getSelectedItem().toString());
				clone.setStatus(status.getSelectedItem().toString());
				controller.update(clone);
				container.dispose();
				dashboardFrame.loadPanel(new CloneMainPanel(dashboardFrame), "Quản lý clone");
			}
		});
		btnAdd.setBounds(129, 463, 160, 23);
		add(btnAdd);
		
		JButton btnReset = new JButton("Nhập lại");
		btnReset.setBounds(310, 463, 174, 23);
		add(btnReset);
				
		cbTags = new JComboBox();
		TagController tagController = new TagController();
		ArrayList<Tag> tags = tagController.all();
		for(Tag tag : tags) {
			cbTags.addItem(tag.getName());
		}
		cbTags.setSelectedItem(clone.getTag());
		cbTags.setBounds(129, 238, 355, 20);
		add(cbTags);
		
		JLabel lblTnClone = new JLabel("Tên clone");
		lblTnClone.setBounds(42, 200, 77, 14);
		add(lblTnClone);
		
		name = new JTextField();
		name.setText(clone.getName());
		name.setColumns(10);
		name.setBounds(129, 200, 355, 20);
		add(name);
		
		newPass = new JTextField();
		newPass.setText("pass mới");
		newPass.setBounds(310, 68, 174, 20);
		add(newPass);
		newPass.setColumns(10);
		
		oldPass = new JPasswordField();
		oldPass.setEnabled(false);
		oldPass.setText(clone.getPassword());
		oldPass.setBounds(129, 68, 160, 20);
		add(oldPass);
				
		ArrayList<String> ugentList = IOHelper.readLines("config/uagents.dat");
		userAgent = new JComboBox();
		for(String agent : ugentList) {
			userAgent.addItem(agent);
		}
		userAgent.setSelectedItem(clone.getUserAgent());
		userAgent.setBounds(129, 106, 355, 20);
		add(userAgent);
		
		JLabel lblUseragent = new JLabel("UserAgent");
		lblUseragent.setBounds(42, 106, 77, 14);
		add(lblUseragent);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(129, 279, 355, 113);
		add(scrollPane_1);
		token = new JEditorPane();
		scrollPane_1.setViewportView(token);
		token.setText(clone.getToken());
		
	}
}
