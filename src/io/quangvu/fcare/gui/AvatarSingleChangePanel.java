package io.quangvu.fcare.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AvatarSingleChangePanel extends JPanel {

	private JTextField path;
	private JLabel avatarPreview;

	public AvatarSingleChangePanel(JDialog container, DashboardFrame dashboardFrame, String cloneId) {
		setLayout(null);

		JButton btnNewButton = new JButton("Chọn ảnh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String selectedPath = jfc.getSelectedFile().getAbsolutePath().replace("\\", "/");
					path.setText(selectedPath);

					if (path.getText().endsWith(".jpg") || path.getText().endsWith(".jpeg")
							|| path.getText().endsWith(".png") || path.getText().endsWith(".gif")) {
						ImageIcon img = new ImageIcon(path.getText(), "Avatar preview");
						avatarPreview.setIcon(img);
					}
				}
			}
		});
		btnNewButton.setBounds(31, 31, 89, 23);
		add(btnNewButton);

		path = new JTextField();
		path.setBounds(130, 32, 447, 20);
		add(path);
		path.setColumns(10);
		path.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				if (path.getText().endsWith(".jpg") || path.getText().endsWith(".jpeg")
						|| path.getText().endsWith(".png") || path.getText().endsWith(".gif")) {
					ImageIcon img = new ImageIcon(path.getText(), "Avatar preview");
					avatarPreview.setIcon(img);
				}else {
					avatarPreview.setIcon(
							new ImageIcon(AvatarSingleChangePanel.class.getResource("/io/quangvu/fcare/gui/icon/no-avatar.png")));
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		JButton btnNewButton_1 = new JButton("Ok, change!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// change avatar here
			}
		});
		btnNewButton_1.setBounds(130, 499, 164, 23);
		add(btnNewButton_1);

		avatarPreview = new JLabel("");
		avatarPreview.setHorizontalAlignment(SwingConstants.CENTER);
		avatarPreview.setIcon(
				new ImageIcon(AvatarSingleChangePanel.class.getResource("/io/quangvu/fcare/gui/icon/no-avatar.png")));
		avatarPreview.setToolTipText("Ảnh này sẽ được tải lên làm avatar mới");
		avatarPreview.setBounds(127, 119, 450, 350);
		add(avatarPreview);
		
		JLabel lblNewLabel = new JLabel("(*) chấp nhận ảnh jpg, gif và png. Size ảnh nên từ 450 x 350 đổ lại");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(130, 68, 422, 14);
		add(lblNewLabel);

	}
}
