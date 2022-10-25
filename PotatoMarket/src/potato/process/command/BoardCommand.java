package potato.process.command;

import java.util.HashMap;

import potato.controller.board.DeleteBoardController;
import potato.controller.board.InsertBoardController;
import potato.controller.board.ProductSearchController;
import potato.controller.board.UpdateBoardController;

public class BoardCommand extends AbsCommand {
	
	public BoardCommand() {
		command = new HashMap<>();
		command.put(1, new InsertBoardController()); // 게시물 없을시 새로 작성
		command.put(2, new ProductSearchController()); // 상품 검색
		//command.put(3, new ); // 상품 구매
		command.put(4, new UpdateBoardController()); // 게시글 수정
		command.put(5, new DeleteBoardController()); // 게시글 삭제
		
	}

}
