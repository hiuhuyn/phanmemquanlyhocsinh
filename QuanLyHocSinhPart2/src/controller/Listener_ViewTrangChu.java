package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewTrangChu;

public class Listener_ViewTrangChu implements ActionListener{
	
	private ViewTrangChu viewTrangChu;
	

	public Listener_ViewTrangChu(ViewTrangChu viewTrangChu) {
		super();
		this.viewTrangChu = viewTrangChu;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		
		if(src.equals("Hồ sơ học sinh")) {
			viewTrangChu.getPanelMain().removeAll();
			viewTrangChu.getPanelMain().add(viewTrangChu.getPanel_QLHS());
			viewTrangChu.getPanelMain().revalidate();
			viewTrangChu.getPanelMain().repaint();
			
		}else if (src.equals("Danh sách các lớp")) {
			viewTrangChu.getPanelMain().removeAll();
			viewTrangChu.getPanelMain().add(viewTrangChu.getPanel_QLDSLop());
			viewTrangChu.getPanelMain().revalidate();
			viewTrangChu.getPanelMain().repaint();
			
		}else if (src.equals("Bảng điểm môn")) {
			viewTrangChu.getPanelMain().removeAll();
			viewTrangChu.getPanelMain().add(viewTrangChu.getPanel_BangDiem());
			viewTrangChu.getPanelMain().revalidate();
			viewTrangChu.getPanelMain().repaint();
			
		}else if (src.equals("Danh sách học sinh theo lớp")) {
			viewTrangChu.getPanelMain().removeAll();
			viewTrangChu.getPanelMain().add(viewTrangChu.getPanel_DSHocSinhTheoLop());
			viewTrangChu.getPanelMain().revalidate();
			viewTrangChu.getPanelMain().repaint();
				
		}else if (src.equals("Thống kê theo lớp")) {
			viewTrangChu.getPanelMain().removeAll();
			viewTrangChu.getPanelMain().add(viewTrangChu.getPanel_BaoCaoTk());
			viewTrangChu.getPanelMain().revalidate();
			viewTrangChu.getPanelMain().repaint();
			
		}else if (src.equals("Môn học")) {
			viewTrangChu.getFrameMonHoc().setVisible(true);
		}else if (src.equals("Học kỳ")) {
			viewTrangChu.getFrameHocKy().setVisible(true);
		}else if(src.equals("Hướng dẫn")) {
			viewTrangChu.getJframeHuongDan().setVisible(true);
			
		}else if(src.equals("Liên hệ")) {
			viewTrangChu.LienHe();
		}else if(src.equals("Thông tin tài khoản")) {
			viewTrangChu.getTtTaiKhoan().setVisible(true);;
			
		}else if (src.equals("Đổi mật khẩu")) {
			viewTrangChu.getDoiPass().setVisible(true);
		}
		
		
	}
	
}
