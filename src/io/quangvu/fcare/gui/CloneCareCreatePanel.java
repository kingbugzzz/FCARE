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
	private JSpinner minLike, maxLike, minLikeWait, maxLikeWait;
	private JSpinner minComment, maxComment, minCommentWait, maxCommentWait;
	private JSpinner minShare, maxShare, minShareWait, maxShareWait;
	private JComboBox statusType;
	
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
		minLike.setBounds(106, 295, 57, 20);
		add(minLike);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(194, 298, 29, 14);
		add(lblMax);

		maxLike = new JSpinner();
		maxLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxLikeStatus();
				updateTimeExec();
			}
		});
		maxLike.setBounds(237, 295, 51, 20);
		add(maxLike);

		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 298, 60, 14);
		add(lblSLike);

		JLabel lblNghGiaLike = new JLabel("nghỉ giữa mỗi lượt like");
		lblNghGiaLike.setBounds(376, 298, 151, 14);
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
		
		minComment.setBounds(106, 334, 57, 20);
		add(minComment);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(194, 337, 29, 14);
		add(label_2);

		maxComment = new JSpinner();
		maxComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxCommentStatus();
				updateTimeExec();
			}
		});
		maxComment.setBounds(237, 334, 51, 20);
		add(maxComment);

		minCommentWait = new JSpinner();
		minCommentWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minCommentWait.setBounds(551, 331, 63, 20);
		add(minCommentWait);

		maxCommentWait = new JSpinner();
		maxCommentWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxCommentWait.setBounds(709, 331, 56, 20);
		add(maxCommentWait);

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
		minShare.setBounds(106, 368, 57, 20);
		add(minShare);

		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(194, 371, 29, 14);
		add(label_3);

		maxShare = new JSpinner();
		maxShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxShareStatus();
				updateTimeExec();
			}
		});
		maxShare.setBounds(237, 368, 51, 20);
		add(maxShare);

		minShareWait = new JSpinner();
		minShareWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minShareWait.setBounds(551, 365, 63, 20);
		add(minShareWait);

		maxShareWait = new JSpinner();
		maxShareWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxShareWait.setBounds(709, 365, 56, 20);
		add(maxShareWait);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 201, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 198, 659, 20);
		add(name);
		name.setColumns(10);

		JLabel lblKiuStatus = new JLabel("Status");
		lblKiuStatus.setBounds(36, 247, 50, 14);
		add(lblKiuStatus);

		statusType = new JComboBox();
		statusType.addItem("text+image");
		statusType.addItem("text");
		statusType.addItem("random");
		statusType.addItem("no status");
		statusType.setBounds(106, 244, 185, 20);
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

		lbRam = new JLabel("95 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 128, 80, 14);
		add(lbRam);

		minLikeWait = new JSpinner();
		minLikeWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minLikeWait.setBounds(551, 292, 63, 20);
		add(minLikeWait);

		maxLikeWait = new JSpinner();
		maxLikeWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxLikeWait.setBounds(709, 295, 56, 20);
		
		add(maxLikeWait);

		JLabel lblGiy = new JLabel("đến");
		lblGiy.setBounds(659, 295, 40, 14);
		add(lblGiy);

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
		
		JLabel label = new JLabel("đến");
		label.setBounds(659, 337, 40, 14);
		add(label);
		
		JLabel label_1 = new JLabel("đến");
		label_1.setBounds(659, 371, 40, 14);
		add(label_1);
		
		JLabel lblNghGiaMi = new JLabel("nghỉ giữa mỗi lượt comment");
		lblNghGiaMi.setBounds(376, 337, 165, 14);
		add(lblNghGiaMi);
		
		JLabel lblNghGiaMi_1 = new JLabel("nghỉ giữa mỗi lượt share");
		lblNghGiaMi_1.setBounds(376, 371, 151, 14);
		add(lblNghGiaMi_1);
		
		
		updateMinLikeStatus();updateMaxLikeStatus();
		updateMinCommentStatus();updateMaxCommentStatus();
		updateMinShareStatus();updateMaxShareStatus();
		
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
		
		int mediLikeWait = Integer.parseInt(maxLikeWait.getValue().toString());
		int mediCommentWait = Integer.parseInt(maxCommentWait.getValue().toString());
		int mediShareWait = Integer.parseInt(maxShareWait.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int timeExecution = (csize * (mediLike + mediLikeWait +  mediShare + mediShareWait  + mediComment + mediCommentWait + 50))/60;
		
		this.lbTimeExec.setText(timeExecution + " mins");
	}
	
	private void createCareCampaignHandler() {
		this.controller = new CloneCareCampaignController();
		CloneCareCampaign campaign = new CloneCareCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setStatusType(statusType.getSelectedItem().toString());
		
		campaign.setMinLike(Integer.parseInt(String.valueOf(minLike.getValue())));
		campaign.setMaxLike(Integer.parseInt(String.valueOf(maxLike.getValue())));
		campaign.setMinLikeWait(Integer.parseInt(String.valueOf(minLikeWait.getValue())));
		campaign.setMaxLikeWait(Integer.parseInt(String.valueOf(maxLikeWait.getValue())));
		
		campaign.setMinComment(Integer.parseInt(String.valueOf(minComment.getValue())));
		campaign.setMaxComment(Integer.parseInt(String.valueOf(maxComment.getValue())));
		campaign.setMinCommentWait(Integer.parseInt(String.valueOf(minCommentWait.getValue())));
		campaign.setMaxCommentWait(Integer.parseInt(String.valueOf(maxCommentWait.getValue())));
		
		campaign.setMinShare(Integer.parseInt(String.valueOf(minShare.getValue())));
		campaign.setMaxShare(Integer.parseInt(String.valueOf(maxShare.getValue())));
		campaign.setMinShareWait(Integer.parseInt(String.valueOf(minShareWait.getValue())));
		campaign.setMaxShareWait(Integer.parseInt(String.valueOf(maxShareWait.getValue())));
		
//		campaign.setNumThread(Integer.parseInt(numThread.getSelectedItem().toString()));
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