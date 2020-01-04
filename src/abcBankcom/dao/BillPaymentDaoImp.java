package abcBankcom.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import abcBank.BillPayment;
import abcBankcom.jdbc.Connectivity;

public class BillPaymentDaoImp {
	
	public List<BillPayment> list(BillPayment b) throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		Connection conn = Connectivity.connect();
		List<BillPayment> list = new ArrayList<BillPayment>();
		Statement st = conn.createStatement();
		String query;
		if(b.getBillerid()==-1 && b.getAccountNumber()==-1) {
			query = "select * from billpayment";
		}
		else if(b.getAccountNumber()==-1) {
			query = "select * from billpayment where billid = '" + b.getBillerid() + "'";
		}
		else if(b.getBillerid()==-1) {
			query = "select * from billpayment where accno = '" + b.getAccountNumber() + "'";
		}
		else {
			query = "select * from billpayment where billid = '" + b.getBillerid() + "' and accno = '" + b.getAccountNumber() + "'";
		}
		rs = st.executeQuery(query);
		while(rs.next()) {
			BillPayment v = new BillPayment();
			v.setBillerid(rs.getInt("billid"));
			v.setAccountNumber(rs.getInt("accno"));
			v.setAccountBalance(rs.getInt("accbal"));
			v.setBillAmount(rs.getInt("billamt"));
			list.add(v);
		}
		return list;
		
	}
	
	public boolean update(BillPayment bp) throws ClassNotFoundException,SQLException{
		int i=0;
		boolean b =false;
		Connection conn = Connectivity.connect();
		Statement st = conn.createStatement();
		String query = "update billpayment set accbal =" + bp.getAccountBalance() + ", billamt =" + bp.getBillAmount() + " where billid = " + bp.getBillerid() + " and accno = " + bp.getAccountNumber();
		String query2 = "update billpayment set accbal =" + bp.getAccountBalance() + " where accno =" + bp.getAccountNumber();
		i=st.executeUpdate(query);
		st.executeUpdate(query2);
		if(i>=0) {
			b=true;
		}
		return b;
	}
	
	
	
}
