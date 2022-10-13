package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CSDL_sqlSv.HocKyDAO;
import CSDL_sqlSv.MonHocDAO;
import model.HocKy;
import model.MonHoc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrameHocKy extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_maHK;
	private JTextField tf_TenHK;
	private JTextField tf_NamBatDau;
	private JTextField tf_namKetThuc;
	private JScrollPane scrollPane;

	
	public void setLogo() {

		java.net.URL url2 = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img2 = Toolkit.getDefaultToolkit().createImage(url2);
		
		this.setIconImage(img2);
		
	}
	
	public FrameHocKy() {
		setLogo();
		setTitle("Học kỳ");

		setBounds(100, 100, 744, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Danh sách các Học kỳ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(242, 11, 226, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã học kỳ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 77, 105, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên học kỳ");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 119, 105, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Năm bắt đầu");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 158, 105, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Năm kết thúc");
		lblNewLabel_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(10, 199, 105, 30);
		contentPane.add(lblNewLabel_1_1_2);
		
		tf_maHK = new JTextField();
		tf_maHK.setForeground(new Color(30, 144, 255));
		tf_maHK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_maHK.setBounds(124, 77, 208, 30);
		contentPane.add(tf_maHK);
		tf_maHK.setColumns(10);
		
		tf_TenHK = new JTextField();
		tf_TenHK.setForeground(new Color(30, 144, 255));
		tf_TenHK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenHK.setColumns(10);
		tf_TenHK.setBounds(124, 119, 208, 30);
		contentPane.add(tf_TenHK);
		
		tf_NamBatDau = new JTextField();
		tf_NamBatDau.setForeground(new Color(30, 144, 255));
		tf_NamBatDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_NamBatDau.setColumns(10);
		tf_NamBatDau.setBounds(125, 158, 207, 30);
		contentPane.add(tf_NamBatDau);
		
		tf_namKetThuc = new JTextField();
		tf_namKetThuc.setForeground(new Color(30, 144, 255));
		tf_namKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_namKetThuc.setColumns(10);
		tf_namKetThuc.setBounds(124, 199, 208, 30);
		contentPane.add(tf_namKetThuc);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(FrameHocKy.class.getResource("/view/image/success-icon.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLuu();
				
			}
		});
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(10, 286, 105, 35);
		contentPane.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(FrameHocKy.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonXoa();
			}
		});
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(224, 286, 108, 35);
		contentPane.add(btnXoa);
		
		taoJSc();
		hienThiAll();
		
		
		
		setVisible(false);
	}
	
	public void taoJSc() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(344, 76, 374, 280);
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(30, 144, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", " M\u00E3 h\u1ECDc k\u1EF3", "T\u00EAn h\u1ECDc k\u1EF3", "N\u0103m b\u1EAFt \u0111\u1EA7u", "N\u0103m k\u1EBFt th\u00FAc"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		scroll.setViewportView(table);
		
		scrollPane = scroll;
		
		contentPane.add(scrollPane);
		
	}
	
	
	
	
	public void themVaoTable(HocKy hocKy) {
		DefaultTableModel tableModel = (DefaultTableModel ) table.getModel();
		int irow = tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				irow,
				hocKy.getMaHK().trim(),
				hocKy.getTenHK().trim(),
				hocKy.getNamBatDau(),
				hocKy.getNamKetThuc()
					
		});

	}
	
	public void hienThiAll() {
		contentPane.remove(scrollPane);
		taoJSc();
		ArrayList<HocKy> hocKies = HocKyDAO.getHocKyDAO().selectAll();
		
		for (HocKy hocKy : hocKies) {
			themVaoTable(hocKy);
		}
	}
	

	public void buttonLuu() {
		try {
			
			String maHK = tf_maHK.getText();
			String tenHK = tf_TenHK.getText();
			int namDau = Integer.valueOf(tf_NamBatDau.getText());
			int namket = Integer.valueOf(tf_namKetThuc.getText());
			
			HocKy hocKy = new HocKy(maHK, tenHK, namDau, namket);
			
			HocKy kt = HocKyDAO.getHocKyDAO().selectById(hocKy);
			
			boolean kiemTra = (kt==null);
			

			if(!kiemTra) {
				
				int luaChon = JOptionPane.showConfirmDialog(this, "Học kỳ học này đã tồn tại!!"
						+ "\n Bạn có muốn cập nhật không ?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					HocKyDAO.getHocKyDAO().update(hocKy);
					hienThiAll();
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "Đã lưu!!");
				HocKyDAO.getHocKyDAO().insert(hocKy);
				hienThiAll();
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e);
			
		}

	}
	
	public void buttonXoa() {

			String maHK = tf_maHK.getText();

			HocKy hocKy = new HocKy();
			hocKy.setMaHK(maHK);
			
			HocKy kt = HocKyDAO.getHocKyDAO().selectById(hocKy);
		

//			boolean kiemTra = maMon.equals("");
			
			boolean kiemTra = (kt== null);
			
			
			if(!kiemTra) {
				int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa học kỳ này?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					
					// doạn này để xóa all diem hoc ky nay.
					
					HocKyDAO.getHocKyDAO().delete(hocKy);
					hienThiAll();
				}

			}else {
				JOptionPane.showMessageDialog(this, "Mã Học kỳ xóa không hợp lệ!!" );
			}


	}
	
	
	
}
