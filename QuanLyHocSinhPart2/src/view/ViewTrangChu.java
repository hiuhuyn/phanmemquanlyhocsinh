package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import CSDL_sqlSv.TaiKhoanDAO;
import model.TaiKhoan;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;





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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewTrangChu.class.getResource("/view/image/logoTHCS ChoChu.jpg")));

		setTitle("Phần mềm quản lý học sinh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1500, 805);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1474, 30);
		contentPane.add(menuBar);
		
		JMenu mnQLTK = new JMenu("Tài khoản cá nhân");
		mnQLTK.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLTK);
		
		JMenuItem item_ttTK = new JMenuItem("Thông tin tài khoản");
		item_ttTK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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
		item_doiPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_doiPass.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Security-Password-1-icon (1).png")));
		item_doiPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getDoiPass().setVisible(true);
			}
		});
		mnQLTK.add(item_doiPass);
		
		JMenuItem item_dangxuat = new JMenuItem("Đăng xuất");
		item_dangxuat.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Login-out-icon.png")));
		item_dangxuat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQLTK.add(item_dangxuat);
		item_dangxuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dangXuat();
			}
		});
		
		
		
		JMenu mnhelp = new JMenu("Help");
		mnhelp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnhelp);
		
		JMenuItem item_huongDan = new JMenuItem("Hướng dẫn");
		item_huongDan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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
		item_lienHe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_lienHe.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/customer-service-icon (1).png")));
		item_lienHe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LienHe();
			}
		});
		mnhelp.add(item_lienHe);
		
		

		panelMain = new JPanel();
		panelMain.setBounds(242, 41, 1232, 714);
		contentPane.add(panelMain);
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 41, 222, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnQLHS = new JButton("Quản lý học sinh");
		btnQLHS.setBackground(new Color(255, 255, 255));
		btnQLHS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_QLHS());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnQLHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQLHS.setBounds(10, 66, 175, 40);
		panel.add(btnQLHS);
		
		JLabel lblNewLabel = new JLabel("Chức năng chung");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 133, 23);
		panel.add(lblNewLabel);
		
		JButton btnLop = new JButton("Danh sách lớp học");
		btnLop.setBackground(new Color(255, 255, 255));
		btnLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_QLDSLop());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLop.setBounds(10, 117, 175, 40);
		panel.add(btnLop);
		
		JButton btnBangDiemMon = new JButton("Bảng điểm môn");
		btnBangDiemMon.setBackground(new Color(255, 255, 255));
		btnBangDiemMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_BangDiem());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnBangDiemMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBangDiemMon.setBounds(10, 219, 175, 40);
		panel.add(btnBangDiemMon);
		
		JButton btnHocSinh_Lop = new JButton("Học sinh/lớp");
		btnHocSinh_Lop.setBackground(new Color(255, 255, 255));
		btnHocSinh_Lop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_DSHocSinhTheoLop());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnHocSinh_Lop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHocSinh_Lop.setBounds(10, 168, 175, 40);
		panel.add(btnHocSinh_Lop);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(255, 255, 255));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getPanel_BaoCaoTk());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThongKe.setBounds(10, 270, 175, 40);
		panel.add(btnThongKe);
		

		panelQuyenAdmin();		
	}
	
	
	public void panelQuyenAdmin() {
		// hiển thị các chức năng của riêng Admin
		
		if(kiemTraDangNhap()==true) {
			JPanel panel_admin = new JPanel();
			panel_admin.setBackground(new Color(255, 255, 224));
			panel_admin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_admin.setBounds(10, 388, 222, 367);
			contentPane.add(panel_admin);
			panel_admin.setLayout(null);
			
			JButton btnQLMH = new JButton("Quản lý môn học");
			btnQLMH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getFrameMonHoc().setVisible(true);
				}
			});
			btnQLMH.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnQLMH.setBounds(10, 76, 202, 50);
			panel_admin.add(btnQLMH);
			
			JLabel lblNewLabel_1 = new JLabel("Chức năng riêng của admin");
			lblNewLabel_1.setForeground(new Color(30, 144, 255));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 23, 202, 32);
			panel_admin.add(lblNewLabel_1);
			
			JButton btnQLHK = new JButton("Quản lý học kỳ");
			btnQLHK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getFrameHocKy().setVisible(true);
				}
			});
			btnQLHK.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnQLHK.setBounds(10, 137, 202, 50);
			panel_admin.add(btnQLHK);
			
			JButton btnQLTKUser = new JButton("Tài khoản người dùng");
			btnQLTKUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getqLyUser().setVisible(true);
				}
			});
			btnQLTKUser.setToolTipText("");
			btnQLTKUser.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnQLTKUser.setBounds(10, 198, 202, 50);
			panel_admin.add(btnQLTKUser);
			
		}
	}
	
	public void dangXuat() {
		
		this.setVisible(false);
		ViewLogin.getViewLogin().setVisible(true);
		
		
	}
	
	
	public boolean kiemTraDangNhap() {
		
		// kiểm tra xem người đăng nhập là ai
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
