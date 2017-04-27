package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import io.quangvu.fcare.bean.FriendCareCampaign;
import io.quangvu.fcare.controller.FriendCareCampaignController;
import io.quangvu.fcare.model.CloneModel;

public class FriendCareUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbMinReq, lbMaxReq, lbMinAcp, lbMaxAcp, lbRam,
			lbTimeExec;
	private JSpinner minReq, maxReq, waitReq, waitCloneReq;
	private JSpinner minAcp, maxAcp, waitAcp, waitCloneAcp;
	private JComboBox numThread;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private FriendCareCampaignController controller;
	
	public FriendCareUpdatePanel(JDialog container, DashboardFrame dashboardFrame, FriendCareCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minReq = new JSpinner();
		minReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinReqStatus();
				updateTimeExec();
			}
		});
		minReq.setBounds(106, 326, 40, 20);
		add(minReq);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 332, 29, 14);
		add(lblMax);

		maxReq = new JSpinner();
		maxReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxReq.setBounds(204, 326, 40, 20);
		add(maxReq);

		JLabel lblSReq = new JLabel("Gửi");
		lblSReq.setBounds(36, 329, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt");
		lblNghGiaReq.setBounds(302, 329, 104, 14);
		add(lblNghGiaReq);

		JLabel lblSCmtT = new JLabel("Nhận");
		lblSCmtT.setBounds(36, 360, 60, 14);
		add(lblSCmtT);

		minAcp = new JSpinner();
		minAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinAcpStatus();
				updateTimeExec();
			}
		});
		
		minAcp.setBounds(106, 357, 40, 20);
		add(minAcp);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 363, 29, 14);
		add(label_2);

		maxAcp = new JSpinner();
		maxAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxAcpStatus();
				updateTimeExec();
			}
		});
		maxAcp.setBounds(204, 357, 40, 20);
		add(maxAcp);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 360, 98, 14);
		add(lblNghGiaCmt);

		waitAcp = new JSpinner();
		waitAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitAcp.setBounds(416, 354, 40, 20);
		add(waitAcp);

		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 360, 96, 14);
		add(lblNghGiaClone_1);

		waitCloneAcp = new JSpinner();
		waitCloneAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneAcp.setBounds(673, 354, 42, 20);
		add(waitCloneAcp);

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

		JButton btnLuChySau = new JButton("Cập nhật");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new FriendCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
			}
		});
		btnLuChySau.setBounds(321, 420, 124, 23);
		add(btnLuChySau);
		
		this.cloneList = new JList<String>(this.cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinReqStatus();updateMaxReqStatus();
				updateMinAcpStatus();updateMaxAcpStatus();
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

		JLabel lblNewLabel_2 = new JLabel("Tổng gửi");
		lblNewLabel_2.setBounds(465, 116, 158, 14);
		add(lblNewLabel_2);

		lbMinReq = new JLabel("0");
		lbMinReq.setForeground(new Color(0, 100, 0));
		lbMinReq.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinReq.setBounds(633, 116, 53, 14);
		add(lbMinReq);

		JLabel lblSAcp = new JLabel("Tổng nhận");
		lblSAcp.setBounds(465, 130, 158, 14);
		add(lblSAcp);

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

		lbRam = new JLabel("0 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 191, 80, 14);
		add(lbRam);

		waitReq = new JSpinner();
		waitReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitReq.setBounds(416, 323, 40, 20);
		add(waitReq);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 329, 96, 14);
		add(label_1);

		waitCloneReq = new JSpinner();
		waitCloneReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneReq.setBounds(673, 326, 42, 20);
		
		add(waitCloneReq);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 326, 60, 14);
		add(lblGiy);

		JLabel label_5 = new JLabel("(+10)");
		label_5.setBounds(466, 357, 40, 14);
		add(label_5);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 329, 40, 14);
		add(label_8);

		JLabel label_9 = new JLabel("(+10)");
		label_9.setBounds(725, 360, 40, 14);
		add(label_9);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(708, 116, 18, 14);
		add(label_4);

		lbMaxReq = new JLabel("0");
		lbMaxReq.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxReq.setForeground(new Color(0, 100, 0));
		lbMaxReq.setBounds(725, 116, 40, 14);
		add(lbMaxReq);

		lbMinAcp = new JLabel("0");
		lbMinAcp.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinAcp.setForeground(new Color(0, 100, 0));
		lbMinAcp.setBounds(633, 130, 53, 14);
		add(lbMinAcp);

		JLabel label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setBounds(708, 130, 18, 14);
		add(label_7);

		lbMaxAcp = new JLabel("0");
		lbMaxAcp.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxAcp.setForeground(new Color(0, 100, 0));
		lbMaxAcp.setBounds(725, 130, 40, 14);
		add(lbMaxAcp);
		
		
		updateMinReqStatus();updateMaxReqStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(FriendCareCampaign campaign) {
		this.name.setText(campaign.getName());
		this.numThread.setSelectedItem(String.valueOf(campaign.getNumThread()));
		
		this.minReq.setValue(campaign.getMinReq());
		this.maxReq.setValue(campaign.getMaxReq());
		this.waitReq.setValue(campaign.getWaitReq());
		this.waitCloneReq.setValue(campaign.getWaitCloneReq());
		
		this.minAcp.setValue(campaign.getMinAcp());
		this.maxAcp.setValue(campaign.getMaxAcp());
		this.waitAcp.setValue(campaign.getWaitAcp());
		this.waitCloneAcp.setValue(campaign.getWaitCloneAcp());
	}
	
	private void updateMinReqStatus() {
		int num = Integer.parseInt(minReq.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinReq.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxReqStatus() {
		int num = Integer.parseInt(maxReq.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxReq.setText(String.valueOf(num * csize));
	}
	
	private void updateMinAcpStatus() {
		int num = Integer.parseInt(minAcp.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinAcp.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxAcpStatus() {
		int num = Integer.parseInt(maxAcp.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxAcp.setText(String.valueOf(num * csize));
	}
		
	private void updateTimeExec() {
		int mediReq = Integer.parseInt(maxReq.getValue().toString());
		int mediAcp = Integer.parseInt(maxAcp.getValue().toString());
		
		int mediReqWait = Integer.parseInt(waitReq.getValue().toString());
		int mediAcpWait = Integer.parseInt(waitAcp.getValue().toString());
		
		int mediReqCloneWait = Integer.parseInt(waitCloneReq.getValue().toString());
		int mediAcpCloneWait = Integer.parseInt(waitCloneAcp.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());
		
		int timeExecution = (csize * (mediReq + mediReqWait + 5 + mediReqCloneWait + 5 + mediAcp + mediAcpWait + 5 + mediAcpCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
	
	private void initUpdateValues() {
		
	}
	
	private void updateCareCampaignHandler() {
		this.controller = new FriendCareCampaignController();
		FriendCareCampaign campaign = new FriendCareCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		
		campaign.setMinReq(Integer.parseInt(String.valueOf(minReq.getValue())));
		campaign.setMaxReq(Integer.parseInt(String.valueOf(maxReq.getValue())));
		campaign.setWaitReq(Integer.parseInt(String.valueOf(waitReq.getValue())));
		campaign.setWaitCloneReq(Integer.parseInt(String.valueOf(waitCloneReq.getValue())));
		
		campaign.setMinAcp(Integer.parseInt(String.valueOf(minAcp.getValue())));
		campaign.setMaxAcp(Integer.parseInt(String.valueOf(maxAcp.getValue())));
		campaign.setWaitAcp(Integer.parseInt(String.valueOf(waitAcp.getValue())));
		campaign.setWaitCloneAcp(Integer.parseInt(String.valueOf(waitCloneAcp.getValue())));
		
		
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