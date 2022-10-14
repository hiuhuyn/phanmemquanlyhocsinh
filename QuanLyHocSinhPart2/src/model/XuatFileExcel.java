package model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XuatFileExcel {
	

	
	public static String laypath() {
		// mở cửa sổ tạo file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog( null );
		//
		String path ="";
		try {
			File file = fileChooser.getSelectedFile();
			path = file.getAbsolutePath();
			
//			path = path+".xlsx";

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi lấy path");
		}
		return path;
	}
	
	public static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        
        return style;
    }
	
	public static void exportExcel(JTable jTable) {
		String path = laypath();
		

		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		
		int icell = tableModel.getColumnCount();
		int irow =  tableModel.getRowCount();
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("sheet");
			int rownum = 6;
			XSSFCell cell;
			XSSFRow row;
			
			XSSFCellStyle style = createStyleForTitle(workbook);
			
			rownum++;
			row = sheet.createRow(rownum);
			row.setHeight((short) 500 );
			
			// lay ten cot
			for(int i=0; i<icell; i++) {
				
				cell = row.createCell(i, CellType.STRING);
				cell.setCellValue(tableModel.getColumnName(i)+"");
				cell.setCellStyle(style);
				
			}
			// lay du lieu bang
			for(int i=0; i<irow; i++) {
				rownum++;
				row = sheet.createRow(rownum);
				for(int j=0; j<icell; j++) {
					cell = row.createCell(j, CellType.STRING);
					cell.setCellValue(tableModel.getValueAt(i, j)+"");
				}
			}
			
			
			
			File file = new File(path);
			file.getParentFile().mkdir();
			
			FileOutputStream fStream = new FileOutputStream(file);
			workbook.write(fStream);
			JOptionPane.showMessageDialog(null, "In thành công");
			System.out.println("Create file: " + file.getAbsolutePath());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi xuất file");
		}
		
		
		
		
		

	}
	

}
