package abcBank;
import java.sql.SQLException;
import java.util.*;
import abcBankcom.dao.*;

public class Home {

	private String userName;
	private String password;
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Home h = new Home();
		Scanner s = new Scanner(System.in);
		boolean nextPage = false;
		
		while(!nextPage) {
			nextPage = login(h,s);
			if(!nextPage)
				System.out.println("\nInvalid username or password");
			else {
				int menu = 	menu(nextPage,s);
				operation(menu,h,s);
				break;
			}
		}
		
		System.out.println("System Exit");
		s.close();
		System.exit(0);
	}

	
	private static boolean login(Home srtPage, Scanner s) throws ClassNotFoundException, SQLException {
		
			System.out.printf("%n%n%30s%n%n%n","Login Page");
			System.out.print("username : ");
			srtPage.userName = s.nextLine();
			System.out.print("password : ");
			srtPage.password = s.nextLine();
			boolean b = false;
			
			HomeDaoImp hdi = new HomeDaoImp();
			b=hdi.checkData(srtPage);
		return b;
	}
	
	
	private static int menu(boolean b, Scanner s)  {
			System.out.printf("%n%n%27s%n%n","Menu");
			System.out.println("1. Customer Request");
			System.out.println("2. Queries");
			System.out.println("3. Bill Payment");
			System.out.println("4. Back");
			System.out.println("5. Exit\n");
			System.out.print("Choose an option : ");
			int menu = s.nextInt();
			s.nextLine();
		return menu;	
	}
	
	public static void operation(int menu,Home h, Scanner s) throws ClassNotFoundException, SQLException {
		if(menu==1) {
			CustomerRequest.main(s);
		}
		else if(menu==2) {
			Query.main(h.userName,s);
		}
		else if(menu==3) {
			BillPayment.main(h.userName, s);
		}
		else if(menu==4){
			Home.main(new String[0]);
		}
		else {
			return;
		}
	}
}