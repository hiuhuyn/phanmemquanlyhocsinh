package view;



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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ViewQuanLyUser extends JFrame {

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

	
	public ViewQuanLyUser() {
		setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewQuanLyUser.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
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
		tf_user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_user.setForeground(new Color(30, 144, 255));
		tf_user.setBounds(98, 151, 150, 39);
		panel.add(tf_user);
		tf_user.setColumns(10);
		
		tf_pass = new JTextField();
		tf_pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_pass.setForeground(new Color(30, 144, 255));
		tf_pass.setColumns(10);
		tf_pass.setBounds(98, 201, 150, 39);
		panel.add(tf_pass);
		
		tf_hoten = new JTextField();
		tf_hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_hoten.setForeground(new Color(30, 144, 255));
		tf_hoten.setColumns(10);
		tf_hoten.setBounds(98, 251, 150, 39);
		panel.add(tf_hoten);
		
		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_sdt.setForeground(new Color(30, 144, 255));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(98, 301, 150, 39);
		panel.add(tf_sdt);
		
		tf_email = new JTextField();
		tf_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_email.setForeground(new Color(30, 144, 255));
		tf_email.setColumns(10);
		tf_email.setBounds(100, 351, 150, 39);
		panel.add(tf_email);
		
		comboBox_quyen = new JComboBox();
		comboBox_quyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_quyen.setForeground(new Color(30, 144, 255));
		comboBox_quyen.setModel(new DefaultComboBoxModel(new String[] {"Member", "Admin"}));
		comboBox_quyen.setBounds(98, 403, 150, 39);
		panel.add(comboBox_quyen);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kiemTraGioiHan()) {
					buttonLuu();
				}
				
			}
		});
		btnLuu.setIcon(new ImageIcon(ViewQuanLyUser.class.getResource("/view/image/success-icon.png")));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(98, 479, 186, 50);
		panel.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ViewQuanLyUser.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(98, 560, 186, 50);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonXoa();
			}
		});
		
		panel.add(btnXoa);
		
		JLabel lblNewLabel_2 = new JLabel("(20)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(258, 151, 35, 39);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("(10)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(258, 201, 35, 39);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("(20)");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(258, 251, 35, 39);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("(11)");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_3.setBounds(258, 301, 35, 39);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("(30)");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_4.setBounds(258, 351, 35, 39);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel = new JLabel("Danh sách các tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(691, 21, 309, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_nhapJLabel = new JLabel("Nhập user cần tìm");
		lblNewLabel_nhapJLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel_nhapJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_nhapJLabel.setBounds(706, 89, 130, 39);
		contentPane.add(lblNewLabel_nhapJLabel);
		
		tf_userTimKiem = new JTextField();
		tf_userTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_userTimKiem.setForeground(new Color(30, 144, 255));
		tf_userTimKiem.setColumns(10);
		tf_userTimKiem.setBounds(846, 91, 186, 39);
		contentPane.add(tf_userTimKiem);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonTim();
			}
		});
		btnTimKiem.setIcon(new ImageIcon(ViewQuanLyUser.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBounds(1053, 83, 70, 50);
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXuatExcel.setIcon(new ImageIcon(ViewQuanLyUser.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.setBounds(1176, 83, 150, 50);
		contentPane.add(btnXuatExcel);
		
		
		contentPane.add(btnTimKiem);

		taoJSC();
		hienThiAll();
		
	}
	
	public boolean kiemTraGioiHan() {
		try {
			int szUser = tf_user.getText().length();
			int szPass = tf_pass.getText().length();
			int szHoten = tf_pass.getText().length();
			int szSdt = tf_pass.getText().length();
			int szEmail = tf_pass.getText().length();
			
			
			if(szUser<=20 && szPass<=10  && szHoten <=20  &&  szSdt <=11 &&  szEmail<=30) {
				if(szUser == 0 || szPass == 0  || szHoten == 0  ||  szSdt == 0 ||  szEmail == 0) {
					szEmail = 1/0;
				}
				return true;
			}else {
				if(szUser > 20) {
					JOptionPane.showMessageDialog(this, "Tên tài khoản không được vượt quá 20 ký tự");
				}
				if(szPass > 10) {
					JOptionPane.showMessageDialog(this, "Mật khẩu không được vượt quá 10 ký tự");
				}
				if(szHoten > 20) {
					JOptionPane.showMessageDialog(this, "Họ và tên không được vượt quá 20 ký tự");
				}
				if(szSdt > 11) {
					JOptionPane.showMessageDialog(this, "SDT không được vượt quá 11 ký tự");
				}
				if(szEmail > 30) {
					JOptionPane.showMessageDialog(this, "Email không được vượt quá 30 ký tự");
				}
				
				return false;
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!");
			return false;
		}
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
				hienThiDaChon();
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
			int luaChon =  JOptionPane.showConfirmDialog(this, "Xác nhận tạo tài khoản?");
			if(luaChon == JOptionPane.YES_NO_OPTION) {
				TaiKhoanDAO.getTaiKhoanDAO().insert(taiKhoan);
				hienThiAll();
			}
		}else {
			int luaChon =  JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật tài khoản?");
			if(luaChon == JOptionPane.YES_NO_OPTION) {
				TaiKhoanDAO.getTaiKhoanDAO().update(taiKhoan);
				hienThiAll();
			}
		}
	}
	
	
	
	public void buttonXoa() {
		String user = tf_user.getText();
		String pasString = tf_pass.getText();
		TaiKhoan taiKhoan = TaiKhoanDAO.getTaiKhoanDAO().selectById(new TaiKhoan(user, pasString));
	
		if(user.equals("") || pasString.equals("")) {
			
			JOptionPane.showMessageDialog(this, "Hãy nhập tên tài khoản và mật khẩu!!");
			
		}else if(taiKhoan!=null){
			int luachon =  JOptionPane.showConfirmDialog(this, "Xác nhận xóa User: " + user);
			
			if (luachon == JOptionPane.YES_NO_OPTION) {
				TaiKhoanDAO.getTaiKhoanDAO().delete(taiKhoan);
				hienThiAll();
				JOptionPane.showMessageDialog(this, "Đã xóa tài khoản" );
				
			}
		}else if(taiKhoan == null) {
			JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản này!!");
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
	
	public TaiKhoan getDangChon() {
		
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
	
	
	public void hienThiDaChon() {
		TaiKhoan taiKhoan = this.getDangChon();
		tf_user.setText(taiKhoan.getUser());
		tf_hoten.setText(taiKhoan.getHoten());
		tf_pass.setText(taiKhoan.getPass());
		tf_email.setText(taiKhoan.getEmail());
		tf_sdt.setText(taiKhoan.getSdt());
		this.comboBox_quyen.setSelectedItem(taiKhoan.getQuyenTruyCap());
		
		
	}
}
