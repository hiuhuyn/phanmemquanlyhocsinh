package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.LopDAO;
import DAO.MonHocDAO;
import model.MonHoc;
import model.XuatFileExcel;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class FrameMonHoc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_tenMon;
	private JTextField tf_maMon;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	
	
	public FrameMonHoc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMonHoc.class.getResource("/view/image/logoTHCS ChoChu.jpg")));
		
		
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Môn học");

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin môn học");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(223, 11, 173, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(FrameMonHoc.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLuu();
				
			}
		});
		btnLuu.setBackground(new Color(192, 192, 192));
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(10, 61, 113, 39);
		contentPane.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(FrameMonHoc.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
				
			}
		});
		btnXoa.setBackground(new Color(192, 192, 192));
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(149, 61, 113, 39);
		contentPane.add(btnXoa);
		
		taoJSc();
		hienThiAll();
		
		
		setVisible(false);
	}

	
	public void taoJSc() {
		
		
		
		JScrollPane jcs = new JScrollPane();
		jcs.setBounds(10, 205, 613, 222);
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 111, 613, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã môn");
		lblNewLabel_1_2.setBounds(10, 11, 91, 30);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_maMon = new JTextField();
		tf_maMon.setBounds(110, 12, 171, 30);
		panel.add(tf_maMon);
		tf_maMon.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_maMon.setForeground(new Color(30, 144, 255));
		tf_maMon.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên môn học");
		lblNewLabel_1.setBounds(332, 11, 91, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_tenMon = new JTextField();
		tf_tenMon.setBounds(432, 12, 171, 30);
		panel.add(tf_tenMon);
		tf_tenMon.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_tenMon.setForeground(new Color(30, 144, 255));
		tf_tenMon.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dang sách môn học");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(223, 169, 173, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnXutExcel = new JButton("Xuất Excel");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatFileExcel.exportExcel(table);
			}
		});
		btnXutExcel.setIcon(new ImageIcon(FrameMonHoc.class.getResource("/view/image/Folder-Open-icon.png")));
		btnXutExcel.setForeground(Color.BLACK);
		btnXutExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXutExcel.setBackground(Color.LIGHT_GRAY);
		btnXutExcel.setBounds(472, 61, 151, 39);
		contentPane.add(btnXutExcel);
		
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
			System.out.println(kiemTra);
			
			if(!kiemTra) {
				
				int luaChon = JOptionPane.showConfirmDialog(this, "Môn học này đã tồn tại!!"
						+ "\n Bạn có muốn cập nhật không ?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					MonHocDAO.getMonHocDAO().update(monHoc);
					hienThiAll();
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "Đã lưu!!");
				MonHocDAO.getMonHocDAO().insert(monHoc);
				hienThiAll();
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
			
			

//			boolean kiemTra = maMon.equals("");
			
			boolean kiemTra = (ktHoc == null);
			
			
			if(!kiemTra) {
				int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa môn học này?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					
					// doạn này để xóa all diem mon nay.
					
					MonHocDAO.getMonHocDAO().delete(monHoc);
					hienThiAll();
				}

			}else {
				JOptionPane.showMessageDialog(this, "Mã môn xóa không hợp lệ!!" );
			}


	}
	
	
	
	
	
	
}
