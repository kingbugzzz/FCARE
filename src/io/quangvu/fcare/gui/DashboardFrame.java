package io.quangvu.fcare.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.io.IOUtils;

import io.quangvu.fcare.helper.DBHelper;
import io.quangvu.fcare.helper.IOHelper;

import java.awt.Toolkit;

public class DashboardFrame extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu mnSystem, mnClone, mnCampaign, mnSourceData, mnUtil;
	private JMenuItem miTag, miAbout;
	private JMenuItem miManageClone;
	private JMenuItem miCloneCare, miFriendCare, miGroupCare,  miPageCare;
	private JMenuItem miSourceStatus, miSourceComment, miSourcePage, miSourceImage;
	private JMenuItem miExportUID, miExportGroup, miExportPage, miExportPhone, miExportEmail;
	private JMenuItem miGroupJoin;
	private JMenuItem miFriendCareByUid;

	public DashboardFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/favicon.png")));
		this.initMenuBar();
	}

	private void initMenuBar() {

		this.menubar = new JMenuBar();
		this.setJMenuBar(this.menubar);

		this.mnSystem = new JMenu("Hệ thống");
		this.menubar.add(this.mnSystem);

		this.miTag = new JMenuItem("Tag");
		miTag.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/item.png")));
		this.mnSystem.add(this.miTag);
		this.miTag.addActionListener(this);
		this.mnSystem.addSeparator();
		
		this.miAbout = new JMenuItem("About");
		this.miAbout.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/ico_info.png")));
		this.mnSystem.add(this.miAbout);
		this.miAbout.addActionListener(this);
		this.mnClone = new JMenu("Clone");
		this.menubar.add(this.mnClone);
		
		this.miManageClone = new JMenuItem("Quản lý chung");
		this.miManageClone.addActionListener(this);
		this.mnClone.add(this.miManageClone);

		this.mnCampaign = new JMenu("Chiến dịch");
		this.menubar.add(this.mnCampaign);

		this.miCloneCare = new JMenuItem("Nuôi clone");
		this.miCloneCare.addActionListener(this);
		this.mnCampaign.add(this.miCloneCare);
		this.mnCampaign.addSeparator();

		this.miFriendCare = new JMenuItem("Kéo friend");
		this.miFriendCare.addActionListener(this);
		this.mnCampaign.add(this.miFriendCare);
		
		miFriendCareByUid = new JMenuItem("Kéo friend từ uid");
		miFriendCareByUid.addActionListener(this);
		mnCampaign.add(miFriendCareByUid);
		this.mnCampaign.addSeparator();
		
		this.miGroupCare = new JMenuItem("Kéo mem group");
		this.miGroupCare.addActionListener(this);
		this.mnCampaign.add(this.miGroupCare);
		
		miGroupJoin = new JMenuItem("Join group");
		miGroupJoin.addActionListener(this);
		mnCampaign.add(miGroupJoin);
		this.mnCampaign.addSeparator();
		
		this.miPageCare = new JMenuItem("Kéo like page");
		this.miPageCare.addActionListener(this);
		this.mnCampaign.add(this.miPageCare);
		
		this.mnSourceData = new JMenu("Dữ liệu nguồn");
		this.menubar.add(this.mnSourceData);
		
		this.miSourceStatus = new JMenuItem("Status tổng hợp");
		this.miSourceStatus.addActionListener(this);
		this.mnSourceData.add(this.miSourceStatus);
		this.mnSourceData.addSeparator();
		
		this.miSourceComment = new JMenuItem("Comment tổng hợp");
		this.mnSourceData.add(this.miSourceComment);
		this.miSourceComment.addActionListener(this);
		this.mnSourceData.addSeparator();
		
		this.miSourcePage = new JMenuItem("Page nguồn");
		this.miSourcePage.addActionListener(this);
		this.mnSourceData.add(this.miSourcePage);
		this.mnSourceData.addSeparator();
		
		this.miSourceImage = new JMenuItem("Ảnh nguồn");
		this.mnSourceData.add(this.miSourceImage);
		this.miSourceImage.addActionListener(this);
		
		this.mnUtil = new JMenu("Tiện ích");
		this.menubar.add(this.mnUtil);
		
		this.miExportUID = new JMenuItem("Xuất uid");
		miExportUID.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/export.png")));
		this.mnUtil.add(this.miExportUID);
		this.miExportUID.addActionListener(this);
		this.mnUtil.addSeparator();
		
		this.miExportEmail = new JMenuItem("Xuất email");
		miExportEmail.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/export.png")));
		this.mnUtil.add(this.miExportEmail);
		this.miExportEmail.addActionListener(this);
		this.mnUtil.addSeparator();
		
		this.miExportPhone = new JMenuItem("Xuất số phone");
		miExportPhone.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/export.png")));
		this.mnUtil.add(this.miExportPhone);
		this.miExportPhone.addActionListener(this);
		this.mnUtil.addSeparator();
		
		this.miExportGroup = new JMenuItem("Xuất group id");
		miExportGroup.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/export.png")));
		this.mnUtil.add(this.miExportGroup);
		this.miExportGroup.addActionListener(this);
		this.mnUtil.addSeparator();
		
		this.miExportPage = new JMenuItem("Xuất page id");
		miExportPage.setIcon(new ImageIcon(DashboardFrame.class.getResource("/io/quangvu/fcare/gui/icon/export.png")));
		this.mnUtil.add(this.miExportPage);
		this.miExportPage.addActionListener(this);
	}
	
	public void loadPanel(JPanel panel, String title) {
		this.setTitle(title + " - FCARE");
		this.getContentPane().removeAll();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	public void loadPanel(JPanel panel, String title, int width, int height) {
		this.setTitle(title + " - FCARE");
		this.getContentPane().removeAll();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setSize(width, height);
		this.revalidate();
		this.repaint();
	}

	public void display() {
		this.initWindowCloseEventHandle();
		this.setBounds(100, 100, 1200, 619);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void display(int width, int height) {
		this.initWindowCloseEventHandle();
		this.setBounds(100, 100, width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initWindowCloseEventHandle() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Thoát khỏi hệ thống?", "Dashboard - Facabot 1.0",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					IOHelper.delete(".session/.temp");
					DBHelper.disconnect();
					System.exit(0);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource().equals(this.miTag)) {
			this.loadPanel(new TagMainPanel(this), "Quản lý Tag");
		}
		if(event.getSource().equals(this.miAbout)) {
			this.loadPanel(new AboutMainPanel(this), "Thông tin");
		}
			
		//Clone menu event handler
		if(event.getSource().equals(this.miManageClone)) {
			this.loadPanel(new CloneMainPanel(this), "Quản lý clone");
		}
		
	
		//Campaign menu event handler
		if(event.getSource().equals(this.miCloneCare)) {
			this.loadPanel(new CloneCareMainPanel(this), "Quản lý chiến dịch nuôi");
		}
		if(event.getSource().equals(this.miFriendCare)) {
			this.loadPanel(new FriendCareMainPanel(this), "Quản lý kéo friend");
		}
		if(event.getSource().equals(this.miFriendCareByUid)) {
			this.loadPanel(new FriendCareByUidMainPanel(this), "Quản lý kéo friend từ uid");
		}
		if(event.getSource().equals(this.miGroupCare)) {
			this.loadPanel(new GroupCareMainPanel(this), "Quản lý kéo mem group");
		}
		if(event.getSource().equals(this.miGroupJoin)) {
			this.loadPanel(new GroupJoinMainPanel(this), "Quản lý join group");
		}
		if(event.getSource().equals(this.miPageCare)) {
			this.loadPanel(new PageCareMainPanel(this), "Quản lý kéo like page");
		}
		
		//Datasource menu event handler
		if(event.getSource().equals(this.miSourceStatus)) {
			this.loadPanel(new RStatusMainPanel(this), "Quản lý status nguồn");
		}
		if(event.getSource().equals(this.miSourceImage)) {
		}
		if(event.getSource().equals(this.miSourceComment)) {
		}
		if(event.getSource().equals(this.miSourcePage)) {
			this.loadPanel(new RPageMainPanel(this), "Quản lý page nguồn");
		}
		
		//Util exporter menu event handler
		if(event.getSource().equals(this.miExportEmail) ||
				event.getSource().equals(this.miExportGroup) ||
				event.getSource().equals(this.miExportPage) ||
				event.getSource().equals(this.miExportPhone) ||
				event.getSource().equals(this.miExportUID)) {
			this.loadPanel(new UtilExportMainPanel(this), "Tiện ích");
		}
	}
}
