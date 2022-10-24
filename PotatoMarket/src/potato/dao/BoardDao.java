package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;


public class BoardDao implements Dao {

	

	@Override
	public int insert(Connection conn, Board sale) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;


		String sql = "insert into potato_ values (category=?, product=?, saleprice=?, tradeloc=?)";

		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, sale.getBoardid()); => sql
//			pstmt.setString(2, sale.getUserid()); 
			pstmt.setInt(3, sale.getCategory());
			pstmt.setString(4, sale.getProduct());
//			pstmt.setInt(5, sale.getWritedate()); => sql
			pstmt.setInt(6, sale.getSaleprice());
//			pstmt.setBoolean(7, false);
			pstmt.setString(8, sale.getTradeloc());


			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	@Override
	public int update(Connection conn, Board sale) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update potato_board set category=?, product=?, saleprice=?, tradeloc=? where boardid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, sale.getCategory());
			pstmt.setString(4, sale.getProduct());
			pstmt.setInt(6, sale.getSaleprice());
			pstmt.setString(8, sale.getTradeloc());


			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	@Override
	public int delete(Connection conn, int boardid) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from potato_board where boardid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardid);
	
			result = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	@Override
	public Board selectByBoardid(Connection conn, int boardid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}