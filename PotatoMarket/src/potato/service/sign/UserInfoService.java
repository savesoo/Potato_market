package potato.service.sign;

import java.sql.Connection;
import java.sql.SQLException;


import potato.dao.UserDao;
import potato.domain.UserData;
import potato.util.ConnectionProvider;

public class UserInfoService {

	UserDao dao = new UserDao();

	public UserData viewInfo() {

		UserData userdata = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			userdata = dao.viewInfo(conn);
		}

		catch (SQLException e) {
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
		return userdata;
	}
}