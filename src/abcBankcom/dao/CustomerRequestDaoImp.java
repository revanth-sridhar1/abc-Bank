package abcBankcom.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import abcBank.*;
import abcBankcom.jdbc.Connectivity;

public class CustomerRequestDaoImp {

	public List<LostStolenCard> display(LostStolenCard lsc) throws ClassNotFoundException, SQLException {
		Connection conn = Connectivity.connect();
		List<LostStolenCard> list = new ArrayList<LostStolenCard>();
		Statement st = conn.createStatement();
		String query;
		if(lsc.getStatus().equals("all"))
		query = "select * from customerrequest where request = '" + lsc.getRequest() +"'";
		else
		query = "select * from cutomerrequest where request = '" + lsc.getRequest() +"' and status = '" +  lsc.getStatus() + "'";
		ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					LostStolenCard v = new LostStolenCard();
					v.setRequest(rs.getString(1));
					v.setStatus(rs.getString(2));
					v.setCardNo(rs.getInt(3));
					v.setCardType(rs.getString(4));
					v.setResponse(rs.getString(5));
					list.add(v);
				}
		return list;
		}


	public List<DisputedTransaction> display(DisputedTransaction dt) throws ClassNotFoundException, SQLException {
		Connection conn = Connectivity.connect();
		List<DisputedTransaction> list = new ArrayList<DisputedTransaction>();
		Statement st = conn.createStatement();
		String query;
		if(dt.getStatus().equals("all"))
		query = "select * from customerrequest where request = '" + dt.getRequest() +"'";
		else
		query = "select * from cutomerrequest where request = '" + dt.getRequest() +"' and status = '" +  dt.getStatus() + "'";
		ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DisputedTransaction v = new DisputedTransaction();
					v.setRequest(rs.getString(1));
					v.setStatus(rs.getString(2));
					v.setCustName(rs.getString(3));
					v.setMerhName(rs.getString(4));
					v.setCardNo(rs.getInt(5));
					v.setDateOfTransaction(rs.getString(6));
					v.setAmtDisputed(rs.getInt(7));
					v.setReason(rs.getString(8));
					v.setResponse(rs.getString(9));
					list.add(v);
				}
		return list;
		}	

	
	public List<addOnCard> display(addOnCard aoc) throws ClassNotFoundException, SQLException {
		Connection conn = Connectivity.connect();
		List<addOnCard> list = new ArrayList<addOnCard>();
		Statement st = conn.createStatement();
		String query;
		if(aoc.getStatus().equals("all"))
		query = "select * from customerrequest where request = '" + aoc.getRequest() +"'";
		else
		query = "select * from cutomerrequest where request = '" + aoc.getRequest() +"' and status = '" +  aoc.getStatus() + "'";
		ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					addOnCard v = new addOnCard();
					v.setRequest(rs.getString(1));
					v.setStatus(rs.getString(2));
					v.setAcoountNo(rs.getInt(3));
					v.setCustName(rs.getString(4));
					v.setReqDate(rs.getString(5));
					v.setCardname(rs.getString(6));
					v.setResponse(rs.getString(7));
					list.add(v);
				}
		return list;
		}


	public List<ChequeBookRequest> display(ChequeBookRequest cbr) throws ClassNotFoundException, SQLException {
		Connection conn = Connectivity.connect();
		List<ChequeBookRequest> list = new ArrayList<ChequeBookRequest>();
		Statement st = conn.createStatement();
		String query;  
		if(cbr.getStatus().equals("all"))
			query = "select * from customerrequest where request='" + cbr.getRequest() +"'";	
		else
			query = "select * from customerrequest where request = '" + cbr.getRequest() + "'and status ='" + cbr.getStatus() +"'";
		ResultSet rs = null;
		rs = st.executeQuery(query);
				while(rs.next()) {
					ChequeBookRequest v = new ChequeBookRequest();
					v.setRequest(rs.getString("request"));
					v.setStatus(rs.getString("status"));
					v.setAccountNo(rs.getInt("accountno"));
					v.setCustName(rs.getString("custname"));
					v.setReqDate(rs.getString("requestdate"));
					v.setCardName(rs.getString("cardname"));
					v.setReason(rs.getString("reason"));
					list.add(v);
				}
		return list;
		}
	
	public List<IncreaseCreditLimit> display(IncreaseCreditLimit icl) throws ClassNotFoundException, SQLException {
		Connection conn = Connectivity.connect();
		List<IncreaseCreditLimit> list = new ArrayList<IncreaseCreditLimit>();
		Statement st = conn.createStatement();
		String query;
		if(icl.getStatus().equals("all"))
			query = "select * from customerrequest where request = '" + icl.getRequest() +"'";
		else
			query = "select * from cutomerrequest where request = '" + icl.getRequest() +"' and status = '" +  icl.getStatus() + "'";
		ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					IncreaseCreditLimit v = new IncreaseCreditLimit();
 					v.setRequest(rs.getString(1));
					v.setStatus(rs.getString(2));
					v.setName(rs.getString(3));
					v.setCardType(rs.getString(4));
					v.setCardNo(rs.getInt(5));
					v.setCurrCreditLimit(rs.getInt(6));
					v.setMaxCreditLimit(rs.getInt(7));
					v.setReqCreditLimit(rs.getInt(8));
					v.setAppCreditLimit(rs.getInt(9));
					v.setResponse(rs.getString(10));
					list.add(v);
				}
		return list;
		}	
	
}
