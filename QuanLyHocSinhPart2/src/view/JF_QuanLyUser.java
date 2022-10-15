package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.TaiKhoanDAO;
import model.TaiKhoan;
import model.XuatFileExcel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class JF_QuanLyUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField tf_user;
	private JTextField tf_pass;
	private JTextField tf_hoten;
	private JTextField tf_sdt;
	private JTextField tf_email;
	private JTextField tf_userTimKiem;
	private JComboBox comboBox_quyen;

	
	public JF_QuanLyUser() {
		setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(JF_QuanLyUser.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		setTitle("Quản lý tài khoản người dùng");
		
		setBounds(100, 100, 1352, 692);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 306, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cập nhật tài khoản");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(49, 57, 190, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 151, 63, 39);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 201, 80, 39);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 251, 80, 39);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("SDT");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 301, 80, 39);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Email");
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3.setBounds(10, 351, 80, 39);
		panel.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Quyền");
		lblNewLabel_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_4.setBounds(10, 401, 80, 39);
		panel.add(lblNewLabel_1_1_1_4);
		
		tf_user = new JTextField();
		tf_user.setBounds(98, 151, 186, 39);
		panel.add(tf_user);
		tf_user.setColumns(10);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(98, 201, 186, 39);
		panel.add(tf_pass);
		
		tf_hoten = new JTextField();
		tf_hoten.setColumns(10);
		tf_hoten.setBounds(98, 251, 186, 39);
		panel.add(tf_hoten);
		
		tf_sdt = new JTextField();
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(98, 301, 186, 39);
		panel.add(tf_sdt);
		
		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(98, 351, 186, 39);
		panel.add(tf_email);
		
		comboBox_quyen = new JComboBox();
		comboBox_quyen.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "Member"}));
		comboBox_quyen.setBounds(98, 403, 186, 39);
		panel.add(comboBox_quyen);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLuu();
			}
		});
		btnLuu.setIcon(new ImageIcon(JF_QuanLyUser.class.getResource("/view/image/success-icon.png")));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(10, 537, 113, 39);
		panel.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(JF_QuanLyUser.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(171, 537, 113, 39);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonXoa();
			}
		});
		
		panel.add(btnXoa);
		
		JLabel lblNewLabel = new JLabel("Danh sách các tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(543, 11, 309, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_nhapJLabel = new JLabel("Nhập user cần tìm");
		lblNewLabel_nhapJLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel_nhapJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_nhapJLabel.setBounds(706, 89, 130, 39);
		contentPane.add(lblNewLabel_nhapJLabel);
		
		tf_userTimKiem = new JTextField();
		tf_userTimKiem.setColumns(10);
		tf_userTimKiem.setBounds(846, 91, 186, 39);
		contentPane.add(tf_userTimKiem);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonTim();
			}
		});
		btnTimKiem.setIcon(new ImageIcon(JF_QuanLyUser.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBounds(1042, 89, 91, 39);
		
		
		contentPane.add(btnTimKiem);

		taoJSC();
		hienThiAll();
		
	}
	
	
	
	
	
	public void taoJSC() {
		
		
		table = new JTable();
		table.setForeground(new Color(30, 144, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "User", "Password", "H\u1ECD v\u00E0 t\u00EAn", "SDT", "Email", "Quy\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.setRowHeight(25);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(316, 150, 1010, 492);
		
		scrollPane_1.setViewportView(table);
		
		scrollPane = scrollPane_1;
		contentPane.add(scrollPane);
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXuatExcel.setIcon(new ImageIcon(JF_QuanLyUser.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.setBounds(1159, 89, 167, 39);
		contentPane.add(btnXuatExcel);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				hienThiTaiKhoanDaChon();
			}
		});
		
	}

	public void themVaoTable ( TaiKhoan taiKhoan ) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				irow,
				taiKhoan.getUser().trim(),
				taiKhoan.getPass().trim(),
				taiKhoan.getHoten().trim(),
				taiKhoan.getSdt().trim(),
				taiKhoan.getEmail().trim(),
				taiKhoan.getQuyenTruyCap().trim()
				
				
		});
	}
	
	
	
	
	
	
	public void hienThiAll() {
		contentPane.remove(scrollPane);
		taoJSC();
		ArrayList<TaiKhoan> taiKhoans = TaiKhoanDAO.getTaiKhoanDAO().selectAll();
		
		for (TaiKhoan taiKhoan : taiKhoans) {
			themVaoTable(taiKhoan);
			
		}
	}
	
	
	public void buttonLuu() {
		String user = tf_user.getText();
		String pasString = tf_pass.getText();
		String hoten = tf_hoten.getText();
		String sdt = tf_sdt.getText();
		String email = tf_email.getText();
		String quyen = comboBox_quyen.getSelectedItem().toString();
		
		TaiKhoan taiKhoan = new TaiKhoan(user, pasString, hoten, sdt, email, quyen);
		
		TaiKhoan kttk = TaiKhoanDAO.getTaiKhoanDAO().selectById(taiKhoan);
		
		if(kttk == null) {
			int luaChon =  JOptionPane.showConfirmDialog(this, "Xác nhận tạo tài khoản!!");
			if(luaChon == JOptionPane.YES_NO_OPTION) {
				TaiKhoanDAO.getTaiKhoanDAO().insert(taiKhoan);
				hienThiAll();
			}
		}else {
			int luaChon =  JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật tài khoản!!");
			if(luaChon == JOptionPane.YES_NO_OPTION) {
				TaiKhoanDAO.getTaiKhoanDAO().update(taiKhoan);
				hienThiAll();
			}
		}
	}
	
	public void buttonXoa() {
		String user = tf_user.getText();
		String pasString = tf_pass.getText();
		TaiKhoan taiKhoan = new TaiKhoan(user, pasString);
		
		int luachon =  JOptionPane.showConfirmDialog(this, "Xác nhận xóa User: " + user);
		
		if (luachon == JOptionPane.YES_NO_OPTION) {
			TaiKhoanDAO.getTaiKhoanDAO().delete(taiKhoan);
			hienThiAll();
			JOptionPane.showMessageDialog(this, "Đã xóa tài khoản" );
			
		}

	}
	
	public void buttonTim() {
		String user = tf_userTimKiem.getText();
		ArrayList<TaiKhoan> taiKhoans = TaiKhoanDAO.getTaiKhoanDAO().selectByCondition("UserName = '"  +  user +  "'");
		
		if(user.equals("")) {
			
			hienThiAll();
		}else {
			for (TaiKhoan taiKhoan : taiKhoans) {
				contentPane.remove(scrollPane);
				taoJSC();
				themVaoTable(taiKhoan);
			}
		}
	}
	
	public TaiKhoan getTaiKhoanDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = table.getSelectedRow();
		
		String user = tableModel.getValueAt(irow, 1).toString();
		String pasString = tableModel.getValueAt(irow, 2).toString();
		String hoten = tableModel.getValueAt(irow, 3).toString();
		String sdt = tableModel.getValueAt(irow, 4).toString();
		String email = tableModel.getValueAt(irow, 5).toString();
		String quyen = tableModel.getValueAt(irow, 6).toString();

		return new TaiKhoan(user, pasString, hoten, sdt, email, quyen);
	}
	
	
	public void hienThiTaiKhoanDaChon() {
		TaiKhoan taiKhoan = this.getTaiKhoanDangChon();
		tf_user.setText(taiKhoan.getUser());
		tf_hoten.setText(taiKhoan.getHoten());
		tf_pass.setText(taiKhoan.getPass());
		tf_email.setText(taiKhoan.getEmail());
		tf_sdt.setText(taiKhoan.getSdt());
		this.comboBox_quyen.setSelectedItem(taiKhoan.getQuyenTruyCap());
		
		
	}
}
