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

	private JTextField name;
	private JTextField description;

	private TagController controller;

	public TagUpdatePanel(JDialog container, DashboardFrame dashboardFrame, Tag tag) {
		setLayout(null);
		this.controller = new TagController();

		JLabel lblNewLabel = new JLabel("Tên thẻ");
		lblNewLabel.setBounds(55, 40, 57, 14);
		add(lblNewLabel);

		name = new JTextField();
		name.setBounds(125, 37, 230, 20);
		add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mô tả");
		lblNewLabel_1.setBounds(55, 89, 57, 14);
		add(lblNewLabel_1);

		description = new JTextField();
		description.setColumns(10);
		description.setBounds(125, 86, 230, 20);
		add(description);

		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.update(new Tag(name.getText(), description.getText()));
				dashboardFrame.loadPanel(new TagMainPanel(dashboardFrame), "Quản lý tag");
			}
		});
		btnUpdate.setBounds(125, 134, 89, 23);
		add(btnUpdate);
		this.name.setText(tag.getName());
		this.name.setEditable(false);
		this.description.setText(tag.getDescription());
	}
}
