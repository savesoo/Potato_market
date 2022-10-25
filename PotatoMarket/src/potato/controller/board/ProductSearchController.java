package potato.controller.board;

import java.util.List;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.service.ProductSearchService;
import potato.util.InputString;

// 서비스 클래스에 상품명으로 검색 요청
public class ProductSearchController implements IController {
	
	ProductSearchService service = new ProductSearchService(new BoardDao());

	@Override
	public boolean process() {
		
		while (true) { //재검색 원할시 다시 입력받는 while문
			
			int tryinput;
			
			System.out.println("검색을 시작합니다.");
			System.out.println("찾으실 상품명을 입력해주세요. >>");
			String product = InputString.inputDefaultString(); // 입력
			
			List<Board> list = service.productSearch(product);
			
			System.out.println("---------------검색 결과---------------");
			if(list!=null) {
				System.out.println(list);
				break; 
			} else {
				System.out.println("검색 결과가 없습니다.");
				System.out.println("0. 이전으로 돌아가기 / 그외. 다시 검색>> ");
				tryinput = InputString.inputInt();
				if(tryinput==0) {
					break;
				}
			}	
		}		
		
		return false;
	}
	
	

}
