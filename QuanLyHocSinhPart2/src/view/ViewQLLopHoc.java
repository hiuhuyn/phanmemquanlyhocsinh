package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DiemMonDAO;
import DAO.HocSinhDAO;
import DAO.LopDAO;
import model.DiemMon;
import model.HocSinh;

import model.Lop;
import model.TaiKhoan;
import model.XuatFileExcel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class ViewQLLopHoc extends JPanel {
	private JTable table;
	private JTextField tf_TenLopTao;
	private JTextField tf_SiSo;
	private JTextField tf_maLop;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public ViewQLLopHoc() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1200, 700);
		
	
		
		JLabel lblNewLabel = new JLabel("Danh sách lớp học");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(441, 11, 292, 69);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 91, 1180, 134);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên lớp");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 52, 53, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sĩ số");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 93, 53, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btn_tao_capNhat = new JButton("Lưu");
		btn_tao_capNhat.setIcon(new ImageIcon(ViewQLLopHoc.class.getResource("/view/image/success-icon.png")));
		btn_tao_capNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTaoAndCapNhatLop();
			}
		});

		btn_tao_capNhat.setForeground(new Color(0, 0, 0));
		btn_tao_capNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_tao_capNhat.setBackground(new Color(211, 211, 211));
		btn_tao_capNhat.setBounds(558, 12, 150, 49);
		panel_1.add(btn_tao_capNhat);
		
		JButton btnXoa_lop = new JButton("Xóa");
		btnXoa_lop.setIcon(new ImageIcon(ViewQLLopHoc.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa_lop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonXoa();
			}
		});

		btnXoa_lop.setBackground(new Color(211, 211, 211));
		btnXoa_lop.setForeground(new Color(0, 0, 0));
		btnXoa_lop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa_lop.setBounds(765, 12, 150, 49);
		panel_1.add(btnXoa_lop);
		
		tf_TenLopTao = new JTextField();
		tf_TenLopTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenLopTao.setForeground(new Color(30, 144, 255));
		tf_TenLopTao.setBounds(68, 52, 254, 30);
		panel_1.add(tf_TenLopTao);
		tf_TenLopTao.setColumns(10);
		
		tf_SiSo = new JTextField();
		tf_SiSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SiSo.setForeground(new Color(30, 144, 255));
		tf_SiSo.setColumns(10);
		tf_SiSo.setBounds(68, 93, 254, 30);
		panel_1.add(tf_SiSo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã lớp");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 11, 53, 30);
		panel_1.add(lblNewLabel_1_2);
		
		tf_maLop = new JTextField();
		tf_maLop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_maLop.setForeground(new Color(30, 144, 255));
		tf_maLop.setColumns(10);
		tf_maLop.setBounds(68, 11, 254, 30);
		panel_1.add(tf_maLop);
		
		JButton btn_timLop = new JButton("");
		btn_timLop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTimKiem();
			}
		});

		btn_timLop.setIcon(new ImageIcon(ViewQLLopHoc.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		
		btn_timLop.setForeground(new Color(0, 0, 0));
		btn_timLop.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_timLop.setBackground(new Color(211, 211, 211));
		btn_timLop.setBounds(358, 11, 150, 50);
		panel_1.add(btn_timLop);
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.setBounds(976, 12, 150, 49);
		panel_1.add(btnXuatExcel);
		btnXuatExcel.setIcon(new ImageIcon(ViewQLLopHoc.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		
		taoJcrollPaneRong();
		
		hienThiAllLop();
		
	}

	public void taoJcrollPaneRong() {
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 l\u1EDBp", "T\u00EAn l\u1EDBp", "S\u0129 s\u1ED1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		
		table.setRowHeight(30);
		
		JScrollPane src = new JScrollPane();
		src.setBounds(10, 259, 1180, 430);
		src.setViewportView(table);
		
		scrollPane = src;
		
		
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
	
	public void hienThiAllLop() {
		this.remove(scrollPane);
		taoJcrollPaneRong();
		
		ArrayList<Lop> lops = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lops) {
			themLopVaoTable(lop);
			
			
		}

	}
	
	public void themLopVaoTable(Lop lop) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int i_row = (Integer) tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				i_row,
				lop.getMaLop().trim() + "",
				lop.getTenLop().trim() + "",
				lop.getSiSo() + "".trim()
				
		});
	}
	
	public Lop getDuLieuJTextField() {
		Lop lop = null;
		try {
			String maLop = tf_maLop.getText();
			String tenLop = tf_TenLopTao.getText();
			int siso = Integer.valueOf(tf_SiSo.getText());
			lop = new Lop(maLop, tenLop, siso);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return lop;
	}

	public boolean kiemTraTonTai(Lop lop) {
		
		Lop t = LopDAO.getLopDAO().selectById(lop);
		
		if( t== null) {
			return false;
		}
		
		return true;
	}
	
	public boolean kiemTraMa() {
		
		String maLop = tf_maLop.getText();
		Lop lop = new Lop();
		lop.setMaLop(maLop);
		
		Lop lopKT = LopDAO.getLopDAO().selectById(lop);
		
		if( lopKT == null ) {
			return false;
		}
		return true;
		
	}
	
	
	public void buttonTaoAndCapNhatLop() {
		try {
			
			Lop lop = this.getDuLieuJTextField();
			
			if(this.kiemTraTonTai(lop)) {
				int luachon = JOptionPane.showConfirmDialog(this, "Lớp đã tồn tại,\nbạn "
						+ "có muốn cập nhật lớp không ?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					LopDAO.getLopDAO().update(lop);
					hienThiAllLop();
				}
			}else {
				int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin "
						+ "lớp này không?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					LopDAO.getLopDAO().insert(lop);
					hienThiAllLop();
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e);
		}

	}
	
	public void buttonXoa() {
		
		try {
			
			Lop lop = new Lop();
			lop.setMaLop(tf_maLop.getText());

			if(kiemTraMa()) {
				
				int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa lớp có mã " +lop.getMaLop()+ " không?\n"
						+ "Nếu sẽ xóa thì học sinh của lớp này sẽ mất lớp!!");
				if(luachon ==JOptionPane.YES_NO_OPTION) {

					ArrayList<HocSinh> hocSinh_Lops = HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop = '" + lop.getMaLop() +"'" );
					for (HocSinh hocSinh : hocSinh_Lops) {
						ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + hocSinh.getMaHS() + "'");
						for (DiemMon dMon : diemMons) {
							DiemMonDAO.getDiemMonDAO().delete(dMon);
						}
						HocSinhDAO.getHocSinhDAO().delete(hocSinh);
						
					}
					LopDAO.getLopDAO().delete(lop);
					
					hienThiAllLop();
				}
			}else {
				JOptionPane.showMessageDialog(this, "Lớp muốn xóa không hợp lệ");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this, "Lớp muốn xóa không hợp lệ");
		}
	}
	
	public void themLopVaoFormNhap(Lop lop) {
		tf_maLop.setText(lop.getMaLop().trim());
		tf_TenLopTao.setText(lop.getTenLop().trim());
		tf_SiSo.setText( lop.getSiSo() + "".trim());
	}
	
	public void buttonTimKiem() {
		try {
			String maLop = tf_maLop.getText();
			Lop lop = new Lop();
			lop.setMaLop(maLop);
			Lop lop2 = LopDAO.getLopDAO().selectById(lop);
			themLopVaoFormNhap(lop2);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Hãy nhập mã lớp");	
		}
	}
	
	public Lop getDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = table.getSelectedRow();
		
		String maLop = tableModel.getValueAt(irow, 1).toString().trim();
		Lop lop = LopDAO.getLopDAO().selectById(new Lop(maLop));


		return lop;
	}
	
	
	public void hienThiDaChon() {
		themLopVaoFormNhap(this.getDangChon());

	}
	

	
	
	
}
