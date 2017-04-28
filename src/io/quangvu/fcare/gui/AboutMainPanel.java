package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AboutMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutMainPanel(DashboardFrame dashboardFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FCARE AUTOMATION TOOL");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(451, 94, 263, 34);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Made by Quang Vu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(394, 412, 374, 14);
		add(lblNewLabel_1);
		
		JLabel lblVideoHngDn = new JLabel(" www.fcare.xyz");
		lblVideoHngDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVideoHngDn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideoHngDn.setBounds(394, 139, 374, 14);
		add(lblVideoHngDn);
		
		JLabel lblNewLabel_2 = new JLabel("facebook.com/quangvu.io");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(471, 433, 219, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AboutMainPanel.class.getResource("/io/quangvu/fcare/gui/icon/ladybug.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(492, 257, 178, 133);
		add(lblNewLabel_3);
		
		JLabel lblCmnBn = new JLabel("Cảm ơn bạn đã sử dụng sản phẩm của tôi.");
		lblCmnBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmnBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCmnBn.setBounds(406, 185, 374, 19);
		add(lblCmnBn);
		
		JLabel lblChcBnThnh = new JLabel("CHÚC BẠN THÀNH CÔNG!");
		lblChcBnThnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblChcBnThnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcBnThnh.setBounds(406, 227, 374, 19);
		add(lblChcBnThnh);

	}

}
