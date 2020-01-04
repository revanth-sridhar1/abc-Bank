package abcBankcom.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abcBank.Query;
import abcBankcom.jdbc.Connectivity;

public class QueryDAoImp {

	public List<Query> list(Query q) throws ClassNotFoundException,SQLException{
		ResultSet rs = null;
		Connection conn = Connectivity.connect();
		List<Query> list = new ArrayList<Query>();
		Statement st = conn.createStatement();
		String query;
		if(q.getStatus().equals("all"))
			query = "select * from query";
		else 
			query = "select * from query where status ='" + q.getStatus() + "'";
		rs = st.executeQuery(query);
		while(rs.next()) {
			Query v = new Query();
			v.setCustName(rs.getString("custname"));
			v.setQueryDate(rs.getString("querydate"));
			v.setQuery(rs.getString("query"));
			v.setStatus(rs.getString("status"));
			v.setResponse(rs.getString("response"));
			list.add(v);
		}
		return list;
	}
	
	public boolean update(Query q, Scanner s) throws ClassNotFoundException,SQLException{
		int i=0;
		boolean b =false;
		Connection conn = Connectivity.connect();
		Statement st = conn.createStatement();
		System.out.print("Enter Response : ");
		q.setResponse(s.nextLine());
		q.setStatus("responded");
		String query = "update query set status = 'responded', response ='" + q.getResponse() + "' where custName='" + q.getCustName() + "' and query='" + q.getQuery() + "'";
		i=st.executeUpdate(query);
		if(i>=0) {
			b=true;
		}
		return b;
	}
	
}
