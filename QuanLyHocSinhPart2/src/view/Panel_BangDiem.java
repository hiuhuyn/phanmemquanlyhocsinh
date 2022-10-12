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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CSDL_sqlSv.DiemMonDAO;
import CSDL_sqlSv.HocKyDAO;
import CSDL_sqlSv.HocSinhDAO;
import CSDL_sqlSv.LopDAO;
import CSDL_sqlSv.MonHocDAO;
import model.DiemMon;
import model.HocKy;
import model.HocSinh;
import model.Lop;
import model.MonHoc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Panel_BangDiem extends JPanel {
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
	public Panel_BangDiem() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1430, 730);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 100, 315, 619);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã học kì");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(12, 203, 76, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã môn");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(12, 121, 76, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mã học sinh");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(12, 162, 92, 30);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Điểm 15p");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(12, 395, 76, 30);
		panel.add(lblNewLabel_1_2_2);
		
		tf_d15p = new JTextField();
		tf_d15p.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_d15p.setForeground(new Color(0, 0, 0));
		tf_d15p.setColumns(10);
		tf_d15p.setBounds(115, 395, 76, 30);
		panel.add(tf_d15p);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Điểm 1 tiết");
		lblNewLabel_1_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_1.setBounds(12, 436, 84, 30);
		panel.add(lblNewLabel_1_2_2_1);
		
		tf_1tiet = new JTextField();
		tf_1tiet.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_1tiet.setForeground(new Color(0, 0, 0));
		tf_1tiet.setColumns(10);
		tf_1tiet.setBounds(115, 436, 76, 30);
		panel.add(tf_1tiet);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Thi");
		lblNewLabel_1_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_2.setBounds(12, 477, 76, 30);
		panel.add(lblNewLabel_1_2_2_2);
		
		tf_Dthi = new JTextField();
		tf_Dthi.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_Dthi.setForeground(new Color(0, 0, 0));
		tf_Dthi.setColumns(10);
		tf_Dthi.setBounds(115, 477, 76, 30);
		panel.add(tf_Dthi);
		
		JLabel lblNewLabel_1_2_2_3 = new JLabel("Điểm miệng");
		lblNewLabel_1_2_2_3.setForeground(Color.WHITE);
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_2_3.setBounds(12, 354, 84, 30);
		panel.add(lblNewLabel_1_2_2_3);
		
		tf_diemMieng = new JTextField();
		tf_diemMieng.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_diemMieng.setForeground(new Color(0, 0, 0));
		tf_diemMieng.setColumns(10);
		tf_diemMieng.setBounds(115, 354, 76, 30);
		panel.add(tf_diemMieng);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Cập nhật điểm cho học sinh");
		lblNewLabel_1_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_3_1.setBounds(12, 11, 287, 39);
		panel.add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_2_3_1 = new JLabel("Nhập điểm");
		lblNewLabel_1_2_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_2_3_1.setBounds(12, 300, 145, 30);
		panel.add(lblNewLabel_1_2_2_3_1);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(Panel_BangDiem.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
			}
		});
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(221, 549, 76, 30);
		panel.add(btnXoa);
		
		JButton btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(Panel_BangDiem.class.getResource("/view/image/clear-icon.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReset();
			}
		});
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(115, 549, 76, 30);
		panel.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("Bảng điểm môn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(335, 24, 286, 37);
		add(lblNewLabel);
		
		taoJSc();
		hienThiAll();
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Mã môn");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_4.setBounds(1109, 31, 76, 30);
		add(lblNewLabel_1_2_4);
		
		JButton btn_timkiem = new JButton("");
		btn_timkiem.setIcon(new ImageIcon(Panel_BangDiem.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		btn_timkiem.setForeground(new Color(0, 0, 0));
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_timkiem.setBounds(1330, 27, 90, 42);
		add(btn_timkiem);
		
		JButton btnLuu = new JButton("");
		btnLuu.setIcon(new ImageIcon(Panel_BangDiem.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLuu();
			}
		});
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLuu.setBounds(12, 549, 76, 30);
		panel.add(btnLuu);
		
		comboBox_maMon = new JComboBox();
		comboBox_maMon.setForeground(new Color(0, 0, 0));
		comboBox_maMon.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_maMon.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_maMon.setBounds(115, 121, 76, 30);
		
		
		
		panel.add(comboBox_maMon);
		
		
		comboBox_timHS = new JComboBox();
		comboBox_timHS.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_timHS.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_timHS.setBounds(967, 33, 116, 30);
		
		
		
		
		comboBox_MaHS = new JComboBox();
		comboBox_MaHS.setForeground(new Color(0, 0, 0));
		comboBox_MaHS.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_MaHS.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaHS.setBounds(114, 162, 76, 30);
		ArrayList<HocSinh> hocSinhs = HocSinhDAO.getHocSinhDAO().selectAll();
		for (HocSinh hocSinh : hocSinhs) {
			comboBox_MaHS.addItem(hocSinh.getMaHS());
			comboBox_timHS.addItem(hocSinh.getMaHS());
			
		}
		
		panel.add(comboBox_MaHS);
		add(comboBox_timHS);
		 comboBox_MaHK = new JComboBox();
		 comboBox_MaHK.setForeground(new Color(0, 0, 0));
		 comboBox_MaHK.setFont(new Font("Tahoma", Font.BOLD, 13));
		 comboBox_MaHK.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaHK.setBounds(115, 203, 76, 30);
		
		comboBox_timHK = new JComboBox();
		comboBox_timHK.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_timHK.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_timHK.setBounds(724, 33, 116, 30);
		add(comboBox_timHK);
		
		
		ArrayList<HocKy> hocKys = HocKyDAO.getHocKyDAO().selectAll();
		for (HocKy hocKy : hocKys) {
			comboBox_MaHK.addItem(hocKy.getMaHK());
			comboBox_timHK.addItem(hocKy.getMaHK());
		}
		panel.add(comboBox_MaHK);
		
		comboBox_timMon = new JComboBox();
		comboBox_timMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_timMon.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_timMon.setBounds(1185, 31, 116, 30);
		add(comboBox_timMon);
		
		ArrayList<MonHoc> monHocs = MonHocDAO.getMonHocDAO().selectAll();
		for (MonHoc monHoc : monHocs) {
			comboBox_maMon.addItem(monHoc.getMaMon());
			comboBox_timMon.addItem(monHoc.getMaMon());
			
		}
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 90, 78);
		setImgae(label);
		add(label);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Mã học sinh");
		lblNewLabel_1_2_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_4_1.setBounds(870, 33, 97, 30);
		add(lblNewLabel_1_2_4_1);
		

		
		
		
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("Mã học kỳ");
		lblNewLabel_1_2_4_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_4_2.setBounds(638, 33, 76, 30);
		add(lblNewLabel_1_2_4_2);
		
		
		
		

	}
	
	public void setImgae(JLabel label) {
		
		java.net.URL url = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		label.setIcon(newIcon);
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
		scroll.setBounds(335, 100, 1085, 619);

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
