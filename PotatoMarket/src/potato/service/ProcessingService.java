package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.ProcessingDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

public class ProcessingService {

	ProcessingDao dao;

	public ProcessingService(ProcessingDao dao) {
		this.dao = dao;
	}

	public int processing(Board board) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.processing(conn, board);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
