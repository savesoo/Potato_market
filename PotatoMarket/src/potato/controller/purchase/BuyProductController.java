package potato.controller.purchase;

import potato.controller.IController;
import potato.dao.PurchaseDao;
import potato.service.purchase.BuyProductService;
import potato.util.InputString;

public class BuyProductController implements IController {
	
	
BuyProductService service = new BuyProductService(new PurchaseDao());

@Override
public boolean process() {
	
	System.out.println("구매하고자 하는 게시글번호를 입력해주세요. >> ");
	int boardid = InputString.inputInt();
	int result = service.updateBuy(boardid);
	

	int insertCnt;
	if (result > 0) {
		insertCnt = service.insertTradeData(boardid);
		if(insertCnt != 0) {
			System.out.println("구매 완료!");
			return false;
		}
	} 
	
	System.out.println("구매 실패!");

	
	return false;
}


}
