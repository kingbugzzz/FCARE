package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Font;

public class CloneCareCreatePanel extends JPanel {
	
	private JTextField textField;
	private JList<String> cloneList;
	private JLabel cloneCount;
	
	public CloneCareCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(106, 257, 40, 20);
		add(spinner);
		
		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 263, 29, 14);
		add(lblMax);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(204, 257, 40, 20);
		add(spinner_1);
		
		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 260, 60, 14);
		add(lblSLike);
		
		JLabel lblNghGiaLike = new JLabel("nghỉ giữa lượt");
		lblNghGiaLike.setBounds(302, 260, 104, 14);
		add(lblNghGiaLike);
		
		JLabel lblSCmtT = new JLabel("Số cmt");
		lblSCmtT.setBounds(36, 294, 60, 14);
		add(lblSCmtT);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(106, 291, 40, 20);
		add(spinner_6);
		
		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 297, 29, 14);
		add(label_2);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(204, 291, 40, 20);
		add(spinner_7);
		
		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 294, 98, 14);
		add(lblNghGiaCmt);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(416, 288, 40, 20);
		add(spinner_8);
		
		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 294, 96, 14);
		add(lblNghGiaClone_1);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(673, 288, 42, 20);
		add(spinner_10);
		
		JLabel lblSShareT = new JLabel("Số share");
		lblSShareT.setBounds(36, 325, 66, 14);
		add(lblSShareT);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(106, 322, 40, 20);
		add(spinner_12);
		
		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(165, 328, 29, 14);
		add(label_3);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setBounds(204, 322, 40, 20);
		add(spinner_13);
		
		JLabel lblNghGiaShare = new JLabel("nghỉ giữa lượt");
		lblNghGiaShare.setBounds(302, 325, 98, 14);
		add(lblNghGiaShare);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setBounds(416, 319, 40, 20);
		add(spinner_14);
		
		JLabel lblNghGiaClone_2 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_2.setBounds(567, 325, 96, 14);
		add(lblNghGiaClone_2);
		
		JSpinner spinner_16 = new JSpinner();
		spinner_16.setBounds(673, 319, 42, 20);
		add(spinner_16);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.setBounds(106, 213, 138, 20);
		add(comboBox);
		
		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 216, 60, 14);
		add(lblKiuChy);
		
		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 181, 60, 14);
		add(lblPlan);
		
		textField = new JTextField();
		textField.setBounds(106, 178, 659, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblKiuStatus = new JLabel("Kiểu status");
		lblKiuStatus.setBounds(302, 216, 73, 14);
		add(lblKiuStatus);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("text + image");
		comboBox_2.addItem("text");
		comboBox_2.addItem("text + link");
		comboBox_2.addItem("link");
		comboBox_2.addItem("không post status");
		comboBox_2.setBounds(416, 210, 129, 20);
		add(comboBox_2);
		
		JButton btnNewButton = new JButton("Bắt đầu ngay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(339, 421, 131, 23);
		add(btnNewButton);
		
		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save data
				container.dispose();
			}
		});
		btnLuChySau.setBounds(186, 421, 124, 23);
		add(btnLuChySau);
		
		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(502, 421, 98, 23);
		add(btnNhpLi);
		
		this.cloneList = new JList<String>(cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize()-1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
			}
		});
		JScrollPane scrollPane = new JScrollPane(cloneList);
		scrollPane.setBounds(106, 32, 311, 124);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Clone");
		lblNewLabel.setBounds(465, 32, 124, 14);
		add(lblNewLabel);
		
		cloneCount = new JLabel(String.valueOf(cloneIds.size()));
		cloneCount.setForeground(new Color(0, 100, 0));
		cloneCount.setHorizontalAlignment(SwingConstants.RIGHT);
		cloneCount.setBounds(685, 32, 80, 14);
		add(cloneCount);
		
		JLabel lblNewLabel_2 = new JLabel("Số like");
		lblNewLabel_2.setBounds(465, 57, 158, 14);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("18-36");
		label.setForeground(new Color(0, 100, 0));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(685, 57, 80, 14);
		add(label);
		
		JLabel lblSComment = new JLabel("Số comment");
		lblSComment.setBounds(465, 73, 158, 14);
		add(lblSComment);
		
		JLabel label_7 = new JLabel("15-33");
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(685, 73, 80, 14);
		add(label_7);
		
		JLabel lblSShare = new JLabel("Số share");
		lblSShare.setBounds(465, 88, 158, 14);
		add(lblSShare);
		
		JLabel label_11 = new JLabel("9-12");
		label_11.setForeground(new Color(0, 100, 0));
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(685, 88, 80, 14);
		add(label_11);
		
		JLabel lblThiGianHon = new JLabel("Thời gian hoàn thành(dự tính)");
		lblThiGianHon.setBounds(465, 142, 224, 14);
		add(lblThiGianHon);
		
		JLabel lblMn = new JLabel("46 mins");
		lblMn.setForeground(new Color(0, 100, 0));
		lblMn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMn.setBounds(685, 142, 80, 14);
		add(lblMn);
		
		JLabel lblNewLabel_3 = new JLabel("(*) Lưu ý: Cấu hình like, comment, share là của từng clone chứ không phải là tổng cho cả chiến dịch");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setBounds(36, 371, 731, 14);
		add(lblNewLabel_3);
		
		JLabel lblTiNguynRamd = new JLabel("Tài nguyên RAM(dự tính)");
		lblTiNguynRamd.setBounds(465, 128, 158, 14);
		add(lblTiNguynRamd);
		
		JLabel lblMb = new JLabel("600 MB");
		lblMb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMb.setForeground(new Color(0, 100, 0));
		lblMb.setBounds(685, 128, 80, 14);
		add(lblMb);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(416, 254, 40, 20);
		add(spinner_2);
		
		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 260, 96, 14);
		add(label_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(673, 257, 42, 20);
		add(spinner_3);
		
		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 257, 60, 14);
		add(lblGiy);
		
		JLabel label_5 = new JLabel("(+10)");
		label_5.setBounds(466, 291, 40, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("(+10)");
		label_6.setBounds(466, 322, 40, 14);
		add(label_6);
		
		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 260, 40, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("(+10)");
		label_9.setBounds(725, 294, 40, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("(+10)");
		label_10.setBounds(725, 325, 40, 14);
		add(label_10);
		
	}
}