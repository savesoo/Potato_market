package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.UserDao;
import potato.domain.UserData;
import potato.util.ConnectionProvider;

public class InsertMemService {

	UserDao dao = new UserDao();
	
	public int signUp(UserData userdata) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.insertUser(conn, userdata);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

//	public boolean signUp(UserData userdata) {
//		Connection conn = null;
//		boolean result = false;
//
//		try {
//			conn = ConnectionProvider.getConnection();
//			if (dao.insertUser(conn, userdata) == 1) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}
//		return result;
//	}
}
