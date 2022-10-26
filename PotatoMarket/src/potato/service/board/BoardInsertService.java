package potato.service.board;

import java.sql.Connection;
import java.sql.SQLException;

import potato.domain.Board;
import potato.util.ConnectionProvider;
import potato.dao.BoardDao;

public class BoardInsertService {

BoardDao dao;
	
	public BoardInsertService(BoardDao dao) {
		this.dao = dao;
	}
	
	public int insertBoard(Board board) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			
			result = dao.insertBoard(conn, board);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
