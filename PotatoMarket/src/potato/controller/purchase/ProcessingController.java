package potato.controller.purchase;

import potato.controller.IController;
import potato.dao.ProcessingDao;
import potato.domain.Board;
import potato.domain.Session;
import potato.service.ProcessingService;
import potato.util.InputString;

public class ProcessingController implements IController {

	ProcessingService service = new ProcessingService(new ProcessingDao());

	@Override
	public boolean process() {

		String userid = Session.getInstance().getLoginData().getId();
		boolean salestatus = true;

		System.out.println("상품구매");

		System.out.println("카테고리 >> \n()");
		int category = InputString.inputInt();

		System.out.println("구매할 품목 >> ");
		String product = InputString.inputDefaultString();

		System.out.println("물품 금액 >> ");
		int saleprice = InputString.inputInt();

		System.out.println("거래지역 >> ");
		String tradeloc = InputString.inputDefaultString();

		int result = service.processing(new Board());

		if (result > 0) {
			
		} else {
			System.out.println("입력실패");
		} 
		
		return false;
		
	} 

}
