package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.ViewInfoService;

public class ViewInfoController implements IController {

	ViewInfoService service = new ViewInfoService();

	@Override
	public boolean process() {

		UserData userdata = service.viewInfo();

		while (true) {
			System.out.println();
			System.out.println("\t\t\t내 정보 확인하기");
			System.out.println("▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾");
			System.out.println("   아이디\t              가입일\t        거주지역    닉네임");

			System.out.println();
			if (userdata != null) {
				System.out.println(userdata);
				System.out.println();
				break;
			} else {
				System.out.println("등록된 회원정보가 없습니다.");
			}
		}
		return false;
	}
}
