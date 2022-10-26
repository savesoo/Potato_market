package potato.service.purchase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.PurchaseDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

public class BuyProductService {

	PurchaseDao dao;

	public BuyProductService(PurchaseDao dao) {
		this.dao = dao;
	}

	public int updateBuy(int boardid) {

		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.buyProduct(conn, boardid);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public int insertTradeData(int boardid) {
		// -> insertTrade처리
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.insertTrade(conn, boardid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
