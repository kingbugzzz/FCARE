package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import io.quangvu.fcare.bean.GroupJoinCampaign;
import io.quangvu.fcare.controller.GroupJoinCampaignController;
import io.quangvu.fcare.model.CloneModel;
import java.awt.Font;

public class GroupJoinUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbRam,
			lbTimeExec;
	private JSpinner minWait, maxWait;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private GroupJoinCampaignController controller;
	private JTextField groupIds;
	private JLabel countGroup;
	
	public GroupJoinUpdatePanel(JDialog container, DashboardFrame dashboardFrame, GroupJoinCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minWait.setBounds(247, 374, 93, 20);
		add(minWait);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(388, 377, 29, 14);
		add(lblMax);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxWait.setBounds(476, 374, 87, 20);
		add(maxWait);

		JLabel lblSWait = new JLabel("Nghỉ giữa lượt join");
		lblSWait.setBounds(106, 377, 121, 14);
		add(lblSWait);

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
				updateJoinCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupJoinMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
			}
		});
		btnLuChySau.setBounds(343, 428, 124, 23);
		add(btnLuChySau);
		
		this.cloneList = new JList<String>(this.cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
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

		JLabel lblNewLabel_2 = new JLabel("Group");
		lblNewLabel_2.setBounds(465, 116, 158, 14);
		add(lblNewLabel_2);

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
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		
		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setBounds(36, 286, 60, 14);
		add(lblGroupId);
		
		groupIds = new JTextField();
		groupIds.setText(campaign.getGroupIds());
		groupIds.setColumns(10);
		groupIds.setBounds(106, 283, 659, 20);
		add(groupIds);
		groupIds.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(groupIds.getText().trim().equals("")) {
					countGroup.setText("0");
				}
				if(!groupIds.getText().trim().equals("") && !groupIds.getText().trim().contains(",")) {
					countGroup.setText("1");
				}
				if(groupIds.getText().contains(",")) {
					countGroup.setText(String.valueOf(groupIds.getText().split(",").length));
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("(*) Mỗi group id cách nhau bằng dấu phẩy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(106, 321, 517, 14);
		add(lblNewLabel_1);
		
		countGroup = new JLabel();
		if(groupIds.getText().trim().equals("")) {
			countGroup.setText("0");
		}
		if(!groupIds.getText().trim().equals("") && !groupIds.getText().trim().contains(",")) {
			countGroup.setText("1");
		}
		if(groupIds.getText().contains(",")) {
			countGroup.setText(String.valueOf(groupIds.getText().split(",").length));
		}
		countGroup.setHorizontalAlignment(SwingConstants.RIGHT);
		countGroup.setForeground(new Color(0, 100, 0));
		countGroup.setBounds(685, 116, 80, 14);
		add(countGroup);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(GroupJoinCampaign campaign) {
		this.name.setText(campaign.getName());
		this.groupIds.setText(campaign.getGroupIds());
		
		this.minWait.setValue(campaign.getMinWait());
		this.maxWait.setValue(campaign.getMaxWait());

	}
	
	private void updateTimeExec() {
		int mediWait = Integer.parseInt(maxWait.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int timeExecution = (csize * + this.groupIds.getText().split(",").length * (mediWait + 45))/60;
		this.lbTimeExec.setText(timeExecution + " mins");
	}
	
	private void updateJoinCampaignHandler() {
		this.controller = new GroupJoinCampaignController();
		GroupJoinCampaign campaign = new GroupJoinCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setGroupIds(groupIds.getText().trim());
		
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