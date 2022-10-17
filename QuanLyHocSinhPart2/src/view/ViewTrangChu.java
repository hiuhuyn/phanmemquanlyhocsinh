package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.TaiKhoan;
import javax.swing.border.TitledBorder;

import DAO.TaiKhoanDAO;

import javax.swing.border.BevelBorder;





public class ViewTrangChu extends JFrame {

	private JPanel contentPane;
	private JPanel panelMain;
	
	public static ViewTrangChu getTrangChu() {
		return new ViewTrangChu();
	}
	
	public ViewQuanLyUser getViewQuanLyUser() {
		return new ViewQuanLyUser();
	}

	public ViewTTTaiKhoan getViewTTTaiKhoan() {
		return new ViewTTTaiKhoan() ;
	}

	public ViewDoiPass getViewDoiPass() {
		return new ViewDoiPass();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public ViewQLHS getViewQLHS() {
		return new ViewQLHS();
	}

	public ViewQLLopHoc getViewQLLopHoc() {
		return  new ViewQLLopHoc();
	}

	public ViewBangDiem getViewBangDiem() {
		return  new ViewBangDiem();
	}

	public ViewMonHoc getViewMonHoc() {
		return  new ViewMonHoc();
	}


	public ViewHocKy getViewHocKy() {
		return  new ViewHocKy();
	}

	public ViewThongKe getViewThongKe() {
		return  new ViewThongKe();
	}

	public ViewHuongDan getViewHuongDan() {
		return  new ViewHuongDan();
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
		
		JMenu mnQLTK = new JMenu("Quản lý tài khoản");
		mnQLTK.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLTK);
		
		JMenuItem item_ttTK = new JMenuItem("Thông tin tài khoản");
		item_ttTK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_ttTK.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/user-id-icon.png")));
		item_ttTK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getViewTTTaiKhoan().setVisible(true);
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
				getViewDoiPass().setVisible(true);
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
				getViewHuongDan().setVisible(true);
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
				thongTinLienHe();
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
				getPanelMain().add(getViewQLHS());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnQLHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQLHS.setBounds(10, 66, 202, 40);
		panel.add(btnQLHS);
		
		JLabel lblNewLabel = new JLabel("Chức năng chung");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 133, 23);
		panel.add(lblNewLabel);
		
		JButton btnLop = new JButton("Quản lý lớp học");
		btnLop.setBackground(new Color(255, 255, 255));
		btnLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getViewQLLopHoc());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLop.setBounds(10, 117, 202, 40);
		panel.add(btnLop);
		
		JButton btnBangDiemMon = new JButton("Quản lý điểm môn");
		btnBangDiemMon.setBackground(new Color(255, 255, 255));
		btnBangDiemMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getViewBangDiem());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnBangDiemMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBangDiemMon.setBounds(10, 168, 202, 40);
		panel.add(btnBangDiemMon);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(255, 255, 255));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanelMain().removeAll();
				getPanelMain().add(getViewThongKe());
				getPanelMain().revalidate();
				getPanelMain().repaint();
			}
		});
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThongKe.setBounds(10, 219, 202, 40);
		panel.add(btnThongKe);
		

		hienThiQuyenAdmin();		
	}
	
	
	public void hienThiQuyenAdmin() {
		// hiển thị các chức năng của riêng Admin
		
		if(kiemTraDangNhap()) {
			JPanel panel_admin = new JPanel();
			panel_admin.setBackground(new Color(255, 255, 224));
			panel_admin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_admin.setBounds(10, 388, 222, 367);
			contentPane.add(panel_admin);
			panel_admin.setLayout(null);
			
			JButton btnQLMH = new JButton("Quản lý môn học");
			btnQLMH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getViewMonHoc().setVisible(true);
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
					getViewHocKy().setVisible(true);
				}
			});
			btnQLHK.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnQLHK.setBounds(10, 137, 202, 50);
			panel_admin.add(btnQLHK);
			
			JButton btnQLTKUser = new JButton("Quản lý người dùng");
			btnQLTKUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getViewQuanLyUser().setVisible(true);
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
	
	
	
	
	public void thongTinLienHe() {
		
		String sdt = "0378298920";
		String email = "minhquansn2011@gmail.com";
		
		JOptionPane.showMessageDialog(ViewTrangChu.this, "Liên hệ số điện thoại: "+sdt+"\nEmail: " + email);
		
	}
}
