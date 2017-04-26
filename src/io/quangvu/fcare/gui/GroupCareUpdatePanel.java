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

public class GroupCareUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbMinAdd, lbMaxAdd, lbRam,
			lbTimeExec;
	private JSpinner minAdd, maxAdd, waitAdd, waitCloneAdd;
	private JComboBox numThread;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private GroupCareCampaignController controller;
	
	public GroupCareUpdatePanel(JDialog container, DashboardFrame dashboardFrame, GroupCareCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minAdd = new JSpinner();
		minAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinAddStatus();
				updateTimeExec();
			}
		});
		minAdd.setBounds(106, 326, 40, 20);
		add(minAdd);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(165, 332, 29, 14);
		add(lblMax);

		maxAdd = new JSpinner();
		maxAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxAddStatus();
				updateTimeExec();
			}
		});
		maxAdd.setBounds(204, 326, 40, 20);
		add(maxAdd);

		JLabel lblSAdd = new JLabel("Gửi");
		lblSAdd.setBounds(36, 329, 60, 14);
		add(lblSAdd);

		JLabel lblNghGiaAdd = new JLabel("nghỉ giữa lượt");
		lblNghGiaAdd.setBounds(302, 329, 104, 14);
		add(lblNghGiaAdd);

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
				dashboardFrame.loadPanel(new GroupCareMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
			}
		});
		btnLuChySau.setBounds(321, 379, 124, 23);
		add(btnLuChySau);
		
		this.cloneList = new JList<String>(this.cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinAddStatus();updateMaxAddStatus();
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

		lbMinAdd = new JLabel("0");
		lbMinAdd.setForeground(new Color(0, 100, 0));
		lbMinAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinAdd.setBounds(633, 116, 53, 14);
		add(lbMinAdd);

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

		waitAdd = new JSpinner();
		waitAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitAdd.setBounds(416, 323, 40, 20);
		add(waitAdd);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(567, 329, 96, 14);
		add(label_1);

		waitCloneAdd = new JSpinner();
		waitCloneAdd.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitCloneAdd.setBounds(673, 326, 42, 20);
		
		add(waitCloneAdd);

		JLabel lblGiy = new JLabel("(+10)");
		lblGiy.setBounds(466, 326, 60, 14);
		add(lblGiy);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(725, 329, 40, 14);
		add(label_8);

		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setBounds(708, 116, 18, 14);
		add(label_4);

		lbMaxAdd = new JLabel("0");
		lbMaxAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMaxAdd.setForeground(new Color(0, 100, 0));
		lbMaxAdd.setBounds(725, 116, 40, 14);
		add(lbMaxAdd);
		
		
		updateMinAddStatus();updateMaxAddStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(GroupCareCampaign campaign) {
		this.name.setText(campaign.getName());
		this.numThread.setSelectedItem(String.valueOf(campaign.getNumThread()));
		
		this.minAdd.setValue(campaign.getMinAdd());
		this.maxAdd.setValue(campaign.getMaxAdd());
		this.waitAdd.setValue(campaign.getWaitAdd());
		this.waitCloneAdd.setValue(campaign.getWaitCloneAdd());

	}
	
	private void updateMinAddStatus() {
		int num = Integer.parseInt(minAdd.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
		lbMinAdd.setText(String.valueOf(num * csize));
	}
	
	private void updateMaxAddStatus() {
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
		
	private void updateTimeExec() {
		int mediAdd = Integer.parseInt(maxAdd.getValue().toString());
		
		int mediAddWait = Integer.parseInt(waitAdd.getValue().toString());
		
		int mediAddCloneWait = Integer.parseInt(waitCloneAdd.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());
		
		int timeExecution = (csize * (mediAdd + mediAddWait + 5 + mediAddCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
	
	private void initUpdateValues() {
		
	}
	
	private void updateCareCampaignHandler() {
		this.controller = new GroupCareCampaignController();
		GroupCareCampaign campaign = new GroupCareCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		
		campaign.setMinAdd(Integer.parseInt(String.valueOf(minAdd.getValue())));
		campaign.setMaxAdd(Integer.parseInt(String.valueOf(maxAdd.getValue())));
		campaign.setWaitAdd(Integer.parseInt(String.valueOf(waitAdd.getValue())));
		campaign.setWaitCloneAdd(Integer.parseInt(String.valueOf(waitCloneAdd.getValue())));
		
		
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