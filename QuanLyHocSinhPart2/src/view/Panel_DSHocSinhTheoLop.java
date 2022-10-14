package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CSDL_sqlSv.HocSinhDAO;

import CSDL_sqlSv.LopDAO;

import model.HocSinh;

import model.Lop;

import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Panel_DSHocSinhTheoLop extends JPanel {
	private JTable table;
	private JScrollPane scrollPane_1;
	private JComboBox comboBox_tenlop;

	/**
	 * Create the panel.
	 */
	public Panel_DSHocSinhTheoLop() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1200, 700);

		JLabel lblDanhSchHc = new JLabel("Danh sách học sinh theo lớp");
		lblDanhSchHc.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDanhSchHc.setBounds(380, 27, 432, 65);
		add(lblDanhSchHc);
		

		
		JLabel lblNewLabel_1_2 = new JLabel("Mã lớp");
		lblNewLabel_1_2.setBounds(812, 97, 62, 30);
		add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btn_Tim = new JButton("");
		btn_Tim.setIcon(new ImageIcon(Panel_DSHocSinhTheoLop.class.getResource("/view/image/Very-Basic-Search-icon.png")));

		btn_Tim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTimTheoLop();
			}
			
		});
		btn_Tim.setForeground(new Color(0, 0, 0));
		btn_Tim.setBackground(Color.WHITE);
		btn_Tim.setBounds(1078, 97, 112, 33);
		add(btn_Tim);
		
		btn_Tim.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_tenlop = new JComboBox();
		comboBox_tenlop.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_tenlop.setModel(new DefaultComboBoxModel(new String[] {""}));
		ArrayList<Lop> lops = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lops) {
			comboBox_tenlop.addItem(lop.getMaLop());
		}
		comboBox_tenlop.setBounds(884, 99, 160, 30);
		add(comboBox_tenlop);
		
		
		taoJScrollPane();
		
		hienThiAll();
		
	}

	
	public void taoJScrollPane() {

		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"STT", "M\u00E3 l\u1EDBp", "M\u00E3 h\u1ECDc sinh", "H\u1ECD t\u00EAn h\u1ECDc sinh", "Ng\u00E0y sinh"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 141, 1180, 548);
		scrollPane_1.setViewportView(table);
		add(scrollPane_1);
		
		
		
		
	}
	
	public void themVaoTable(HocSinh hocSinh_Lop) {
		
		HocSinh hocSinh = new HocSinh();
		hocSinh.setMaHS(hocSinh_Lop.getMaHS());
		
		HocSinh hocSinh2 = HocSinhDAO.getHocSinhDAO().selectById(hocSinh);
		System.out.println(hocSinh2.toString());
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = (Integer) tableModel.getRowCount();
		
		tableModel.addRow(new Object[] {
				irow,
				hocSinh_Lop.getMaLop().trim(),
				hocSinh_Lop.getMaHS().trim(),
				hocSinh2.getHoTen().trim(),
				hocSinh2.getNgaySinh()+""

		});

	}
	
	public void hienThiAll() {
		this.remove(scrollPane_1);
		taoJScrollPane();
		ArrayList<HocSinh> list = HocSinhDAO.getHocSinhDAO().selectAll();
		
		for (HocSinh hocSinh_Lop : list) {
			themVaoTable(hocSinh_Lop);
			
		}

	}
	

	
	public void buttonTimTheoLop() {
		
		
		
//		String maLop = tf_malopTim.getText();
		String maLop = comboBox_tenlop.getSelectedItem().toString();

		
		if(maLop.equals("")) {
			taoJScrollPane();
			hienThiAll();
		}else {
			ArrayList<HocSinh> list = HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop = '" +maLop+  "'");
			this.remove(scrollPane_1);
			taoJScrollPane();
			for (HocSinh hocSinh_Lop2 : list) {
				themVaoTable(hocSinh_Lop2);
			}
		}
		
		

	}

}
