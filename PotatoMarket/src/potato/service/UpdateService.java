package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.Dao;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

public class UpdateService {
	
	Dao dao = new BoardDao();
	
	public int update(Board sale) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.update(conn, sale);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
