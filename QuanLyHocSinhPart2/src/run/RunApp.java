package run;

import java.util.ArrayList;

import javax.swing.UIManager;

import DAO.HocSinhDAO;
import DAO.JDBCUtil;
import model.HocKy;
import model.HocSinh;
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
