package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.HistoryDao;
import potato.domain.HistoryData;
import potato.util.ConnectionProvider;

public class HistoryService {

	HistoryDao dao;

	public HistoryService(HistoryDao dao) {
		this.dao = dao;
	}

	public int history(HistoryData history) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.history(conn, history);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
