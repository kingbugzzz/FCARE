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

public class TagCreatePanel extends JPanel {

	private JTextField name;
	private JTextField description;

	private TagController controller;

	public TagCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		setLayout(null);
		this.controller = new TagController();

		JLabel lblNewLabel = new JLabel("Tên thẻ");
		lblNewLabel.setBounds(48, 73, 57, 14);
		add(lblNewLabel);

		name = new JTextField();
		name.setBounds(118, 70, 230, 20);
		add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mô tả");
		lblNewLabel_1.setBounds(48, 122, 57, 14);
		add(lblNewLabel_1);

		description = new JTextField();
		description.setColumns(10);
		description.setBounds(118, 119, 230, 20);
		add(description);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.add(new Tag(name.getText().trim(), description.getText().trim()));
				container.dispose();
				dashboardFrame.loadPanel(new TagMainPanel(dashboardFrame), "Quản lý tag");
			}
		});
		btnNewButton.setBounds(118, 173, 89, 23);
		add(btnNewButton);

	}
}
