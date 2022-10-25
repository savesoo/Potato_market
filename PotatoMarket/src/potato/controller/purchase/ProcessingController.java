package potato.controller.purchase;

import potato.controller.IController;
import potato.dao.ProcessingDao;
import potato.domain.ProcessingData;
import potato.domain.Session;
import potato.service.ProcessingService;
import potato.util.InputString;

public class ProcessingController implements IController {
	
	ProcessingService service = new ProcessingService(new ProcessingDao());

	@Override
	public boolean process() {
		
		String userid, tradeloc;
		
		
		System.out.println("상품구매");
		
		System.out.println("아이디");
		userid = InputString.inputDefaultString();
		System.out.println("거래지역 >> ");
		tradeloc = InputString.inputDefaultString();
		
		ProcessingData processingdata = new ProcessingData(userid, tradeloc);
		int result = service.processing(processingdata);
		
		if(result > 0) {
			System.out.println("구매완료");
		} else {
			System.out.println("구매실패");
		}
		
		
		
		return false;
	}
	

}
