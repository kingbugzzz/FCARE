package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;

public class SystemGeneralInfoPanel extends JPanel {

	public SystemGeneralInfoPanel(DashboardFrame container) {
		setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(54, 60, 412, 138);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTngSClone = new JLabel("Tổng số clone: 112");
		lblTngSClone.setBounds(26, 26, 187, 14);
		panel_3.add(lblTngSClone);
		
		JLabel lblActive = new JLabel("Active: 90");
		lblActive.setBounds(26, 52, 187, 14);
		panel_3.add(lblActive);
		
		JLabel lblCheckpoint = new JLabel("Checkpoint: 8");
		lblCheckpoint.setBounds(26, 77, 187, 14);
		panel_3.add(lblCheckpoint);
		
		JLabel lblangNui = new JLabel("Đang nuôi: 30");
		lblangNui.setBounds(26, 102, 187, 14);
		panel_3.add(lblangNui);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(530, 60, 412, 138);
		add(panel);
		
		JLabel lblStatusMu = new JLabel("Status mẫu: 60");
		lblStatusMu.setBounds(26, 26, 187, 14);
		panel.add(lblStatusMu);
		
		JLabel lblGroupNgun = new JLabel("Group nguồn: 110");
		lblGroupNgun.setBounds(26, 52, 187, 14);
		panel.add(lblGroupNgun);
		
		JLabel lblPageNgun = new JLabel("Page nguồn: 98");
		lblPageNgun.setBounds(26, 77, 187, 14);
		panel.add(lblPageNgun);
		
		JLabel lblUidNgun = new JLabel("Uid nguồn: 300");
		lblUidNgun.setBounds(26, 102, 187, 14);
		panel.add(lblUidNgun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(54, 236, 412, 138);
		add(panel_1);
		
		JLabel lblSChinDch = new JLabel("Số chiến dịch nuôi: 16");
		lblSChinDch.setBounds(26, 26, 187, 14);
		panel_1.add(lblSChinDch);
		
		JLabel lblSChinDch_1 = new JLabel("Số chiến dịch kéo friend: 32");
		lblSChinDch_1.setBounds(26, 52, 187, 14);
		panel_1.add(lblSChinDch_1);
		
		JLabel lblSChinDch_2 = new JLabel("Số chiến dịch kéo mem group: 80");
		lblSChinDch_2.setBounds(26, 77, 232, 14);
		panel_1.add(lblSChinDch_2);
		
		JLabel lblSChinDch_3 = new JLabel("Số chiến dịch kéo like page: 32");
		lblSChinDch_3.setBounds(26, 102, 232, 14);
		panel_1.add(lblSChinDch_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBounds(530, 236, 412, 138);
		add(panel_2);
		
		JLabel lblSRequestFriends = new JLabel("Số request friends đã gửi: 1033");
		lblSRequestFriends.setBounds(26, 26, 187, 14);
		panel_2.add(lblSRequestFriends);
		
		JLabel lblSAcceptFriends = new JLabel("Số accept friends đã nhận: 959");
		lblSAcceptFriends.setBounds(26, 52, 187, 14);
		panel_2.add(lblSAcceptFriends);
		
		JLabel lblSLike = new JLabel("Số like đã like: 350");
		lblSLike.setBounds(26, 77, 187, 14);
		panel_2.add(lblSLike);
		
		JLabel lblSComment = new JLabel("Số comment: 168");
		lblSComment.setBounds(26, 102, 187, 14);
		panel_2.add(lblSComment);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(54, 406, 888, 95);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblKeyDsgfdhdsgfshjgdfgdl = new JLabel("Key: DSGfdh-dsg5675-FSHJGdf-GDL56");
		lblKeyDsgfdhdsgfshjgdfgdl.setBounds(27, 24, 265, 14);
		panel_4.add(lblKeyDsgfdhdsgfshjgdfgdl);
		
		JLabel lblLevelNormal = new JLabel("Level: Normal");
		lblLevelNormal.setBounds(27, 58, 265, 14);
		panel_4.add(lblLevelNormal);

	}
}
