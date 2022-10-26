package potato.service.sign;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.UserDao;
import potato.domain.UserData;
import potato.util.ConnectionProvider;

public class UserUpdateService {

	UserDao dao = new UserDao();

	public boolean editMem(UserData userdata) {
		Connection conn = null;
		boolean result = false;

		try {
			conn = ConnectionProvider.getConnection();
			if (dao.editMem(conn, userdata) == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
