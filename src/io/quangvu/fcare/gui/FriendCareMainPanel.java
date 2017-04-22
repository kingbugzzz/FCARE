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

public class FriendCareMainPanel extends JPanel {

	public FriendCareMainPanel(DashboardFrame container) {
		setLayout(null);
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloneCareCreateDialog(container, "Tạo một chiến dịch nuôi", 760, 360).display();
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
				
		String cols[] = {"No.","Tên chiến dịch", "Ngày tạo", "Số like", "Số comment", "Số share", "Số nick chạy", "Số lần chạy", "Lần chạy cuối", "Hiện trạng"};
		String[][] data = {
				{"1","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"2","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"3","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"4","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"5","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"6","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"7","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"8","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"9","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"10","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"11","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"12","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"13","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"14","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"15","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"16","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"17","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"18","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"19","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"20","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"21","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"22","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"23","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"24","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"25","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"26","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"27","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"28","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"},
				{"29","Nuôi 50 nick thả thính", "10-Apr-2017 09:15 AM", "135", "78", "36", "48", "7", "19-Apr-2017 10:46 PM", "Đang nghỉ"}
		};
		
		JTable table = new JTable(data, cols);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(140);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 930, 427);
		add(scrollPane);
		
		JLabel lblangNui = new JLabel("Tổng: 50");
		lblangNui.setBounds(35, 534, 104, 14);
		add(lblangNui);
		
		JButton btnKtBn = new JButton("");
		btnKtBn.setToolTipText("Nghỉ");
		btnKtBn.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/pause.png")));
		btnKtBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKtBn.setBounds(476, 34, 49, 23);
		add(btnKtBn);
		
		JButton btnAddMem = new JButton("");
		btnAddMem.setToolTipText("Dừng chạy");
		btnAddMem.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/stop.png")));
		btnAddMem.setBounds(535, 34, 42, 23);
		add(btnAddMem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Tất cả chiến dịch");
		comboBox.addItem("Đang chạy");
		comboBox.addItem("Đang nghỉ");
		comboBox.addItem("Đã hoàn thành");
		comboBox.setBounds(811, 37, 151, 20);
		add(comboBox);
		
		JButton btnPlanlist = new JButton("");
		btnPlanlist.setToolTipText("Bắt đầu chạy");
		btnPlanlist.setIcon(new ImageIcon(CloneCareMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/play.png")));
		btnPlanlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlanlist.setBounds(417, 34, 49, 23);
		add(btnPlanlist);
	}
}
