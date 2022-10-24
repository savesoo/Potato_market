package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.Dao;
import potato.dao.BoardDao;
import potato.util.ConnectionProvider;
import potato.dao.BoardDao;

public class DeleteService {

	Dao dao = new BoardDao();

	public int delete(int boardid) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			result = dao.delete(conn, boardid);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}