package run;

import javax.swing.UIManager;

import DAO.JDBCUtil;
import view.ViewLogin;
import view.ViewTrangChu;

/**
 * @author minhq
 *
 */
public class RunApp {
	
	public static void main(String[] args) {
		try {			
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ViewLogin.getViewLogin().setVisible(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
