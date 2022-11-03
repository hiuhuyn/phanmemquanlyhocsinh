package DAO;

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
		
		try {
			
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into TaiKhoan( UserName, Pass, Hoten, Sdt, Email, Quyen ) "
					+ " values( ?, ?, ?, ?, ?, ? )";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getUser());
			psm.setString(2, t.getPass());
			psm.setNString(3, t.getHoten());
			psm.setString(4, t.getSdt());
			psm.setString(5, t.getEmail());
			psm.setString(6, t.getQuyenTruyCap());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		return 0;
	}

	@Override
	public int update(TaiKhoan t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection =JDBCUtil.getConnection();
			String sql = "update TaiKhoan set Pass = ?, Hoten = ?, Sdt = ?, Email = ?, Quyen = ?  where UserName = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getPass());
			psm.setNString(2, t.getHoten());
			psm.setString(3, t.getSdt());
			psm.setString(4, t.getEmail());
			psm.setString(5, t.getQuyenTruyCap());
			psm.setString(6, t.getUser());
			
			
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
		ArrayList<TaiKhoan> taiKhoans = new ArrayList<TaiKhoan>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from TaiKhoan";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			ResultSet resultSet = psm.executeQuery();
			
			while(resultSet.next()) {
				String user = resultSet.getString("UserName");
				String pass = resultSet.getString("Pass");
				String hoten = resultSet.getNString("Hoten");
				String sdt = resultSet.getString("SDT");
				String email = resultSet.getString("Email");
				String quyen = resultSet.getString("Quyen");
				
				TaiKhoan taiKhoan = new TaiKhoan(user, pass, hoten, sdt, email, quyen);
				taiKhoans.add(taiKhoan);
				
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		return taiKhoans;
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
				String quyen = rSet.getString("Quyen");
				
				taiKhoan = new TaiKhoan(user, pass, hoten, sdt, email, quyen);

			}
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return taiKhoan;
	}
	@Override
	public ArrayList<TaiKhoan> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<TaiKhoan> taiKhoans = new ArrayList<TaiKhoan>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from TaiKhoan where " + condition;
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			
			ResultSet resultSet = psm.executeQuery();
			
			while(resultSet.next()) {
				String user = resultSet.getString("UserName");
				String pass = resultSet.getString("Pass");
				String hoten = resultSet.getNString("Hoten");
				String sdt = resultSet.getString("SDT");
				String email = resultSet.getString("Email");
				String quyen = resultSet.getString("Quyen");
				
				TaiKhoan taiKhoan = new TaiKhoan(user, pass, hoten, sdt, email, quyen);
				taiKhoans.add(taiKhoan);
				
				
			}
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		return taiKhoans;
	}
	
	
	
	

}
