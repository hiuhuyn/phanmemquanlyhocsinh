package CSDL_sqlSv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.HocSinh;
import model.HocSinh;

public class HocSinhDAO implements DAOInterface<HocSinh>{
	
	public static HocSinhDAO getHocSinhDAO() {
		return new HocSinhDAO();
	}

	@Override
	public int insert(HocSinh t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "insert into HocSinh(MaHS, HoTenHS, MaLop, "
					+ "NgaySinh, GioiTinh, SDT_LL, DanToc, "
					+ "NoiSinh, DiaChi, TenPhuHuynh, NgheNghiep, TieuHoc) "
					+ "values(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaHS());
			psm.setNString(2, t.getHoTen());
			psm.setString(3, t.getMaLop());
			psm.setDate(4, (Date) t.getNgaySinh());
			psm.setNString(5, t.getGioiTinh());
			psm.setString(6, t.getSdt_LienLac());
			psm.setNString(7, t.getDanToc());
			psm.setNString(8, t.getNoiSinh());
			psm.setNString(9, t.getDiaChi());
			psm.setNString(10, t.getHoten_PhuHuynh() );
			psm.setNString(11, t.getNgheNnghiep());
			psm.setNString(12, t.getChuongTrinhTieuHoc());
			
			
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(HocSinh t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "update HocSinh"
					+ " set HoTenHS = ?, MaLop =?,"
					+ "NgaySinh = ?, GioiTinh = ?, SDT_LL = ?, DanToc = ?, "
					+ "NoiSinh = ?, DiaChi = ?, TenPhuHuynh =?, NgheNghiep = ?, TieuHoc =?"
					+ " where MaHS = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			
			psm.setNString(1, t.getHoTen());
			psm.setString(2, t.getMaLop());
			psm.setDate(3, (Date) t.getNgaySinh());
			psm.setNString(4, t.getGioiTinh());
			psm.setString(5, t.getSdt_LienLac());
			psm.setNString(6, t.getDanToc());
			psm.setNString(7, t.getNoiSinh());
			psm.setNString(8, t.getDiaChi());
			psm.setNString(9, t.getHoten_PhuHuynh() );
			psm.setNString(10, t.getNgheNnghiep());
			psm.setNString(11, t.getChuongTrinhTieuHoc());
			psm.setString(12, t.getMaHS());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(HocSinh t) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtil.getConnection();
			
			String sql = "delete from HocSinh"
					+ " where MaHS = ?";
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaHS());
			
			int kq = psm.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<HocSinh> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<HocSinh> list = new ArrayList<HocSinh>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from HocSinh";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maHocSinh = rSet.getString("MaHS");
				String hoTenHS = rSet.getNString("HoTenHS");
				String lop = rSet.getString("MaLop");
				Date ngayDate = rSet.getDate("NgaySinh");
				
				String gioiTinh = rSet.getNString("GioiTinh");
				String sdt = rSet.getString("SDT_LL");
				String danToc = rSet.getNString("DanToc");
				String noiSinh = rSet.getNString("NoiSinh");
				String diaChi = rSet.getNString("DiaChi");
				String phuHuynh = rSet.getNString("TenPhuHuynh");
				String nghenghiep = rSet.getNString("NgheNghiep");
				String tieuhoc = rSet.getNString("TieuHoc");
				
				
				HocSinh HocSinh = new HocSinh(maHocSinh,  hoTenHS,lop, ngayDate, 
						gioiTinh, sdt, danToc, noiSinh, diaChi, phuHuynh, nghenghiep, tieuhoc);
				list.add(HocSinh);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HocSinh selectById(HocSinh t) {
		// TODO Auto-generated method stub
		HocSinh hocSinh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from HocSinh where MaHS= ?";
			
			PreparedStatement psm = connection.prepareStatement(sql);
			psm.setString(1, t.getMaHS());
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maHocSinh = rSet.getString("MaHS");
				String hoTenHS = rSet.getNString("HoTenHS");
				String lop = rSet.getString("MaLop");
				Date ngayDate = rSet.getDate("NgaySinh");
				
				String gioiTinh = rSet.getNString("GioiTinh");
				String sdt = rSet.getString("SDT_LL");
				String danToc = rSet.getNString("DanToc");
				String noiSinh = rSet.getNString("NoiSinh");
				String diaChi = rSet.getNString("DiaChi");
				String phuHuynh = rSet.getNString("TenPhuHuynh");
				String nghenghiep = rSet.getNString("NgheNghiep");
				String tieuhoc = rSet.getNString("TieuHoc");
				hocSinh = new HocSinh(maHocSinh,  hoTenHS,lop, ngayDate, 
						gioiTinh, sdt, danToc, noiSinh, diaChi, phuHuynh, nghenghiep, tieuhoc);
				
				
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hocSinh;
	}

	@Override
	public ArrayList<HocSinh> selectByCondition(String condition) {
		ArrayList<HocSinh> list = new ArrayList<HocSinh>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "select * from HocSinh where " + condition;
			
			PreparedStatement psm = connection.prepareStatement(sql);
			
			ResultSet rSet = psm.executeQuery();
			
			while(rSet.next()) {
				String maHocSinh = rSet.getString("MaHS");
				String hoTenHS = rSet.getNString("HoTenHS");
				String lop = rSet.getString("MaLop");
				Date ngayDate = rSet.getDate("NgaySinh");
				
				String gioiTinh = rSet.getNString("GioiTinh");
				String sdt = rSet.getString("SDT_LL");
				String danToc = rSet.getNString("DanToc");
				String noiSinh = rSet.getNString("NoiSinh");
				String diaChi = rSet.getNString("DiaChi");
				String phuHuynh = rSet.getNString("TenPhuHuynh");
				String nghenghiep = rSet.getNString("NgheNghiep");
				String tieuhoc = rSet.getNString("TieuHoc");
				
				HocSinh hocSinh = new HocSinh(maHocSinh,  hoTenHS,lop, ngayDate, 
						gioiTinh, sdt, danToc, noiSinh, diaChi, phuHuynh, nghenghiep, tieuhoc);
				
				list.add(hocSinh);
				
			}
			
			JDBCUtil.closeConnection(connection);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
