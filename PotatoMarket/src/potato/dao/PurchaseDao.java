package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;
import potato.domain.Session;

public class PurchaseDao {

	public List<Board> buyHistory(Connection conn) throws SQLException {

		List<Board> list = null;
		String userid = Session.getInstance().getId();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select b.* from potato_trade t, potato_board b where t.boardid = b.boardid and t.userid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		}

		return list;

	}

	public List<Board> purchaseprocessing(Connection conn, int boardid) throws SQLException {
		List<Board> list = new ArrayList<>();
		String userid = Session.getInstance().getId();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from potato_board where boardid = ? and userid != ? and salestatus = 1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, boardid);

			rs = pstmt.executeQuery();

			// rs.next();
			// -> true: 구매 가능한 상태이므로, 관련 처리를 해줍니다
			// -> false: 구매 불가한 상태이므로, 관련 처리를 해줍니다

		} finally {

			if (pstmt != null) {
				pstmt.close();
				if (rs != null)
					rs.close();
			}
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
