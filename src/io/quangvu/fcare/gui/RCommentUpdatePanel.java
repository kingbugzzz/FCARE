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

import io.quangvu.fcare.bean.RComment;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.RCommentController;
import io.quangvu.fcare.controller.TagController;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RCommentUpdatePanel extends JPanel {

	private TagController tagController;
	private RCommentController controller;
	private JComboBox cbTags;
	private JTextField name;
	private JLabel src;
	
	public RCommentUpdatePanel(JDialog container, DashboardFrame dashboardFrame, RComment status) {
		
		setLayout(null);
		
		this.controller = new RCommentController();
		
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
		name.setText(status.getName());
		name.setBounds(117, 73, 331, 20);
		add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					src.setText(jfc.getSelectedFile().getAbsolutePath().replace("\\", "/"));
				}
			}
		});
		btnNewButton.setBounds(117, 122, 99, 23);
		add(btnNewButton);
		
		src = new JLabel(status.getSrc());
		src.setToolTipText(src.getText());
		src.setBounds(226, 126, 222, 14);
		add(src);
		
		JButton btnNewButton_1 = new JButton("Cập nhật");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				RComment status = new RComment();
				status.setTag(cbTags.getSelectedItem().toString());
				status.setName(name.getText());
				status.setSrc(src.getText());
				controller.update(status);
				container.dispose();
				dashboardFrame.loadPanel(new RCommentMainPanel(dashboardFrame), "Quản lý status nguồn");
			}
		});
		btnNewButton_1.setBounds(115, 175, 101, 23);
		add(btnNewButton_1);

	}
}
