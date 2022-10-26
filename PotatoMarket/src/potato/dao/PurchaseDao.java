package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;
import potato.domain.Session;
import potato.util.ConvertData;

public class PurchaseDao {

	public List<Board> buyHistory(Connection conn) throws SQLException {

		List<Board> list = new ArrayList<>();
		String userid = Session.getInstance().getId();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select b.* from potato_trade t, potato_board b where t.boardid = b.boardid and t.userid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			// rs 를 Board로 변환해서 list에 add();
			while(rs.next()) {
				list.add(ConvertData.rowToBoard(rs));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		}

		return list;

	}

	// 구매처리 dao
	public int buyProduct(Connection conn, int boardid) throws SQLException {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "update potato_board set salestatus=0  where boardid=? and userid!=? and salestatus=1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			pstmt.setString(2, Session.getInstance().getId());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 구매 insert
	public int insertTrade(Connection conn, int boardid) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into potato_trade (boardid, userid) values (?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardid);
			pstmt.setString(2, Session.getInstance().getId());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

		}
		return result;
	}
}
