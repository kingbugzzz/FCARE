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

public class FriendCareCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbMinReq, lbMaxReq, lbMinAcp, lbMaxAcp, lbRam,
			lbTimeExec;
	private JSpinner minReq, maxReq, waitReq, waitCloneReq;
	private JSpinner minAcp, maxAcp, waitAcp, waitCloneAcp;
	private JComboBox numThread;
	
	private FriendCareCampaignController controller;
	
	public FriendCareCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minReq = new JSpinner();
		minReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinReqStatus();
				updateTimeExec();
			}
		});
		minReq.setBounds(106, 257, 40, 20);
		add(minReq);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 263, 29, 14);
		add(lblMax);

		maxReq = new JSpinner();
		maxReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxReq.setBounds(204, 257, 40, 20);
		add(maxReq);

		JLabel lblSReq = new JLabel("Gửi");
		lblSReq.setBounds(36, 260, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt");
		lblNghGiaReq.setBounds(302, 260, 104, 14);
		add(lblNghGiaReq);

		JLabel lblSCmtT = new JLabel("Nhận");
		lblSCmtT.setBounds(36, 294, 60, 14);
		add(lblSCmtT);

		minAcp = new JSpinner();
		minAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinAcpStatus();
				updateTimeExec();
			}
		});
		
		minAcp.setBounds(106, 291, 40, 20);
		add(minAcp);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(165, 297, 29, 14);
		add(label_2);

		maxAcp = new JSpinner();
		maxAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxAcpStatus();
				updateTimeExec();
			}
		});
		maxAcp.setBounds(204, 291, 40, 20);
		add(maxAcp);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt");
		lblNghGiaCmt.setBounds(302, 294, 98, 14);
		add(lblNghGiaCmt);

		waitAcp = new JSpinner();
		waitAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitAcp.setBounds(416, 288, 40, 20);
		add(waitAcp);

		JLabel lblNghGiaClone_1 = new JLabel("nghỉ giữa clone");
		lblNghGiaClone_1.setBounds(567, 294, 96, 14);
		add(lblNghGiaClone_1);

		waitCloneAcp = new JSpinner();
		waitCloneAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneAcp.setBounds(673, 288, 42, 20);
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
		
		numThread.setBounds(106, 213, 138, 20);
		add(numThread);

		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 216, 60, 14);
		add(lblKiuChy);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 181, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 178, 659, 20);
		add(name);
		name.setColumns(10);

		JButton btnNewButton = new JButton("Bắt đầu ngay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(349, 352, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new FriendCareMainPanel(dashboardFrame), "Quản lý chiến dịch kéo friend");
			}
		});
		btnLuChySau.setBounds(196, 352, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(512, 352, 98, 23);
		add(btnNhpLi);

		this.cloneList = new JList<String>(cloneIds);
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

		JLabel lblNewLabel_2 = new JLabel("Tổng gửi");
		lblNewLabel_2.setBounds(465, 57, 158, 14);
		add(lblNewLabel_2);

		lbMinReq = new JLabel("0");
		lbMinReq.setForeground(new Color(0, 100, 0));
		lbMinReq.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinReq.setBounds(633, 57, 53, 14);
		add(lbMinReq);

		JLabel lblSAcp = new JLabel("Tổng nhận");
		lblSAcp.setBounds(465, 82, 158, 14);
		add(lblSAcp);

		JLabel lblThiGianHon = new JLabel("Thời gian hoàn thành(dự tính)");
		lblThiGianHon.setBounds(465, 142, 224, 14);
		add(lblThiGianHon);

		lbTimeExec = new JLabel("0 mins");
		lbTimeExec.setForeground(new Color(0, 100, 0));
		lbTimeExec.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTimeExec.setBounds(685, 142, 80, 14);
		add(lbTimeExec);

		JLabel lblTiNguynRamd = new JLabel("Tài nguyên RAM(dự tính)");
		lblTiNguynRamd.setBounds(465, 120, 158, 14);
		add(lblTiNguynRamd);

		lbRam = new JLabel("0 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 120, 80, 14);
		add(lbRam);

		waitReq = new JSpinner();
		waitReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitReq.setBounds(416, 254, 40, 20);
		add(waitReq);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 260, 96, 14);
		add(label_1);

		waitCloneReq = new JSpinner();
		waitCloneReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneReq.setBounds(673, 257, 42, 20);
		
		add(waitCloneReq);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 257, 60, 14);
		add(lblGiy);

		JLabel label_5 = new JLabel("(+10)");
		label_5.setBounds(466, 291, 40, 14);
		add(label_5);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 260, 40, 14);
		add(label_8);

		JLabel label_9 = new JLabel("(+10)");
		label_9.setBounds(725, 294, 40, 14);
		add(label_9);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(706, 57, 18, 14);
		add(label_4);

		lbMaxReq = new JLabel("0");
		lbMaxReq.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxReq.setForeground(new Color(0, 100, 0));
		lbMaxReq.setBounds(734, 57, 31, 14);
		add(lbMaxReq);

		lbMinAcp = new JLabel("0");
		lbMinAcp.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinAcp.setForeground(new Color(0, 100, 0));
		lbMinAcp.setBounds(633, 82, 53, 14);
		add(lbMinAcp);

		JLabel label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setBounds(706, 82, 18, 14);
		add(label_7);

		lbMaxAcp = new JLabel("0");
		lbMaxAcp.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxAcp.setForeground(new Color(0, 100, 0));
		lbMaxAcp.setBounds(734, 82, 31, 14);
		add(lbMaxAcp);
		
		
		updateMinReqStatus();updateMaxReqStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		updateTimeExec();
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
		
		int timeExecution = (csize * (mediReq + mediReqWait + 5 + mediReqCloneWait + 5  + mediAcp + mediAcpWait + 5 + mediAcpCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
	
	private void createCareCampaignHandler() {
		this.controller = new FriendCareCampaignController();
		FriendCareCampaign campaign = new FriendCareCampaign();
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