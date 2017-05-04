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
	private JSpinner minMem, maxMem, minWait, maxWait;
	
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
		minMem.setBounds(106, 289, 60, 20);
		add(minMem);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(195, 292, 29, 14);
		add(lblMax);

		maxMem = new JSpinner();
		maxMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxMem.setBounds(234, 289, 60, 20);
		add(maxMem);

		JLabel lblSReq = new JLabel("Mem");
		lblSReq.setBounds(36, 292, 60, 14);
		add(lblSReq);

		JLabel lblNghGiaReq = new JLabel("nghỉ giữa lượt add mem");
		lblNghGiaReq.setBounds(344, 292, 144, 14);
		add(lblNghGiaReq);

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
		btnNewButton.setBounds(348, 343, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupCareMainPanel(dashboardFrame), "Quản lý chiến dịch kéo mem group");
			}
		});
		btnLuChySau.setBounds(195, 343, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(511, 343, 98, 23);
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

		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minWait.setBounds(509, 289, 80, 20);
		add(minWait);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxWait.setBounds(685, 289, 80, 20);
		
		add(maxWait);

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
		
		JLabel label = new JLabel("đến");
		label.setBounds(628, 292, 29, 14);
		add(label);
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
		int mediMem = Integer.parseInt(maxMem.getValue().toString());
		
		int mediMemWait = Integer.parseInt(maxWait.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int timeExecution = (csize * this.groupIds.getText().split(",").length * (mediMem + mediMemWait + 45))/60;
		
		this.lbTimeExec.setText(timeExecution + " mins");
	}
	
	private void createCareCampaignHandler() {
		this.controller = new GroupCareCampaignController();
		GroupCareCampaign campaign = new GroupCareCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setGroupIds(groupIds.getText().trim());
		
		campaign.setMinMem(Integer.parseInt(String.valueOf(minMem.getValue())));
		campaign.setMaxMem(Integer.parseInt(String.valueOf(maxMem.getValue())));
		campaign.setMinWait(Integer.parseInt(String.valueOf(minWait.getValue())));
		campaign.setMaxWait(Integer.parseInt(String.valueOf(maxWait.getValue())));
			
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