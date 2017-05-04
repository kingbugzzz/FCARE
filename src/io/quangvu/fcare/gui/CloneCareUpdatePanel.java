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
	private JSpinner minLike, maxLike, minLikeWait, maxLikeWait;
	private JSpinner minComment, maxComment, minCommentWait, maxCommentWait;
	private JSpinner minShare, maxShare, minShareWait, maxShareWait;
	private JComboBox statusType;
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
		minLike.setBounds(106, 326, 52, 20);
		add(minLike);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(192, 329, 29, 14);
		add(lblMax);

		maxLike = new JSpinner();
		maxLike.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxLikeStatus();
				updateTimeExec();
			}
		});
		maxLike.setBounds(242, 326, 49, 20);
		add(maxLike);

		JLabel lblSLike = new JLabel("Số like");
		lblSLike.setBounds(36, 329, 60, 14);
		add(lblSLike);

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
		
		minComment.setBounds(106, 357, 52, 20);
		add(minComment);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(192, 360, 29, 14);
		add(label_2);

		maxComment = new JSpinner();
		maxComment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxCommentStatus();
				updateTimeExec();
			}
		});
		maxComment.setBounds(242, 357, 49, 20);
		add(maxComment);

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
		minShare.setBounds(106, 391, 52, 20);
		add(minShare);

		JLabel label_3 = new JLabel("đến");
		label_3.setBounds(192, 394, 29, 14);
		add(label_3);

		maxShare = new JSpinner();
		maxShare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxShareStatus();
				updateTimeExec();
			}
		});
		maxShare.setBounds(242, 391, 49, 20);
		add(maxShare);

		JLabel lblKiuChy = new JLabel("Status");
		lblKiuChy.setBounds(36, 289, 60, 14);
		add(lblKiuChy);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 246, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 243, 659, 20);
		add(name);
		name.setColumns(10);

		statusType = new JComboBox();
		statusType.addItem("text+image");
		statusType.addItem("text");
		statusType.addItem("random");
		statusType.addItem("no status");
		statusType.setBounds(106, 286, 185, 20);
		add(statusType);

		JButton btnLuChySau = new JButton("Cập nhật");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new CloneCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
				
			}
		});
		btnLuChySau.setBounds(332, 452, 124, 23);
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

		JLabel lblTiNguynRamd = new JLabel("Tài nguyên RAM(dự tính)");
		lblTiNguynRamd.setBounds(465, 191, 158, 14);
		add(lblTiNguynRamd);

		lbRam = new JLabel("95 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 191, 80, 14);
		add(lbRam);

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
		
		
		
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		
		JLabel label = new JLabel("nghỉ giữa mỗi lượt like");
		label.setBounds(376, 324, 151, 14);
		add(label);
		
		minLikeWait = new JSpinner();
		minLikeWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minLikeWait.setBounds(551, 318, 63, 20);
		add(minLikeWait);
		
		JLabel label_1 = new JLabel("đến");
		label_1.setBounds(659, 321, 40, 14);
		add(label_1);
		
		maxLikeWait = new JSpinner();
		maxLikeWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxLikeWait.setBounds(709, 321, 56, 20);
		add(maxLikeWait);
		
		maxCommentWait = new JSpinner();
		maxCommentWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxCommentWait.setBounds(709, 357, 56, 20);
		add(maxCommentWait);
		
		JLabel label_5 = new JLabel("đến");
		label_5.setBounds(659, 363, 40, 14);
		add(label_5);
		
		minCommentWait = new JSpinner();
		minCommentWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minCommentWait.setBounds(551, 357, 63, 20);
		add(minCommentWait);
		
		JLabel label_6 = new JLabel("nghỉ giữa mỗi lượt comment");
		label_6.setBounds(376, 363, 165, 14);
		add(label_6);
		
		JLabel label_8 = new JLabel("nghỉ giữa mỗi lượt share");
		label_8.setBounds(376, 397, 151, 14);
		add(label_8);
		
		minShareWait = new JSpinner();
		minShareWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minShareWait.setBounds(551, 391, 63, 20);
		add(minShareWait);
		
		JLabel label_9 = new JLabel("đến");
		label_9.setBounds(659, 397, 40, 14);
		add(label_9);
		
		maxShareWait = new JSpinner();
		maxShareWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxShareWait.setBounds(709, 391, 56, 20);
		add(maxShareWait);
		this.initUpdateFormValues(campaign);
		updateMinLikeStatus();updateMaxLikeStatus();
		updateMinCommentStatus();updateMaxCommentStatus();
		updateMinShareStatus();updateMaxShareStatus();
		updateTimeExec();
	}
	
	private void initUpdateFormValues(CloneCareCampaign campaign) {
		this.name.setText(campaign.getName());
		this.statusType.setSelectedItem(campaign.getStatusType());
		
		this.minLike.setValue(campaign.getMinLike());
		this.maxLike.setValue(campaign.getMaxLike());
		this.minLikeWait.setValue(campaign.getMinLikeWait());
		this.maxLikeWait.setValue(campaign.getMaxLikeWait());
		
		this.minComment.setValue(campaign.getMinComment());
		this.maxComment.setValue(campaign.getMaxComment());
		this.minCommentWait.setValue(campaign.getMinCommentWait());
		this.maxCommentWait.setValue(campaign.getMaxCommentWait());
		
		this.minShare.setValue(campaign.getMinShare());
		this.maxShare.setValue(campaign.getMaxShare());
		this.minShareWait.setValue(campaign.getMinShareWait());
		this.maxShareWait.setValue(campaign.getMaxShareWait());
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
		
	private void updateCareCampaignHandler() {
		this.controller = new CloneCareCampaignController();
		CloneCareCampaign campaign = new CloneCareCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
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