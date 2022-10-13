package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import CSDL_sqlSv.TaiKhoanDAO;
import model.TaiKhoan;





public class ViewTrangChu extends JFrame {

	private JPanel contentPane;
	private JPanel panelMain;
	private Panel_QLHS panel_QLHS;
	private Panel_DSLop panel_QLDSLop;
	private Panel_BangDiem panel_BangDiem;
	private FrameMonHoc frameMonHoc;

	private Panel_DSHocSinhTheoLop panel_DSHocSinhTheoLop;
	private FrameHocKy frameHocKy;
	private Panel_tkTheoHocKy panel_BaoCaoTk;
	
	private HuongDan jframeHuongDan;
	
	private JF_TTTaiKhoan ttTaiKhoan;
	private JF_DoiPass doiPass;
	private JF_QuanLyUser qLyUser;
	private JMenu mnAdmin;
	
	
	
	
	public JF_QuanLyUser getqLyUser() {
		return qLyUser = new JF_QuanLyUser();
	}

	public JF_TTTaiKhoan getTtTaiKhoan() {
		return ttTaiKhoan = new JF_TTTaiKhoan() ;
	}

	public JF_DoiPass getDoiPass() {
		return doiPass = new JF_DoiPass();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public Panel_QLHS getPanel_QLHS() {
		return panel_QLHS = new Panel_QLHS();
	}

	public Panel_DSLop getPanel_QLDSLop() {
		return panel_QLDSLop = new Panel_DSLop();
	}

	public Panel_BangDiem getPanel_BangDiem() {
		return panel_BangDiem = new Panel_BangDiem();
	}

	public FrameMonHoc getFrameMonHoc() {
		return frameMonHoc = new FrameMonHoc();
	}

	public Panel_DSHocSinhTheoLop getPanel_DSHocSinhTheoLop() {
		return panel_DSHocSinhTheoLop = new Panel_DSHocSinhTheoLop();
	}

	public FrameHocKy getFrameHocKy() {
		return frameHocKy = new FrameHocKy();
	}

	public Panel_tkTheoHocKy getPanel_BaoCaoTk() {
		return panel_BaoCaoTk = new Panel_tkTheoHocKy();
	}

	public HuongDan getJframeHuongDan() {
		return jframeHuongDan = new HuongDan();
	}
	

	
	
	public ViewTrangChu() {
		setResizable(false);

		setTitle("Phần mềm quản lý học sinh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1450, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1434, 30);
		contentPane.add(menuBar);
		
		JMenu mnQLTK = new JMenu("Quản lý tài khoản");
		mnQLTK.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLTK);
		
		JMenuItem item_ttTK = new JMenuItem("Thông tin tài khoản");
		item_ttTK.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/user-id-icon.png")));
		item_ttTK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTtTaiKhoan().setVisible(true);
			}
		});
		mnQLTK.add(item_ttTK);
		
		JMenuItem item_doiPass = new JMenuItem("Đổi mật khẩu");
		item_doiPass.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Security-Password-1-icon (1).png")));
		item_doiPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getDoiPass().setVisible(true);
			}
		});
		mnQLTK.add(item_doiPass);
		
		JMenu mnQLHS = new JMenu("Quản lý học sinh");
		mnQLHS.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLHS);
		
		JMenuItem item_hoSoHS = new JMenuItem("Hồ sơ học sinh");
		item_hoSoHS.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/cv-icon.png")));
		item_hoSoHS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_QLHS());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		mnQLHS.add(item_hoSoHS);
		
		JMenu mnQLL = new JMenu("Quản lý lớp");
		mnQLL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLL);
		
		JMenuItem item_DSLop = new JMenuItem("Danh sách các lớp");
		item_DSLop.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Bulleted-List-icon.png")));
		item_DSLop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_QLDSLop());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		mnQLL.add(item_DSLop);
		
		JMenuItem item_DS_HS_LOP = new JMenuItem("Danh sách học sinh theo lớp");
		item_DS_HS_LOP.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Apps-preferences-contact-list-icon.png")));
		item_DS_HS_LOP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_DSHocSinhTheoLop());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		mnQLL.add(item_DS_HS_LOP);
		
		JMenu mnQunLim = new JMenu("Quản lý điểm");
		mnQunLim.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQunLim);
		
		JMenuItem item_BangDiemMon = new JMenuItem("Bảng điểm môn");
		item_BangDiemMon.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Database-Table-icon.png")));
		item_BangDiemMon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_BangDiem());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		mnQunLim.add(item_BangDiemMon);
		
		JMenu mnBoCo = new JMenu("Thống kê");
		mnBoCo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnBoCo);
		
		JMenuItem item_BCTK = new JMenuItem("Thống kê theo lớp");
		item_BCTK.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Very-Basic-Filter-icon.png")));
		item_BCTK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_BaoCaoTk());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		mnBoCo.add(item_BCTK);
		
		mnAdmin = new JMenu("Admin");
		mnAdmin.setEnabled(kiemTraDangNhap());
		mnAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnAdmin);
		
		JMenuItem item_monHoc = new JMenuItem("Quản lý môn học");
		mnAdmin.add(item_monHoc);
		item_monHoc.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Books-icon.png")));
		item_monHoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getFrameMonHoc().setVisible(true);
			}
		});
		
		JMenuItem item_hocKy = new JMenuItem("Quản lý học kỳ");
		mnAdmin.add(item_hocKy);
		item_hocKy.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/calendar-selection-month-icon.png")));
		item_hocKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				getFrameHocKy().setVisible(true);
				
			}
		});
		
		JMenuItem item_qlTKuser = new JMenuItem("Quản lý tài khoản người dùng");
		item_qlTKuser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAdmin.add(item_qlTKuser);
		
		JMenu mnhelp = new JMenu("Help");
		mnhelp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnhelp);
		
		JMenuItem item_huongDan = new JMenuItem("Hướng dẫn");
		item_huongDan.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/info_button_16.png")));
		item_huongDan.setSelected(true);
		item_huongDan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getJframeHuongDan().setVisible(true);
			}
		});
		mnhelp.add(item_huongDan);
		
		JMenuItem item_lienHe = new JMenuItem("Liên hệ");
		item_lienHe.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/customer-service-icon (1).png")));
		item_lienHe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LienHe();
			}
		});
		mnhelp.add(item_lienHe);
		
		
		item_qlTKuser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				getqLyUser().setVisible(true);
				
			}
		});
		
		

		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMain.setBounds(0, 30, 1435, 731);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds( 0, 0, panelMain.getWidth()   ,panelMain.getHeight());
		setImgae(lblNewLabel);
		panelMain.add(lblNewLabel);

		
		
		
	}
	
	
	public boolean kiemTraDangNhap() {
		TaiKhoan taiKhoan = new TaiKhoan(ViewLogin.User, ViewLogin.Pass);
		TaiKhoan taiKhoan2 = TaiKhoanDAO.getTaiKhoanDAO().selectById(taiKhoan);
		System.out.println(taiKhoan2.toString());
		
		if( taiKhoan2.getQuyenTruyCap().trim().equals("Admin") ) {
			return true;
		}
		return false;
	}
	
	public void setImgae(JLabel label) {
		
		java.net.URL url = ViewTrangChu.class.getResource("bia2.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		label.setIcon(newIcon);
		

		java.net.URL url2 = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img2 = Toolkit.getDefaultToolkit().createImage(url2);
		
		this.setIconImage(img2);
		
	}
	
	
	public void LienHe() {
		
		String sdt = "0378298920";
		String email = "minhquansn2011@gmail.com";
		
		JOptionPane.showMessageDialog(ViewTrangChu.this, "Liên hệ số điện thoại: "+sdt+"\nEmail: " + email);
		
	}
}
