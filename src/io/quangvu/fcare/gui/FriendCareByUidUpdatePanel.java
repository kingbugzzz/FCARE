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
import io.quangvu.fcare.model.CloneModel;
import java.awt.Font;

public class FriendCareByUidUpdatePanel extends JPanel {

	private JTextField name;
	private JList<String> cloneList;
	private JLabel title, cloneCount, lbRam,
			lbTimeExec, friendUidFilePath;
	private JSpinner minWait, maxWait, waitClone;
	private JComboBox numThread;
	private Vector<String> cloneIds;
	
	private CloneModel cloneModel;
	
	private FriendCareByUidCampaignController controller;
	private JLabel friendCount;
	
	public FriendCareByUidUpdatePanel(JDialog container, DashboardFrame dashboardFrame, FriendCareByUidCampaign campaign) {
		setLayout(null);
		this.cloneModel = new CloneModel();
		this.cloneIds = this.cloneModel.getCloneUpdateCampaignUid(campaign.getCloneIdList());
		
		minWait = new JSpinner();
		minWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMinWaitStatus();
				updateTimeExec();
			}
		});
		minWait.setBounds(247, 409, 40, 20);
		add(minWait);

		JLabel lblMax = new JLabel("đến");
		lblMax.setBounds(324, 412, 29, 14);
		add(lblMax);

		maxWait = new JSpinner();
		maxWait.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateMaxWaitStatus();
				updateTimeExec();
			}
		});
		maxWait.setBounds(377, 409, 40, 20);
		add(maxWait);

		JLabel lblSWait = new JLabel("Nghỉ giữa lượt join");
		lblSWait.setBounds(106, 412, 121, 14);
		add(lblSWait);

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
		
		numThread.setBounds(106, 362, 111, 20);
		add(numThread);

		JLabel lblKiuChy = new JLabel("Số luồng");
		lblKiuChy.setBounds(36, 365, 60, 14);
		add(lblKiuChy);

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
				updateAddCampaignHandler();
				container.dispose();
				dashboardFrame.loadPanel(new FriendCareByUidMainPanel(dashboardFrame), "Quản lý chiến dịch nuôi");
			}
		});
		btnLuChySau.setBounds(315, 459, 124, 23);
		add(btnLuChySau);
		
		this.cloneList = new JList<String>(this.cloneIds);
		this.cloneList.setSelectionInterval(0, this.cloneList.getModel().getSize() - 1);
		this.cloneList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				cloneCount.setText(String.valueOf(cloneList.getSelectedIndices().length));
				updateMinWaitStatus();updateMaxWaitStatus();
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

		JLabel lblNewLabel_2 = new JLabel("Uid");
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

		lbRam = new JLabel("0 MB");
		lbRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbRam.setForeground(new Color(0, 100, 0));
		lbRam.setBounds(685, 191, 80, 14);
		add(lbRam);

		JLabel label_1 = new JLabel("nghỉ giữa clone");
		label_1.setBounds(465, 412, 96, 14);
		add(label_1);

		waitClone = new JSpinner();
		waitClone.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTimeExec();
			}
		});
		waitClone.setBounds(571, 409, 42, 20);
		
		add(waitClone);

		JLabel label_8 = new JLabel("(+10)");
		label_8.setBounds(633, 412, 40, 14);
		add(label_8);
		
		
		updateMinWaitStatus();updateMaxWaitStatus();
		updateMinAcpStatus();updateMaxAcpStatus();
		lbRam.setText((Integer.parseInt(numThread.getSelectedItem().toString()) * 150) + " MB");
		
		title = new JLabel("Camp Id: " + campaign.getId());
		title.setBounds(106, 43, 311, 14);
		add(title);
		
		friendCount = new JLabel();
		if(campaign.getFriendIdsSourceFile().trim().length() > 0) {
			int numUid = IOHelper.readLines(campaign.getFriendIdsSourceFile()).size();
			friendCount.setText(String.valueOf(numUid));
		}
		
		friendCount.setHorizontalAlignment(SwingConstants.RIGHT);
		friendCount.setForeground(new Color(0, 100, 0));
		friendCount.setBounds(685, 116, 80, 14);
		add(friendCount);
		
		JButton btnNewButton = new JButton("Browse uid");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if(returnValue == 0) {
					String srcPath = jfc.getSelectedFile().getAbsolutePath().replace("\\", "/");
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						friendUidFilePath.setText(srcPath);
						int numUid = IOHelper.readLines(srcPath).size();
						friendCount.setText(String.valueOf(numUid));
					}
				}
			}
		});
		btnNewButton.setBounds(106, 307, 111, 23);
		add(btnNewButton);
		
		friendUidFilePath = new JLabel("");
		friendUidFilePath.setText(campaign.getFriendIdsSourceFile());
		friendUidFilePath.setBounds(227, 311, 538, 14);
		add(friendUidFilePath);
		this.initUpdateFormValues(campaign);
		updateTimeExec();
	}
	
	private void initUpdateFormValues(FriendCareByUidCampaign campaign) {
		this.name.setText(campaign.getName());
		this.numThread.setSelectedItem(String.valueOf(campaign.getNumThread()));
		
		this.minWait.setValue(campaign.getMinWait());
		this.maxWait.setValue(campaign.getMaxWait());
		this.waitClone.setValue(campaign.getWaitClone());

	}
	
	private void updateMinWaitStatus() {
		int num = Integer.parseInt(minWait.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMaxWaitStatus() {
		int num = Integer.parseInt(maxWait.getValue().toString().trim());
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMinAcpStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
	
	private void updateMaxAcpStatus() {
		int csize  = cloneList.getSelectedIndices().length;
	}
		
	private void updateTimeExec() {
		int mediWait = Integer.parseInt(maxWait.getValue().toString());
		
		int mediWaitCloneWait = Integer.parseInt(waitClone.getValue().toString());
		
		int csize = this.cloneList.getSelectedIndices().length;
		
		int numThread = Integer.parseInt(this.numThread.getSelectedItem().toString());
		
		int timeExecution = (csize * (mediWait + 5 + mediWaitCloneWait + 5 + 45 + 45))/60;
		this.lbTimeExec.setText(timeExecution/numThread + " mins");
	}
	
	private void updateAddCampaignHandler() {
		this.controller = new FriendCareByUidCampaignController();
		FriendCareByUidCampaign campaign = new FriendCareByUidCampaign();
		campaign.setId(Integer.parseInt((this.title.getText().split(":")[1]).trim()));
		campaign.setName(name.getText().trim());
		campaign.setCloneIdList(this.getSelectedCloneIds());
		campaign.setFriendIdsSourceFile(this.friendUidFilePath.getText().trim());
		
		campaign.setMinWait(Integer.parseInt(String.valueOf(minWait.getValue())));
		campaign.setMaxWait(Integer.parseInt(String.valueOf(maxWait.getValue())));
		campaign.setWaitClone(Integer.parseInt(String.valueOf(waitClone.getValue())));
		
		
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