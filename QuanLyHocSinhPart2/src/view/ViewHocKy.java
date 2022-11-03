package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DiemMonDAO;
import DAO.HocKyDAO;
import DAO.MonHocDAO;
import model.DiemMon;
import model.HocKy;
import model.MonHoc;
import model.TaiKhoan;
import model.XuatFileExcel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ViewHocKy extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_maHK;
	private JTextField tf_TenHK;
	private JTextField tf_NamBatDau;
	private JTextField tf_namKetThuc;
	private JScrollPane scrollPane;

	
	
	
	public ViewHocKy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewHocKy.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		
		setTitle("Học kỳ");

		setBounds(100, 100, 744, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Danh sách các Học kỳ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(242, 11, 226, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(ViewHocKy.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kiemTraGioiHan()) {
					buttonLuu();
				}
				
				
			}
		});
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(10, 78, 150, 50);
		contentPane.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ViewHocKy.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
			}
		});
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(184, 78, 150, 50);
		contentPane.add(btnXoa);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 139, 329, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã học kỳ");
		lblNewLabel_1.setBounds(10, 29, 105, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf_maHK = new JTextField();
		tf_maHK.setBounds(124, 29, 150, 30);
		panel.add(tf_maHK);
		tf_maHK.setForeground(new Color(30, 144, 255));
		tf_maHK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_maHK.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên học kỳ");
		lblNewLabel_1_1.setBounds(10, 71, 105, 30);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf_TenHK = new JTextField();
		tf_TenHK.setBounds(124, 71, 150, 30);
		panel.add(tf_TenHK);
		tf_TenHK.setForeground(new Color(30, 144, 255));
		tf_TenHK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenHK.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Năm bắt đầu");
		lblNewLabel_1_1_1.setBounds(10, 110, 105, 30);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf_NamBatDau = new JTextField();
		tf_NamBatDau.setBounds(124, 111, 150, 30);
		panel.add(tf_NamBatDau);
		tf_NamBatDau.setForeground(new Color(30, 144, 255));
		tf_NamBatDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_NamBatDau.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Năm kết thúc");
		lblNewLabel_1_1_2.setBounds(10, 151, 105, 30);
		panel.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf_namKetThuc = new JTextField();
		tf_namKetThuc.setBounds(124, 151, 150, 30);
		panel.add(tf_namKetThuc);
		tf_namKetThuc.setForeground(new Color(30, 144, 255));
		tf_namKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_namKetThuc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("(10)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(284, 29, 35, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("(10)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(284, 70, 35, 30);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("(int)");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(284, 110, 35, 30);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("(int)");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_3.setBounds(284, 151, 35, 30);
		panel.add(lblNewLabel_2_3);
		
		JButton btnXutExcel = new JButton("Xuất excel");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXutExcel.setIcon(new ImageIcon(ViewHocKy.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXutExcel.setForeground(Color.BLACK);
		btnXutExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXutExcel.setBounds(568, 12, 150, 50);
		contentPane.add(btnXutExcel);
		
		
		
		
		
		taoJSc();
		hienThiAll();
		
		
		
	}
	
	
	public boolean kiemTraGioiHan() {
		try {
			int szHK = tf_maHK.getText().length();
			int szTenHK = tf_TenHK.getText().length();
			int nbd = Integer.valueOf(tf_NamBatDau.getText()) ;
			int nkt = Integer.valueOf(tf_namKetThuc.getText()) ;
			
			if(szHK<=10 && szTenHK<=10) {
				if(szHK == 0 || szTenHK == 0) {
					szHK = 1/0;
				}
				
				return true;
			}else {
				if(szHK > 10) {
					JOptionPane.showMessageDialog(contentPane, "Mã học kỳ không được vượt quá 10 ký tự");
				}
				if(szTenHK > 10) {
					JOptionPane.showMessageDialog(contentPane, "Tên học kỳ không được vượt quá 10 ký tự");
				}
				
				return false;
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(contentPane, "Thông tin không hợp lệ!");
			return false;
		}
	}
	
	
	public void taoJSc() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(344, 78, 374, 278);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", " M\u00E3 h\u1ECDc k\u1EF3", "T\u00EAn h\u1ECDc k\u1EF3", "N\u0103m b\u1EAFt \u0111\u1EA7u", "N\u0103m k\u1EBFt th\u00FAc"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		scroll.setViewportView(table);
		
		scrollPane = scroll;
		
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
	
	
	
	
	public void themVaoTable(HocKy hocKy) {
		DefaultTableModel tableModel = (DefaultTableModel ) table.getModel();
		int irow = tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				irow,
				hocKy.getMaHK().trim(),
				hocKy.getTenHK().trim(),
				hocKy.getNamBatDau(),
				hocKy.getNamKetThuc()
					
		});

	}
	
	public void hienThiAll() {
		contentPane.remove(scrollPane);
		taoJSc();
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		
		for (HocKy hocKy : hocKies) {
			themVaoTable(hocKy);
		}
	}
	

	public void buttonLuu() {
		try {
			
			String maHK = tf_maHK.getText();
			String tenHK = tf_TenHK.getText();
			int namDau = Integer.valueOf(tf_NamBatDau.getText());
			int namket = Integer.valueOf(tf_namKetThuc.getText());
			
			HocKy hocKy = new HocKy(maHK, tenHK, namDau, namket);
			
			HocKy kt = HocKyDAO.getHocKyDAO().selectById(hocKy);
			
			boolean kiemTra = (kt==null);
			

			if(!kiemTra) {
				
				int luaChon = JOptionPane.showConfirmDialog(this, "Học kỳ học này đã tồn tại!!"
						+ "\n Bạn có muốn cập nhật không ?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					HocKyDAO.getHocKyDAO().update(hocKy);
					hienThiAll();
				}
				
			}else {
				int luaChon = JOptionPane.showConfirmDialog(this, "Xác nhận lưu?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					JOptionPane.showMessageDialog(this, "Đã lưu!!");
					HocKyDAO.getHocKyDAO().insert(hocKy);
					hienThiAll();
				}
				
				
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e);
			
		}

	}
	
	public void buttonXoa() {

			String maHK = tf_maHK.getText();

			HocKy hocKy = new HocKy();
			hocKy.setMaHK(maHK);
			
			HocKy kt = HocKyDAO.getHocKyDAO().selectById(hocKy);
			
			boolean kiemTra = (kt== null);
						
			if(!kiemTra) {
				int luaChon = JOptionPane.showConfirmDialog(this, "Xác nhận xóa?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					
					ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHK = '" + maHK + "'");
					for (DiemMon diemMon : diemMons) {
						DiemMonDAO.getDiemMonDAO().delete(diemMon);
					}
					
					HocKyDAO.getHocKyDAO().delete(hocKy);
					JOptionPane.showMessageDialog(this, "Xóa thành công!!");
					hienThiAll();
				}

			}else {
				JOptionPane.showMessageDialog(this, "Mã Học kỳ xóa không hợp lệ!!" );
			}
	}
	
	public HocKy getDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = table.getSelectedRow();
		
		String maHK = tableModel.getValueAt(irow, 1).toString();
		String tenHK = tableModel.getValueAt(irow, 2).toString();
		int namBatDau = Integer.valueOf(tableModel.getValueAt(irow, 3).toString()) ;
		int namKetThuc = Integer.valueOf(tableModel.getValueAt(irow, 4).toString()) ;


		return new HocKy(maHK, tenHK, namBatDau, namKetThuc);
	}
	
	
	public void hienThiDaChon() {
		HocKy hk = getDangChon();
		tf_maHK.setText(hk.getMaHK());
		tf_TenHK.setText(hk.getTenHK());
		tf_NamBatDau.setText(hk.getNamBatDau()+"");
		tf_namKetThuc.setText(hk.getNamKetThuc()+"");
		
	}
}
