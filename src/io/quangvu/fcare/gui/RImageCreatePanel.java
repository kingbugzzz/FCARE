package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import io.quangvu.fcare.bean.RImage;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.RImageController;
import io.quangvu.fcare.controller.TagController;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class RImageCreatePanel extends JPanel {

	private TagController tagController;
	private RImageController controller;
	private JComboBox cbTags;
	private JTextField name;
	private JLabel src;
	
	public RImageCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		
		setLayout(null);
		
		this.controller = new RImageController();
		
		cbTags = new JComboBox();
		cbTags.setBounds(117, 31, 331, 20);
		add(cbTags);
		
		tagController = new TagController();
		ArrayList<Tag> tags = tagController.all();
		for(Tag tag : tags) {
			cbTags.addItem(tag.getName());
		}
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setBounds(38, 34, 46, 14);
		add(lblTag);
		
		JLabel lblMT = new JLabel("Mô tả");
		lblMT.setBounds(38, 76, 46, 14);
		add(lblMT);
		
		name = new JTextField();
		name.setBounds(117, 73, 331, 20);
		add(name);
		name.setColumns(10);
		
		JButton browser = new JButton("Browse");
		browser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					src.setText(jfc.getSelectedFile().getAbsolutePath().replace("\\", "/"));
				}
			}
		});
		browser.setBounds(117, 122, 101, 23);
		add(browser);
		src = new JLabel("");
		src.setToolTipText(src.getText());
		src.setBounds(235, 126, 229, 14);
		add(src);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RImage status = new RImage();
				status.setTag(cbTags.getSelectedItem().toString());
				status.setName(name.getText());
				status.setSrc(src.getText());
				controller.add(status);
				container.dispose();
				dashboardFrame.loadPanel(new RImageMainPanel(dashboardFrame), "Quản lý status nguồn");
			}
		});
		btnNewButton_1.setBounds(115, 175, 103, 23);
		add(btnNewButton_1);

	}
}
