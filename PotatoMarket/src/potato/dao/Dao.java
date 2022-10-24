package potato.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.domain.Board;

public interface Dao {
	
	
	Board selectByBoardid(Connection conn, int boardid) throws SQLException;

	int insert(Connection conn, Board sale) throws SQLException;
	int update(Connection conn, Board sale) throws SQLException;
	int delete(Connection conn, int boardid) throws SQLException;
	

}