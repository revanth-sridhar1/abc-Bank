package abcBank;

import java.util.Scanner;
import abcBankcom.dao.BillPaymentDaoImp;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class BillPayment {
	
	private int billerid;
	private int accountBalance;
	private int billAmount;
	private int accountNumber;
	
	public static void main(String username, Scanner s) throws ClassNotFoundException, SQLException {
		BillPayment b = new BillPayment();
		System.out.printf("%n%n%31s%n%n","Bill Payment");
		System.out.println("1. Display all bills");
		System.out.println("2. Display bills from a biller");
		System.out.println("3. Display bills from an account");
		System.out.println("4. Display bills from a biller and an account");
		System.out.print("\nEnter a mode : ");
		int i = s.nextInt();
		s.nextLine();
		b.display(i,s);
		BillPaymentDaoImp bpdi = new BillPaymentDaoImp();
		List<BillPayment> l = bpdi.list(b);
		Iterator<BillPayment> itr = l.iterator();
		int j=1;
		while(itr.hasNext()) {
			b = itr.next();
			System.out.println("\nsl : " + j + "\n" + b.getBillerid() + " " + b.getAccountNumber() + " " + b.getAccountBalance() + " " + b.getBillAmount());
			j++;
		}
	//	String payment = b.paymentOption(s);
		System.out.print("\nEnter rownum to pay bill : ");
		j=s.nextInt();
		b = l.get(j-1);
		System.out.println("\n" + b.getBillerid() + " " + b.getAccountNumber() + " " + b.getAccountBalance() + " " + b.getBillAmount());
		String str = b.paymentOption(s);
		b.pay(str,bpdi);
		
		//		b.display();
	}

	private String paymentOption(Scanner s) {
		System.out.println("\nPayment Options ");
		if((accountBalance - billAmount)<0) {
			System.out.println("Bill payment not possible");
			System.exit(0);
		}
		else if(billAmount==0) {
			System.out.println("Bill processed");
			System.exit(0);
		}
		else {
		System.out.println("available balance after payment : " + (accountBalance - billAmount));
		System.out.println("* pay  * fpay * reject");
		System.out.print("Enter option : ");
		s.nextLine();
		}
		return s.nextLine();
	}
	
	private void pay(String payment, BillPaymentDaoImp b) throws ClassNotFoundException, SQLException {
		if(payment.equals("reject")) 
			System.out.println("Transaction Unsuccessful");
		else {
			this.setAccountBalance(this.accountBalance-this.billAmount);
			this.setBillAmount(0);
			
			System.out.println(this.getAccountBalance() + " " + this.getBillAmount());
			boolean bool = b.update(this);
			if(bool)
				System.out.println("Transaction Successful");
			else 
				System.out.println("Transaction Unsuccessful");
		}
	}
	
	private void display(int i, Scanner s) {
		if(i==1) {
			this.setBillerid(-1);
			this.setAccountNumber(-1);
		}
		if(i==2) {
			System.out.print("Enter biller id : ");
			this.setBillerid(s.nextInt());
			this.setAccountNumber(-1);
			s.nextLine();
		}
		if(i==3) {
			System.out.print("Enter account no : ");
			this.setAccountNumber(s.nextInt());
			this.setBillerid(-1);
			s.nextLine();
		}
		if(i==4) {
			System.out.print("Enter biller id : ");
			this.setBillerid(s.nextInt());
			s.nextLine();
			System.out.print("Enter account no : ");
			this.setAccountNumber(s.nextInt());
			s.nextLine();
		}
	}

	public int getBillerid() {
		return billerid;
	}

	public void setBillerid(int billerid) {
		this.billerid = billerid;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
	
}
