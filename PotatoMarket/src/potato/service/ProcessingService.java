package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.ProcessingDao;
import potato.domain.ProcessingData;
import potato.util.ConnectionProvider;

public class ProcessingService {

	ProcessingDao dao;

	public ProcessingService(ProcessingDao dao) {
		this.dao = dao;
	}

	public int processing(ProcessingData processing) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.processing(conn, processing);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
