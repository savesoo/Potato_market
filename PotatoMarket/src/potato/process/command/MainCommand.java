package potato.process.command;

import java.util.HashMap;

import potato.controller.EndpointController;
import potato.controller.board.InsertController;
import potato.controller.board.PrintController;
import potato.controller.sign.UserMenuController;


public class MainCommand extends AbsCommand {

	public MainCommand(){
		command = new HashMap<>();
		command.put(1, new PrintController()); // 전체글 보기
		//command.put(2, )// 내 판매글 보기
		command.put(3, new InsertController()); // 판매 글쓰기
		//command.put(4, ); // 내 구매내역 보기
		command.put(5, new UserMenuController()); // 회원 정보
		command.put(6, new EndpointController()); // 종료
	}
}
