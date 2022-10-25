package potato.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

// 상품명으로 검색 처리
public class ProductSearchService {

	BoardDao dao;

	public ProductSearchService(BoardDao dao) {
		this.dao = dao;
	}

	public List<Board> productSearch(String product) {

		List<Board> list = null;
		Connection conn = null;

		try {
			
			conn = ConnectionProvider.getConnection();
			list = dao.searchBoardByProduct(conn, product);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

}
