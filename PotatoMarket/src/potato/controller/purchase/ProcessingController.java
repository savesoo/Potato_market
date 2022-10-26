package potato.controller.purchase;


import java.util.List;

import potato.controller.IController;
import potato.dao.PurchaseDao;
import potato.domain.Board;
import potato.service.purchase.ProcessingService;
import potato.util.InputString;


public class ProcessingController implements IController {

	ProcessingService service = new ProcessingService(new PurchaseDao());

	@Override
	public boolean process() {
		while(true) {
			
			int tryinput;
			
			System.out.println("조회을 시작합니다.");
			System.out.println("조회하실 게시글 번호를 입력해주세요");
			int boardid = InputString.inputInt();
			
			List<Board> list = service.purchase(boardid);
			
			System.out.println("조회결과 ==================");
			if(list!=null) {
				System.out.println(list);
				break;
			} else {
				
			}
		
		}
		return false;
		
	}
		

	}

		
	


	