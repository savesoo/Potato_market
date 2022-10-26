package potato.service.board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import potato.dao.BoardDao;
import potato.domain.Board;
import potato.util.ConnectionProvider;

// 컨트롤러에서 요청을 받아와 게시물 리스트 출력 처리하는 클래스
public class BoardListService {

	BoardDao dao;

	public BoardListService(BoardDao dao) {
		this.dao = dao;
	}

	// 리스트 출력
	public List<Board> allBoardPrint() {

		List<Board> list = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection(); // 커넥션으로 DB 연결
			list = dao.selectBoard(conn); // 저장된 게시물 dao에서 불러오는 메소드 사용

		} catch (SQLException e) {

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

// -----------------------------------------------------

	// 수정, 삭제시 사용할 권한 확인 기능
	// boardid 랑 내 userid 일치하면 출력, 아니면 false
	public boolean verifyID(int boardid) {

		Board board = null;
		Connection conn = null;
		boolean result = false;

		try {
			conn = ConnectionProvider.getConnection();
			board = dao.verifyID(conn, boardid);

			if (board != null) {
				result = true;
			}

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

		return result;

	}

}
