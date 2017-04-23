package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.TagController;

public class TagUpdatePanel extends JPanel {

	private JTextField code;
	private JTextField name;

	private TagController controller;
	private JTextField id;

	public TagUpdatePanel(JDialog container, DashboardFrame dashboardFrame, Tag tag) {
		setLayout(null);
		this.controller = new TagController();

		JLabel lblNewLabel = new JLabel("Mã tag");
		lblNewLabel.setBounds(55, 118, 57, 14);
		add(lblNewLabel);

		code = new JTextField();
		code.setBounds(125, 115, 230, 20);
		add(code);
		code.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mô tả");
		lblNewLabel_1.setBounds(55, 167, 57, 14);
		add(lblNewLabel_1);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(125, 164, 230, 20);
		add(name);

		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.update(new Tag(Integer.parseInt(id.getText()), code.getText(), name.getText()));
				dashboardFrame.loadPanel(new TagMainPanel(dashboardFrame), "Quản lý tag");
			}
		});
		btnUpdate.setBounds(125, 218, 89, 23);
		add(btnUpdate);
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(125, 65, 230, 20);
		add(id);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(55, 68, 57, 14);
		add(lblId);
		
		this.id.setText(String.valueOf(tag.getId()));
		this.code.setText(tag.getCode());
		this.name.setText(tag.getName());
	}
}
