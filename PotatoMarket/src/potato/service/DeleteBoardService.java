package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.domain.Board;
import potato.dao.BoardDao;
import potato.util.ConnectionProvider;

public class DeleteBoardService {

	BoardDao dao;

	public DeleteBoardService(BoardDao dao) {
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