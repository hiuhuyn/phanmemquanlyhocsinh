package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.DiemMonDAO;
import DAO.HocKyDAO;
import DAO.HocSinhDAO;
import DAO.LopDAO;
import DAO.MonHocDAO;
import model.DiemMon;
import model.HocKy;
import model.HocSinh;
import model.Lop;
import model.MonHoc;
import model.XuatFileExcel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ViewBangDiem extends JPanel {
	private JTextField tf_d15p;
	private JTextField tf_1tiet;
	private JTextField tf_Dthi;
	private JTable table;
	private JTextField tf_diemMieng;
	private JScrollPane scrollPane;
	private JComboBox comboBox_maMon;
	private JComboBox comboBox_MaHS;
	private JComboBox comboBox_MaHK;
	private JComboBox comboBox_timMon;
	private JComboBox comboBox_timHS;
	private JComboBox comboBox_timHK;

	/**
	 * Create the panel.
	 */
	public ViewBangDiem() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1200, 700);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 96, 718, 245);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã học kì");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 184, 76, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã môn");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 102, 76, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mã học sinh");
		lblNewLabel_1_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 143, 92, 30);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Điểm 15p");
		lblNewLabel_1_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(262, 143, 76, 30);
		panel.add(lblNewLabel_1_2_2);
		
		tf_d15p = new JTextField();
		tf_d15p.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_d15p.setForeground(new Color(0, 0, 0));
		tf_d15p.setColumns(10);
		tf_d15p.setBounds(365, 143, 76, 30);
		panel.add(tf_d15p);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Điểm 1 tiết");
		lblNewLabel_1_2_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_1.setBounds(262, 184, 84, 30);
		panel.add(lblNewLabel_1_2_2_1);
		
		tf_1tiet = new JTextField();
		tf_1tiet.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_1tiet.setForeground(new Color(0, 0, 0));
		tf_1tiet.setColumns(10);
		tf_1tiet.setBounds(365, 184, 76, 30);
		panel.add(tf_1tiet);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Điểm Thi");
		lblNewLabel_1_2_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_2.setBounds(489, 102, 76, 30);
		panel.add(lblNewLabel_1_2_2_2);
		
		tf_Dthi = new JTextField();
		tf_Dthi.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_Dthi.setForeground(new Color(0, 0, 0));
		tf_Dthi.setColumns(10);
		tf_Dthi.setBounds(592, 103, 76, 30);
		panel.add(tf_Dthi);
		
		JLabel lblNewLabel_1_2_2_3 = new JLabel("Điểm miệng");
		lblNewLabel_1_2_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_3.setBounds(262, 102, 84, 30);
		panel.add(lblNewLabel_1_2_2_3);
		
		tf_diemMieng = new JTextField();
		tf_diemMieng.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_diemMieng.setForeground(new Color(0, 0, 0));
		tf_diemMieng.setColumns(10);
		tf_diemMieng.setBounds(365, 102, 76, 30);
		panel.add(tf_diemMieng);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ViewBangDiem.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
			}
		});
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(334, 34, 107, 41);
		panel.add(btnXoa);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon(ViewBangDiem.class.getResource("/view/image/clear-icon.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReset();
			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(10, 34, 107, 41);
		panel.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Bảng điểm môn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(449, 28, 286, 37);
		add(lblNewLabel);
		
		taoJSc();
		hienThiAll();
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(ViewBangDiem.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLuu();
			}
		});
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLuu.setBounds(170, 34, 107, 41);
		panel.add(btnLuu);
		
		comboBox_maMon = new JComboBox();
		comboBox_maMon.setForeground(new Color(0, 0, 0));
		comboBox_maMon.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_maMon.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_maMon.setBounds(113, 102, 113, 30);
		
		
		
		panel.add(comboBox_maMon);
		
		
		
		
		comboBox_MaHS = new JComboBox();
		comboBox_MaHS.setForeground(new Color(0, 0, 0));
		comboBox_MaHS.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_MaHS.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaHS.setBounds(112, 144, 114, 30);
		
		
		panel.add(comboBox_MaHS);
		 comboBox_MaHK = new JComboBox();
		 comboBox_MaHK.setForeground(new Color(0, 0, 0));
		 comboBox_MaHK.setFont(new Font("Tahoma", Font.BOLD, 13));
		 comboBox_MaHK.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaHK.setBounds(113, 185, 114, 30);
		panel.add(comboBox_MaHK);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(738, 96, 452, 245);
		add(panel_1);
		panel_1.setLayout(null);
		

		
		
		
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("Mã học kỳ");
		lblNewLabel_1_2_4_2.setBounds(10, 11, 76, 30);
		panel_1.add(lblNewLabel_1_2_4_2);
		lblNewLabel_1_2_4_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox_timHK = new JComboBox();
		comboBox_timHK.setBounds(107, 11, 116, 30);
		panel_1.add(comboBox_timHK);
		comboBox_timHK.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_timHK.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Mã học sinh");
		lblNewLabel_1_2_4_1.setBounds(10, 64, 97, 30);
		panel_1.add(lblNewLabel_1_2_4_1);
		lblNewLabel_1_2_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		comboBox_timHS = new JComboBox();
		comboBox_timHS.setBounds(107, 64, 116, 30);
		panel_1.add(comboBox_timHS);
		comboBox_timHS.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_timHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Mã môn");
		lblNewLabel_1_2_4.setBounds(10, 116, 76, 30);
		panel_1.add(lblNewLabel_1_2_4);
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox_timMon = new JComboBox();
		comboBox_timMon.setBounds(107, 116, 116, 30);
		panel_1.add(comboBox_timMon);
		comboBox_timMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_timMon.setModel(new DefaultComboBoxModel(new String[] {""}));
		
		JButton btn_timkiem = new JButton("");
		btn_timkiem.setBounds(252, 11, 182, 54);
		panel_1.add(btn_timkiem);
		btn_timkiem.setIcon(new ImageIcon(ViewBangDiem.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		btn_timkiem.setForeground(new Color(0, 0, 0));
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.setBounds(258, 190, 176, 44);
		panel_1.add(btnXuatExcel);
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXuatExcel.setIcon(new ImageIcon(ViewBangDiem.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDanhSchBng = new JLabel("Danh sách bảng điểm");
		lblDanhSchBng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSchBng.setBounds(468, 343, 231, 37);
		add(lblDanhSchBng);
		
		
		ArrayList<HocSinh> hocSinhs = HocSinhDAO.getHocSinhDAO().selectAll();
		for (HocSinh hocSinh : hocSinhs) {
			comboBox_MaHS.addItem(hocSinh.getMaHS());
			comboBox_timHS.addItem(hocSinh.getMaHS());
			
		}
		
		ArrayList<HocKy> hocKys = HocKyDAO.getHocKyDAO().selectAll();
		for (HocKy hocKy : hocKys) {
			comboBox_MaHK.addItem(hocKy.getMaHK());
			comboBox_timHK.addItem(hocKy.getMaHK());
		}
		
		
		ArrayList<MonHoc> monHocs = MonHocDAO.getMonHocDAO().selectAll();
		for (MonHoc monHoc : monHocs) {
			comboBox_maMon.addItem(monHoc.getMaMon());
			comboBox_timMon.addItem(monHoc.getMaMon());
			
		}
		

	}
	

	public void buttonReset() {
		comboBox_maMon.setSelectedIndex(-1);
		comboBox_MaHS.setSelectedIndex(-1);
		comboBox_maMon.setSelectedIndex(-1);
		tf_diemMieng.setText("");
		tf_d15p.setText("");
		tf_1tiet.setText("");
		tf_Dthi.setText("");
	}
	
	
	
	public void taoJSc() {

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 384, 1180, 305);

		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 m\u00F4n", "M\u00E3 h\u1ECDc sinh", "M\u00E3 h\u1ECDc k\u1EF3", "\u0110i\u1EC3m mi\u1EC7ng", "\u0110i\u1EC3m 15p", "\u0110i\u1EC3m 1 ti\u1EBFt", "\u0110i\u1EC3m thi", "Trung b\u00ECnh m\u00F4n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(74);
		table.getColumnModel().getColumn(5).setPreferredWidth(61);
		table.getColumnModel().getColumn(6).setPreferredWidth(64);
		table.getColumnModel().getColumn(7).setPreferredWidth(59);
		table.getColumnModel().getColumn(8).setPreferredWidth(58);
		table.setRowHeight(30);
		scroll.setViewportView(table);
		
		scrollPane = scroll;
		
		this.add(scrollPane);

	}
	
	public void themVaoTable(DiemMon diemMon) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				irow,
				diemMon.getMonHoc().trim() + "",
				diemMon.getHocSinh().trim() + "",
				diemMon.getHocKy().trim() + "",
				diemMon.getDiemMieng() +"",
				diemMon.getDiem15p() + "",
				diemMon.getDiem1Tiet() + "",
				diemMon.getDiemThi() + "",
				String.format("%,.2f", diemMon.getDiemTBmon())
//				diemMon.getDiemTBmon() + ""

		});
	}
	
	public void hienThiAll() {
		this.remove(scrollPane);
		taoJSc();

		ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectAll();
		for (DiemMon diemMon : diemMons) {
			themVaoTable(diemMon);
		}
	}
	//
	public void layDataTuTable() {
		
	}
	
	
	public DiemMon getDiemMonInJTextField() {
		String maMon = comboBox_maMon.getSelectedItem().toString();
		String maHS = comboBox_MaHS.getSelectedItem().toString();
		String maHK =comboBox_MaHK.getSelectedItem().toString();
		float diemMieng = Float.valueOf(tf_diemMieng.getText());
		float diem15p = Float.valueOf(tf_d15p.getText());
		float diem1tiet = Float.valueOf(tf_1tiet.getText());
		float diemthi = Float.valueOf(tf_Dthi.getText());
		
		return new DiemMon(maMon, maHS, maHK, diemMieng, diem15p, diem1tiet, diemthi);
		
	}
	
	
	public boolean kiemTraMon_HocSinh_HocKy() {
		String maMon = comboBox_maMon.getSelectedItem().toString();
		String maHS = comboBox_MaHS.getSelectedItem().toString();
		String maHK =comboBox_MaHK.getSelectedItem().toString();
		
		MonHoc monHoc = MonHocDAO.getMonHocDAO().selectById(new MonHoc(maMon));
		HocSinh hocSinh = HocSinhDAO.getHocSinhDAO().selectById(new HocSinh(maHS));
		HocKy hocKy = HocKyDAO.getHocKyDAO().selectById(new HocKy(maHK));
		
		if(  monHoc == null || hocSinh == null || hocKy == null ) {
			return false;
			
		}else {
			return true;
		}

	}
	
	
	public boolean kiemTraTonTai(DiemMon diemMon) {
		
		
		DiemMon kt = DiemMonDAO.getDiemMonDAO().selectById(diemMon);
		if(kt==null) {
			
			System.out.println( "Thông tin không tồn tại trong csdl!!");
			return false;
		}else {
			System.out.println("Thông tin đã tồn tại");
			return true;
		}
	}
	
	
	public boolean kiemTraRong() {
		DiemMon diemMon = new DiemMon();
		
		diemMon.setMonHoc(comboBox_maMon.getSelectedItem().toString());
		diemMon.setHocKy(comboBox_MaHK.getSelectedItem().toString());
		diemMon.setHocSinh(comboBox_MaHS.getSelectedItem().toString());
		
		boolean ktRong = (diemMon.getMonHoc().equals("") ||  
				diemMon.getHocSinh().equals("") || diemMon.getHocKy().equals(""));
		
		if( ktRong) {
			JOptionPane.showMessageDialog(this, "Thông tin đang rỗng!!");
			return true;
		}else {
			return false;
		}
	}
	
	
	public void buttonLuu() {
		try {

			DiemMon diemMon = getDiemMonInJTextField();
			
			if(kiemTraRong() == true) {
				JOptionPane.showMessageDialog(this, "Thông tin đang rỗng!!");
			}else {
				if(kiemTraMon_HocSinh_HocKy() == true ) {
					if(kiemTraTonTai(diemMon) != true ) {
						
						DiemMonDAO.getDiemMonDAO().insert(diemMon);

						JOptionPane.showMessageDialog(this, "Đã lưu!!");
						hienThiAll();
						
					}else {
						int luachon =  JOptionPane.showConfirmDialog(this, "Thông tin điểm đã tồn tại,\nbạn muốn cập nhật không?");
						if(luachon == JOptionPane.YES_NO_OPTION) {
							DiemMonDAO.getDiemMonDAO().update(diemMon);
							hienThiAll();
						}
					}
				}else {
					JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!!");
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
//			JOptionPane.showMessageDialog(this, "Lỗi lưu: " + e );
		}
	}
	
	public void buttonXoa() {
		try {
			String maMon = comboBox_maMon.getSelectedItem().toString();
			String maHS = comboBox_MaHS.getSelectedItem().toString();
			String maHK =comboBox_MaHK.getSelectedItem().toString();
			DiemMon diemMon = new DiemMon(maMon, maHS, maHK);
			
			
			if(kiemTraRong() != true) {
				if(kiemTraTonTai(diemMon) == true) {
					DiemMonDAO.getDiemMonDAO().delete(diemMon);
					JOptionPane.showMessageDialog(this, "Đã xóa!!" );
					hienThiAll();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e );
		}

	}
	

	
	
	
	public void timKiem() {
		this.remove(scrollPane);
		taoJSc();
		
		String maMon = comboBox_timMon.getSelectedItem().toString();
		String maHK = comboBox_timHK.getSelectedItem().toString();
		String maHS = comboBox_timHS.getSelectedItem().toString();
		
		if(maMon.equals("") && maHK.equals("") && maHS.equals("") ) {
			// hien thi all
			hienThiAll();
		}else if(maMon.equals("") && maHS.equals("") ){
			 // hien thi theo ma hoc ky
			
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHK = '" + maHK + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
			
		}else if ( maHK.equals("") && maHS.equals("")  ) {
			// hien thi theo ma mon
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaMon = '" + maMon + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
			
		}else if ( maHK.equals("") && maMon.equals("")  ) {
			// hien thi theo ma học sinh
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + maHS + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
		}else if(maHK.equals("")) {
			// hien thi theo ma hoc sinh -  ma mon
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + maHS + "' and MaMon= '" + maMon + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
		}else if(maHS.equals("")) {
			// hien thi theo ma mon -  ma hoc ky
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHK = '" + maHK + "' and MaMon= '" + maMon + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
		}else if(maMon.equals("")) {
			// hien thi theo ma hoc sinh -  ma hoc ky
			ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHK = '" + maHK + "' and MaHS = '" + maHS + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
		}else {
			
			//  ma hoc ky - ma hoc sinh - ma mon
			ArrayList<DiemMon> diemMons = 
					DiemMonDAO.getDiemMonDAO().selectByCondition
					("MaHK = '" + maHK + "' and MaHS = '" + maHS + "' and MaMon= '" + maMon + "'");
			
			for (DiemMon diemMon : diemMons) {
				themVaoTable(diemMon);
			}
			
			
		}
	}

	
	
	
	
}
