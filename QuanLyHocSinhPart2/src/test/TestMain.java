package test;

import javax.swing.UIManager;

import CSDL_sqlSv.JDBCUtil;
import view.ViewLogin;
import view.ViewTrangChu;

/**
 * @author minhq
 *
 */
public class TestMain {
	
	public static void main(String[] args) {
		try {
			
			
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
//			ViewTrangChu viewTrangChu = new ViewTrangChu();
//			viewTrangChu.setVisible(true);

			ViewLogin.getViewLogin().setVisible(true);


			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
