package potato.process.command;

import java.util.HashMap;

import potato.controller.board.DeleteController;
import potato.controller.board.InsertController;
import potato.controller.board.SearchController;
import potato.controller.board.SellHistoryController;
import potato.controller.board.UpdateController;

public class BoardCommand extends AbsCommand {
	
	public BoardCommand() {
		command = new HashMap<>();
		command.put(1, new InsertController()); // 게시물 없을시 새로 작성
		command.put(2, new SearchController()); // 상품 검색
		//command.put(3, new ); // 상품 구매
		command.put(4, new UpdateController()); // 게시글 수정
		command.put(5, new DeleteController()); // 게시글 삭제
		command.put(6, new SellHistoryController()); // 내 판매 내역 확인
		
	}

}
