package CSDL_sqlSv;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.Properties;


public class JDBCUtil {
	
	private static String database = "QLHS";
	private static String userName = "";
	private static String password = "";
	
	
	
	public static void setConnection(String database, String userName, String password) {
	
		JDBCUtil.database = database;
		JDBCUtil.userName = userName;
		JDBCUtil.password = password;
		
		
	}
	
	// ket noi csdl
	public static Connection getConnection() {
		
		Connection connection = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String dbURL = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName="+ database +";integratedSecurity=true;";

			connection = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("Ket noi thanh cong");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi ket noi");
			
			e.printStackTrace();
		}
        return connection;
    }
	

	
	
	
	// ngat ket noi
	public static void closeConnection(Connection connection) {
		
		try {
			if(connection!=null) {
				connection.close();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
