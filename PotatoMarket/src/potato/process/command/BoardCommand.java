package potato.process.command;

import java.util.HashMap;

import potato.controller.board.BoardDeleteController;
import potato.controller.board.BoardInsertController;
import potato.controller.board.ProductSearchController;
import potato.controller.board.BoardUpdateController;
import potato.controller.purchase.BuyProductController;

public class BoardCommand extends AbsCommand {
	
	public BoardCommand() {
		command = new HashMap<>();
		command.put(1, new BoardInsertController()); // 게시물 없을시 새로 작성
		command.put(2, new ProductSearchController()); // 상품 검색
		command.put(3, new BuyProductController()); // 상품 구매
		command.put(4, new BoardUpdateController()); // 게시글 수정
		command.put(5, new BoardDeleteController()); // 게시글 삭제
		
	}

}
