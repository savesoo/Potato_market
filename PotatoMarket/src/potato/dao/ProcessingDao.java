package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import potato.domain.ProcessingData;

public class ProcessingDao {

	public int processing(Connection conn, ProcessingData processing) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, processing.getUserid());
			pstmt.setInt(2, processing.getBoardid());
			pstmt.setInt(3, processing.getCategory());
			pstmt.setString(4, processing.getProduct());
			pstmt.setString(5, processing.getTradeloc());
			pstmt.setInt(6, processing.getSaleprice());
			pstmt.setInt(7, processing.getWritedate());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

}
