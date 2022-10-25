package potato.service;

import java.sql.Connection;
import java.sql.SQLException;

import potato.dao.UserDao;
import potato.util.ConnectionProvider;
import potato.util.InputString;

public class CheckIdService {

	UserDao dao = new UserDao();

	public String checkId() {
		String userid = null;
		Connection conn = null;
		boolean chk = true;

		try {
			conn = ConnectionProvider.getConnection();
			while (chk) {
				System.out.print("아이디를 설정해주세요 >> ");
				userid = InputString.inputDefaultString();
				chk = dao.chkId(conn, userid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userid;
	}
}
