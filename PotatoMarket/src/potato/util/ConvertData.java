package potato.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import potato.domain.Board;

public class ConvertData {
	public static Board rowToBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("boardid"), rs.getString("userid"), rs.getInt("category"), rs.getString("product"),
				rs.getInt("saleprice"), rs.getBoolean("salestatus"), rs.getString("writedate"),
				rs.getString("tradeloc"));
	}
}
