package potato.controller.board;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.domain.Session;
import potato.service.InsertBoardService;
import potato.util.InputString;

public class InsertBoardController implements IController {

	InsertBoardService service = new InsertBoardService(new BoardDao());

	@Override
	public boolean process() {

		int boardid = 0;
		String userid = Session.getInstance().getLoginData().getId();
		boolean salestatus = true;

		System.out.println("판매글 입력을 시작합니다.");

		System.out.println("카테고리>> \n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
		int category = InputString.inputInt();

		System.out.println("판매물품 >> ");
		String product = InputString.inputDefaultString();

		System.out.println("판매금액 >> ");
		int saleprice = InputString.inputInt();

		System.out.println("거래지역 >> \n (ex.서울시=>서울, 영양군=>영양)");
		String tradeloc = InputString.inputDefaultString();
		
		int result = service.insertBoard(new Board(boardid, userid, category, product, saleprice, salestatus, null, tradeloc));
		
		if (result > 0) {
			System.out.println("입력되었습니다.");
			
			System.out.println("====================================");
			System.out.println("아이디\t카테고리\t판매물품\t판매금액\t거래지역");
			System.out.println("====================================");
			System.out.println(userid+"\t"+category+"\t"+product +"\t"+saleprice+"\t"+tradeloc);
			
			
		} else {
			System.out.println("입력 실패");
		}

		return false;

	}

}
