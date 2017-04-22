package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CloneCareCreatePanel extends JPanel {
	
	private JTextField textField;
	
	public CloneCareCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(106, 130, 29, 20);
		add(spinner);
		
		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(145, 133, 29, 14);
		add(lblMax);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(171, 130, 29, 20);
		add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(356, 130, 29, 20);
		add(spinner_2);
		
		JLabel lbln = new JLabel("đến");
		lbln.setBounds(395, 133, 29, 14);
		add(lbln);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(427, 130, 41, 20);
		add(spinner_3);
		
		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 133, 60, 14);
		add(lblSLike);
		
		JLabel lblNghGiaLike = new JLabel("nghỉ giữa like");
		lblNghGiaLike.setBounds(250, 133, 88, 14);
		add(lblNghGiaLike);
		
		JLabel lblNghGiaClone = new JLabel("nghỉ giữa clone");
		lblNghGiaClone.setBounds(489, 133, 98, 14);
		add(lblNghGiaClone);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(583, 130, 29, 20);
		add(spinner_4);
		
		JLabel label_1 = new JLabel("đến");
		label_1.setBounds(622, 133, 29, 14);
		add(label_1);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(649, 130, 43, 20);
		add(spinner_5);
		
		JLabel lblSCmtT = new JLabel("Số cmt");
		lblSCmtT.setBounds(36, 174, 60, 14);
		add(lblSCmtT);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(106, 171, 29, 20);
		add(spinner_6);
		
		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(145, 174, 29, 14);
		add(label_2);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(171, 171, 29, 20);
		add(spinner_7);
		
		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa cmt");
		lblNghGiaCmt.setBounds(250, 174, 88, 14);
		add(lblNghGiaCmt);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(356, 171, 29, 20);
		add(spinner_8);
		
		JLabel label_4 = new JLabel("đến");
		label_4.setBounds(395, 174, 29, 14);
		add(label_4);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(427, 171, 41, 20);
		add(spinner_9);
		
		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(489, 174, 98, 14);
		add(lblNghGiaClone_1);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(583, 171, 29, 20);
		add(spinner_10);
		
		JLabel label_6 = new JLabel("đến");
		label_6.setBounds(622, 174, 29, 14);
		add(label_6);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(649, 171, 43, 20);
		add(spinner_11);
		
		JLabel lblSShareT = new JLabel("Số share");
		lblSShareT.setBounds(36, 217, 66, 14);
		add(lblSShareT);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(106, 214, 29, 20);
		add(spinner_12);
		
		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(145, 217, 29, 14);
		add(label_3);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setBounds(171, 214, 29, 20);
		add(spinner_13);
		
		JLabel lblNghGiaShare = new JLabel("nghỉ giữa share");
		lblNghGiaShare.setBounds(250, 217, 96, 14);
		add(lblNghGiaShare);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setBounds(356, 214, 29, 20);
		add(spinner_14);
		
		JLabel label_8 = new JLabel("đến");
		label_8.setBounds(395, 217, 29, 14);
		add(label_8);
		
		JSpinner spinner_15 = new JSpinner();
		spinner_15.setBounds(427, 214, 41, 20);
		add(spinner_15);
		
		JLabel lblNghGiaClone_2 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_2.setBounds(489, 217, 98, 14);
		add(lblNghGiaClone_2);
		
		JSpinner spinner_16 = new JSpinner();
		spinner_16.setBounds(583, 214, 29, 20);
		add(spinner_16);
		
		JLabel label_10 = new JLabel("đến");
		label_10.setBounds(622, 217, 29, 14);
		add(label_10);
		
		JSpinner spinner_17 = new JSpinner();
		spinner_17.setBounds(649, 214, 43, 20);
		add(spinner_17);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("thứ tự");
		comboBox.addItem("ngẫu nhiên");
		comboBox.setBounds(106, 79, 92, 20);
		add(comboBox);
		
		JLabel lblKiuChy = new JLabel("Kiểu chạy");
		lblKiuChy.setBounds(36, 82, 60, 14);
		add(lblKiuChy);
		
		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 35, 60, 14);
		add(lblPlan);
		
		textField = new JTextField();
		textField.setBounds(106, 32, 586, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblKiuNui = new JLabel("Kiểu nuôi");
		lblKiuNui.setBounds(250, 82, 60, 14);
		add(lblKiuNui);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("cookie");
		comboBox_1.addItem("token");
		comboBox_1.setBounds(309, 79, 92, 20);
		add(comboBox_1);
		
		JLabel lblKiuStatus = new JLabel("Kiểu status");
		lblKiuStatus.setBounds(451, 82, 73, 14);
		add(lblKiuStatus);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("text + image");
		comboBox_2.addItem("text");
		comboBox_2.addItem("text + link");
		comboBox_2.addItem("link");
		comboBox_2.addItem("không post status");
		comboBox_2.setBounds(534, 79, 158, 20);
		add(comboBox_2);
		
		JButton btnNewButton = new JButton("Bắt đầu ngay");
		btnNewButton.setBounds(286, 277, 131, 23);
		add(btnNewButton);
		
		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save data
				container.dispose();
			}
		});
		btnLuChySau.setBounds(133, 277, 124, 23);
		add(btnLuChySau);
		
		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(449, 277, 98, 23);
		add(btnNhpLi);
		
	}
}