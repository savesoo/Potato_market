package potato.process.command;

import java.util.HashMap;

import potato.controller.EndpointController;
import potato.controller.board.InsertBoardController;
import potato.controller.board.PrintBoardController;
import potato.controller.board.SellHistoryController;
import potato.controller.sign.UserMenuController;


public class MainCommand extends AbsCommand {

	public MainCommand(){
		command = new HashMap<>();
		command.put(1, new PrintBoardController()); // 전체글 보기
		command.put(2, new SellHistoryController()); // 내 판매글 보기
		command.put(3, new InsertBoardController()); // 판매 글쓰기
		//command.put(4, ); // 내 구매내역 보기
		command.put(5, new UserMenuController()); // 회원 정보
		command.put(6, new EndpointController()); // 종료
	}
}
