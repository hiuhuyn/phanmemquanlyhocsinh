package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DiemMon;
import model.DiemMon;

public class DiemMonDAO implements DAOInterface<DiemMon>{
	
	public static DiemMonDAO getDiemMonDAO() {
		return new DiemMonDAO();
	}

	@Override
	public int insert(DiemMon t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try { 
			connection = JDBCUtil.getConnection();
			
			String sql = "insert into DiemMon(MaMon, MaHS, MaHK, "
					+ "DiemMieng, Diem15p, Diem1tiet, DiemThi, DiemTBmon) "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMonHoc());
			psm.setString(2, t.getHocSinh());
			psm.setString(3, t.getHocKy());
			
			psm.setFloat(4, t.getDiemMieng());
			psm.setFloat(5, t.getDiem15p());
			psm.setFloat(6, t.getDiem1Tiet());
			psm.setFloat(7, t.getDiemThi());
			psm.setFloat(8, t.getDiemTBmon());
			
			
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(DiemMon t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "update DiemMon"
					+ " set DiemMieng= ?, Diem15p= ?, Diem1tiet= ?, "
					+ "DiemThi= ?, DiemTBmon= ?"
					+ " where MaMon = ? AND MaHS = ? AND MaHK = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			
			
			psm.setFloat(1, t.getDiemMieng());
			psm.setFloat(2, t.getDiem15p());
			psm.setFloat(3, t.getDiem1Tiet());
			psm.setFloat(4, t.getDiemThi());
			psm.setFloat(5, t.getDiemTBmon());
			
			psm.setString(6, t.getMonHoc());
			psm.setString(7, t.getHocSinh());
			psm.setNString(8, t.getHocKy());
			
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(DiemMon t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "delete from DiemMon"
					+ " where MaMon = ? AND MaHS = ? AND MaHK = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMonHoc());
			psm.setString(2, t.getHocSinh());
			psm.setNString(3, t.getHocKy());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<DiemMon> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<DiemMon> list = new ArrayList<DiemMon>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from DiemMon";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String maHS = rSet.getString("MaHS");
				String maHK = rSet.getString("MaHK");
				
								
				float mieng = rSet.getFloat("DiemMieng");
				float diem15p = rSet.getFloat("Diem15p");
				float diem1tiet = rSet.getFloat("Diem1tiet");
				float diemthi = rSet.getFloat("DiemThi");
				
				
				DiemMon diemMon = new DiemMon(maMon, maHS, maHK,
						mieng, diem15p, diem1tiet, diemthi);
				
				
				list.add(diemMon);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DiemMon selectById(DiemMon t) {
		// TODO Auto-generated method stub
		DiemMon diemMon = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from DiemMon "
					+ "where MaMon = ? AND MaHS = ? AND MaHK = ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMonHoc());
			psm.setString(2, t.getHocSinh());
			psm.setString(3, t.getHocKy());
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String maHS = rSet.getString("MaHS");
				String maHK = rSet.getString("MaHK");
				
				float mieng = rSet.getFloat("DiemMieng");
				float diem15p = rSet.getFloat("Diem15p");
				float diem1tiet = rSet.getFloat("Diem1tiet");
				float diemthi = rSet.getFloat("DiemThi");

				diemMon = new DiemMon(maMon, maHS, maHK,
						mieng, diem15p, diem1tiet, diemthi);

			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return diemMon;
	}

	@Override
	public ArrayList<DiemMon> selectByCondition(String condition) {
		ArrayList<DiemMon> list = new ArrayList<DiemMon>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from DiemMon where " + condition;
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maMon = rSet.getString("MaMon");
				String maHS = rSet.getString("MaHS");
				String maHK = rSet.getString("MaHK");
//				
				float mieng = rSet.getFloat("DiemMieng");
				float diem15p = rSet.getFloat("Diem15p");
				float diem1tiet = rSet.getFloat("Diem1tiet");
				float diemthi = rSet.getFloat("DiemThi");
				

				DiemMon diemMon = new DiemMon(maMon, maHS, maHK, 
						mieng, diem15p, diem1tiet, diemthi);
				list.add(diemMon);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}
