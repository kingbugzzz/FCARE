package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.quangvu.fcare.bean.RComment;
import io.quangvu.fcare.bean.Tag;
import io.quangvu.fcare.controller.CloneController;
import io.quangvu.fcare.controller.RCommentController;
import io.quangvu.fcare.controller.TagController;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class RCommentMainPanel extends JPanel {

	private RCommentController controller;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	private JLabel sum;
	
	public RCommentMainPanel(DashboardFrame container) {
		setLayout(null);
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RCommentCreateDialog(container, "Thêm mới mẫu comment", 500, 250).display();
			}
		});
		btnNew.setBounds(35, 34, 49, 23);
		add(btnNew);
		
		JButton btnXa = new JButton("");
		btnXa.setToolTipText("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRowIndexes = table.getSelectedRows();
				String strIds = "";
				for(int i : selectedRowIndexes) {
					System.out.println(table.getValueAt(i, 0));
					strIds += table.getValueAt(i, 0).toString() + ",";
				}
				strIds = strIds.substring(0, strIds.length()-1);
				controller.delete(strIds);
				updateTable();
			}
		});
		btnXa.setIcon(new ImageIcon(RCommentMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/recycle-bin-recycle-16.png")));
		btnXa.setBounds(94, 34, 49, 23);
		add(btnXa);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRowIndexes = table.getSelectedRows();
				if(selectedRowIndexes.length == 1) {
					RComment status = new RComment();
					status.setId(Integer.parseInt(table.getValueAt(selectedRowIndexes[0], 0).toString()));
					status.setTag(table.getValueAt(selectedRowIndexes[0], 1).toString());
					status.setName(table.getValueAt(selectedRowIndexes[0], 2).toString());
					status.setSrc(table.getValueAt(selectedRowIndexes[0], 3).toString());
					new RCommentUpdateDialog(container, "Cập nhật comment nguồn", 500, 250, status).display();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Chọn 1 thôi!");
				}
			}
		});
		btnCpNht.setToolTipText("Chỉnh sửa");
		btnCpNht.setIcon(new ImageIcon(RCommentMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/ic_mode_edit_48px-16.png")));
		btnCpNht.setBounds(153, 34, 49, 23);
		add(btnCpNht);
						
		this.controller = new RCommentController();
		this.tableHeader = this.controller.getTableHeader();
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel = new DefaultTableModel(this.tableData, this.tableHeader);
		this.table = new JTable(this.tabelModel);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(320);
		table.getColumnModel().getColumn(3).setPreferredWidth(558);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 1106, 419);
		add(scrollPane);
		
		sum = new JLabel("Tổng: " + String.valueOf(this.table.getModel().getRowCount()));
		sum.setBounds(35, 529, 104, 14);
		add(sum);
		
		JComboBox cbTags = new JComboBox();
		TagController tagController = new TagController();
		ArrayList<Tag> tags = tagController.all();
		for(Tag tag : tags) {
			cbTags.addItem(tag.getName());
		}
		cbTags.setBounds(952, 37, 189, 20);
		add(cbTags);
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(320);
		table.getColumnModel().getColumn(3).setPreferredWidth(558);
		this.sum.setText("Tổng:" + this.table.getRowCount());
	}
}
