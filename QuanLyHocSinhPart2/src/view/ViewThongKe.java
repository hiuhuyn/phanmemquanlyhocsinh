package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

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


public class ViewThongKe extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox_hocKy;
	private JComboBox comboBox_MaLop;
	/**
	 * Create the panel.
	 */
	public ViewThongKe() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1200, 700);
		
		JLabel lblNewLabel = new JLabel("Tổng kết điểm học sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(402, 27, 312, 40);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 94, 1180, 71);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã học kỳ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(255, 20, 80, 30);
		panel.add(lblNewLabel_1_1);
		

		
		comboBox_hocKy = new JComboBox();
		comboBox_hocKy.setForeground(new Color(30, 144, 255));
		comboBox_hocKy.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_hocKy.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_hocKy.setBounds(345, 20, 150, 30);
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		for (HocKy hocKy : hocKies) {
			comboBox_hocKy.addItem(hocKy.getMaHK());
		}
		
		
		panel.add(comboBox_hocKy);
		
		JButton btnLapBaoCao = new JButton("Lập báo cáo");
		btnLapBaoCao.setIcon(new ImageIcon(ViewThongKe.class.getResource("/view/image/Very-Basic-Filter-icon.png")));
		btnLapBaoCao.setForeground(new Color(0, 0, 0));
		btnLapBaoCao.setBackground(Color.WHITE);
		btnLapBaoCao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLapBaoCao.setBounds(822, 10, 150, 50);
		
		btnLapBaoCao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hienThiAll();
			}
		});
		
		panel.add(btnLapBaoCao);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã lớp");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 20, 80, 30);
		panel.add(lblNewLabel_1_1_1);
		
		comboBox_MaLop = new JComboBox();
		comboBox_MaLop.setForeground(new Color(30, 144, 255));
		comboBox_MaLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_MaLop.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaLop.setBounds(95, 21, 150, 30);
		ArrayList<Lop> lops = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lops) {
			comboBox_MaLop.addItem(lop.getMaLop());
		}
		
		panel.add(comboBox_MaLop);
		
		
		
		JButton btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.setIcon(new ImageIcon(ViewThongKe.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXuatExcel.setBounds(1020, 10, 150, 50);
		panel.add(btnXuatExcel);
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
				
			}
		});
		btnXuatExcel.setForeground(new Color(0, 0, 0));
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.setBackground(Color.WHITE);
		
		
		taoJSc();
		hienThiAll();

		
	}

	public void taoJSc() {
		
		
		ArrayList<MonHoc> monHocs = MonHocDAO.getMonHocDAO().selectAll();
		
		String tenCot[] = new String[] { "STT","Mã lớp","Mã học sinh","Học sinh", "Học kì","Số môn học", "Điểm TB học kỳ"};
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));		
		table.setModel(new DefaultTableModel(new Object[][] {},tenCot ));
		
		
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setRowHeight(30);
		
				JScrollPane scroll = new JScrollPane();
				scroll.setBounds(10, 183, 1180, 506);
				add(scroll);
				scroll.setViewportView(table);
				scrollPane = scroll;

	}
	
	
	public void hienThiAll() {
		this.remove(scrollPane);
		taoJSc();
		
		String maHK = comboBox_hocKy.getSelectedItem().toString();
		String maLop = comboBox_MaLop.getSelectedItem().toString();
		
		if(maHK.equals("") && maLop.equals("") ) {
			themVaoTable();
		}else if (maHK.equals("")) {
			themVaoTableVSLop(maLop);
		}else if (maLop.equals("")) {
			themVaoTablevsHocKy(maHK);
		}else {
			themVaoTable(maLop, maHK);
		}
	}
	public void themVaoTable() {
		ArrayList<HocSinh> hocSinhs = 
				HocSinhDAO.getHocSinhDAO().selectAll();
		ArrayList<DiemMon> diemMons;
		
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		
		
		for (HocKy hocKy : hocKies) {
			for (HocSinh hocSinh : hocSinhs) {
				double diemTK = 0;
				diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + hocSinh.getMaHS() + "' and MaHK = '" + hocKy.getMaHK() +"'");

				
				for (DiemMon diemMon : diemMons) {
					diemTK += diemMon.getDiemTBmon();
				}
				
				diemTK /= diemMons.size();
				
				tableModel.addRow(new Object[] {
						irow,
						hocSinh.getMaLop(),
						hocSinh.getMaHS(),
						hocSinh.getHoTen(),
						hocKy.getMaHK(),
						diemMons.size(),
						String.format("%,.2f", diemTK)
				});
				irow++;
			}
		}
		
	}
	
	public void themVaoTableVSLop(String malop) {
		ArrayList<HocSinh> hocSinhs = 
				HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop = '" + malop +  "'");
		ArrayList<DiemMon> diemMons;
		
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		
		for (HocKy hocKy : hocKies) {
			for (HocSinh hocSinh : hocSinhs) {
				double diemTK = 0;
				diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + hocSinh.getMaHS() + "' and MaHK = '" + hocKy.getMaHK() +"'");

				
				for (DiemMon diemMon : diemMons) {
					diemTK += diemMon.getDiemTBmon();
				}
				
				diemTK /= diemMons.size();
				
				tableModel.addRow(new Object[] {
						irow,
						hocSinh.getMaLop(),
						hocSinh.getMaHS(),
						hocSinh.getHoTen(),
						hocKy.getMaHK(),
						diemMons.size(),
						String.format("%,.2f", diemTK)
				});
				irow++;
			}
		}
		
	}
	
	public void themVaoTablevsHocKy(String maHK ) {
		ArrayList<HocSinh> hocSinhs = 
				HocSinhDAO.getHocSinhDAO().selectAll();
		ArrayList<DiemMon> diemMons;
		
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		
		for (HocSinh hocSinh : hocSinhs) {
			double diemTK = 0;
			diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + hocSinh.getMaHS() +  "' and MaHK= '" + maHK  +"'"  );

			
			for (DiemMon diemMon : diemMons) {
				diemTK += diemMon.getDiemTBmon();
			}
			
			diemTK /= diemMons.size();
			
			tableModel.addRow(new Object[] {
					irow,
					hocSinh.getMaLop(),
					hocSinh.getMaHS(),
					hocSinh.getHoTen(),
					maHK,
					diemMons.size(),
//					diemTK
					String.format("%,.2f", diemTK)
			});
			irow++;
		}
		
	}
	
	public void themVaoTable(String maLop, String maHK ) {
		ArrayList<HocSinh> hocSinhs = 
				HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop= '" +maLop+ "'");
		ArrayList<DiemMon> diemMons;
		
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = tableModel.getRowCount();
		
		for (HocSinh hocSinh : hocSinhs) {
			double diemTK = 0;
			diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaHS = '" + hocSinh.getMaHS() +  "' and MaHK= '" + maHK  +"'"  );

			
			for (DiemMon diemMon : diemMons) {
				diemTK += diemMon.getDiemTBmon();
			}
			
			diemTK /= diemMons.size();
			
			tableModel.addRow(new Object[] {
					irow,
					maLop,
					hocSinh.getMaHS(),
					hocSinh.getHoTen(),
					maHK,
					diemMons.size(),
//					diemTK
					String.format("%,.2f", diemTK)
			});
			irow++;
		}
		
	}
}
