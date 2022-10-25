package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;
import potato.domain.Session;

public class BoardDao {

	
	// 게시물 작성
	public int insertBoard(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into potato_board (boardid, userid, category, product, saleprice, tradeloc) values (?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardid());
			pstmt.setString(2, board.getUserid());
			pstmt.setInt(3, board.getCategory());
			pstmt.setString(4, board.getProduct());
			pstmt.setInt(5, board.getSaleprice());
			pstmt.setString(6, board.getTradeloc());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
	// 게시물 수정
	public int updateBoard(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update potato_board set category=?, product=?, saleprice=?, tradeloc=? where boardid=? and userid=? and salestatus=1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getCategory());
			pstmt.setString(2, board.getProduct());
			pstmt.setInt(3, board.getSaleprice());
			pstmt.setString(4, board.getTradeloc());
			pstmt.setInt(5, board.getBoardid());
			pstmt.setString(6, Session.getInstance().getLoginData().getId()); // id 불러오기

			result = pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
	// 게시물 삭제
	public int deleteBoard(Connection conn, Board board) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from potato_board where boardid=? and userid=? and salestatus=1";
		// salestatus = 1 -> 판매상태 true, 즉 판매중일 때 삭제 가능

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardid());
			pstmt.setString(2, board.getUserid());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	
	
	
// ------------------------------------------------------------------------------------

	// DB에 저장된 판매 게시글 불러오기
	public List<Board> selectBoard(Connection conn) throws SQLException { // throws 처리했으므로 catch문 삭제

		List<Board> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "SELECT * FROM potato_board WHERE salestatus=1"; // 현재 판매중인 게시글만 표시
			rs = stmt.executeQuery(sql); // ResultSet 객체 반환

			while (rs.next()) { // 다음으로 넘어가면 행 추가해주기
				list.add(rowToBoard(rs));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return list;

	}

	
	// 행 단위로 데이터 입력해주는 메소드
	private Board rowToBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("boardid"), rs.getString("userid"), rs.getInt("category"), rs.getString("product"),
				rs.getInt("saleprice"), rs.getBoolean("salestatus"), rs.getString("writedate"), rs.getString("tradeloc"));
	}

	
	// 판매 내역 조회. 단 판매상태는 구분 X
	public List<Board> showsellHistory(Connection conn) throws SQLException {

		List<Board> list = new ArrayList<>();
		String userid = Session.getInstance().getLoginData().getId();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM potato_board WHERE userid=?";
		// userid가 일치하며 판매중/판매완료 둘 다 표시

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rowToBoard(rs));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return list;
	}
	
	
	// 판매상품으로 검색
	public List<Board> searchBoardByProduct(Connection conn, String product) throws SQLException {
		
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM potato_board WHERE product LIKE concat('%',?,'%')";
		// 입력한 상품명을 키워드로 검색 
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rowToBoard(rs));
			}
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}

		return list;
	}

}