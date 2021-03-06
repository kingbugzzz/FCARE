package io.quangvu.fcare.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import io.quangvu.fcare.bean.CloneCareCampaign;
import io.quangvu.fcare.controller.CloneCareCampaignController;
import io.quangvu.fcare.helper.NumberHelper;

public class CloneCareMainPanel extends JPanel {
	
	private CloneCareCampaignController controller;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	private JLabel sum;
	
	private CloneCareRunningDialog cloneCRD;
	
	public CloneCareMainPanel(DashboardFrame container) {
		setLayout(null);
		this.controller = new CloneCareCampaignController();
		
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
		btnXa.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/recycle-bin-recycle-16.png")));
		btnXa.setBounds(35, 34, 49, 23);
		add(btnXa);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					
					CloneCareCampaign campaign = controller.get(String.valueOf(table.getValueAt(selectedRowIndexes[0], 0)));
					
					System.out.println(campaign.toString());
					
					new CloneCareUpdateDialog(container, "Cập nhật chiến dịch nuôi [id:" + campaign.getId() + "]", 830, 535, campaign).display();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1 thôi!");
				}
			}
		});
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/ic_mode_edit_48px-16.png")));
		btnCpNht.setBounds(94, 34, 49, 23);
		add(btnCpNht);
				
		this.tableHeader = this.controller.getTableHeader();
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel = new DefaultTableModel(this.tableData, this.tableHeader);
		table = new JTable(this.tabelModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 1109, 427);
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
		comboBox.setBounds(993, 37, 151, 20);
		add(comboBox);
		
		JButton btnStart = new JButton("");
		btnStart.setToolTipText("Bắt đầu chạy");
		btnStart.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/play.png")));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if (selectedRowIndexes.length == 1) {
					String campId = String.valueOf(table.getValueAt(selectedRowIndexes[0], 0));
					cloneCRD = new CloneCareRunningDialog(container, "Campaign Id: " + campId + "", campId);
					cloneCRD.setModal(false);
					cloneCRD.display();
					
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1!");
				}
			}
		});
		btnStart.setBounds(214, 34, 55, 23);
		add(btnStart);
		//updateTable();
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		this.sum.setText("Tổng:" + this.table.getRowCount());
	}
}
