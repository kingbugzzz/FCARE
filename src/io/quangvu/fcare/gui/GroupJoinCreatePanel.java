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
import javax.swing.JEditorPane;
import java.awt.Font;

public class GroupJoinCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbRam, lbTimeExec;
	private JSpinner minWait, maxWait, waitClone;
	private JComboBox numThread;

	private GroupJoinCampaignController controller;
	private JTextField groupIds;
	private JLabel countGroup;

	public GroupJoinCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinReqStatus();
				updateTimeExec();
			}
		});
		minWait.setBounds(240, 326, 40, 20);
		add(minWait);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(326, 329, 29, 14);
		add(lblMax);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxReqStatus();
				updateTimeExec();
			}
		});
		maxWait.setBounds(377, 326, 40, 20);
		add(maxWait);

		JLabel lblSReq = new JLabel("Nghỉ giữa lượt join");
		lblSReq.setBounds(106, 329, 124, 14);
		add(lblSReq);

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
				createJoinCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new GroupJoinMainPanel(dashboardFrame), "Quản lý chiến dịch join group");
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
				updateMinReqStatus();
				updateMaxReqStatus();
				updateMinAcpStatus();
				updateMaxAcpStatus();
				updateMinShareStatus();
				updateMaxShareStatus();
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

		JLabel lblNewLabel_2 = new JLabel("Group");
		lblNewLabel_2.setBounds(465, 57, 158, 14);
		add(lblNewLabel_2);

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

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(465, 329, 96, 14);
		add(label_1);

		waitClone = new JSpinner();
		waitClone.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitClone.setBounds(571, 326, 42, 20);

		add(waitClone);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(633, 329, 40, 14);
		add(label_8);

		updateMinReqStatus();
		updateMaxReqStatus();
		updateMinAcpStatus();
		updateMaxAcpStatus();
		updateMinShareStatus();
		updateMaxShareStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");

		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setBounds(36, 218, 60, 14);
		add(lblGroupId);

		groupIds = new JTextField();
		groupIds.setColumns(10);
		groupIds.setBounds(106, 215, 659, 20);
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

		JLabel lblNewLabel_1 = new JLabel("* Mỗi group id cách nhau bằng dấu phẩy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(106, 246, 631, 14);
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
		countGroup.setBounds(685, 57, 80, 14);
		add(countGroup);
		updateTimeExec();
	}

	private void updateMinReqStatus() {
		int num = Integer.parseInt(minWait.getValue().toString().trim());
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateMaxReqStatus() {
		int num = Integer.parseInt(maxWait.getValue().toString().trim());
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateMinAcpStatus() {
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateMaxAcpStatus() {
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateMinShareStatus() {
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateMaxShareStatus() {
		int csize = cloneList.getSelectedIndices().length;
	}

	private void updateTimeExec() {
		int mediReq = Integer.parseInt(maxWait.getValue().toString());

		int mediReqCloneWait = Integer.parseInt(waitClone.getValue().toString());

		int csize = this.cloneList.getSelectedIndices().length;

		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());

		int timeExecution = (csize * (mediReq + 5 + mediReqCloneWait + 5 + 45 + 45)) / 60;
		this.lbTimeExec.setText(timeExecution / numThread + " mins");
	}

	private void createJoinCampaignHandler() {
		this.controller = new GroupJoinCampaignController();
		GroupJoinCampaign campaign = new GroupJoinCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setGroupIds(groupIds.getText().trim());

		campaign.setMinWait(Integer.parseInt(String.valueOf(minWait.getValue())));
		campaign.setMaxWait(Integer.parseInt(String.valueOf(maxWait.getValue())));
		campaign.setWaitClone(Integer.parseInt(String.valueOf(waitClone.getValue())));

		campaign.setNumThread(Integer.parseInt(numThread.getSelectedItem().toString()));
		campaign.setStatus("off");

		// System.out.println(campaign.toString());

		this.controller.add(campaign);
	}

	private String getSelectedCloneIds() {
		String ids = "";
		int selectedIndexes[] = this.cloneList.getSelectedIndices();
		String id = null;
		for (int selectedIndex : selectedIndexes) {
			id = this.cloneList.getModel().getElementAt(selectedIndex).toString().split("<")[1];
			ids += id.substring(0, id.length() - 1) + ",";
		}
		return ids.substring(0, ids.length() - 1);
	}
}