package abcBankcom.dao;

import java.sql.SQLException;
import java.util.List;

import abcBank.*;

public interface QueryDAo {

	public List<Query> list(Query q) throws ClassNotFoundException,SQLException;
	public Query update(Query q) throws ClassNotFoundException,SQLException;
	
}
