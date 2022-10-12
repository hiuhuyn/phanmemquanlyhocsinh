package CSDL_sqlSv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Lop;
import model.Lop;

public class LopDAO implements DAOInterface<Lop> {
	
	public static LopDAO getLopDAO() {
		return new LopDAO();
	}

	@Override
	public int insert(Lop t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "insert into Lop(MaLop, TenLop, SiSo)"
					+ " values(?, ?, ?)";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaLop());
			psm.setNString(2, t.getTenLop());
			psm.setInt(3, t.getSiSo());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Lop t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "update Lop"
					+ " set TenLop = ?, SiSo = ?"
					+ " where MaLop = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(3, t.getMaLop());
			psm.setNString(1, t.getTenLop());
			psm.setInt(2, t.getSiSo());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(Lop t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "delete from Lop"
					+ " where MaLop = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaLop());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Lop> selectAll() {
		ArrayList<Lop> list = new ArrayList<Lop>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from Lop";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maLop = rSet.getString("maLop");
				String TenLop = rSet.getNString("TenLop");
				int Siso = rSet.getInt("SiSo");
				
				Lop lop = new Lop(maLop, TenLop, Siso);
				list.add(lop);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Lop selectById(Lop t) {
		// TODO Auto-generated method stub
		Lop lop = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from Lop where MaLop= ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaLop());
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maLop = rSet.getString("MaLop");
				String TenLop = rSet.getNString("TenLop");
				int Siso = rSet.getInt("SiSo");
				lop = new Lop(maLop, TenLop, Siso);
				
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lop;
	}

	@Override
	public ArrayList<Lop> selectByCondition(String condition) {
		ArrayList<Lop> list = new ArrayList<Lop>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from Lop where " + condition;
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maLop = rSet.getString("maLop");
				String TenLop = rSet.getNString("TenLop");
				int Siso = rSet.getInt("SiSo");
				Lop lop = new Lop(maLop, TenLop, Siso);
				list.add(lop);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
