package potato.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import potato.domain.Board;

public class ProductDao {
	
	// DB에 저장된 판매 게시글 불러오기
	public List<Board> select(Connection conn) throws SQLException {
		
		List<Board> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "Select * from potato_board"; // 쿼리문 문자열로 변환
			rs = stmt.executeQuery(sql); // ResultSet 객체 반환
			

			while (rs.next()) {
				list.add(rowToBoard(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		return list;
		
	}
	
	
	// 행 단위로 데이터 입력해주는 메소드
	private Board rowToBoard(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("boardid"), rs.getString("userid"), rs.getInt("category"), 
				rs.getString("product"), rs.getInt("saleprice"), rs.getBoolean("salestatus"),
				rs.getInt("writedate"), rs.getString("tradeloc"));
	}
	
	

	
	
	

}
