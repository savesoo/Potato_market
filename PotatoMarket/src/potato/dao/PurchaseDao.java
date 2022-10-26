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

	public List<Board> purchaseHistory(Connection conn) throws SQLException {

		List<Board> list = new ArrayList<>();
		String userid;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from potato_board where boardid = ? and userid != ? and salestatus = 1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Session.getInstance().getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rowToBoard(rs));
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
		String userid = Session.getInstance().getLoginData().getId();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from potato_trade where userid != ? ";

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
	private Board rowToBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("boardid"), rs.getString("userid"), rs.getInt("category"), rs.getString("product"),
				rs.getInt("saleprice"), rs.getBoolean("salestatus"), rs.getString("writedate"),
				rs.getString("tradeloc"));
	}

}


