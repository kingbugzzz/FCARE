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
import io.quangvu.fcare.model.CloneModel;
import java.awt.Font;

public class GroupCareUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbMinMem, lbMaxMem, lbRam,
			lbTimeExec;
	private JSpinner minMem, maxMem, minWait, maxWait;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private GroupCareCampaignController controller;
	private JTextField groupIds;
	
	public GroupCareUpdatePanel(JDialog container, DashboardFrame dashboardFrame, GroupCareCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minMem = new JSpinner();
		minMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinMemStatus();
				updateTimeExec();
			}
		});
		minMem.setBounds(106, 367, 71, 20);
		add(minMem);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(202, 370, 29, 14);
		add(lblMax);

		maxMem = new JSpinner();
		maxMem.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxMemStatus();
				updateTimeExec();
			}
		});
		maxMem.setBounds(241, 367, 60, 20);
		add(maxMem);

		JLabel lblSMem = new JLabel("Mem");
		lblSMem.setBounds(36, 370, 60, 14);
		add(lblSMem);

		JLabel lblNghGiaMem = new JLabel("nghỉ giữa lượt add mem");
		lblNghGiaMem.setBounds(350, 370, 149, 14);
		add(lblNghGiaMem);

		JLabel lblPlan = new JLabel("Camp");
		lblPlan.setBounds(36, 255, 60, 14);
		add(lblPlan);

		name = new JTextField();
		name.setBounds(106, 252, 659, 20);
		add(name);
		name.setColumns(10);

		JButton btnLuChySau = new JButton("Cập nhật");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCareCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
			}
		});
		btnLuChySau.setBounds(314, 428, 124, 23);
		add(btnLuChySau);
		
		this.cloneList = new JList<String>(this.cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinMemStatus();updateMaxMemStatus();
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

		lbMinMem = new JLabel("0");
		lbMinMem.setForeground(new Color(0, 100, 0));
		lbMinMem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinMem.setBounds(633, 116, 53, 14);
		add(lbMinMem);

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

		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minWait.setBounds(509, 367, 80, 20);
		add(minWait);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxWait.setBounds(685, 367, 80, 20);
		
		add(maxWait);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(708, 116, 18, 14);
		add(label_4);

		lbMaxMem = new JLabel("0");
		lbMaxMem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxMem.setForeground(new Color(0, 100, 0));
		lbMaxMem.setBounds(725, 116, 40, 14);
		add(lbMaxMem);
		
		
		updateMinMemStatus();updateMaxMemStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		
		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setBounds(36, 286, 60, 14);
		add(lblGroupId);
		
		groupIds = new JTextField();
		groupIds.setText((String) null);
		groupIds.setColumns(10);
		groupIds.setBounds(106, 283, 659, 20);
		add(groupIds);
		
		JLabel lblNewLabel_1 = new JLabel("(*) Mỗi group id cách nhau bằng dấu phẩy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(106, 321, 517, 14);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("đến");
		label.setBounds(628, 370, 29, 14);
		add(label);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(GroupCareCampaign campaign) {
		this.name.setText(campaign.getName());
		this.groupIds.setText(campaign.getGroupIds());
		
		this.minMem.setValue(campaign.getMinMem());
		this.maxMem.setValue(campaign.getMaxMem());
		this.minWait.setValue(campaign.getMinWait());
		this.maxWait.setValue(campaign.getMaxWait());

	}
	
	private void updateMinMemStatus() {
		int num = Integer.parseInt(minMem.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinMem.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxMemStatus() {
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
		
	private void updateTimeExec() {
		int mediMem = Integer.parseInt(maxMem.getValue().toString());
		
		int mediMemWait = Integer.parseInt(minWait.getValue().toString());
		
		int mediMemCloneWait = Integer.parseInt(maxWait.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int timeExecution = (csize * (mediMem + mediMemWait + 5 + mediMemCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution + " mins");
	}
	
	private void updateCareCampaignHandler() {
		this.controller = new GroupCareCampaignController();
		GroupCareCampaign campaign = new GroupCareCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setGroupIds(groupIds.getText().trim());
		
		campaign.setMinMem(Integer.parseInt(String.valueOf(minMem.getValue())));
		campaign.setMaxMem(Integer.parseInt(String.valueOf(maxMem.getValue())));
		campaign.setMinWait(Integer.parseInt(String.valueOf(minWait.getValue())));
		campaign.setMaxWait(Integer.parseInt(String.valueOf(maxWait.getValue())));
		
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