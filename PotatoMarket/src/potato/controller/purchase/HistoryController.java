package potato.controller.purchase;

import java.util.Scanner;

import potato.controller.IController;
import potato.dao.HistoryDao;
import potato.domain.HistoryData;
import potato.domain.Session;
import potato.service.HistoryService;
import potato.util.InputString;

public class HistoryController implements IController {
	
	
	HistoryService service = new HistoryService(new HistoryDao());

	@Override
	public boolean process() {

		String userid;
		int boardid, orderid;

		System.out.println("구매내역 조회");

		System.out.println("아이디 입력 >> ");
		userid = InputString.inputDefaultString();
		System.out.println("게시글번호 입력 >> ");
		boardid = InputString.inputInt();
		System.out.println("주문번호 입력 >> ");
		orderid = InputString.inputInt();

		HistoryData historydata = new HistoryData(userid, boardid, orderid);
		int result = service.history(historydata);
		
		if (result > 0) {
			System.out.println("입력되었습니다.");
			System.out.println("=====================================");
			System.out.println("아이디\t게시글번호\t주문번호");
			System.out.println(userid+"\t"+boardid+"\t"+orderid+"\t");
			System.out.println("=====================================");
			
		
		} else {
			System.out.println("입력 실패");
		
		}
		
		
		return false;
	}

}
