package potato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import potato.domain.LoginData;
import potato.domain.Session;
import potato.domain.UserData;

public class UserDao {
	public int selectByUserIdAndPw(Connection conn, LoginData loginData) throws SQLException {
		int result = 0;
		String sql = "Select * from potato_user where userid = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginData.getId());
			pstmt.setString(2, loginData.getPassword());

			rs = pstmt.executeQuery();

			if (rs.next()) { // next가 있다는 건, id와 pw가 같은 row가 있다는 거임
				result++;
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}

		return result;
	}

	// 회원가입 dao
	public int insertUser(Connection conn, UserData userData) throws SQLException {
		int result = 0;
		String sql = "Insert into potato_user (userid, password, loc, nickname) values (?, ?, ?, ?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userData.getUserid());
			pstmt.setString(2, userData.getPassword());
			pstmt.setString(3, userData.getLoc());
			pstmt.setString(4, userData.getNickname());
			
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();

		}

		return result;
	}

	// 회원 정보 보기 dao
	public UserData viewInfo(Connection conn) throws SQLException {
	
		UserData userdata = null;
		String sql = "select * from potato_user where userid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Session.getInstance().getId());
	
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				userdata = new UserData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
	
		return userdata;
	}
	
	
	

	// 정보수정 dao
	public int editMem(Connection conn, UserData userData) throws SQLException {
		int result = 0;
		String sql = "Update potato_user set password=?, loc=?, nickname=? where userid=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userData.getPassword());
			pstmt.setString(2, userData.getLoc());
			pstmt.setString(3, userData.getNickname());
			pstmt.setString(4, Session.getInstance().getId());
			
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return result;
	}

	// 회원탈퇴 dao
	public int deleteMem(Connection conn) throws SQLException {
		int result = 0;
		String sql = "delete from potato_user where userid=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Session.getInstance().getId());
			
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return result;

	}
	
	
	// 가입 id 중복체크 dao
	public boolean chkId(Connection conn, String userid) throws SQLException {
		String sql = "select userid from potato_user where userid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요.");
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return result;
	}

}
