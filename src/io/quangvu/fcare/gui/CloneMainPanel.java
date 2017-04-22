package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CloneMainPanel extends JPanel {

	public CloneMainPanel(DashboardFrame container) {
		setLayout(null);
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCreateDialog(container, "Thêm mới clone", 520, 380).display();
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
				
		String cols[] = {"Stt","Uid", "Tên clone", "Tag", "Friends", "F.req", "F.acp", "Gma", "Lin", "Shn", "Hiện trạng", "Lat" };
		String[][] data = {
			{"1", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"2", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"3", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"4", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"5", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"6", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"7", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"8", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"9", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			{"10", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "active", "18-Apr-2017 08:32 AM"},
			
			{"11", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"12", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"13", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"14", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"15", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"16", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"17", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"18", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"19", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"20", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"21", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"22", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"23", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"24", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"25", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"26", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"27", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"28", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"29", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"},
			{"30", "214235678679789", "KingBugz", "Thả thính", "120", "100", "69", "80", "138", "22", "inactive", "18-Apr-2017 08:32 AM"}
		};
		
		JTable table = new JTable(data, cols);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);
		table.getColumnModel().getColumn(7).setPreferredWidth(55);
		table.getColumnModel().getColumn(8).setPreferredWidth(55);
		table.getColumnModel().getColumn(9).setPreferredWidth(55);
		table.getColumnModel().getColumn(10).setPreferredWidth(75);
		table.getColumnModel().getColumn(11).setPreferredWidth(130);
		
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
		btnKtBn.setBounds(476, 34, 49, 23);
		add(btnKtBn);
		
		JButton btnAddMem = new JButton("");
		btnAddMem.setToolTipText("Kéo mem group");
		btnAddMem.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/group.png")));
		btnAddMem.setBounds(535, 34, 42, 23);
		add(btnAddMem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Tất cả clone");
		comboBox.addItem("Đang chạy");
		comboBox.addItem("Đang inactive");
		comboBox.addItem("Đang active");
		comboBox.addItem("Đang deactive");
		comboBox.addItem("Checkpoint");
		comboBox.setBounds(811, 37, 151, 20);
		add(comboBox);
		
		JButton btnPlanlist = new JButton("");
		btnPlanlist.setToolTipText("Chiến dịch nuôi");
		btnPlanlist.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/baby.png")));
		btnPlanlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlanlist.setBounds(417, 34, 49, 23);
		add(btnPlanlist);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/like.png")));
		button.setToolTipText("Kéo like page");
		button.setBounds(587, 34, 42, 23);
		add(button);
	}
}
