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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_TTTaiKhoan extends JFrame {

	private JPanel contentPane;
	private JTextField tf_hoten;
	private JTextField tf_sdt;
	private JTextField tf_email;
	private JLabel label_User;
	private JLabel label_Quyen;


	/**
	 * Create the frame.
	 */
	public JF_TTTaiKhoan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JF_TTTaiKhoan.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		setTitle("Tài khoản");

		setBounds(100, 100, 468, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(128, 11, 201, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 89, 71, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(45, 130, 116, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setIcon(new ImageIcon(JF_TTTaiKhoan.class.getResource("/view/image/success-icon.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTK();
			}
		});
		btnUpdate.setBackground(new Color(30, 144, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(46, 345, 154, 43);
		contentPane.add(btnUpdate);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(JF_TTTaiKhoan.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBounds(233, 345, 154, 43);
		contentPane.add(btnXoa);
		
		tf_hoten = new JTextField();
		tf_hoten.setForeground(new Color(30, 144, 255));
		tf_hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_hoten.setColumns(10);
		tf_hoten.setBounds(170, 130, 217, 30);
		contentPane.add(tf_hoten);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SDT");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(45, 171, 116, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tf_sdt = new JTextField();
		tf_sdt.setForeground(new Color(30, 144, 255));
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(170, 171, 217, 30);
		contentPane.add(tf_sdt);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(45, 212, 116, 30);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		
		tf_email = new JTextField();
		tf_email.setForeground(new Color(30, 144, 255));
		tf_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_email.setColumns(10);
		tf_email.setBounds(170, 212, 217, 30);
		contentPane.add(tf_email);
		
		label_User = new JLabel("");
		label_User.setForeground(new Color(30, 144, 255));
		label_User.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_User.setBounds(170, 89, 217, 30);
		contentPane.add(label_User);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Quyen");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2_1.setBounds(45, 253, 116, 30);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		label_Quyen = new JLabel("");
		label_Quyen.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Quyen.setBounds(170, 253, 217, 30);
		
		
		contentPane.add(label_Quyen);
		
		
		HienThiTT();
		
		setVisible(false);
	}
	
	
	
	public void deleteUser() {
		String user = label_User.getText();
		String pasStr = JOptionPane.showInputDialog(this, "Mật khẩu");
		TaiKhoan taiKhoan = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(user, pasStr));
		if(taiKhoan!=null) {
			TaiKhoanDAO.getTaiKhoanDAO().delete(taiKhoan);
			JOptionPane.showMessageDialog(this, "Bạn đã xóa tài khoản, phần mềm sẽ tự tắt!!");
			System.exit(0);
		}else {
			JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ!!");
			
			
		}
	}
	
	public void HienThiTT() {
		String user = ViewLogin.getViewLogin().User;
		String pass = ViewLogin.getViewLogin().Pass;
		
		TaiKhoan taiKhoan = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(user, pass));
		
		label_User.setText(taiKhoan.getUser().trim());
		tf_hoten.setText(taiKhoan.getHoten().trim());
		tf_sdt.setText(taiKhoan.getSdt().trim());
		tf_email.setText(taiKhoan.getEmail().trim());
		label_Quyen.setText(taiKhoan.getQuyenTruyCap());
		
	}
	
	
	public void updateTK() {
		String user = label_User.getText();
		String pass = JOptionPane.showInputDialog(this, "Mật khẩu");
		String hoten = tf_hoten.getText();
		String sdt = tf_sdt.getText();
		String email = tf_email.getText();
		
		TaiKhoan taiKhoan = new TaiKhoan(user, pass, hoten, sdt, email);
		
		TaiKhoan kt = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(user, pass));
		if(kt!=null) {
			
			TaiKhoanDAO.getTaiKhoanDAO().update(taiKhoan);
			JOptionPane.showMessageDialog(this, "Đã cập nhật thành công");
			HienThiTT();
		}else {
			JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
		}
	}
}
