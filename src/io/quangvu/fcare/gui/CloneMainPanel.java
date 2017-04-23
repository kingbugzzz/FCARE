package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.quangvu.fcare.controller.CloneController;

public class CloneMainPanel extends JPanel {
	
	private CloneController controller;
	private JTable table;
	private DefaultTableModel tabelModel;
	private Vector<String> tableHeader;
	private Vector<Vector<String>> tableData; 
	
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
		
		JLabel lblangNui = new JLabel("Tổng: 55");
		lblangNui.setBounds(35, 529, 104, 14);
		add(lblangNui);
		
		JButton btnKtBn = new JButton("");
		btnKtBn.setToolTipText("Kéo friends");
		btnKtBn.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/friend_add.png")));
		btnKtBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKtBn.setBounds(575, 34, 49, 23);
		add(btnKtBn);
		
		JButton btnAddMem = new JButton("");
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
		btnCheck.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/cl.png")));
		btnCheck.setToolTipText("Check live");
		btnCheck.setBounds(395, 34, 49, 23);
		add(btnCheck);
	}
	
	private void updateTable() {
		this.tableData = this.controller.getTableDataModel();
		this.tabelModel.setDataVector(this.tableData, this.tableHeader);
		this.table.setModel(this.tabelModel);
	}
}
