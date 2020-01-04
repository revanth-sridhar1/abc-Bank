package abcBank;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import abcBankcom.dao.*;

public class Query {

	private String custName;
	private String queryDate;
	private String query;
	private String status;
	private String response;
	
	public static void main(String userName, Scanner s) throws ClassNotFoundException, SQLException {
		System.out.printf("%n%n%32s%n%n","Query Response");
		System.out.println("1. History of Records");
		System.out.println("2. Queries to Respond");
		System.out.println("3. Queries Answered");
		System.out.print("\nEnter a value : ");
		Query q = new Query();
		String str = q.statusCollect(s.nextInt());
		q.setStatus(str);
		s.nextLine();
		QueryDAoImp qdi = new QueryDAoImp();
		List<Query> l = qdi.list(q);
		System.out.println();
		Iterator<Query> itr = l.iterator();
		int i = 1;
		while(itr.hasNext()) {
			q = itr.next();
			System.out.println(i + " " + q.custName + " " + q.queryDate + " \nquery: " + q.query + " \nstatus: " + q.status + " \nresponse: " + q.response);
			System.out.println();
			i++;
		}
		if(l.size()==0)
			System.out.println("No queries left");
		else {
			System.out.print("Enter Query No : ");
			int j = s.nextInt();
			s.nextLine();
			if(j<=l.size() && j>0) {
				q=l.get(j-1);
				if(q.getStatus().equals("responded")) {
					System.out.println("\nAlready responded");
					System.out.println(q.custName + " " + q.queryDate + " \nquery: " + q.query + " \nstatus: " + q.status + " \nresponse: " + q.response);
				}
				else {
					boolean b = qdi.update(q,s);
					if(b) {
						System.out.println("\nResponse entered");
						System.out.println(q.custName + " " + q.queryDate + " \nquery: " + q.query + " \nstatus: " + q.status + " \nresponse: " + q.response);
					}
				}
			}
			else {
				System.out.println("Invalid entry");
			}
		}
	}
	
	public String statusCollect(int i) {
		switch(i) {
		case 1:
			return "all";
		case 2:
			return "pending";
		case 3:
			return "responded";
		default:
			return "";
		}
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
