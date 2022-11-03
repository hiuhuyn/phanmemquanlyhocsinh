package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DiemMonDAO;

import DAO.MonHocDAO;
import model.DiemMon;
import model.MonHoc;

import model.XuatFileExcel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ViewMonHoc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_tenMon;
	private JTextField tf_maMon;
	private JScrollPane scrollPane;

	
	
	public ViewMonHoc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMonHoc.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		
		
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Môn học");
		setBounds(100, 100, 649, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin môn học");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(162, 21, 338, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(ViewMonHoc.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kiemTraGioiHan()) {
					buttonLuu();
				}
				
				
			}
		});
		btnLuu.setBackground(new Color(192, 192, 192));
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(11, 82, 150, 50);
		contentPane.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ViewMonHoc.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
				
			}
		});
		btnXoa.setBackground(new Color(192, 192, 192));
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(171, 82, 150, 50);
		contentPane.add(btnXoa);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 143, 613, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã môn");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(10, 11, 91, 30);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_maMon = new JTextField();
		tf_maMon.setBounds(110, 12, 150, 30);
		panel.add(tf_maMon);
		tf_maMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_maMon.setForeground(new Color(30, 144, 255));
		tf_maMon.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên môn học");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(315, 11, 91, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_tenMon = new JTextField();
		tf_tenMon.setBounds(415, 12, 150, 30);
		panel.add(tf_tenMon);
		tf_tenMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_tenMon.setForeground(new Color(30, 144, 255));
		tf_tenMon.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("(10)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(270, 12, 35, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("(10)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(575, 11, 35, 30);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Dang sách môn học");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(223, 201, 173, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnXutExcel = new JButton("Xuất Excel");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXutExcel.setIcon(new ImageIcon(ViewMonHoc.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXutExcel.setForeground(Color.BLACK);
		btnXutExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXutExcel.setBackground(Color.LIGHT_GRAY);
		btnXutExcel.setBounds(473, 82, 150, 50);
		contentPane.add(btnXutExcel);
		
		
		taoJSc();
		hienThiAll();
	}
	
	public boolean kiemTraGioiHan() {
		try {
			
			int sizeMaMon = tf_maMon.getText().length();
			int sizeTenMon = tf_tenMon.getText().length();
			
			if(sizeMaMon<=10 && sizeTenMon <=10 ) {
				if(sizeMaMon == 0 || sizeTenMon == 0) {
					sizeMaMon =1/0; // tạo exception
				}
				
				return true;
			}else {
				if(sizeMaMon > 10) {
					JOptionPane.showMessageDialog(this, "Mã môn không được vượt quá 10 ký tự!" );
				}
				if(sizeTenMon > 10) {
					JOptionPane.showMessageDialog(this, "Tên môn không được vượt quá 10 ký tự!" );
				}
					
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ!!");
			return false;
		}
		
		
		
		
	}
	
	public void taoJSc() {
		JScrollPane jcs = new JScrollPane();
		jcs.setBounds(10, 237, 613, 222);
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setForeground(new Color(30, 144, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 m\u00F4n", "T\u00EAn m\u00F4n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.setRowHeight(25);
		jcs.setViewportView(table);
		
		scrollPane = jcs;
		
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
	
	
	
	public void themVaoTable(MonHoc monHoc) {
		DefaultTableModel tableModel = (DefaultTableModel ) table.getModel();
		int irow = tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				irow,
				monHoc.getMaMon().trim(),
				monHoc.getTenMon().trim()
					
		});

	}
	
	
	
	public void hienThiAll() {
		contentPane.remove(scrollPane);
		taoJSc();
		ArrayList<MonHoc> monHocs = MonHocDAO.getMonHocDAO().selectAll();
		
		for (MonHoc monHoc : monHocs) {
			themVaoTable(monHoc);
		}
	}
	
	public void buttonLuu() {
		try {
			
			String maMon = tf_maMon.getText();
			String tenMon = tf_tenMon.getText();
			
			MonHoc monHoc = new MonHoc(maMon, tenMon);
			
			MonHoc kt = MonHocDAO.getMonHocDAO().selectById(monHoc);
			
			boolean kiemTra = (kt==null);
			
			
			if(!kiemTra) {
				
				int luaChon = JOptionPane.showConfirmDialog(this, "Môn học này đã tồn tại!!"
						+ "\n Bạn có muốn cập nhật không ?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					MonHocDAO.getMonHocDAO().update(monHoc);
					hienThiAll();
				}
				
			}else {
				int luaChon = JOptionPane.showConfirmDialog(this, "Xác nhận lưu?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					MonHocDAO.getMonHocDAO().insert(monHoc);
					JOptionPane.showMessageDialog(this, "Đã lưu!!");
					hienThiAll();
				}
				
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e);
			
		}

	}
	
	public void buttonXoa() {

			String maMon = tf_maMon.getText();

			MonHoc monHoc = new MonHoc();
			monHoc.setMaMon(maMon);
			
			MonHoc ktHoc = MonHocDAO.getMonHocDAO().selectById(monHoc);
			
			boolean kiemTra = (ktHoc == null);
			
			
			if(!kiemTra) {
				int luaChon = JOptionPane.showConfirmDialog(this, "Xác nhận xóa?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					
					ArrayList<DiemMon> diemMons = DiemMonDAO.getDiemMonDAO().selectByCondition("MaMon = '" + maMon + "'");
					for (DiemMon diemMon : diemMons) {
						DiemMonDAO.getDiemMonDAO().delete(diemMon);
					}
					
					MonHocDAO.getMonHocDAO().delete(monHoc);
					JOptionPane.showMessageDialog(this, "Xóa thành công!!");
					hienThiAll();
				}

			}else {
				JOptionPane.showMessageDialog(this, "Mã môn xóa không hợp lệ!!" );
			}


	}
	
	public MonHoc getDangChon() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int irow = table.getSelectedRow();
		
		String maMon = tableModel.getValueAt(irow, 1).toString();
		String tenMon = tableModel.getValueAt(irow, 2).toString();
		

		return new MonHoc(maMon, tenMon) ;
	}
	
	
	public void hienThiDaChon() {
		MonHoc monHoc = this.getDangChon();
		tf_maMon.setText(monHoc.getMaMon());
		tf_tenMon.setText(monHoc.getTenMon());
		
	}
	
	
	
	
}
