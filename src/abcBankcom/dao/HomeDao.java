package abcBankcom.dao;

import java.sql.SQLException;

import abcBank.*;

public interface HomeDao {
	
	public boolean checkData(Home h) throws ClassNotFoundException,SQLException;
	
}
