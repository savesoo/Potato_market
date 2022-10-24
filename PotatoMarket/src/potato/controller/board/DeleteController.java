package potato.controller.board;

import potato.controller.IController;
import potato.service.DeleteService;

public class DeleteController implements IController {
	
	DeleteService service = new DeleteService();
	
	public void process() {


		System.out.println("게시글 삭제가 진행됩니다.");
		
		System.out.println("삭제할 게시글 번호 >>");
		int boardid = Integer.parseInt(Main.sc.nextLine());
		
		int result = service.delete(boardid);
		
		if(result > 0) {
			System.out.println("삭제되었습니다.");			
		} else {
			System.out.println("삭제 실패");
		}
		
	}

}