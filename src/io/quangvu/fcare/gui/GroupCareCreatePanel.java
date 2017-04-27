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
import javax.swing.JEditorPane;
import java.awt.Font;

public class GroupCareCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbMinMem, lbMaxMem, lbRam,
			lbTimeExec;
	private JSpinner minMem, maxMem, waitMem, waitClone;
	private JComboBox numThread;
	
	private GroupCareCampaignController controller;
	private JTextField groupIds;
	
	public GroupCareCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minMem = new JSpinner();
		minMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinReqStatus();
				updateTimeExec();
			}
		});
		minMem.setBounds(106, 326, 40, 20);
		add(minMem);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 332, 29, 14);
		add(lblMax);

		maxMem = new JSpinner();
		maxMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxMem.setBounds(204, 326, 40, 20);
		add(maxMem);

		JLabel lblSReq = new JLabel("Mem");
		lblSReq.setBounds(36, 329, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt");
		lblNghGiaReq.setBounds(302, 329, 104, 14);
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
		
		numThread.setBounds(106, 285, 138, 20);
		add(numThread);

		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 288, 60, 14);
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
		btnNewButton.setBounds(357, 392, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupCareMainPanel(dashboardFrame), "Quản lý chiến dịch kéo mem group");
			}
		});
		btnLuChySau.setBounds(204, 392, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(520, 392, 98, 23);
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

		JLabel lblNewLabel_2 = new JLabel("Số member");
		lblNewLabel_2.setBounds(465, 57, 158, 14);
		add(lblNewLabel_2);

		lbMinMem = new JLabel("0");
		lbMinMem.setForeground(new Color(0, 100, 0));
		lbMinMem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinMem.setBounds(633, 57, 53, 14);
		add(lbMinMem);

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

		waitMem = new JSpinner();
		waitMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitMem.setBounds(416, 323, 40, 20);
		add(waitMem);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 329, 96, 14);
		add(label_1);

		waitClone = new JSpinner();
		waitClone.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitClone.setBounds(673, 326, 42, 20);
		
		add(waitClone);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 326, 60, 14);
		add(lblGiy);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 329, 40, 14);
		add(label_8);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(706, 57, 18, 14);
		add(label_4);

		lbMaxMem = new JLabel("0");
		lbMaxMem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxMem.setForeground(new Color(0, 100, 0));
		lbMaxMem.setBounds(734, 57, 31, 14);
		add(lbMaxMem);
		
		
		updateMinReqStatus();updateMaxReqStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		updateMinShareStatus();updateMaxShareStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setBounds(36, 218, 60, 14);
		add(lblGroupId);
		
		groupIds = new JTextField();
		groupIds.setColumns(10);
		groupIds.setBounds(106, 215, 659, 20);
		add(groupIds);
		
		JLabel lblNewLabel_1 = new JLabel("* Mỗi group id cách nhau bằng dấu phẩy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(106, 246, 631, 14);
		add(lblNewLabel_1);
		updateTimeExec();
	}
	
	private void updateMinReqStatus() {
		int num = Integer.parseInt(minMem.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinMem.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxReqStatus() {
		int num = Integer.parseInt(maxMem.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMaxMem.setText(String.valueOf(num * csize));
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
		int mediReq = Integer.parseInt(maxMem.getValue().toString());
		
		int mediReqWait = Integer.parseInt(waitMem.getValue().toString());
		
		int mediReqCloneWait = Integer.parseInt(waitClone.getValue().toString());
		
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
		campaign.setGroupIds(groupIds.getText().trim());
		
		campaign.setMinMem(Integer.parseInt(String.valueOf(minMem.getValue())));
		campaign.setMaxMem(Integer.parseInt(String.valueOf(maxMem.getValue())));
		campaign.setWaitMem(Integer.parseInt(String.valueOf(waitMem.getValue())));
		campaign.setWaitClone(Integer.parseInt(String.valueOf(waitClone.getValue())));
			
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