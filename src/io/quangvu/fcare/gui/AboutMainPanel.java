package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class AboutMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutMainPanel(DashboardFrame dashboardFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FCARE 1.0");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(422, 148, 263, 34);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Made by Quang Vu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(359, 254, 374, 14);
		add(lblNewLabel_1);
		
		JLabel lblVideoHngDn = new JLabel("Website: www.fcare.xyz");
		lblVideoHngDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVideoHngDn.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideoHngDn.setBounds(359, 204, 374, 14);
		add(lblVideoHngDn);
		
		JLabel lblNewLabel_2 = new JLabel("https://www.facebook.com/quangvu.io");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(436, 275, 219, 14);
		add(lblNewLabel_2);

	}

}
