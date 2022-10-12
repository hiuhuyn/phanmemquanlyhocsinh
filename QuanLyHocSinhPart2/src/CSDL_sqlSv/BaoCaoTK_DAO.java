package CSDL_sqlSv;

import java.sql.Connection;
import java.util.ArrayList;

public class BaoCaoTK_DAO implements DAOInterface<BaoCaoTK_DAO>{

	@Override
	public int insert(BaoCaoTK_DAO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BaoCaoTK_DAO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BaoCaoTK_DAO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BaoCaoTK_DAO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaoCaoTK_DAO selectById(BaoCaoTK_DAO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BaoCaoTK_DAO> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		
		ArrayList<BaoCaoTK_DAO> list = new ArrayList<BaoCaoTK_DAO>();
		
		try {
			
			Connection connection = JDBCUtil.getConnection();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return null;
	}

}
