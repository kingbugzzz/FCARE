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

import io.quangvu.fcare.bean.Clone;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.CloneController;

public class CloneMainPanel extends JPanel {
	
	private CloneController controller;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	private JLabel sum;
	
	public CloneMainPanel(DashboardFrame container) {
		setLayout(null);
				
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCreateDialog(container, "Thêm mới clone", 530, 460).display();
			}
		});
		btnNew.setBounds(35, 34, 49, 23);
		add(btnNew);
		
		JButton btnXa = new JButton("");
		btnXa.setToolTipText("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 1));
					ids.add(table.getValueAt(i, 1).toString());
				}
				controller.delete(ids);
				updateTable();
			}
		});
		btnXa.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/trash2.png")));
		btnXa.setBounds(94, 34, 49, 23);
		add(btnXa);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 1));
					ids.add(table.getValueAt(i, 1).toString());
				}
				controller.updateStatus(ids, "active");
				updateTable();
			}
		});
		btnNewButton.setToolTipText("Tạm khóa");
		btnNewButton.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/active.png")));
		btnNewButton.setBounds(250, 34, 42, 23);
		add(btnNewButton);
		
		JButton btnDeactive = new JButton("");
		btnDeactive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 1));
					ids.add(table.getValueAt(i, 1).toString());
				}
				controller.updateStatus(ids, "deactive");
				updateTable();
			}
		});
		btnDeactive.setToolTipText("Mở khóa");
		btnDeactive.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/block.png")));
		btnDeactive.setBounds(302, 34, 42, 23);
		add(btnDeactive);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					
					Clone clone = controller.get(String.valueOf(table.getValueAt(selectedRowIndexes[0], 1)));
					
					new CloneUpdateDialog(container, "Cập nhật clone", 530, 450, clone).display();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1 thôi!");
				}
			}
		});
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/edit_40b.png")));
		btnCpNht.setBounds(153, 34, 49, 23);
		add(btnCpNht);
				
		
		this.controller = new CloneController();
		this.tableHeader = this.controller.getTableHeader();
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel = new DefaultTableModel(this.tableData, this.tableHeader);
		this.table = new JTable(this.tabelModel);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
//		table.getColumnModel().getColumn(4).setPreferredWidth(55);
//		table.getColumnModel().getColumn(5).setPreferredWidth(55);
//		table.getColumnModel().getColumn(6).setPreferredWidth(55);
//		table.getColumnModel().getColumn(7).setPreferredWidth(55);
//		table.getColumnModel().getColumn(8).setPreferredWidth(55);
//		table.getColumnModel().getColumn(9).setPreferredWidth(55);
//		table.getColumnModel().getColumn(10).setPreferredWidth(75);
		table.getColumnModel().getColumn(12).setPreferredWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(120);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 930, 422);
		add(scrollPane);
		
		sum = new JLabel("Tổng:");
		sum.setBounds(35, 529, 85, 14);
		sum.setText("Tổng:" + this.table.getRowCount());
		add(sum);
		
		JButton btnKtBn = new JButton("");
		btnKtBn.setToolTipText("Kéo friends");
		btnKtBn.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/friend_add.png")));
		btnKtBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FriendCareCreateDialog(container, "Tạo một chiến dịch kéo friends", 830, 475, getSelectedCloneIds()).display();
			}
		});
		btnKtBn.setBounds(575, 34, 49, 23);
		add(btnKtBn);
		
		JButton btnAddMem = new JButton("");
		btnAddMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GroupCareCreateDialog(container, "Tạo một chiến dịch kéo mem group", 830, 405, getSelectedCloneIds()).display();
			}
		});
		btnAddMem.setToolTipText("Kéo mem group");
		btnAddMem.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/group.png")));
		btnAddMem.setBounds(634, 34, 42, 23);
		add(btnAddMem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Tất cả clone");
		comboBox.addItem("Đang chạy");
		comboBox.addItem("Đang inactive");
		comboBox.addItem("Đang active");
		comboBox.addItem("Đang deactive");
		comboBox.addItem("Checkpoint");
		comboBox.setBounds(858, 37, 104, 20);
		add(comboBox);
		
		JButton btnPlanlist = new JButton("");
		btnPlanlist.setToolTipText("Chiến dịch nuôi");
		btnPlanlist.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/baby.png")));
		btnPlanlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCareCreateDialog(container, "Tạo một chiến dịch nuôi", 830, 525, getSelectedCloneIds()).display();
			}
		});
		btnPlanlist.setBounds(516, 34, 49, 23);
		add(btnPlanlist);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/like.png")));
		button.setToolTipText("Kéo like page");
		button.setBounds(686, 34, 42, 23);
		add(button);
		
		JButton btnCheck = new JButton("");
		btnCheck.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/death2-16.png")));
		btnCheck.setToolTipText("Check live");
		btnCheck.setBounds(395, 34, 70, 23);
		add(btnCheck);
	}
	
	private Vector<String> getSelectedCloneIds() {
		Vector<String> selectedList = new Vector<String>();
		int selectedRows[] = this.table.getSelectedRows();
		for(int selectedRow : selectedRows) {
			selectedList.add(String.valueOf(this.table.getValueAt(selectedRow, 2)) + "<" + String.valueOf(this.table.getValueAt(selectedRow, 1)) + ">");
		}
		return selectedList;
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(12).setPreferredWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(120);
		this.sum.setText("Tổng:" + this.table.getRowCount());
	}
}
