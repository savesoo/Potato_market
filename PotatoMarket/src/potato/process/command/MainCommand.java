package potato.process.command;

import potato.controller.EndpointController;
import potato.controller.board.BoardPrintController;

public class MainCommand extends AbsCommand {

	public MainCommand(){
		command.put(1, new BoardPrintController()); // 전체글 보기
		//command.put(2, )// 판매글
		//command.put(3, ); // 구매내역
		//command.put(4, ); // 회원 정보
		command.put(5, new EndpointController()); // 종료
	}
}
