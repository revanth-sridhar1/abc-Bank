package abcBankcom.dao;

import abcBank.Home;
import abcBankcom.jdbc.Connectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeDaoImp {
	
	public boolean checkData(Home h) throws ClassNotFoundException,SQLException{
		boolean result = false;
		ResultSet rs = null;
		String str="abc";
		Connection conn = Connectivity.connect();
		Statement s = conn.createStatement();
		String query = "select * from  login where username='" + h.getUserName()+"'";
		rs = s.executeQuery(query);
		while(rs.next())
			str = rs.getString(2);
		if(str.equals(h.getPassword()))
			result = true;
		return 	result;
	}

}
