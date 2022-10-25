package potato.controller.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.domain.Session;
import potato.util.InputString;

public abstract class BoardController implements IController {
	
	// 게시글 작성
	public void insert() {

		System.out.println("판매글 입력을 시작합니다.");

		System.out.println("카테고리>> \n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
		int category = InputString.inputInt();

		System.out.println("판매물품 >> ");
		String product = InputString.inputDefaultString();

		System.out.println("판매금액 >> ");
		int saleprice = InputString.inputInt();
		
		System.out.println("거래지역 >> \n (ex.서울시=>서울, 영양군=>영양)");
		String tradeloc = InputString.inputDefaultString();

		try {

			String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "test1234");

			String sql = "insert into potato_board values (category=?, product=?, saleprice=?, tradeloc=?, )";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			pstmt.setString(2, product);
			pstmt.setInt(3, saleprice);
			pstmt.setString(4, tradeloc);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("입력되었습니다.");
			}

			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	private int SelectByBoardid() {
		// 저장된 게시글번호 불러오기

		int boardid = 0;
		String userid = Session.getInstance().getLoginData().getId();

		try {
					
			
			String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn;
			conn = DriverManager.getConnection(dbUrl, "scott", "test1234");

			String sql = "select * from potato_board where userid=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(userid == sql) {
				rs.getInt(boardid);
				}
			}
			
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardid;

	}

	public void update() {
		
		int boardid = SelectByBoardid();

		System.out.println("수정할 게시글번호를 입력해주세요. >> ");
		int no = InputString.inputInt();

		if (boardid == no) {

			System.out.println("게시글 수정이 시작됩니다.");

			System.out.println("카테고리>> \n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
			int category = InputString.inputInt();

			System.out.println("판매물품 >> ");
			String product = InputString.inputDefaultString();

			System.out.println("판매금액 >> ");
			int saleprice = InputString.inputInt();

			System.out.println("거래지역 >> \n (ex.서울시=>서울, 영양군=>영양)");
			String tradeloc = InputString.inputDefaultString();

			try {

				String dbUrl = "jdbc:mysql://localhost:3306/project";
				Connection conn = DriverManager.getConnection(dbUrl, "scott", "test1234");

				String sql = "update potato_board set category=?, product=?, saleprice=?, tradeloc=? where boardid=? and userid=?";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, category);
				pstmt.setString(2, product);
				pstmt.setInt(3, saleprice);
				pstmt.setString(4, tradeloc);
				pstmt.setInt(5, boardid);
				pstmt.setString(6, Session.getInstance().getId());

				int result = pstmt.executeUpdate();

				if (result > 0) {
					System.out.println("수정되었습니다.");
				}

				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("게시글번호가 일치하지 않습니다.");
		}
	}

	public void delete() {

		int boardid = SelectByBoardid();
		
		System.out.println("삭제할 게시글번호를 입력하세요. >> ");
		int no = InputString.inputInt();

		if (boardid == no) {
			
			System.out.println("삭제가 진행됩니다.");

			try {

				String dbUrl = "jdbc:mysql://localhost:3306/project";
				Connection conn = DriverManager.getConnection(dbUrl, "scott", "test1234");

				String sql = "delete from potato_board where boardid=? and userid=?";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardid);
				pstmt.setString(2,Session.getInstance().getLoginData().getId());

				int result = pstmt.executeUpdate();

				if (result > 0) {
					System.out.println("삭제되었습니다.");
				}

				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("게시글번호가 일치하지 않습니다.");
		}
	}

	public void exit() {

		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

}
