package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CSDL_sqlSv.TaiKhoanDAO;
import model.TaiKhoan;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JF_DoiPass extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
	private JTextField tf_beforePass;
	private JTextField tf_newPass;
	private JLabel label_user;


	public JF_DoiPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JF_DoiPass.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		setTitle("Đổi mật khẩu");
		
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setBounds(150, 10, 134, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(77, 66, 122, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu cũ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(77, 108, 122, 31);
		contentPane.add(lblNewLabel_1_1);
		
		tf_beforePass = new JTextField();
		tf_beforePass.setForeground(new Color(30, 144, 255));
		tf_beforePass.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_beforePass.setColumns(10);
		tf_beforePass.setBounds(209, 108, 151, 31);
		contentPane.add(tf_beforePass);
		
		JButton btnDoiPass = new JButton("Đổi mật khẩu");
		btnDoiPass.setIcon(new ImageIcon(JF_DoiPass.class.getResource("/view/image/success-icon.png")));
		btnDoiPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiPass();
			}
		});
		btnDoiPass.setBackground(new Color(211, 211, 211));
		btnDoiPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoiPass.setBounds(41, 224, 161, 42);
		contentPane.add(btnDoiPass);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(JF_DoiPass.class.getResource("/view/image/Login-out-icon.png")));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thoat();
				
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBackground(new Color(211, 211, 211));
		btnThoat.setBounds(235, 224, 151, 42);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(77, 147, 122, 31);
		contentPane.add(lblNewLabel_1_1_1);
		
		tf_newPass = new JTextField();
		tf_newPass.setForeground(new Color(30, 144, 255));
		tf_newPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_newPass.setColumns(10);
		tf_newPass.setBounds(209, 147, 151, 31);
		contentPane.add(tf_newPass);
		
		label_user = new JLabel("");
		label_user.setForeground(new Color(30, 144, 255));
		
		label_user.setText(ViewLogin.getViewLogin().User);
		
		label_user.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_user.setBounds(209, 66, 151, 31);
		contentPane.add(label_user);
		
		setVisible(false);
		
	}
	
	
	
	public void doiPass() {
		String user = label_user.getText();
		String beforePass = tf_beforePass.getText();
		String passNew = tf_newPass.getText();
		
		TaiKhoan taiKhoan = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(user, beforePass));
		
		boolean kt = taiKhoan!=null; // co -> true
		
		if(kt) {
			
			taiKhoan.setPass(passNew);
			
			
			TaiKhoanDAO.getTaiKhoanDAO().update(taiKhoan);
			
			JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Mật khẩu hoặc tài khoản không đúng");
		}
		
	}
	
	public void thoat() {
		
		setVisible(false);
		
	}
	
	
	
	
	
	
}
