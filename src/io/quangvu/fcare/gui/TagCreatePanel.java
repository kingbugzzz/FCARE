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

	private JTextField code;
	private JTextField name;

	private TagController controller;

	public TagCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		setLayout(null);
		this.controller = new TagController();

		JLabel lblNewLabel = new JLabel("Mã tag");
		lblNewLabel.setBounds(48, 73, 57, 14);
		add(lblNewLabel);

		code = new JTextField();
		code.setBounds(118, 70, 230, 20);
		add(code);
		code.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mô tả");
		lblNewLabel_1.setBounds(48, 122, 57, 14);
		add(lblNewLabel_1);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(118, 119, 230, 20);
		add(name);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.add(new Tag(code.getText().trim(), name.getText().trim()));
				dashboardFrame.loadPanel(new TagMainPanel(dashboardFrame), "Quản lý tag");
			}
		});
		btnNewButton.setBounds(118, 173, 89, 23);
		add(btnNewButton);

	}
}
