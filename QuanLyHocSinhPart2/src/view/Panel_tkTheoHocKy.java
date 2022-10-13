package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

import javax.swing.JTextField;

public class Panel_tkTheoHocKy extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox_hocKy;
	private JComboBox comboBox_MaLop;
	private JTextField textField_path;
	/**
	 * Create the panel.
	 */
	public Panel_tkTheoHocKy() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1430, 730);
		
		JLabel lblNewLabel = new JLabel("Tổng kết điểm học sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(559, 34, 312, 40);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 127, 1410, 94);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã học kỳ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(990, 36, 75, 30);
		panel.add(lblNewLabel_1_1);
		

		
		comboBox_hocKy = new JComboBox();
		comboBox_hocKy.setForeground(new Color(0, 0, 0));
		comboBox_hocKy.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_hocKy.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_hocKy.setBounds(1086, 31, 109, 39);
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		for (HocKy hocKy : hocKies) {
			comboBox_hocKy.addItem(hocKy.getMaHK());
		}
		
		
		panel.add(comboBox_hocKy);
		
		JButton btnLapBaoCao = new JButton("Lập báo cáo");
		btnLapBaoCao.setIcon(new ImageIcon(Panel_tkTheoHocKy.class.getResource("/view/image/Very-Basic-Filter-icon.png")));
		btnLapBaoCao.setForeground(new Color(0, 0, 0));
		btnLapBaoCao.setBackground(Color.WHITE);
		btnLapBaoCao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLapBaoCao.setBounds(1226, 31, 174, 40);
		
		btnLapBaoCao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hienThiAll();
			}
		});
		
		panel.add(btnLapBaoCao);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã lớp");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(813, 38, 52, 30);
		panel.add(lblNewLabel_1_1_1);
		
		comboBox_MaLop = new JComboBox();
		comboBox_MaLop.setForeground(new Color(0, 0, 0));
		comboBox_MaLop.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_MaLop.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_MaLop.setBounds(868, 33, 109, 39);
		ArrayList<Lop> lops = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lops) {
			comboBox_MaLop.addItem(lop.getMaLop());
		}
		
		panel.add(comboBox_MaLop);
		
		
		
		JButton btnInBC = new JButton("In báo cáo");
		btnInBC.setIcon(new ImageIcon(Panel_tkTheoHocKy.class.getResource("/view/image/document-excel-icon.png")));
		btnInBC.setBounds(510, 32, 174, 40);
		panel.add(btnInBC);
		btnInBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
				
			}
		});
		btnInBC.setForeground(new Color(0, 0, 0));
		btnInBC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInBC.setBackground(Color.WHITE);
		
		JButton btnLayDuongDan = new JButton("Lấy đường dẫn");
		btnLayDuongDan.setIcon(new ImageIcon(Panel_tkTheoHocKy.class.getResource("/view/image/Folder-Open-icon.png")));
		btnLayDuongDan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laypath();
				
			}
		});
		btnLayDuongDan.setForeground(new Color(0, 0, 0));
		btnLayDuongDan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLayDuongDan.setBackground(Color.WHITE);
		btnLayDuongDan.setBounds(326, 32, 174, 40);
		panel.add(btnLayDuongDan);
		
		textField_path = new JTextField();
		textField_path.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_path.setForeground(new Color(0, 0, 0));
		textField_path.setBounds(81, 32, 235, 40);
		panel.add(textField_path);
		textField_path.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Panel_tkTheoHocKy.class.getResource("/view/image/User-Interface-Command-Line-icon.png")));
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(42, 30, 36, 40);
		panel.add(lblNewLabel_1_1_1_1);
		
		
		taoJSc();
		hienThiAll();

		
	}
	
	public void setImgae(JLabel label) {
		
		java.net.URL url = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		label.setIcon(newIcon);
	}
	
	
	public void taoJSc() {
		
		
		ArrayList<MonHoc> monHocs = MonHocDAO.getMonHocDAO().selectAll();
		
		String tenCot[] = new String[] { "STT","Mã lớp","Mã học sinh","Học sinh", "Học kì","Số môn học", "Điểm TB học kỳ"};
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));		
		table.setModel(new DefaultTableModel(new Object[][] {},tenCot ));
		
		
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setRowHeight(30);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 232, 1410, 487);
		scroll.setViewportView(table);
		scrollPane = scroll;
		add(scrollPane);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 126, 105);
		add(label);
		setImgae(label);

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
	
	public void laypath() {
		// mở cửa sổ tạo file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(this);
		//
		
		try {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			
			path = path+".xlsx";
			textField_path.setText(path);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
	}

	private XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        
        return style;
    }
	
	public void exportExcel() {
		if(textField_path.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Chưa có đường dẫn!!");
		}else {
			try {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Tổng kết học kỳ sheet");
				int rownum = 6;
				XSSFCell cell;
				XSSFRow row;
				
				XSSFCellStyle style = createStyleForTitle(workbook);

				rownum++;
				row = sheet.createRow(rownum);
				row.setHeight((short) 500 );
				
				// tên cột
				cell = row.createCell(0, CellType.STRING);
				cell.setCellValue("STT");
				cell.setCellStyle(style);
				
				
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue("Mã Lớp");
				cell.setCellStyle(style);
				
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue("Mã học sinh");
				cell.setCellStyle(style);
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("Họ và tên");
				cell.setCellStyle(style);
				
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue("Mã học kỳ");
				cell.setCellStyle(style);
				
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue("Số môn");
				cell.setCellStyle(style);
				
				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue("Điểm TB học kỳ");
				cell.setCellStyle(style);
				
				
				// tao du lieu bang
				
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int i_row = tableModel.getRowCount();
				
				for(int i=0; i<i_row; i++) {
					rownum++;
					row = sheet.createRow(rownum);
					
					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 0)+"");
					
					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 1)+"");
					
					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 2)+"");
					
					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 3)+"");
					
					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 4)+"");
					
					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 5)+"");
					
					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, 6)+"");
					
				}
				
				String path = textField_path.getText();
				
				File file = new File(path);
				file.getParentFile().mkdir();
				
				FileOutputStream fStream = new FileOutputStream(file);
				workbook.write(fStream);
				JOptionPane.showMessageDialog(this, "In thành công");
				System.out.println("Create file: " + file.getAbsolutePath());
				
				
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
	}
}
