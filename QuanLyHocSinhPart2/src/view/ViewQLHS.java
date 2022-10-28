package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.HocSinhDAO;
import DAO.LopDAO;
import model.HocSinh;
import model.Lop;
import model.TaiKhoan;
import model.XuatFileExcel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.EtchedBorder;


public class ViewQLHS extends JPanel {
	private JTextField tf_mahs;
	private JTextField tf_hoten;
	private JTextField tf_noisinh;
	private JTextField tf_sdt_lienlac;
	private JTextField tf_phuHuynh;
	private JTextField tf_TruongTieuHoc;
	private JTextField tf_day;
	private JTextField tf_dantoc;
	private JTextField tf_ngheNghiep;
	private JTextField tf_MaTim;
	private JTable table;
	private JTextField tf_diaChi;
	private JTextField tf_month;
	private JTextField tf_Year;
	private JScrollPane scrollPane;
	private JComboBox comboBox_lops;
	private JComboBox comboBox_gioiTinh;
	private JComboBox comboBox_lops_2;


	/**
	 * Create the panel.
	 */
	public ViewQLHS() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1200, 700);
		
		

		JPanel panel_thongTinHs = new JPanel();
		panel_thongTinHs.setForeground(new Color(255, 255, 255));
		panel_thongTinHs.setBackground(new Color(30, 144, 255));
		panel_thongTinHs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_thongTinHs.setBounds(10, 57, 1180, 276);
		add(panel_thongTinHs);
		panel_thongTinHs.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã học sinh");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 11, 138, 30);
		panel_thongTinHs.add(lblNewLabel_1);
		
		tf_mahs = new JTextField();
		tf_mahs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_mahs.setForeground(new Color(30, 144, 255));
		tf_mahs.setBounds(178, 11, 200, 30);
		panel_thongTinHs.add(tf_mahs);
		tf_mahs.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(455, 11, 100, 30);
		panel_thongTinHs.add(lblNewLabel_1_1);
		
		tf_hoten = new JTextField();
		tf_hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_hoten.setForeground(new Color(30, 144, 255));
		tf_hoten.setColumns(10);
		tf_hoten.setBounds(562, 11, 200, 30);
		panel_thongTinHs.add(tf_hoten);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nơi sinh");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(35, 52, 138, 30);
		panel_thongTinHs.add(lblNewLabel_1_3);
		
		tf_noisinh = new JTextField();
		tf_noisinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_noisinh.setForeground(new Color(30, 144, 255));
		tf_noisinh.setColumns(10);
		tf_noisinh.setBounds(178, 52, 200, 30);
		panel_thongTinHs.add(tf_noisinh);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa chỉ");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(35, 91, 138, 30);
		panel_thongTinHs.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("SDT liên lạc");
		lblNewLabel_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(455, 91, 100, 30);
		panel_thongTinHs.add(lblNewLabel_1_5);
		
		tf_sdt_lienlac = new JTextField();
		tf_sdt_lienlac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_sdt_lienlac.setForeground(new Color(30, 144, 255));
		tf_sdt_lienlac.setColumns(10);
		tf_sdt_lienlac.setBounds(562, 93, 200, 30);
		panel_thongTinHs.add(tf_sdt_lienlac);
		
		JLabel lblNewLabel_1_6 = new JLabel("Họ và tên cha/mẹ");
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(35, 132, 138, 30);
		panel_thongTinHs.add(lblNewLabel_1_6);
		
		tf_phuHuynh = new JTextField();
		tf_phuHuynh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_phuHuynh.setForeground(new Color(30, 144, 255));
		tf_phuHuynh.setColumns(10);
		tf_phuHuynh.setBounds(178, 134, 200, 30);
		panel_thongTinHs.add(tf_phuHuynh);
		
		tf_TruongTieuHoc = new JTextField();
		tf_TruongTieuHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TruongTieuHoc.setForeground(new Color(30, 144, 255));
		tf_TruongTieuHoc.setColumns(10);
		tf_TruongTieuHoc.setBounds(400, 173, 362, 30);
		panel_thongTinHs.add(tf_TruongTieuHoc);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Đã hoàn thành chương trình tiểu học tại trường:");
		lblNewLabel_1_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(35, 173, 341, 30);
		panel_thongTinHs.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Sinh Nhật");
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(849, 45, 73, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_1);
		
		tf_day = new JTextField();
		tf_day.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_day.setForeground(new Color(30, 144, 255));
		tf_day.setColumns(10);
		tf_day.setBounds(943, 45, 50, 30);
		panel_thongTinHs.add(tf_day);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Dân tộc");
		lblNewLabel_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(455, 52, 100, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_1_1);
		
		tf_dantoc = new JTextField();
		tf_dantoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_dantoc.setForeground(new Color(30, 144, 255));
		tf_dantoc.setColumns(10);
		tf_dantoc.setBounds(562, 52, 200, 30);
		panel_thongTinHs.add(tf_dantoc);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("Nghề nghiệp");
		lblNewLabel_1_6_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6_2.setBounds(455, 134, 100, 30);
		panel_thongTinHs.add(lblNewLabel_1_6_2);
		
		tf_ngheNghiep = new JTextField();
		tf_ngheNghiep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_ngheNghiep.setForeground(new Color(30, 144, 255));
		tf_ngheNghiep.setColumns(10);
		tf_ngheNghiep.setBounds(562, 132, 200, 30);
		panel_thongTinHs.add(tf_ngheNghiep);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(849, 86, 73, 30);
		panel_thongTinHs.add(lblNewLabel_1_2);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setIcon(new ImageIcon(ViewQLHS.class.getResource("/view/image/success-icon.png")));

		btn_Luu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonLuu();
			}
		});
		btn_Luu.setForeground(new Color(0, 0, 0));
		btn_Luu.setBackground(new Color(245, 245, 245));
		btn_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Luu.setBounds(658, 215, 150, 50);
		panel_thongTinHs.add(btn_Luu);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setIcon(new ImageIcon(ViewQLHS.class.getResource("/view/image/Close-2-icon.png")));
		btn_xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonXoa();
			}
		});
		btn_xoa.setForeground(new Color(0, 0, 0));
		btn_xoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_xoa.setBackground(new Color(245, 245, 245));
		btn_xoa.setBounds(831, 215, 150, 50);
		panel_thongTinHs.add(btn_xoa);
		
		tf_diaChi = new JTextField();
		tf_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_diaChi.setForeground(new Color(30, 144, 255));
		tf_diaChi.setColumns(10);
		tf_diaChi.setBounds(178, 93, 200, 30);
		panel_thongTinHs.add(tf_diaChi);
		
		
		tf_month = new JTextField();
		tf_month.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_month.setForeground(new Color(30, 144, 255));
		tf_month.setColumns(10);
		tf_month.setBounds(1003, 45, 50, 30);
		panel_thongTinHs.add(tf_month);
		
		tf_Year = new JTextField();
		tf_Year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Year.setForeground(new Color(30, 144, 255));
		tf_Year.setColumns(10);
		tf_Year.setBounds(1063, 45, 66, 30);
		panel_thongTinHs.add(tf_Year);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Ngày");
		lblNewLabel_1_2_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_2.setBounds(943, 11, 50, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Tháng");
		lblNewLabel_1_2_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_2_1.setBounds(1003, 11, 50, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("Năm");
		lblNewLabel_1_2_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_2_1_1.setBounds(1063, 11, 66, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_1_2_1_1);
		
		comboBox_lops = new JComboBox();
		comboBox_lops.setForeground(new Color(30, 144, 255));
		comboBox_lops.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_lops.setModel(new DefaultComboBoxModel(new String[] {""}));
		
		
		
		comboBox_lops.setBounds(943, 127, 188, 30);
		panel_thongTinHs.add(comboBox_lops);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Lớp");
		lblNewLabel_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(849, 125, 73, 30);
		panel_thongTinHs.add(lblNewLabel_1_2_2);
		
		comboBox_gioiTinh = new JComboBox();
		comboBox_gioiTinh.setForeground(new Color(30, 144, 255));
		comboBox_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_gioiTinh.setModel(new DefaultComboBoxModel(new String[] {"", "Nam", "Nữ"}));
		comboBox_gioiTinh.setBounds(943, 86, 188, 30);
		panel_thongTinHs.add(comboBox_gioiTinh);
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXuatExcel.setIcon(new ImageIcon(ViewQLHS.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setForeground(Color.BLACK);
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.setBackground(new Color(245, 245, 245));
		btnXuatExcel.setBounds(1005, 215, 150, 50);
		panel_thongTinHs.add(btnXuatExcel);
		
		JLabel lblDanhSchHc = new JLabel("Danh sách học sinh");
		lblDanhSchHc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSchHc.setBounds(492, 342, 183, 30);
		add(lblDanhSchHc);
		
		JLabel lblNewLabel_1_8 = new JLabel("Mã học sinh");
		lblNewLabel_1_8.setBounds(741, 8, 94, 30);
		add(lblNewLabel_1_8);
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf_MaTim = new JTextField();
		tf_MaTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_MaTim.setForeground(new Color(30, 144, 255));
		tf_MaTim.setBounds(845, 8, 263, 30);
		add(tf_MaTim);
		tf_MaTim.setColumns(10);
		
		JButton btnTm = new JButton("");
		btnTm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTim();
			}
		});

		btnTm.setIcon(new ImageIcon(ViewQLHS.class.getResource("/view/image/Very-Basic-Search-icon.png")));

		btnTm.setForeground(new Color(0, 0, 0));
		btnTm.setBounds(1117, 8, 73, 30);
		add(btnTm);

		btnTm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTm.setBackground(new Color(245, 245, 245));
		
		JLabel lblQunLHc = new JLabel("Hồ sơ học sinh");
		lblQunLHc.setBounds(10, 8, 249, 38);
		add(lblQunLHc);
		lblQunLHc.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		comboBox_lops_2 = new JComboBox();
		comboBox_lops_2.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_lops_2.setForeground(new Color(30, 144, 255));
		comboBox_lops_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_lops_2.setBounds(905, 344, 188, 30);
		add(comboBox_lops_2);
		
		ArrayList<Lop> lopcomBoBox = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lopcomBoBox) {
			comboBox_lops.addItem(lop.getMaLop());
			comboBox_lops_2.addItem(lop.getMaLop());
		}
		
		
		JLabel lblop = new JLabel("Lớp");
		lblop.setForeground(Color.BLACK);
		lblop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblop.setBounds(855, 344, 50, 30);
		add(lblop);
		
		JButton btnLoc = new JButton("");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locTheoLop();
			}
		});
		btnLoc.setIcon(new ImageIcon(ViewQLHS.class.getResource("/view/image/Very-Basic-Filter-icon.png")));
		btnLoc.setForeground(Color.BLACK);
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoc.setBackground(new Color(245, 245, 245));
		btnLoc.setBounds(1117, 344, 73, 30);
		add(btnLoc);
		
		taoJSC();
		hienThiAll();
	}
	

	
	
	
	
	public void taoJSC() {
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u1ECDc sinh", "H\u1ECD v\u00E0 t\u00EAn", "M\u00E3 l\u1EDBp", "Sinh nh\u1EADt", "Gi\u1EDBi t\u00EDnh", "D\u00E2n t\u1ED9c", "SDT li\u00EAn l\u1EA1c", "N\u01A1i sinh", "\u0110\u1ECBa ch\u1EC9", "H\u1ECD v\u00E0 t\u00EAn cha/m\u1EB9", "Ngh\u1EC1 nghi\u1EC7p cha/m\u1EB9", "Tr\u01B0\u1EDDng ti\u1EC3u h\u1ECDc \u0111\u00E3 theo h\u1ECDc"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.getColumnModel().getColumn(3).setPreferredWidth(52);
		table.getColumnModel().getColumn(5).setPreferredWidth(43);
		table.getColumnModel().getColumn(6).setPreferredWidth(44);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(57);
		table.getColumnModel().getColumn(9).setPreferredWidth(62);
		table.getColumnModel().getColumn(11).setPreferredWidth(70);
		table.setRowHeight(25);

		
		
		JScrollPane js1 = new JScrollPane();
		js1.setBounds(10, 384, 1180, 305);
		
		js1.setViewportView(table);
		js1.setBackground(new Color(255, 255, 255));
		
		scrollPane = js1;
		add(scrollPane);
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
	
	
	// hiển thị danh sách tất cả học sinh
	public void hienThiAll() {
		
		this.remove(scrollPane);
		taoJSC();
		ArrayList<HocSinh> list =   HocSinhDAO.getHocSinhDAO().selectAll();
		for (HocSinh hocSinh : list) {
			this.themVaoTable(hocSinh);
		}

	}
	
	
	public void locTheoLop() {
		
		String maLop = comboBox_lops_2.getSelectedItem().toString();
		if(maLop.equals("")) {
			taoJSC();
			hienThiAll();
		}else {
			ArrayList<HocSinh> list = HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop = '" +maLop+  "'");
			this.remove(scrollPane);
			taoJSC();
			for (HocSinh hocSinh_Lop2 : list) {
				themVaoTable(hocSinh_Lop2);
			}
		}
		
	}
	
	
	
	public void resetForm() {
		tf_mahs.setText("");
		tf_hoten.setText("");
		tf_day.setText("");
		tf_month.setText("");
		tf_Year.setText("");
		comboBox_lops.setSelectedIndex(0);
		comboBox_gioiTinh.setSelectedIndex(0);
		tf_dantoc.setText("");
		tf_diaChi.setText("");
		tf_ngheNghiep.setText("");
		tf_noisinh.setText("");
		tf_phuHuynh.setText("");
		tf_sdt_lienlac.setText("");
		tf_TruongTieuHoc.setText("");
		tf_MaTim.setText("");
	}
	
	
	// 

	// ổn
	public void themVaoTable(HocSinh hs) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int i_row = (Integer) tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				i_row,
				hs.getMaHS().trim() +"",
				hs.getHoTen().trim() +"",
				hs.getMaLop().trim() + "",
				hs.getNgaySinh() +"",
				hs.getGioiTinh().trim()+"",
				hs.getDanToc().trim()+"",
				hs.getSdt_LienLac().trim()+"",
				hs.getNoiSinh().trim()+"",
				hs.getDiaChi().trim()+"",
				hs.getHoten_PhuHuynh().trim()+"",
				hs.getNgheNghiepPhuHuynh().trim()+"",
				hs.getChuongTrinhTieuHoc().trim()+""
		});
	} 
	
	//kiểm tra đầu vào
	
	public boolean kiemTraHS_TonTai(HocSinh hocSinh) {
		HocSinh t = HocSinhDAO.getHocSinhDAO().selectById(hocSinh);
		
		if( t == null ) {
			return false;
		}
		return true;
	}
	
	// khi thuc hien nut lưu
	
	public void buttonLuu() {
		
		try {
			// lấy dữ liệu
			String mahs = this.tf_mahs.getText();
			String tenHS = this.tf_hoten.getText();
			String lop = this.comboBox_lops.getSelectedItem().toString();
			
			int day = Integer.valueOf(this.tf_day.getText());
			int month = Integer.valueOf(this.tf_month.getText()) - 1  ;
			int year = Integer.valueOf(this.tf_Year.getText()) - 1900;
			java.sql.Date ngayDate = new java.sql.Date(year, month, day);
			//
			String gioiTinh = this.comboBox_gioiTinh.getSelectedItem().toString();
			String sdtLL = this.tf_sdt_lienlac.getText();
			String dantoc = this.tf_dantoc.getText();
			String noiSinh = this.tf_noisinh.getText();
			String diaChi = this.tf_diaChi.getText();
			String phuHuyng = this.tf_phuHuynh.getText();
			String ngheNghiep = this.tf_ngheNghiep.getText();
			String tieuHoc = this.tf_TruongTieuHoc.getText();
			HocSinh hocSinh = new HocSinh(mahs, tenHS, lop ,ngayDate, gioiTinh, sdtLL,
					dantoc, noiSinh, diaChi, phuHuyng, ngheNghiep, tieuHoc);
			
			if(this.kiemTraHS_TonTai(hocSinh)) {
				int luachon = JOptionPane.showConfirmDialog(this, "Học sinh đã tồn tại,\nbạn có muốn cập nhật học sinh không ?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					HocSinhDAO.getHocSinhDAO().update(hocSinh);
					
					hienThiAll();					
				}

			}else {
				int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin học sinh này không?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {

					HocSinhDAO.getHocSinhDAO().insert(hocSinh);
					
					hienThiAll();		
				}
			}
			
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Nhập lỗi!!");
			e.printStackTrace();
		}
	}
	
	
	// them hoc sinh vào form điền thông tin hs
	
	public void themHSVao_FormTT(HocSinh hocSinh) {
		this.tf_mahs.setText(hocSinh.getMaHS().trim());
		this.tf_hoten.setText(hocSinh.getHoTen().trim());
		
		this.comboBox_lops.setSelectedItem(hocSinh.getMaLop());
		
		//
		java.sql.Date date = hocSinh.getNgaySinh();
		
		System.out.println(date);
		
		this.tf_day.setText(date.getDate() + "" );
		this.tf_month.setText((date.getMonth()+1) + "" );
		this.tf_Year.setText((date.getYear()+1900) + "" );
		
		//
		
		this.comboBox_gioiTinh.setSelectedItem(hocSinh.getGioiTinh());
		this.tf_sdt_lienlac.setText(hocSinh.getSdt_LienLac().trim());
		this.tf_dantoc.setText(hocSinh.getDanToc().trim());
		this.tf_noisinh.setText(hocSinh.getNoiSinh().trim());
		this.tf_diaChi.setText(hocSinh.getDiaChi().trim());
		this.tf_phuHuynh.setText(hocSinh.getHoten_PhuHuynh().trim());
		this.tf_ngheNghiep.setText(hocSinh.getNgheNghiepPhuHuynh().trim());
		this.tf_TruongTieuHoc.setText(hocSinh.getChuongTrinhTieuHoc().trim());
		
		
	}
	
	// tim hs
	
	public void buttonTim() {
		String tuKhoa = this.tf_MaTim.getText();
		timKiem(tuKhoa);

		String lop = comboBox_lops.getSelectedItem().toString();
		System.out.println("Combobox: " + lop);

	}
	
	// phương thức tìm kiếm
	public void timKiem(String maHS) {
		HocSinh hsT = new HocSinh();
		hsT.setMaHS(maHS);
		// tìm trong sql
		HocSinh hocSinh = HocSinhDAO.getHocSinhDAO().selectById(hsT);
		this.themHSVao_FormTT(hocSinh);
		
	}

	
	// button xoa
	public void buttonXoa() {
		
//		boolean kiemTra = tf_mahs.getText().equals("");
		
		String maHS = tf_mahs.getText();
		HocSinh hocSinh = new HocSinh();
		hocSinh.setMaHS(maHS);
		
		HocSinh ktHocSinh = HocSinhDAO.getHocSinhDAO().selectById(hocSinh);
		
		boolean kiemTra = (ktHocSinh == null);
		
		
		if(kiemTra) {
			JOptionPane.showMessageDialog(this, "Mã sinh viên muốn xóa không hợp lệ!!");
		}
		else {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa học sinh có mã " +maHS+ " không?");
			if(luachon ==JOptionPane.YES_NO_OPTION) {
				
				HocSinhDAO.getHocSinhDAO().delete(hocSinh);
				hienThiAll();		
			}
		}
		System.out.println(kiemTra);
		resetForm();
		
	}
	
	public HocSinh getDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = table.getSelectedRow();
		
		String maHs = tableModel.getValueAt(irow, 1).toString();
		HocSinh hocSinh = HocSinhDAO.getHocSinhDAO().selectById(new HocSinh(maHs));
		
		
		return hocSinh;
	}
	
	
	public void hienThiDaChon() {
		HocSinh hocSinh = this.getDangChon();
		themHSVao_FormTT(hocSinh);
		
	}
	
	
}
