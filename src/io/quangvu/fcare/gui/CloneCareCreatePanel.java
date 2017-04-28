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

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.controller.CloneCareCampaignController;
import io.quangvu.fcare.helper.NumberHelper;

import java.awt.Color;
import java.awt.Font;

public class CloneCareCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbMinLike, lbMaxLike, lbMinComment, lbMaxComment, lbMinShare, lbMaxShare, lbRam,
			lbTimeExec;
	private JSpinner minLike, maxLike, waitLike, waitCloneLike;
	private JSpinner minComment, maxComment, waitComment, waitCloneComment;
	private JSpinner minShare, maxShare, waitShare, waitCloneShare;
	private JComboBox numThread, statusType;
	
	private CloneCareCampaignController controller;
	
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
		minLike.setBounds(106, 295, 40, 20);
		add(minLike);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 301, 29, 14);
		add(lblMax);

		maxLike = new JSpinner();
		maxLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxLikeStatus();
				updateTimeExec();
			}
		});
		maxLike.setBounds(204, 295, 40, 20);
		add(maxLike);

		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 298, 60, 14);
		add(lblSLike);

		JLabel lblNghGiaLike = new JLabel("nghỉ giữa lượt");
		lblNghGiaLike.setBounds(302, 298, 104, 14);
		add(lblNghGiaLike);

		JLabel lblSCmtT = new JLabel("Số cmt");
		lblSCmtT.setBounds(36, 337, 60, 14);
		add(lblSCmtT);

		minComment = new JSpinner();
		minComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinCommentStatus();
				updateTimeExec();
			}
		});
		
		minComment.setBounds(106, 334, 40, 20);
		add(minComment);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 340, 29, 14);
		add(label_2);

		maxComment = new JSpinner();
		maxComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxCommentStatus();
				updateTimeExec();
			}
		});
		maxComment.setBounds(204, 334, 40, 20);
		add(maxComment);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 337, 98, 14);
		add(lblNghGiaCmt);

		waitComment = new JSpinner();
		waitComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitComment.setBounds(416, 331, 40, 20);
		add(waitComment);

		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 337, 96, 14);
		add(lblNghGiaClone_1);

		waitCloneComment = new JSpinner();
		waitCloneComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneComment.setBounds(673, 331, 42, 20);
		add(waitCloneComment);

		JLabel lblSShareT = new JLabel("Số share");
		lblSShareT.setBounds(36, 371, 66, 14);
		add(lblSShareT);

		minShare = new JSpinner();
		minShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinShareStatus();
				updateTimeExec();
			}
		});
		minShare.setBounds(106, 368, 40, 20);
		add(minShare);

		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(165, 374, 29, 14);
		add(label_3);

		maxShare = new JSpinner();
		maxShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxShareStatus();
				updateTimeExec();
			}
		});
		maxShare.setBounds(204, 368, 40, 20);
		add(maxShare);

		JLabel lblNghGiaShare = new JLabel("nghỉ giữa lượt");
		lblNghGiaShare.setBounds(302, 371, 98, 14);
		add(lblNghGiaShare);

		waitShare = new JSpinner();
		waitShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitShare.setBounds(416, 365, 40, 20);
		add(waitShare);

		JLabel lblNghGiaClone_2 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_2.setBounds(567, 371, 96, 14);
		add(lblNghGiaClone_2);

		waitCloneShare = new JSpinner();
		waitCloneShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneShare.setBounds(673, 365, 42, 20);
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
		
		numThread.setBounds(106, 247, 138, 20);
		add(numThread);

		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 250, 60, 14);
		add(lblKiuChy);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 201, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 198, 659, 20);
		add(name);
		name.setColumns(10);

		JLabel lblKiuStatus = new JLabel("Kiểu status");
		lblKiuStatus.setBounds(302, 250, 73, 14);
		add(lblKiuStatus);

		statusType = new JComboBox();
		statusType.addItem("text+image");
		statusType.addItem("text");
		statusType.addItem("random");
		statusType.addItem("no status");
		statusType.setBounds(416, 244, 129, 20);
		add(statusType);

		JButton btnNewButton = new JButton("Bắt đầu ngay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(347, 428, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new CloneCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
				
			}
		});
		btnLuChySau.setBounds(194, 428, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(510, 428, 98, 23);
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
		waitLike.setBounds(416, 292, 40, 20);
		add(waitLike);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 298, 96, 14);
		add(label_1);

		waitCloneLike = new JSpinner();
		waitCloneLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneLike.setBounds(673, 295, 42, 20);
		
		add(waitCloneLike);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 295, 60, 14);
		add(lblGiy);

		JLabel label_5 = new JLabel("(+10)");
		label_5.setBounds(466, 334, 40, 14);
		add(label_5);

		JLabel label_6 = new JLabel("(+10)");
		label_6.setBounds(466, 368, 40, 14);
		add(label_6);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 298, 40, 14);
		add(label_8);

		JLabel label_9 = new JLabel("(+10)");
		label_9.setBounds(725, 337, 40, 14);
		add(label_9);

		JLabel label_10 = new JLabel("(+10)");
		label_10.setBounds(725, 371, 40, 14);
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
	
	private void createCareCampaignHandler() {
		this.controller = new CloneCareCampaignController();
		CloneCareCampaign campaign = new CloneCareCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setStatusType(statusType.getSelectedItem().toString());
		
		campaign.setMinLike(Integer.parseInt(String.valueOf(minLike.getValue())));
		campaign.setMaxLike(Integer.parseInt(String.valueOf(maxLike.getValue())));
		campaign.setWaitLike(Integer.parseInt(String.valueOf(waitLike.getValue())));
		campaign.setWaitCloneLike(Integer.parseInt(String.valueOf(waitCloneLike.getValue())));
		
		campaign.setMinComment(Integer.parseInt(String.valueOf(minComment.getValue())));
		campaign.setMaxComment(Integer.parseInt(String.valueOf(maxComment.getValue())));
		campaign.setWaitComment(Integer.parseInt(String.valueOf(waitComment.getValue())));
		campaign.setWaitCloneComment(Integer.parseInt(String.valueOf(waitCloneComment.getValue())));
		
		campaign.setMinShare(Integer.parseInt(String.valueOf(minShare.getValue())));
		campaign.setMaxShare(Integer.parseInt(String.valueOf(maxShare.getValue())));
		campaign.setWaitShare(Integer.parseInt(String.valueOf(waitShare.getValue())));
		campaign.setWaitCloneShare(Integer.parseInt(String.valueOf(waitCloneShare.getValue())));
		
		campaign.setNumThread(Integer.parseInt(numThread.getSelectedItem().toString()));
		campaign.setStatus("off");
		
//		System.out.println(campaign.toString());
		
		this.controller.add(campaign);
	}
	
	private String getSelectedCloneIds() {
		String ids = "";
		int selectedIndexes[] = this.cloneList.getSelectedIndices();
		String id=null;
		for(int selectedIndex : selectedIndexes) {
			id = this.cloneList.getModel().getElementAt(selectedIndex).toString().split("<")[1];
			ids +=  id.substring(0, id.length()-1) + ",";
		}
		return ids.substring(0, ids.length()-1);
	}
}