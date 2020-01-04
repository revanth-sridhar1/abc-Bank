package abcBankcom.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
	
	static Connection conn = null;
	
	public static Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String userName ="system";
		String password = "password";
		conn = DriverManager.getConnection(url,userName,password);
		return conn;
	}

}
