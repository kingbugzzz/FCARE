package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class StatusDatasourceCreatePanel extends JPanel {

	public StatusDatasourceCreatePanel(JDialog container, DashboardFrame dashboardFrame) {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 34, 249, 20);
		comboBox.addItem("Tổng hợp");
		comboBox.addItem("Thời trang");
		comboBox.addItem("Âm nhạc");
		add(comboBox);
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setBounds(36, 37, 46, 14);
		add(lblTag);
		
		JLabel lblNewLabel = new JLabel("Nội dung");
		lblNewLabel.setBounds(36, 80, 64, 14);
		add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(115, 80, 452, 123);
		add(editorPane);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(115, 233, 112, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nhập lại");
		btnNewButton_1.setBounds(252, 233, 112, 23);
		add(btnNewButton_1);

	}
}
