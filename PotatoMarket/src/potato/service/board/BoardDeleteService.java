package potato.service.board;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.BoardDao;
import potato.util.ConnectionProvider;

public class BoardDeleteService {

	BoardDao dao;

	public BoardDeleteService(BoardDao dao) {
		this.dao = dao;
	}

	public int deleteBoard(int boardid) {
		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			result = dao.deleteBoard(conn, boardid);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}