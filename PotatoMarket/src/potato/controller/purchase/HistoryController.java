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

		List<Board> list = service.purchaseHistory();

		for (Board b : list) {
			System.out.println(b);
		}

		return false;

	}

}
