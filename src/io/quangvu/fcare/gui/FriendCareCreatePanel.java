package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FriendCareCreatePanel extends JPanel {
	
	private JTextField textField;
	
	public FriendCareCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(114, 127, 29, 20);
		add(spinner);
		
		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(151, 130, 29, 14);
		add(lblMax);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(177, 127, 41, 20);
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
		
		JLabel lblSLike = new JLabel("Add đề xuất");
		lblSLike.setBounds(36, 133, 77, 14);
		add(lblSLike);
		
		JLabel lblNghGiaLike = new JLabel("nghỉ giữa lần");
		lblNghGiaLike.setBounds(269, 130, 77, 14);
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
		
		JLabel lblSCmtT = new JLabel("Nhận lời");
		lblSCmtT.setBounds(36, 171, 60, 14);
		add(lblSCmtT);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(114, 168, 29, 20);
		add(spinner_6);
		
		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(151, 171, 29, 14);
		add(label_2);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(177, 168, 41, 20);
		add(spinner_7);
		
		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lần");
		lblNghGiaCmt.setBounds(269, 171, 77, 14);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("cookie");
		comboBox.addItem("token");
		comboBox.setBounds(114, 79, 104, 20);
		add(comboBox);
		
		JLabel lblKiuChy = new JLabel("Kiểu làm");
		lblKiuChy.setBounds(36, 82, 60, 14);
		add(lblKiuChy);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(36, 35, 41, 14);
		add(lblPlan);
		
		textField = new JTextField();
		textField.setBounds(116, 32, 576, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Bắt đầu ngay");
		btnNewButton.setBounds(310, 276, 124, 23);
		add(btnNewButton);
		
		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.setBounds(158, 276, 124, 23);
		add(btnLuChySau);
		
		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(460, 276, 98, 23);
		add(btnNhpLi);
		
		JLabel lblAddTUid = new JLabel("Add từ uid");
		lblAddTUid.setBounds(36, 215, 77, 14);
		add(lblAddTUid);
		
		JButton btnNewButton_1 = new JButton("Browser...");
		btnNewButton_1.setBounds(114, 211, 92, 23);
		add(btnNewButton_1);
		
		JLabel lbSelectedFilePath = new JLabel("...");
		lbSelectedFilePath.setBounds(216, 215, 476, 14);
		add(lbSelectedFilePath);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
			        int returnValue = fileChooser.showOpenDialog(null);
			        if (returnValue == JFileChooser.APPROVE_OPTION) {
			          File selectedFile = fileChooser.getSelectedFile();
			          lbSelectedFilePath.setText(selectedFile.getAbsolutePath());
			          System.out.println(selectedFile.getName());
			        }
			}
		});
		
	}
}
