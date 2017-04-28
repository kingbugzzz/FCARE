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
import io.quangvu.fcare.controller.TagController;

public class CloneMainPanel extends JPanel {
	
	private CloneController controller;
	private TagController tagController;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	private JLabel sum;
	private JComboBox<String> comboQuickTag;
	
	public CloneMainPanel(DashboardFrame container) {
		setLayout(null);
				
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCreateDialog(container, "Thêm mới clone", 545, 630).display();
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
					System.out.println(table.getValueAt(i, 2));
					ids.add(table.getValueAt(i, 2).toString());
				}
				controller.delete(ids);
				updateTable();
			}
		});
		btnXa.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/trash.png")));
		btnXa.setBounds(94, 34, 49, 23);
		add(btnXa);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					ids.add(table.getValueAt(i, 2).toString());
				}
				controller.updateStatus(ids, "active");
				updateTable();
			}
		});
		btnNewButton.setToolTipText("Active");
		btnNewButton.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/active.png")));
		btnNewButton.setBounds(361, 34, 42, 23);
		add(btnNewButton);
		
		JButton btnDeactive = new JButton("");
		btnDeactive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				ArrayList<String> ids = new ArrayList<String>();
				for(int i : selectedRowIndexes) {
					ids.add(table.getValueAt(i, 2).toString());
				}
				controller.updateStatus(ids, "deactive");
				updateTable();
			}
		});
		btnDeactive.setToolTipText("Lock");
		btnDeactive.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/block.png")));
		btnDeactive.setBounds(413, 34, 42, 23);
		add(btnDeactive);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					
					Clone clone = controller.get(String.valueOf(table.getValueAt(selectedRowIndexes[0], 2)));
					
					new CloneUpdateDialog(container, "Cập nhật clone", 545, 630, clone).display();
					
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
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 1115, 422);
		add(scrollPane);
		
		sum = new JLabel("Tổng:");
		sum.setBounds(35, 529, 85, 14);
		sum.setText("Tổng:" + this.table.getRowCount());
		add(sum);
		
		JButton btnKtBn = new JButton("");
		btnKtBn.setToolTipText("Kéo friends đề xuất");
		btnKtBn.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/friend_add.png")));
		btnKtBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FriendCareCreateDialog(container, "Tạo một chiến dịch kéo friends", 830, 475, getSelectedCloneIds()).display();
			}
		});
		btnKtBn.setBounds(834, 34, 49, 23);
		add(btnKtBn);
		
		JButton btnAddMem = new JButton("");
		btnAddMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GroupCareCreateDialog(container, "Tạo một chiến dịch kéo mem group", 830, 525, getSelectedCloneIds()).display();
			}
		});
		btnAddMem.setToolTipText("Kéo mem group");
		btnAddMem.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/four-leaf-clover.png")));
		btnAddMem.setBounds(1029, 34, 42, 23);
		add(btnAddMem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Tất cả clone");
		comboBox.addItem("Đang chạy");
		comboBox.addItem("Đang inactive");
		comboBox.addItem("Đang active");
		comboBox.addItem("Đang deactive");
		comboBox.addItem("Checkpoint");
		comboBox.setBounds(1046, 519, 104, 20);
		add(comboBox);
		
		JButton btnPlanlist = new JButton("");
		btnPlanlist.setToolTipText("Tạo chiến dịch nuôi");
		btnPlanlist.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/tree-icon.png")));
		btnPlanlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCareCreateDialog(container, "Tạo một chiến dịch nuôi", 830, 525, getSelectedCloneIds()).display();
			}
		});
		btnPlanlist.setBounds(747, 34, 49, 23);
		add(btnPlanlist);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/like.png")));
		button.setToolTipText("Kéo like page");
		button.setBounds(1108, 34, 42, 23);
		add(button);
		
		JButton btnCheck = new JButton("");
		btnCheck.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/death2-16.png")));
		btnCheck.setToolTipText("Check live");
		btnCheck.setBounds(465, 34, 49, 23);
		add(btnCheck);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FriendCareByUidCreateDialog(container, "Tạo một chiến dịch kéo friend theo uid", 830, 525, getSelectedCloneIds()).display();
			}
		});
		button_1.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/friend.png")));
		button_1.setToolTipText("Add friend từ list uid");
		button_1.setBounds(893, 34, 49, 23);
		add(button_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GroupJoinCreateDialog(container, "Tạo một chiến dịch join group", 830, 525, getSelectedCloneIds()).display();
			}
		});
		btnNewButton_1.setToolTipText("Join group");
		btnNewButton_1.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/group.png")));
		btnNewButton_1.setBounds(970, 34, 49, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Đổi tag nhanh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = { "Yes", "No" };
				initQuickTag();
				int PromptResult = JOptionPane.showOptionDialog(null, comboQuickTag,
						"FCARE 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					controller.updateTags(getCloneIdsForQuickTagChanging(), comboQuickTag.getSelectedItem().toString());
					updateTable();
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/icons_16_tag.png")));
		btnNewButton_2.setBounds(271, 34, 55, 23);
		add(btnNewButton_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
			}
		});
		button_3.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/checkbox_unchecked 16.png")));
		button_3.setToolTipText("Bỏ chọn");
		button_3.setBounds(212, 34, 49, 23);
		add(button_3);
	}
	
	private Vector<String> getSelectedCloneIds() {
		Vector<String> selectedList = new Vector<String>();
		int selectedRows[] = this.table.getSelectedRows();
		for(int selectedRow : selectedRows) {
			selectedList.add(String.valueOf(this.table.getValueAt(selectedRow, 3)) + "<" + String.valueOf(this.table.getValueAt(selectedRow, 2)) + ">");
		}
		return selectedList;
	}
	
	
	private void initQuickTag () {
		this.tagController = new TagController();
		this.comboQuickTag = new JComboBox<String>();
		ArrayList<Tag> tags = this.tagController.all();
		for(Tag tag : tags) {
			comboQuickTag.addItem(tag.getName());
		}
	}
	
	private String getCloneIdsForQuickTagChanging() {
		int selectedRows[] = this.table.getSelectedRows();
		String ids = "";
		for(int selectedRow : selectedRows) {
			ids += "'" + String.valueOf(this.table.getValueAt(selectedRow, 2)) + "',";
		}
		return ids.substring(0, ids.length()-1);
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		this.sum.setText("Tổng:" + this.table.getRowCount());
	}
}
