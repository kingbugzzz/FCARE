package io.quangvu.fcare.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import io.quangvu.fcare.controller.TagController;
import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.SystemStaticHelper;
import io.quangvu.fcare.model.TagModel;
import io.quangvu.fcare.service.LoginService;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField tfPassword;

	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/io/quangvu/fcare/gui/icon/lock-icon.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(44, 39, 65, 14);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(119, 36, 257, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 74, 65, 14);
		contentPane.add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(119, 71, 257, 20);
		
		tfPassword.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	if(doLogin()) {
					success();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Login failed!");
				}
		    }
		});
		
		contentPane.add(tfPassword);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/io/quangvu/fcare/gui/icon/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(doLogin()) {
					success();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Login failed!");
				}
			}
		});
		btnNewButton.setBounds(119, 112, 129, 23);
		contentPane.add(btnNewButton);
		
		setTitle("Đăng nhập hệ thống - Facebot 1.0");
		setBounds(100, 100, 414, 202);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private boolean doLogin() {
		String username = this.tfUsername.getText().trim();
		String password = String.valueOf(this.tfPassword.getPassword());
		return LoginService.login(username, password);
	}
	
	private void success() {
		this.dispose();
		DBHelper.cnt();
		DashboardFrame dashboard = new DashboardFrame();
		dashboard.loadPanel(new CloneMainPanel(dashboard), "Quản lý clone - FCARE");
		dashboard.display();
	}
}
