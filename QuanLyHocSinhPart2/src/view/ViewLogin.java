package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CSDL_sqlSv.TaiKhoanDAO;
import model.TaiKhoan;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewLogin extends JFrame {

	private JPanel contentPane;

	public static String User;
	public static String Pass;
	private JTextField tf_user;
	private JPasswordField passwordField;
	
	public static ViewLogin getViewLogin() {
		return new ViewLogin();
	}
	
	public void setLogo() {

		java.net.URL url2 = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img2 = Toolkit.getDefaultToolkit().createImage(url2);
		
		this.setIconImage(img2);
		
	}
	
	public ViewLogin() {
		setLogo();
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setBounds(121, 11, 174, 49);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/image/man-icon (1).png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(37, 92, 133, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("  Mật khẩu");
		lblNewLabel_1_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/image/Security-Password-1-icon (1).png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(37, 134, 133, 31);
		contentPane.add(lblNewLabel_1_1);
		
		tf_user = new JTextField();
		tf_user.setForeground(new Color(30, 144, 255));
		tf_user.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_user.setBounds(180, 92, 190, 31);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/image/success-icon.png")));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DangNhap();
				
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangNhap.setBounds(37, 198, 155, 38);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/image/Login-out-icon.png")));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.setBounds(248, 198, 121, 38);
		contentPane.add(btnThoat);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(30, 144, 255));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(180, 134, 190, 31);
		contentPane.add(passwordField);
		
		
		
	}
	

	
	
	public void DangNhap() {
		String u = tf_user.getText();
		String p = String.valueOf(passwordField.getPassword());
		
		TaiKhoan taiKhoan = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(u, p));
		
		if(taiKhoan!=null) {
			
			User = u;
			Pass = p;
			
			ViewTrangChu viewTrangChu = new ViewTrangChu();
			viewTrangChu.setVisible(true);
			this.setVisible(false);
			
			
		}else {
			
			JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác!!");
			
		}
		
	}
}
