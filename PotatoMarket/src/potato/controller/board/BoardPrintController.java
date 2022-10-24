package potato.controller.board;

import java.util.List;

import potato.controller.IController;
import potato.dao.ProductDao;
import potato.domain.Board;
import potato.service.BoardPrintService;

public class BoardPrintController implements IController {
	
	// 게시물 보여줄 것을 서비스에 요청하는 서비스 클래스
	// List<Board> 출력

	BoardPrintService service = new BoardPrintService(new ProductDao());

	@Override
	public boolean process() {

		List<Board> list = service.print();

		if (list != null && !list.isEmpty()) {
			for (Board b : list) {
				System.out.println(b);
			}
		} else {
			System.out.println("현재 등록된 게시물이 없습니다.");
		}
		
		return false;

	}

}
