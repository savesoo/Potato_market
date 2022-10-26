package potato.controller.board;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.service.board.BoardDeleteService;
import potato.service.board.BoardListService;
import potato.util.InputString;

public class BoardDeleteController implements IController {

	BoardDeleteService service = new BoardDeleteService(new BoardDao());
	BoardListService ps = new BoardListService(new BoardDao());

	@Override
	public boolean process() {
		
		System.out.println("게시글 삭제가 진행됩니다.");

		System.out.println("삭제할 게시글 번호 >>");
		int boardid = InputString.inputInt();
		
		// 작성자 아닐시 삭제 불가 처리
		if(ps.verifyID(boardid)!=true) {
			System.out.println("권한은 작성자 본인에게만 주어집니다.");
			return false;
		} else {
			System.out.println("작업이 가능합니다.");
		}

		int result = service.deleteBoard(boardid);

		if (result > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제 실패");
		}

		return false;

	}

}