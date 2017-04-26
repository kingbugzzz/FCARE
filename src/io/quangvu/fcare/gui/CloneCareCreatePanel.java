package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.jna.IntegerType;

import io.quangvu.fcare.helper.NumberHelper;

import java.awt.Color;
import java.awt.Font;

public class CloneCareCreatePanel extends JPanel {

	private JTextField textField;
	private JList<String> cloneList;
	private JLabel cloneCount, lbMinLike, lbMaxLike, lbMinComment, lbMaxComment, lbMinShare, lbMaxShare, lbRam,
			lbTimeExec;
	private JSpinner minLike, maxLike, waitLike, waitCloneLike;
	private JSpinner minComment, maxComment, waitComment, waitCloneComment;
	private JSpinner minShare, maxShare, waitShare, waitCloneShare;
	private JComboBox numThread;

	public CloneCareCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minLike = new JSpinner();
		minLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinLikeStatus();
				updateTimeExec();
			}
		});
		minLike.setBounds(106, 257, 40, 20);
		add(minLike);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 263, 29, 14);
		add(lblMax);

		maxLike = new JSpinner();
		maxLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxLikeStatus();
				updateTimeExec();
			}
		});
		maxLike.setBounds(204, 257, 40, 20);
		add(maxLike);

		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 260, 60, 14);
		add(lblSLike);

		JLabel lblNghGiaLike = new JLabel("nghỉ giữa lượt");
		lblNghGiaLike.setBounds(302, 260, 104, 14);
		add(lblNghGiaLike);

		JLabel lblSCmtT = new JLabel("Số cmt");
		lblSCmtT.setBounds(36, 294, 60, 14);
		add(lblSCmtT);

		minComment = new JSpinner();
		minComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinCommentStatus();
				updateTimeExec();
			}
		});
		
		minComment.setBounds(106, 291, 40, 20);
		add(minComment);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 297, 29, 14);
		add(label_2);

		maxComment = new JSpinner();
		maxComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxCommentStatus();
				updateTimeExec();
			}
		});
		maxComment.setBounds(204, 291, 40, 20);
		add(maxComment);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 294, 98, 14);
		add(lblNghGiaCmt);

		waitComment = new JSpinner();
		waitComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitComment.setBounds(416, 288, 40, 20);
		add(waitComment);

		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 294, 96, 14);
		add(lblNghGiaClone_1);

		waitCloneComment = new JSpinner();
		waitCloneComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneComment.setBounds(673, 288, 42, 20);
		add(waitCloneComment);

		JLabel lblSShareT = new JLabel("Số share");
		lblSShareT.setBounds(36, 325, 66, 14);
		add(lblSShareT);

		minShare = new JSpinner();
		minShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinShareStatus();
				updateTimeExec();
			}
		});
		minShare.setBounds(106, 322, 40, 20);
		add(minShare);

		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(165, 328, 29, 14);
		add(label_3);

		maxShare = new JSpinner();
		maxShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxShareStatus();
				updateTimeExec();
			}
		});
		maxShare.setBounds(204, 322, 40, 20);
		add(maxShare);

		JLabel lblNghGiaShare = new JLabel("nghỉ giữa lượt");
		lblNghGiaShare.setBounds(302, 325, 98, 14);
		add(lblNghGiaShare);

		waitShare = new JSpinner();
		waitShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitShare.setBounds(416, 319, 40, 20);
		add(waitShare);

		JLabel lblNghGiaClone_2 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_2.setBounds(567, 325, 96, 14);
		add(lblNghGiaClone_2);

		waitCloneShare = new JSpinner();
		waitCloneShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneShare.setBounds(673, 319, 42, 20);
		add(waitCloneShare);

		numThread = new JComboBox();
		numThread.addItem("1");
		numThread.addItem("2");
		numThread.addItem("3");
		numThread.addItem("4");
		numThread.addItem("5");
		numThread.addItem("6");
		numThread.addItem("7");
		numThread.addItem("8");
		numThread.addItem("9");
		numThread.addItem("10");
		numThread.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
				updateTimeExec();
			}
		});
		
		numThread.setBounds(106, 213, 138, 20);
		add(numThread);

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
		btnNewButton.setBounds(343, 440, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save data
				container.dispose();
			}
		});
		btnLuChySau.setBounds(190, 440, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(506, 440, 98, 23);
		add(btnNhpLi);

		this.cloneList = new JList<String>(cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinLikeStatus();updateMaxLikeStatus();
				updateMinCommentStatus();updateMaxCommentStatus();
				updateMinShareStatus();updateMaxShareStatus();
				updateTimeExec();
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

		lbMinLike = new JLabel("0");
		lbMinLike.setForeground(new Color(0, 100, 0));
		lbMinLike.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinLike.setBounds(695, 57, 29, 14);
		add(lbMinLike);

		JLabel lblSComment = new JLabel("Số comment");
		lblSComment.setBounds(465, 73, 158, 14);
		add(lblSComment);

		JLabel lblSShare = new JLabel("Số share");
		lblSShare.setBounds(465, 88, 158, 14);
		add(lblSShare);

		JLabel lblThiGianHon = new JLabel("Thời gian hoàn thành(dự tính)");
		lblThiGianHon.setBounds(465, 142, 224, 14);
		add(lblThiGianHon);

		lbTimeExec = new JLabel("0 mins");
		lbTimeExec.setForeground(new Color(0, 100, 0));
		lbTimeExec.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTimeExec.setBounds(685, 142, 80, 14);
		add(lbTimeExec);

		JLabel lblNewLabel_3 = new JLabel(
				"(*) Lưu ý: Cấu hình like, comment, share là của từng clone chứ không phải là tổng cho cả chiến dịch.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setBounds(34, 371, 731, 14);
		add(lblNewLabel_3);

		JLabel lblTiNguynRamd = new JLabel("Tài nguyên RAM(dự tính)");
		lblTiNguynRamd.setBounds(465, 128, 158, 14);
		add(lblTiNguynRamd);

		lbRam = new JLabel("0 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 128, 80, 14);
		add(lbRam);

		waitLike = new JSpinner();
		waitLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitLike.setBounds(416, 254, 40, 20);
		add(waitLike);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 260, 96, 14);
		add(label_1);

		waitCloneLike = new JSpinner();
		waitCloneLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneLike.setBounds(673, 257, 42, 20);
		
		add(waitCloneLike);

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

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(724, 57, 18, 14);
		add(label_4);

		lbMaxLike = new JLabel("0");
		lbMaxLike.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxLike.setForeground(new Color(0, 100, 0));
		lbMaxLike.setBounds(734, 57, 31, 14);
		add(lbMaxLike);

		lbMinComment = new JLabel("0");
		lbMinComment.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinComment.setForeground(new Color(0, 100, 0));
		lbMinComment.setBounds(695, 73, 29, 14);
		add(lbMinComment);

		JLabel label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setBounds(724, 73, 18, 14);
		add(label_7);

		lbMaxComment = new JLabel("0");
		lbMaxComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxComment.setForeground(new Color(0, 100, 0));
		lbMaxComment.setBounds(734, 73, 31, 14);
		add(lbMaxComment);

		lbMinShare = new JLabel("0");
		lbMinShare.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinShare.setForeground(new Color(0, 100, 0));
		lbMinShare.setBounds(695, 88, 29, 14);
		add(lbMinShare);

		JLabel label_13 = new JLabel("-");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(new Color(0, 100, 0));
		label_13.setBounds(724, 88, 18, 14);
		add(label_13);

		lbMaxShare = new JLabel("0");
		lbMaxShare.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxShare.setForeground(new Color(0, 100, 0));
		lbMaxShare.setBounds(734, 88, 31, 14);
		add(lbMaxShare);
		
		
		updateMinLikeStatus();updateMaxLikeStatus();
		updateMinCommentStatus();updateMaxCommentStatus();
		updateMinShareStatus();updateMaxShareStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		JLabel lblPhnThngTin = new JLabel("Phần thông tin của chiến dịch được tổng kết ở phần góc trên, bên phải");
		lblPhnThngTin.setForeground(new Color(0, 0, 139));
		lblPhnThngTin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPhnThngTin.setBounds(88, 396, 426, 14);
		add(lblPhnThngTin);
		updateTimeExec();
	}
	
	private void updateMinLikeStatus() {
		int num = Integer.parseInt(minLike.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinLike.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxLikeStatus() {
		int num = Integer.parseInt(maxLike.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxLike.setText(String.valueOf(num * csize));
	}
	
	private void updateMinCommentStatus() {
		int num = Integer.parseInt(minComment.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinComment.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxCommentStatus() {
		int num = Integer.parseInt(maxComment.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxComment.setText(String.valueOf(num * csize));
	}
	
	private void updateMinShareStatus() {
		int num = Integer.parseInt(minShare.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinShare.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxShareStatus() {
		int num = Integer.parseInt(maxShare.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxShare.setText(String.valueOf(num * csize));
	}
	
	private void updateTimeExec() {
		int mediLike = Integer.parseInt(maxLike.getValue().toString());
		int mediComment = Integer.parseInt(maxComment.getValue().toString());
		int mediShare = Integer.parseInt(maxShare.getValue().toString());
		
		int mediLikeWait = Integer.parseInt(waitLike.getValue().toString());
		int mediCommentWait = Integer.parseInt(waitComment.getValue().toString());
		int mediShareWait = Integer.parseInt(waitShare.getValue().toString());
		
		int mediLikeCloneWait = Integer.parseInt(waitCloneLike.getValue().toString());
		int mediCommentCloneWait = Integer.parseInt(waitCloneComment.getValue().toString());
		int mediShareCloneWait = Integer.parseInt(waitCloneShare.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());
		
		int timeExecution = (csize * (mediLike + mediLikeWait + 5 + mediLikeCloneWait + 5 + mediShare + mediShareWait + 5 + mediShareCloneWait + 5 + mediComment + mediCommentWait + 5 + mediCommentCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
}