package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import potato.domain.HistoryData;

public class HistoryDao {

//	구매내역 조회
	public int history(Connection conn, HistoryData historydata) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, historydata.getUserid());
			pstmt.setInt(2, historydata.getBoardid());
			pstmt.setInt(3, historydata.getOrderid());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

}
