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

import io.quangvu.fcare.bean.GroupCareCampaign;
import io.quangvu.fcare.controller.GroupCareCampaignController;

public class GroupCareCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbMinAdd, lbMaxAdd, lbRam,
			lbTimeExec;
	private JSpinner minAdd, maxAdd, waitAdd, waitCloneAdd;
	private JComboBox numThread;
	
	private GroupCareCampaignController controller;
	
	public GroupCareCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minAdd = new JSpinner();
		minAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinReqStatus();
				updateTimeExec();
			}
		});
		minAdd.setBounds(106, 257, 40, 20);
		add(minAdd);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 263, 29, 14);
		add(lblMax);

		maxAdd = new JSpinner();
		maxAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxAdd.setBounds(204, 257, 40, 20);
		add(maxAdd);

		JLabel lblSReq = new JLabel("Gửi");
		lblSReq.setBounds(36, 260, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt");
		lblNghGiaReq.setBounds(302, 260, 104, 14);
		add(lblNghGiaReq);

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
		btnNewButton.setBounds(357, 311, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupCareMainPanel(dashboardFrame), "Quản lý chiến dịch kéo friend");
			}
		});
		btnLuChySau.setBounds(204, 311, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(520, 311, 98, 23);
		add(btnNhpLi);

		this.cloneList = new JList<String>(cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinReqStatus();updateMaxReqStatus();
				updateMinAcpStatus();updateMaxAcpStatus();
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

		JLabel lblNewLabel_2 = new JLabel("Tổng add");
		lblNewLabel_2.setBounds(465, 57, 158, 14);
		add(lblNewLabel_2);

		lbMinAdd = new JLabel("0");
		lbMinAdd.setForeground(new Color(0, 100, 0));
		lbMinAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinAdd.setBounds(633, 57, 53, 14);
		add(lbMinAdd);

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

		waitAdd = new JSpinner();
		waitAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitAdd.setBounds(416, 254, 40, 20);
		add(waitAdd);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 260, 96, 14);
		add(label_1);

		waitCloneAdd = new JSpinner();
		waitCloneAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneAdd.setBounds(673, 257, 42, 20);
		
		add(waitCloneAdd);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 257, 60, 14);
		add(lblGiy);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 260, 40, 14);
		add(label_8);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(706, 57, 18, 14);
		add(label_4);

		lbMaxAdd = new JLabel("0");
		lbMaxAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxAdd.setForeground(new Color(0, 100, 0));
		lbMaxAdd.setBounds(734, 57, 31, 14);
		add(lbMaxAdd);
		
		
		updateMinReqStatus();updateMaxReqStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		updateMinShareStatus();updateMaxShareStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		updateTimeExec();
	}
	
	private void updateMinReqStatus() {
		int num = Integer.parseInt(minAdd.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinAdd.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxReqStatus() {
		int num = Integer.parseInt(maxAdd.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxAdd.setText(String.valueOf(num * csize));
	}
	
	private void updateMinAcpStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMaxAcpStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMinShareStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMaxShareStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateTimeExec() {
		int mediReq = Integer.parseInt(maxAdd.getValue().toString());
		
		int mediReqWait = Integer.parseInt(waitAdd.getValue().toString());
		
		int mediReqCloneWait = Integer.parseInt(waitCloneAdd.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());
		
		int timeExecution = (csize * (mediReq + mediReqWait + 5 + mediReqCloneWait + 5  + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
	
	private void createCareCampaignHandler() {
		this.controller = new GroupCareCampaignController();
		GroupCareCampaign campaign = new GroupCareCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		
		campaign.setMinAdd(Integer.parseInt(String.valueOf(minAdd.getValue())));
		campaign.setMaxAdd(Integer.parseInt(String.valueOf(maxAdd.getValue())));
		campaign.setWaitAdd(Integer.parseInt(String.valueOf(waitAdd.getValue())));
		campaign.setWaitCloneAdd(Integer.parseInt(String.valueOf(waitCloneAdd.getValue())));
			
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