package CSDL_sqlSv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TaiKhoan;

public class TaiKhoanDAO implements DAOInterface<TaiKhoan>{
	
	public static TaiKhoanDAO getTaiKhoanDAO() {
		return new TaiKhoanDAO();
	}
	

	@Override
	public int insert(TaiKhoan t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TaiKhoan t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection =JDBCUtil.getConnection();
			String sql = "update TaiKhoan set Pass = ?, Hoten = ?, Sdt = ?, Email = ? where UserName = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getPass());
			psm.setNString(2, t.getHoten());
			psm.setString(3, t.getSdt());
			psm.setString(4, t.getEmail());
			psm.setString(5, t.getUser());
			
			int kq = psm.executeUpdate();
			JDBCUtil.closeConnection(connection);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}

	@Override
	public int delete(TaiKhoan t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection =JDBCUtil.getConnection();
			String sql = "delete from TaiKhoan where UserName = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			psm.setString(1, t.getUser());
			
			int kq = psm.executeUpdate();
			JDBCUtil.closeConnection(connection);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

	@Override
	public ArrayList<TaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan selectById(TaiKhoan t) {
		// TODO Auto-generated method stub
		TaiKhoan taiKhoan = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from TaiKhoan where UserName = ? and Pass = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getUser());
			psm.setString(2, t.getPass());
			ResultSet  rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String user = rSet.getString("UserName");
				String pass = rSet.getString("Pass");
				String hoten = rSet.getNString("Hoten");
				String sdt = rSet.getString("Sdt");
				String email = rSet.getString("Email");
				
				taiKhoan = new TaiKhoan(user, pass, hoten, sdt, email);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return taiKhoan;
	}
	@Override
	public ArrayList<TaiKhoan> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
