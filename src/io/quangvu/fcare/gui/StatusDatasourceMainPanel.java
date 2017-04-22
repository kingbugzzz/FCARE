package io.quangvu.fcare.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StatusDatasourceMainPanel extends JPanel {

	public StatusDatasourceMainPanel(DashboardFrame container) {
		setLayout(null);
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Thêm mới");
		btnNew.setIcon(new ImageIcon(CloneMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/additem.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatusDatasourceCreateDialog(container, "Thêm mới mẫu status", 620, 320).display();
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
				
		String cols[] = {"Stt","Tag", "Nội dung", "Trạng thái"};
		String[][] data = {
			{"1", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active",},
			{"2", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"3", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"4", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"5", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"6", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"7", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"8", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"9", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"},
			{"10", "fashion", "Tôi buồn không biết vì sao tôi buồn", "active"}
		};
		
		JTable table = new JTable(data, cols);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(732);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 86, 930, 419);
		add(scrollPane);
		
		JLabel lblangNui = new JLabel("Tổng: 55");
		lblangNui.setBounds(35, 529, 104, 14);
		add(lblangNui);
	}
}
