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

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.controller.CloneCareCampaignController;
import io.quangvu.fcare.controller.CloneController;
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneCareCampaignModel;
import io.quangvu.fcare.model.CloneModel;

import java.awt.Color;
import java.awt.Font;

public class CloneCareUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbMinLike, lbMaxLike, lbMinComment, lbMaxComment, lbMinShare, lbMaxShare, lbRam,
			lbTimeExec;
	private JSpinner minLike, maxLike, waitLike, waitCloneLike;
	private JSpinner minComment, maxComment, waitComment, waitCloneComment;
	private JSpinner minShare, maxShare, waitShare, waitCloneShare;
	private JComboBox numThread, statusType;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private CloneCareCampaignController controller;
	
	public CloneCareUpdatePanel(JDialog container, DashboardFrame dashboardFrame, CloneCareCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minLike = new JSpinner();
		minLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinLikeStatus();
				updateTimeExec();
			}
		});
		minLike.setBounds(106, 326, 40, 20);
		add(minLike);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 332, 29, 14);
		add(lblMax);

		maxLike = new JSpinner();
		maxLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxLikeStatus();
				updateTimeExec();
			}
		});
		maxLike.setBounds(204, 326, 40, 20);
		add(maxLike);

		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 329, 60, 14);
		add(lblSLike);

		JLabel lblNghGiaLike = new JLabel("nghỉ giữa lượt");
		lblNghGiaLike.setBounds(302, 329, 104, 14);
		add(lblNghGiaLike);

		JLabel lblSCmtT = new JLabel("Số cmt");
		lblSCmtT.setBounds(36, 360, 60, 14);
		add(lblSCmtT);

		minComment = new JSpinner();
		minComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinCommentStatus();
				updateTimeExec();
			}
		});
		
		minComment.setBounds(106, 357, 40, 20);
		add(minComment);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 363, 29, 14);
		add(label_2);

		maxComment = new JSpinner();
		maxComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxCommentStatus();
				updateTimeExec();
			}
		});
		maxComment.setBounds(204, 357, 40, 20);
		add(maxComment);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 360, 98, 14);
		add(lblNghGiaCmt);

		waitComment = new JSpinner();
		waitComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitComment.setBounds(416, 354, 40, 20);
		add(waitComment);

		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 360, 96, 14);
		add(lblNghGiaClone_1);

		waitCloneComment = new JSpinner();
		waitCloneComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneComment.setBounds(673, 354, 42, 20);
		add(waitCloneComment);

		JLabel lblSShareT = new JLabel("Số share");
		lblSShareT.setBounds(36, 394, 66, 14);
		add(lblSShareT);

		minShare = new JSpinner();
		minShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinShareStatus();
				updateTimeExec();
			}
		});
		minShare.setBounds(106, 391, 40, 20);
		add(minShare);

		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(165, 397, 29, 14);
		add(label_3);

		maxShare = new JSpinner();
		maxShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxShareStatus();
				updateTimeExec();
			}
		});
		maxShare.setBounds(204, 391, 40, 20);
		add(maxShare);

		JLabel lblNghGiaShare = new JLabel("nghỉ giữa lượt");
		lblNghGiaShare.setBounds(302, 394, 98, 14);
		add(lblNghGiaShare);

		waitShare = new JSpinner();
		waitShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitShare.setBounds(416, 388, 40, 20);
		add(waitShare);

		JLabel lblNghGiaClone_2 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_2.setBounds(567, 394, 96, 14);
		add(lblNghGiaClone_2);

		waitCloneShare = new JSpinner();
		waitCloneShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneShare.setBounds(673, 388, 42, 20);
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
		
		numThread.setBounds(106, 286, 138, 20);
		add(numThread);

		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 289, 60, 14);
		add(lblKiuChy);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 246, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 243, 659, 20);
		add(name);
		name.setColumns(10);

		JLabel lblKiuStatus = new JLabel("Kiểu status");
		lblKiuStatus.setBounds(302, 289, 73, 14);
		add(lblKiuStatus);

		statusType = new JComboBox();
		statusType.addItem("text+image");
		statusType.addItem("text");
		statusType.addItem("text+link");
		statusType.addItem("link");
		statusType.addItem("random");
		statusType.addItem("no status");
		statusType.setBounds(416, 283, 129, 20);
		add(statusType);

		JButton btnLuChySau = new JButton("Cập nhật");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new CloneCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
				
			}
		});
		btnLuChySau.setBounds(332, 502, 124, 23);
		add(btnLuChySau);
		
		
		
		this.cloneList = new JList<String>(this.cloneIds);
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
		JScrollPane scrollPane = new JScrollPane(this.cloneList);
		scrollPane.setBounds(106, 91, 311, 128);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("Clone");
		lblNewLabel.setBounds(465, 91, 124, 14);
		add(lblNewLabel);

		cloneCount = new JLabel(String.valueOf(cloneIds.size()));
		cloneCount.setForeground(new Color(0, 100, 0));
		cloneCount.setHorizontalAlignment(SwingConstants.RIGHT);
		cloneCount.setBounds(685, 91, 80, 14);
		add(cloneCount);

		JLabel lblNewLabel_2 = new JLabel("Số like");
		lblNewLabel_2.setBounds(465, 116, 158, 14);
		add(lblNewLabel_2);

		lbMinLike = new JLabel("0");
		lbMinLike.setForeground(new Color(0, 100, 0));
		lbMinLike.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinLike.setBounds(695, 116, 29, 14);
		add(lbMinLike);

		JLabel lblSComment = new JLabel("Số comment");
		lblSComment.setBounds(465, 130, 158, 14);
		add(lblSComment);

		JLabel lblSShare = new JLabel("Số share");
		lblSShare.setBounds(465, 141, 158, 14);
		add(lblSShare);

		JLabel lblThiGianHon = new JLabel("Thời gian hoàn thành(dự tính)");
		lblThiGianHon.setBounds(465, 205, 224, 14);
		add(lblThiGianHon);

		lbTimeExec = new JLabel("0 mins");
		lbTimeExec.setForeground(new Color(0, 100, 0));
		lbTimeExec.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTimeExec.setBounds(685, 205, 80, 14);
		add(lbTimeExec);

		JLabel lblNewLabel_3 = new JLabel(
				"(*) Lưu ý: Cấu hình like, comment, share là của từng clone chứ không phải là tổng cho cả chiến dịch.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setBounds(34, 433, 731, 14);
		add(lblNewLabel_3);

		JLabel lblTiNguynRamd = new JLabel("Tài nguyên RAM(dự tính)");
		lblTiNguynRamd.setBounds(465, 191, 158, 14);
		add(lblTiNguynRamd);

		lbRam = new JLabel("0 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 191, 80, 14);
		add(lbRam);

		waitLike = new JSpinner();
		waitLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitLike.setBounds(416, 323, 40, 20);
		add(waitLike);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 329, 96, 14);
		add(label_1);

		waitCloneLike = new JSpinner();
		waitCloneLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneLike.setBounds(673, 326, 42, 20);
		
		add(waitCloneLike);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 326, 60, 14);
		add(lblGiy);

		JLabel label_5 = new JLabel("(+10)");
		label_5.setBounds(466, 357, 40, 14);
		add(label_5);

		JLabel label_6 = new JLabel("(+10)");
		label_6.setBounds(466, 391, 40, 14);
		add(label_6);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 329, 40, 14);
		add(label_8);

		JLabel label_9 = new JLabel("(+10)");
		label_9.setBounds(725, 360, 40, 14);
		add(label_9);

		JLabel label_10 = new JLabel("(+10)");
		label_10.setBounds(725, 394, 40, 14);
		add(label_10);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(724, 116, 18, 14);
		add(label_4);

		lbMaxLike = new JLabel("0");
		lbMaxLike.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxLike.setForeground(new Color(0, 100, 0));
		lbMaxLike.setBounds(734, 116, 31, 14);
		add(lbMaxLike);

		lbMinComment = new JLabel("0");
		lbMinComment.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinComment.setForeground(new Color(0, 100, 0));
		lbMinComment.setBounds(695, 130, 29, 14);
		add(lbMinComment);

		JLabel label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setBounds(724, 130, 18, 14);
		add(label_7);

		lbMaxComment = new JLabel("0");
		lbMaxComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxComment.setForeground(new Color(0, 100, 0));
		lbMaxComment.setBounds(734, 130, 31, 14);
		add(lbMaxComment);

		lbMinShare = new JLabel("0");
		lbMinShare.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinShare.setForeground(new Color(0, 100, 0));
		lbMinShare.setBounds(695, 141, 29, 14);
		add(lbMinShare);

		JLabel label_13 = new JLabel("-");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(new Color(0, 100, 0));
		label_13.setBounds(724, 141, 18, 14);
		add(label_13);

		lbMaxShare = new JLabel("0");
		lbMaxShare.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxShare.setForeground(new Color(0, 100, 0));
		lbMaxShare.setBounds(734, 141, 31, 14);
		add(lbMaxShare);
		
		
		updateMinLikeStatus();updateMaxLikeStatus();
		updateMinCommentStatus();updateMaxCommentStatus();
		updateMinShareStatus();updateMaxShareStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		JLabel lblPhnThngTin = new JLabel("Phần thông tin của chiến dịch được tổng kết ở phần góc trên, bên phải");
		lblPhnThngTin.setForeground(new Color(0, 0, 139));
		lblPhnThngTin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPhnThngTin.setBounds(88, 458, 426, 14);
		add(lblPhnThngTin);
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(CloneCareCampaign campaign) {
		this.name.setText(campaign.getName());
		this.numThread.setSelectedItem(String.valueOf(campaign.getNumThread()));
		this.statusType.setSelectedItem(campaign.getStatusType());
		
		this.minLike.setValue(campaign.getMinLike());
		this.maxLike.setValue(campaign.getMaxLike());
		this.waitLike.setValue(campaign.getWaitLike());
		this.waitCloneLike.setValue(campaign.getWaitCloneLike());
		
		this.minComment.setValue(campaign.getMinComment());
		this.maxComment.setValue(campaign.getMaxComment());
		this.waitComment.setValue(campaign.getWaitComment());
		this.waitCloneComment.setValue(campaign.getWaitCloneComment());
		
		this.minShare.setValue(campaign.getMinShare());
		this.maxShare.setValue(campaign.getMaxShare());
		this.waitShare.setValue(campaign.getWaitShare());
		this.waitCloneShare.setValue(campaign.getWaitCloneShare());
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
	
	private void initUpdateValues() {
		
	}
	
	private void updateCareCampaignHandler() {
		this.controller = new CloneCareCampaignController();
		CloneCareCampaign campaign = new CloneCareCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
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
		
		this.controller.update(campaign);
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