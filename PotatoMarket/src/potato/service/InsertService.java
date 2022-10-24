package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.Dao;
import potato.domain.Board;
import potato.util.ConnectionProvider;
import potato.dao.BoardDao;

public class InsertService {

	Dao dao = new BoardDao();
	
	public int insert(Board sale) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			
			result = dao.insert(conn, sale);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
