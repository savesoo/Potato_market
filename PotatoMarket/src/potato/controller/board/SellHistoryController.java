package potato.controller.board;

import java.util.List;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.service.board.SellHistoryService;

//서비스에 내 판매 내역 확인 요청
public class SellHistoryController implements IController {

	SellHistoryService service = new SellHistoryService(new BoardDao());
	
	@Override
	public boolean process() {
		
		// 확인 조건 : userid 일치
		List<Board> list = service.mySellHistory();
		for(Board b : list) {
			System.out.println(b);
		}
		return false;
	}

	
}
