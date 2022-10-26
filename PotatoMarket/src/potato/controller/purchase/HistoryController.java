package potato.controller.purchase;

import java.util.List;

import potato.controller.IController;
import potato.dao.PurchaseDao;
import potato.domain.Board;
import potato.service.purchase.HistoryService;

public class HistoryController implements IController {

	HistoryService service = new HistoryService(new PurchaseDao());

	@Override
	public boolean process() {
		System.out.println("내 구매내역을 확인 합니다.");
		
		List<Board> list = service.purchaseHistory();

		if(list != null && !list.isEmpty()) {
			for (Board b : list) {
				System.out.println(b);
			}
		} else {
			System.out.println("현재 구매 내역이 없습니다!");
		}
		
		return false;

	}

}
