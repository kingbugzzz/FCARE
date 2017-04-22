package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.quangvu.fcare.controller.TagController;

public class TagMainPanel extends JPanel {
	
	private TagController controller;
	private JTable table;
	
	public TagMainPanel(DashboardFrame container) {
		setLayout(null);
		
		this.controller = new TagController();
		
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
					System.out.println(i);
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
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/edit_40b.png")));
		btnCpNht.setBounds(153, 34, 49, 23);
		add(btnCpNht);
				
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Id");columnNames.add("Mã");columnNames.add("Tên");
		Vector<Vector<String>> data = this.controller.getTagTableDataModel();
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(803);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 930, 312);
		add(scrollPane);
	}
}