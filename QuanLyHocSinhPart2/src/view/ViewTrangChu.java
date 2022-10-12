package view;


import java.awt.*;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


import controller.Listener_ViewTrangChu;


public class ViewTrangChu extends JFrame {

	private JPanel contentPane;
	private JPanel panelMain;
	private Panel_QLHS panel_QLHS;
	private Panel_DSLop panel_QLDSLop;
	private Panel_BangDiem panel_BangDiem;
	private FrameMonHoc frameMonHoc;

	private Panel_DSHocSinhTheoLop panel_DSHocSinhTheoLop;
	private FrameHocKy frameHocKy;
	private Panel_tkTheoHocKy panel_BaoCaoTk;
	
	private HuongDan jframeHuongDan;
	
	private JF_TTTaiKhoan ttTaiKhoan;
	private JF_DoiPass doiPass;
	
	
	
	
	public JF_TTTaiKhoan getTtTaiKhoan() {
		return ttTaiKhoan = new JF_TTTaiKhoan() ;
	}

	public JF_DoiPass getDoiPass() {
		return doiPass = new JF_DoiPass();
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public Panel_QLHS getPanel_QLHS() {
		return panel_QLHS = new Panel_QLHS();
	}

	public Panel_DSLop getPanel_QLDSLop() {
		return panel_QLDSLop = new Panel_DSLop();
	}

	public Panel_BangDiem getPanel_BangDiem() {
		return panel_BangDiem = new Panel_BangDiem();
	}

	public FrameMonHoc getFrameMonHoc() {
		return frameMonHoc = new FrameMonHoc();
	}

	public Panel_DSHocSinhTheoLop getPanel_DSHocSinhTheoLop() {
		return panel_DSHocSinhTheoLop = new Panel_DSHocSinhTheoLop();
	}

	public FrameHocKy getFrameHocKy() {
		return frameHocKy = new FrameHocKy();
	}

	public Panel_tkTheoHocKy getPanel_BaoCaoTk() {
		return panel_BaoCaoTk = new Panel_tkTheoHocKy();
	}

	public HuongDan getJframeHuongDan() {
		return jframeHuongDan = new HuongDan();
	}

	
	
	public ViewTrangChu() {
		setResizable(false);

		setTitle("Phần mềm quản lý học sinh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1450, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Listener_ViewTrangChu listener_ViewTrangChu = new Listener_ViewTrangChu(this);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1434, 30);
		contentPane.add(menuBar);
		
		JMenu mnQLTK = new JMenu("Quản lý tài khoản");
		mnQLTK.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLTK);
		
		JMenuItem item_ttTK = new JMenuItem("Thông tin tài khoản");
		item_ttTK.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/user-id-icon.png")));
		item_ttTK.addActionListener(listener_ViewTrangChu);
		mnQLTK.add(item_ttTK);
		
		JMenuItem item_doiPass = new JMenuItem("Đổi mật khẩu");
		item_doiPass.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Security-Password-1-icon (1).png")));
		item_doiPass.addActionListener(listener_ViewTrangChu);
		mnQLTK.add(item_doiPass);
		
		JMenu mnQLHS = new JMenu("Quản lý học sinh");
		mnQLHS.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLHS);
		
		JMenuItem item_hoSoHS = new JMenuItem("Hồ sơ học sinh");
		item_hoSoHS.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/cv-icon.png")));
		item_hoSoHS.addActionListener(listener_ViewTrangChu);
		mnQLHS.add(item_hoSoHS);
		
		JMenu mnQLL = new JMenu("Quản lý lớp");
		mnQLL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQLL);
		
		JMenuItem item_DSLop = new JMenuItem("Danh sách các lớp");
		item_DSLop.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Bulleted-List-icon.png")));
		item_DSLop.addActionListener(listener_ViewTrangChu);
		mnQLL.add(item_DSLop);
		
		JMenuItem item_DS_HS_LOP = new JMenuItem("Danh sách học sinh theo lớp");
		item_DS_HS_LOP.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Apps-preferences-contact-list-icon.png")));
		item_DS_HS_LOP.addActionListener(listener_ViewTrangChu);
		mnQLL.add(item_DS_HS_LOP);
		
		JMenu mnQunLim = new JMenu("Quản lý điểm");
		mnQunLim.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQunLim);
		
		JMenuItem item_BangDiemMon = new JMenuItem("Bảng điểm môn");
		item_BangDiemMon.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Database-Table-icon.png")));
		item_BangDiemMon.addActionListener(listener_ViewTrangChu);
		mnQunLim.add(item_BangDiemMon);
		
		JMenu mnBoCo = new JMenu("Thống kê");
		mnBoCo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnBoCo);
		
		JMenuItem item_BCTK = new JMenuItem("Thống kê theo lớp");
		item_BCTK.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Very-Basic-Filter-icon.png")));
		item_BCTK.addActionListener(listener_ViewTrangChu);
		mnBoCo.add(item_BCTK);
		
		JMenu mnQuynh = new JMenu("Quy định");
		mnQuynh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnQuynh);
		
		JMenuItem item_monHoc = new JMenuItem("Môn học");
		item_monHoc.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/Books-icon.png")));
		item_monHoc.addActionListener(listener_ViewTrangChu);
		mnQuynh.add(item_monHoc);
		
		JMenuItem item_hocKy = new JMenuItem("Học kỳ");
		item_hocKy.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/calendar-selection-month-icon.png")));
		item_hocKy.addActionListener(listener_ViewTrangChu);
		mnQuynh.add(item_hocKy);
		
		JMenu mnhelp = new JMenu("Help");
		mnhelp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnhelp);
		
		JMenuItem item_huongDan = new JMenuItem("Hướng dẫn");
		item_huongDan.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/info_button_16.png")));
		item_huongDan.setSelected(true);
		item_huongDan.addActionListener(listener_ViewTrangChu);
		mnhelp.add(item_huongDan);
		
		JMenuItem item_lienHe = new JMenuItem("Liên hệ");
		item_lienHe.setIcon(new ImageIcon(ViewTrangChu.class.getResource("/view/image/customer-service-icon (1).png")));
		item_lienHe.addActionListener(listener_ViewTrangChu);
		mnhelp.add(item_lienHe);
		
		

		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMain.setBounds(0, 30, 1435, 731);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds( 0, 0, panelMain.getWidth()   ,panelMain.getHeight());
		setImgae(lblNewLabel);
		panelMain.add(lblNewLabel);

		
		
		
	}
	
	public void setImgae(JLabel label) {
		
		java.net.URL url = ViewTrangChu.class.getResource("bia2.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		label.setIcon(newIcon);
		

		java.net.URL url2 = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img2 = Toolkit.getDefaultToolkit().createImage(url2);
		
		this.setIconImage(img2);
		
	}
	
	
	public void LienHe() {
		
		String sdt = "0378298920";
		String email = "minhquansn2011@gmail.com";
		
		JOptionPane.showMessageDialog(ViewTrangChu.this, "Liên hệ số điện thoại: "+sdt+"\nEmail: " + email);
		
	}
}
