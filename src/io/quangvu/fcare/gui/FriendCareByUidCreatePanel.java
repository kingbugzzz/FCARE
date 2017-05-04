package io.quangvu.fcare.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileSystemView;

import io.quangvu.fcare.bean.FriendCareByUidCampaign;
import io.quangvu.fcare.controller.FriendCareByUidCampaignController;
import io.quangvu.fcare.helper.IOHelper;

public class FriendCareByUidCreatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel cloneCount, lbRam, lbTimeExec, friendUidFilePath;
	private JSpinner minWait, maxWait;

	private FriendCareByUidCampaignController controller;
	private JLabel friendCount;

	public FriendCareByUidCreatePanel(JDialog container, DashboardFrame dashboardFrame, Vector<String> cloneIds) {
		setLayout(null);

		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		minWait.setBounds(240, 290, 72, 20);
		add(minWait);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(360, 293, 29, 14);
		add(lblMax);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		maxWait.setBounds(441, 290, 72, 20);
		add(maxWait);

		JLabel lblSReq = new JLabel("Nghỉ giữa lượt add");
		lblSReq.setBounds(106, 293, 124, 14);
		add(lblSReq);

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
		btnNewButton.setBounds(362, 356, 131, 23);
		add(btnNewButton);

		JButton btnLuChySau = new JButton("Lưu chạy sau");
		btnLuChySau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAddCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new FriendCareByUidMainPanel(dashboardFrame), "Quản lý chiến dịch add friend theo uid");
			}
		});
		btnLuChySau.setBounds(209, 356, 124, 23);
		add(btnLuChySau);

		JButton btnNhpLi = new JButton("Nhập lại");
		btnNhpLi.setBounds(525, 356, 98, 23);
		add(btnNhpLi);

		this.cloneList = new JList<String>(cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
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

		JLabel lblNewLabel_2 = new JLabel("Uid");
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

		lbRam = new JLabel("95 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 120, 80, 14);
		add(lbRam);

		
		friendCount = new JLabel();
		
		friendCount.setHorizontalAlignment(SwingConstants.RIGHT);
		friendCount.setForeground(new Color(0, 100, 0));
		friendCount.setBounds(685, 57, 80, 14);
		add(friendCount);
		
		JButton browseFile = new JButton("Browse uid");
		browseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if(returnValue == 0) {
					String srcPath = jfc.getSelectedFile().getAbsolutePath().replace("\\", "/");
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						friendUidFilePath.setText(srcPath);
						friendCount.setText(String.valueOf(IOHelper.readLines(srcPath).size()));
					}
				}
			}
		});
		browseFile.setBounds(106, 226, 124, 23);
		add(browseFile);
		friendUidFilePath = new JLabel("");
		friendUidFilePath.setBounds(240, 235, 525, 14);
		add(friendUidFilePath);
		updateTimeExec();
	}

	private void updateTimeExec() {
		int mediWait = Integer.parseInt(maxWait.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		int timeExecution = csize * mediWait;
		
		if(!this.friendCount.getText().equals("")) {
			timeExecution = csize *  Integer.parseInt(this.friendCount.getText().trim()) * mediWait / 60;
		}
		
		this.lbTimeExec.setText(timeExecution + " mins");
	}

	private void createAddCampaignHandler() {
		this.controller = new FriendCareByUidCampaignController();
		FriendCareByUidCampaign campaign = new FriendCareByUidCampaign();
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setFriendIdsSourceFile(friendUidFilePath.getText().trim());

		campaign.setMinWait(Integer.parseInt(String.valueOf(minWait.getValue())));
		campaign.setMaxWait(Integer.parseInt(String.valueOf(maxWait.getValue())));

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