package potato.controller.board;


import potato.controller.IController;
import potato.domain.Board;
import potato.service.InsertService;

public class InsertController implements IController  {

	InsertService service = new InsertService();
	
	public void process() {
		
		int boardid=0;
		String userid=null;
		int writedate = 0;
		boolean salestatus= true;
		
		System.out.println("판매글 입력을 시작합니다.");
		
		System.out.println("카테고리>> /n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
		int category = Integer.parseInt(Main.nextLine());
		
		System.out.println("판매물품 >> ");
		String product = Main.nextLine();
		
		System.out.println("판매금액 >> ");
		int saleprice = Integer.parseInt(Main.nextLine());
		
		System.out.println("거래지역 >> /n (ex.서울시=>서울, 영양군=>영양)");
		String tradeloc = Main.nextLine();
		
		int result = service.insert(new Board(boardid, userid, category, product, writedate, saleprice, salestatus, tradeloc));
		
		if(result>0) {
			System.out.println("입력되었습니다.");
		} else {
			System.out.println("입력실패");
		}
		
	}
	
}
