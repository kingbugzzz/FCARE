package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.quangvu.fcare.bean.FriendCareByUidCampaign;
import io.quangvu.fcare.controller.FriendCareByUidCampaignController;

public class FriendCareByUidMainPanel extends JPanel {
	
	private FriendCareByUidCampaignController controller;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	private JLabel sum;
	
	public FriendCareByUidMainPanel(DashboardFrame container) {
		setLayout(null);
		this.controller = new FriendCareByUidCampaignController();
		
		JButton btnXa = new JButton("");
		btnXa.setToolTipText("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 0));
					ids.add(table.getValueAt(i, 0).toString());
				}
				controller.delete(ids);
				updateTable();
			}
		});
		btnXa.setIcon(new ImageIcon(FriendCareByUidMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/recycle-bin-recycle-16.png")));
		btnXa.setBounds(35, 34, 49, 23);
		add(btnXa);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					
					FriendCareByUidCampaign campaign = controller.get(String.valueOf(table.getValueAt(selectedRowIndexes[0], 0)));
					
					new FriendCareByUidUpdateDialog(container, "Cập nhật chiến dịch join group [id:" + campaign.getId() + "]", 830, 585, campaign).display();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1 thôi!");
				}
			}
		});
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(FriendCareByUidMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/ic_mode_edit_48px-16.png")));
		btnCpNht.setBounds(94, 34, 49, 23);
		add(btnCpNht);
				
		this.tableHeader = this.controller.getTableHeader();
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel = new DefaultTableModel(this.tableData, this.tableHeader);
		table = new JTable(this.tabelModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(245);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 1114, 427);
		add(scrollPane);
		
		sum = new JLabel();
		sum.setText("Tổng:" + this.table.getRowCount());
		sum.setBounds(35, 534, 66, 14);
		add(sum);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Tất cả chiến dịch");
		comboBox.addItem("Đang chạy");
		comboBox.addItem("Đang nghỉ");
		comboBox.addItem("Đã hoàn thành");
		comboBox.setBounds(998, 44, 151, 20);
		add(comboBox);
		
		JButton btnPlanlist = new JButton("");
		btnPlanlist.setToolTipText("Bắt đầu chạy");
		btnPlanlist.setIcon(new ImageIcon(FriendCareByUidMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/settings_ico.png")));
		btnPlanlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlanlist.setBounds(214, 34, 49, 23);
		add(btnPlanlist);
		updateTable();
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(245);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		this.sum.setText("Tổng:" + this.table.getRowCount());
	}
}