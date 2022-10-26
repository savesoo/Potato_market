package potato.process.command;

import java.util.HashMap;

import potato.controller.EndpointController;
import potato.controller.board.BoardInsertController;
import potato.controller.board.BoardListController;
import potato.controller.board.SellHistoryController;
import potato.controller.purchase.HistoryController;
import potato.controller.sign.UserMenuController;


public class MainCommand extends AbsCommand {

	public MainCommand(){
		command = new HashMap<>();
		command.put(1, new BoardListController()); // 전체글 보기
		command.put(2, new SellHistoryController()); // 내 판매글 보기
		command.put(3, new BoardInsertController()); // 판매 글쓰기
		command.put(4, new HistoryController()); // 내 구매내역 보기
		command.put(5, new UserMenuController()); // 회원 정보
		command.put(6, new EndpointController()); // 종료
	}
}
