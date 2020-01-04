package abcBank;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import abcBankcom.dao.*;

public class CustomerRequest {
		
	protected String request;
	protected String status;
	
	public static void main(Scanner s) throws ClassNotFoundException, SQLException {	
		CustomerRequest c = new CustomerRequest(); 
		int req = c.reqType(s);
		c.request = c.setRequest(req);
		int stat = c.status(s);
		c.status = c.setStatus(stat);
		CustomerRequestDaoImp cri = new CustomerRequestDaoImp();
		
		if(c.request.equals("chequebookrequest")) {
			ChequeBookRequest cbr = new ChequeBookRequest();
			cbr.setRequest(c.getRequest());
			cbr.setStatus(c.getStatus());
			List<ChequeBookRequest> l = cri.display(cbr);
			Iterator<ChequeBookRequest> itr = l.iterator();
			while(itr.hasNext()) {
				cbr = itr.next();
				System.out.println(cbr.getRequest() + " " + cbr.getStatus() + " " + cbr.getAccountNo() + " " + cbr.getCustName() + " " + cbr.getReqDate() + " " + cbr.getCardName() + " " + cbr.getReason());
			}
			
		}
		
		if(c.request.equals("disputedtransactions")) {
			DisputedTransaction dt = new DisputedTransaction();
			List<DisputedTransaction> l = cri.display(dt);
			Iterator<DisputedTransaction> itr = l.iterator();
			while(itr.hasNext()) {
				dt = itr.next();
				System.out.println(dt.request + " " + dt.status + " " + dt.getCustName() + " " + dt.getMerhName() + " " + dt.getCardNo() + " " + dt.getDateOfTransaction() + " " + dt.getAmtDisputed() + " " + dt.getReason() + " " + dt.getResponse()) ;
			}
		}
		
		if(c.request.equals("addoncard")) {
			addOnCard aoc = new addOnCard();
			List<addOnCard> l = cri.display(aoc);
			Iterator<addOnCard> itr = l.iterator();
			while(itr.hasNext()) {
				aoc = itr.next();
				System.out.println(aoc.request + " " + aoc.status + " " + aoc.getAcoountNo() + " " + aoc.getCustName() + " " + aoc.getReqDate() + " " + aoc.getCardname() + " " + aoc.getResponse());
			}
		}
		
		if(c.request.equals("loststolencard")) {
			LostStolenCard lsc = new LostStolenCard();
			List<LostStolenCard> l = cri.display(lsc);
			Iterator<LostStolenCard> itr = l.iterator();
			while(itr.hasNext()) {
				lsc = itr.next();
				System.out.println(lsc.request + " " + lsc.status + " " + lsc.getCardNo() + " " + lsc.getCardType() + " " + lsc.getResponse());
			}
		}
			
		if(c.request.equals("increasecreditlimit")) {
			IncreaseCreditLimit icl = new IncreaseCreditLimit();
			List<IncreaseCreditLimit> l = cri.display(icl);
			Iterator<IncreaseCreditLimit> itr = l.iterator();
			while(itr.hasNext()) {
				icl = itr.next();
				System.out.println(icl.request + " " + icl.status + " " + icl.getName() + " " + icl.getCardType() + " " + icl.getCardNo() + " " + icl.getCurrCreditLimit() + " " + icl.getMaxCreditLimit() + " " + icl.getReqCreditLimit() + " " + icl.getAppCreditLimit() + " " + icl.getResponse());
			}
		}
		
		
	}
	
	private int reqType(Scanner s){
		System.out.println("\n\n          List of Customer Requests\n\n");
		System.out.println("1. Cheque Book Request");
		System.out.println("2. Disputed Transactions");
		System.out.println("3. Add On Card");
		System.out.println("4. Lost Stolen Card");
		System.out.println("5. Increase Credit Limit");
		System.out.print("Request Type : ");
		int req =  s.nextInt();
		s.nextLine();
		return req;
	}
	
	private String setRequest(int req) {
		switch(req) {
		case 1:
			return "chequebookrequest";
		case 2: 
			return "disputedtransactions";
		case 3:
			return "addoncard";
		case 4:
			return "loststolencard";
		case 5:
			return "increasecreditlimit";
		default:
			return "";
		
		}
	}
	
	private int status(Scanner s){

		System.out.println("\n1. All");
		System.out.println("2. Pending");
		System.out.println("3. Rejected");
		System.out.println("4. Processing");
		System.out.println("Enter Status : ");
		int stat =  s.nextInt();
		s.nextLine();
		return stat;
	}
	
	private String setStatus(int stat) {
		switch(stat) {
		case 1:
			return "all";
		case 2: 
			return "pending";
		case 3:
			return "rejected";
		case 4:
			return "processing";
		default:
			return "";
		}
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
