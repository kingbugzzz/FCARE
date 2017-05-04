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
import io.quangvu.fcare.helper.NumberHelper;
import io.quangvu.fcare.model.CloneModel;

public class FriendCareUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbMinReq, lbMaxReq, lbMinAcp, lbMaxAcp, lbRam,
			lbTimeExec;
	private JSpinner minReq, maxReq, minReqWait, maxReqWait;
	private JSpinner minAcp, maxAcp, minAcpWait, maxAcpWait;
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
		minReq.setBounds(106, 295, 52, 20);
		add(minReq);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(186, 298, 29, 14);
		add(lblMax);

		maxReq = new JSpinner();
		maxReq.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxReq.setBounds(239, 295, 51, 20);
		add(maxReq);

		JLabel lblSReq = new JLabel("Gửi");
		lblSReq.setBounds(36, 298, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt gửi");
		lblNghGiaReq.setBounds(352, 295, 104, 14);
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
		
		minAcp.setBounds(106, 357, 52, 20);
		add(minAcp);

		JLabel label_2 = new JLabel("đến");
		label_2.setBounds(186, 360, 29, 14);
		add(label_2);

		maxAcp = new JSpinner();
		maxAcp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxAcpStatus();
				updateTimeExec();
			}
		});
		maxAcp.setBounds(239, 357, 51, 20);
		add(maxAcp);

		JLabel lblNghGiaCmt = new JLabel("nghỉ giữa lượt nhận");
		lblNghGiaCmt.setBounds(352, 357, 124, 14);
		add(lblNghGiaCmt);

		minAcpWait = new JSpinner();
		minAcpWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minAcpWait.setBounds(486, 354, 64, 20);
		add(minAcpWait);

		maxAcpWait = new JSpinner();
		maxAcpWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxAcpWait.setBounds(697, 354, 68, 20);
		add(maxAcpWait);

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

		lbRam = new JLabel("95 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 191, 80, 14);
		add(lbRam);

		minReqWait = new JSpinner();
		minReqWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minReqWait.setBounds(486, 292, 64, 20);
		add(minReqWait);

		maxReqWait = new JSpinner();
		maxReqWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxReqWait.setBounds(697, 295, 68, 20);
		
		add(maxReqWait);

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
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		
		JLabel label = new JLabel("đến");
		label.setBounds(608, 298, 29, 14);
		add(label);
		
		JLabel label_1 = new JLabel("đến");
		label_1.setBounds(608, 360, 29, 14);
		add(label_1);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(FriendCareCampaign campaign) {
		this.name.setText(campaign.getName());
		
		this.minReq.setValue(campaign.getMinReq());
		this.maxReq.setValue(campaign.getMaxReq());
		this.minReqWait.setValue(campaign.getMinReqWait());
		this.maxReqWait.setValue(campaign.getMaxReqWait());
		
		this.minAcp.setValue(campaign.getMinAcp());
		this.maxAcp.setValue(campaign.getMaxAcp());
		this.minAcpWait.setValue(campaign.getMinAcpWait());
		this.maxAcpWait.setValue(campaign.getMaxAcpWait());
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
		int mediReq = NumberHelper.getRandomInt(Integer.parseInt(maxReq.getValue().toString()), Integer.parseInt(minReq.getValue().toString()));
		int mediAcp = NumberHelper.getRandomInt(Integer.parseInt(maxAcp.getValue().toString()), Integer.parseInt(minAcp.getValue().toString()));
		
		int mediReqWait = NumberHelper.getRandomInt(Integer.parseInt(maxReqWait.getValue().toString()), Integer.parseInt(minReqWait.getValue().toString()));
		int mediAcpWait = NumberHelper.getRandomInt(Integer.parseInt(maxAcpWait.getValue().toString()), Integer.parseInt(minAcpWait.getValue().toString()));
				
		int csize = this.cloneList.getSelectedIndices().length;
		
		int timeExecution = (csize * (mediReq + mediReqWait + mediAcp + mediAcpWait + 45))/60;
		this.lbTimeExec.setText(timeExecution+ " mins");
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
		campaign.setMinReqWait(Integer.parseInt(String.valueOf(minReqWait.getValue())));
		campaign.setMaxReqWait(Integer.parseInt(String.valueOf(maxReqWait.getValue())));
		
		campaign.setMinAcp(Integer.parseInt(String.valueOf(minAcp.getValue())));
		campaign.setMaxAcp(Integer.parseInt(String.valueOf(maxAcp.getValue())));
		campaign.setMinAcpWait(Integer.parseInt(String.valueOf(minAcpWait.getValue())));
		campaign.setMaxAcpWait(Integer.parseInt(String.valueOf(maxAcpWait.getValue())));
		
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