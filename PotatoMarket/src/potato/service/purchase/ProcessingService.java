package potato.service.purchase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.PurchaseDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

public class ProcessingService {

	PurchaseDao dao;

	public ProcessingService(PurchaseDao dao) {
		this.dao = dao;
	}

	public List<Board> purchase(int boardid) {

		List<Board> list = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			list = dao.purchaseprocessing(conn, boardid);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return list;
	}

	

}
