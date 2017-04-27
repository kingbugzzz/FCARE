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
import io.quangvu.fcare.helper.IOHelper;

public class CloneCreatePanel extends JPanel {
	
	private JTextField id;
	private JLabel lblCookie;
	private JPasswordField password;
	private JComboBox cbTags, status, userAgent;
	private CloneController controller;
	private JTextField name;
	private JEditorPane token, cookie;
	public CloneCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		
		setLayout(null);
		
		this.controller = new CloneController();
		
		JLabel lblCloneId = new JLabel("Clone ID");
		lblCloneId.setBounds(42, 43, 77, 14);
		add(lblCloneId);
		
		id = new JTextField();
		id.setBounds(129, 43, 355, 20);
		add(id);
		id.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 71, 77, 14);
		add(lblPassword);
		
		lblCookie = new JLabel("Cookie");
		lblCookie.setBounds(42, 275, 77, 14);
		add(lblCookie);
		
		cookie = new JEditorPane();
		cookie.setBounds(129, 272, 355, 66);
		add(cookie);
		
		JButton btnCheckLive = new JButton("Check live");
		btnCheckLive.setBounds(129, 366, 355, 23);
		add(btnCheckLive);
		
				
		JLabel lblTags = new JLabel("Tag");
		lblTags.setBounds(42, 454, 46, 14);
		add(lblTags);
		
		status = new JComboBox();
		status.setBounds(129, 495, 160, 20);
		status.addItem("active");
		status.addItem("deactive");
		add(status);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(42, 495, 77, 14);
		add(lblTrngThi);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clone clone = new Clone();
				clone.setId(id.getText());
				clone.setPassword(String.valueOf(password.getPassword()));
				clone.setUserAgent(userAgent.getSelectedItem().toString());
				clone.setCookie(cookie.getText());
				clone.setToken(token.getText());
				clone.setName(name.getText());
				clone.setTag(cbTags.getSelectedItem().toString());
				clone.setStatus(status.getSelectedItem().toString());
				controller.add(clone);
				container.dispose();
				dashboardFrame.loadPanel(new CloneMainPanel(dashboardFrame), "Quản lý clone");
			}
		});
		btnAdd.setBounds(129, 546, 160, 23);
		add(btnAdd);
		
		JButton btnReset = new JButton("Nhập lại");
		btnReset.setBounds(310, 546, 174, 23);
		add(btnReset);
		
		password = new JPasswordField();
		password.setBounds(129, 68, 355, 20);
		add(password);
				
		cbTags = new JComboBox();
		TagController tagController = new TagController();
		ArrayList<Tag> tags = tagController.all();
		for(Tag tag : tags) {
			cbTags.addItem(tag.getName());
		}
		cbTags.setBounds(129, 454, 355, 20);
		add(cbTags);
		
		JLabel lblTnClone = new JLabel("Tên clone");
		lblTnClone.setBounds(42, 411, 77, 14);
		add(lblTnClone);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(129, 411, 355, 20);
		add(name);
		
		JLabel lblUseragent = new JLabel("UserAgent");
		lblUseragent.setBounds(42, 113, 77, 14);
		add(lblUseragent);
		
		ArrayList<String> ugentList = IOHelper.readLines("config/uagents.dat");
		userAgent = new JComboBox();
		for(String agent : ugentList) {
			userAgent.addItem(agent);
		}
		userAgent.setBounds(129, 110, 355, 20);
		add(userAgent);
		
		token = new JEditorPane();
		token.setBounds(129, 154, 355, 94);
		add(token);
		
		JLabel lblToken = new JLabel("Token");
		lblToken.setBounds(42, 154, 77, 14);
		add(lblToken);

	}
}
