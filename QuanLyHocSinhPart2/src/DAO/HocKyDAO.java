package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import model.HocKy;

public class HocKyDAO implements DAOInterface<HocKy> {
	
	public static HocKyDAO getHocKyDAO() {
		return new HocKyDAO();
		
	}
	

	@Override
	public int insert(HocKy t) {
		Connection connection = null;
		try {
			// b1 tao ket noi den csdl
			connection = JDBCUtil.getConnection();
			
			
			
			String sql = "INSERT INTO HocKy(MaHK, TenHK, NamBatDau, NamKetThuc)"
					+ " values(?, ?, ? , ?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			// chuyen du lieu vao dau ?
			pst.setString(1, t.getMaHK());
			pst.setString(2, t.getTenHK());
			pst.setInt(3, t.getNamBatDau());
			pst.setInt(4, t.getNamKetThuc());
			
			int KetQua = pst.executeUpdate();
			
			// dong connection
			JDBCUtil.closeConnection(connection);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(HocKy t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = JDBCUtil.getConnection();
			
//			Statement stm = connection.createStatement();
//			
//			String sql = "update HocKy"
//					+ " set TenHK= N'" + t.getTenHK() + "'"
//					+ " where MaHK= '" + t.getMaHK() + "';";
//			
//			int kq = stm.executeUpdate(sql);
			
			String sql = "update HocKy"
					+ " set TenHK = ?, NamBatDau = ?, NamKetThuc = ? "
					+ " where MaHk= ? ;";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			// chuyen du lieu vao dau ?
			pst.setString(1, t.getTenHK());
			pst.setString(2, t.getMaHK());
			pst.setInt(3, t.getNamBatDau());
			pst.setInt(4, t.getNamKetThuc());
			
			int KetQua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int delete(HocKy t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = JDBCUtil.getConnection();
			
			Statement stm = connection.createStatement();
			
			String sql = "delete from HocKy"
					+ " where MaHK= ?;";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			// chuyen du lieu vao dau ?
			pst.setString(1, t.getMaHK());
			
			int KetQua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0; 
	}

	@Override
	public ArrayList<HocKy> selectAll() {
		// lấy toàn bộ dữ liệu bảng hoc ky
		
		// TODO Auto-generated method stub
		ArrayList<HocKy> ketQua = new ArrayList<HocKy>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng 
			String sql = "SELECT * FROM HocKy";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maHK = rs.getString("MaHK");
				String tenHK = rs.getString("TenHK");
				int namdau = rs.getInt("NamBatDau");
				int namKet = rs.getInt("NamKetThuc");
				
				HocKy HocKy = new HocKy(maHK, tenHK, namdau, namKet);
				ketQua.add(HocKy);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
		
		
		
	}

	@Override
	public HocKy selectById(HocKy t) {
		// lay du lieu của doi tuong hoc ky với diều kiện mã học kì == nhau
		
		// TODO Auto-generated method stub
		HocKy ketQua = null;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from HocKy where MaHK= ?";
			
			PreparedStatement ptm = connection.prepareStatement(sql);
			ptm.setString(1, t.getMaHK());
			
			ResultSet rs = ptm.executeQuery();
			
			while(rs.next()) {
				String maHK = rs.getString("MaHK");
				String tenHK = rs.getString("TenHK");
				int namdau = rs.getInt("NamBatDau");
				int namKet = rs.getInt("NamKetThuc");
				
				ketQua = new HocKy(maHK, tenHK, namdau, namKet);
				 
				
			}
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<HocKy> selectByCondition(String condition) {
		// lấy danh sách đối tượng với Điều kiện nhập vào là condition
		
		ArrayList<HocKy> ketQua = new ArrayList<HocKy>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng 
			String sql = "SELECT * FROM HocKy where " + condition;
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String maHK = rs.getString("MaHK");
				String tenHK = rs.getString("TenHK");
				int namdau = rs.getInt("NamBatDau");
				int namKet = rs.getInt("NamKetThuc");
				
				HocKy HocKy = new HocKy(maHK, tenHK, namdau, namKet);
				
				ketQua.add(HocKy);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
		
	
	}


	

}
