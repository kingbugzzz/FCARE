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

import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.TagController;

public class TagMainPanel extends JPanel {
	
	private TagController controller;
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> columnNames;
	private Vector<Vector<String>> data; 
	
	public TagMainPanel(DashboardFrame container) {
		setLayout(null);
				
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TagCreateDialog(container, "Thêm tag", 450, 350).display();
			}
		});
		btnNew.setBounds(35, 34, 49, 23);
		add(btnNew);
		
		JButton btnXa = new JButton("");
		btnXa.setToolTipText("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 0));
					controller.delete(Integer.parseInt(table.getValueAt(i, 0).toString()));
					updateTable();
				}
				
			}
		});
		btnXa.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/trash2.png")));
		btnXa.setBounds(94, 34, 49, 23);
		add(btnXa);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Tạm khóa");
		btnNewButton.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/active.png")));
		btnNewButton.setBounds(250, 34, 42, 23);
		add(btnNewButton);
		
		JButton btnDeactive = new JButton("");
		btnDeactive.setToolTipText("Mở khóa");
		btnDeactive.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/block.png")));
		btnDeactive.setBounds(302, 34, 42, 23);
		add(btnDeactive);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					int id = Integer.parseInt(table.getValueAt(selectedRowIndexes[0], 0).toString());
					String code = table.getValueAt(selectedRowIndexes[0], 1).toString();
					String name = table.getValueAt(selectedRowIndexes[0], 2).toString();
					new TagUpdateDialog(container, "Thêm tag", 450, 350, new Tag(id, code, name)).display();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1 thôi!");
				}
			}
		});
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/edit_40b.png")));
		btnCpNht.setBounds(153, 34, 49, 23);
		add(btnCpNht);
				
		
		this.controller = new TagController();
		this.columnNames = new Vector<String>();
		this.initTableHeader();
		this.loadTableData();
		this.tableModel = new DefaultTableModel(this.data, this.columnNames);
		this.table = new JTable(tableModel);
		this.table = new JTable(tableModel);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 930, 312);
		add(scrollPane);
	}
	
	private void initTableHeader() {
		this.columnNames.add("Id");
		this.columnNames.add("Mã");
		this.columnNames.add("Tên");
	}
	
	private void loadTableData() {
		this.data = this.controller.getTagTableDataModel();
	}
	
	private void updateTable() {
		this.data = this.controller.getTagTableDataModel();
		this.tableModel.setDataVector(this.data, this.columnNames);
		this.table.setModel(this.tableModel);
	}
}