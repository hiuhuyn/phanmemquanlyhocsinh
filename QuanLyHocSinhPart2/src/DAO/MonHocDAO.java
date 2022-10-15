package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.MonHoc;

public class MonHocDAO implements DAOInterface<MonHoc> {
	
	public static MonHocDAO getMonHocDAO() {
		return new MonHocDAO();
	}

	@Override
	public int insert(MonHoc t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "insert into MonHoc(MaMon, TenMon)"
					+ " values(?, ?)";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaMon());
			psm.setNString(2, t.getTenMon());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(MonHoc t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "update MonHoc"
					+ " set TenMon = ?"
					+ " where MaMon = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setNString(1, t.getTenMon());
			psm.setString(2, t.getMaMon());
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(MonHoc t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "delete from MonHoc "
					+ " where MaMon = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaMon());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public ArrayList<MonHoc> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MonHoc> list = new ArrayList<MonHoc>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from MonHoc";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String tenMon = rSet.getNString("TenMon");
				
				MonHoc monHoc = new MonHoc(maMon, tenMon);
				list.add(monHoc);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MonHoc selectById(MonHoc t) {
		// TODO Auto-generated method stub
		MonHoc monHoc = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from MonHoc where MaMon= ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaMon());
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String tenMon = rSet.getNString("TenMon");
				
				monHoc = new MonHoc(maMon, tenMon);
				
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return monHoc;
	}

	@Override
	public ArrayList<MonHoc> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<MonHoc> list = new ArrayList<MonHoc>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from MonHoc where " + condition;
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String tenMon = rSet.getNString("TenMon");
				
				MonHoc monHoc = new MonHoc(maMon, tenMon);
				list.add(monHoc);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
}
	
	
	

}
