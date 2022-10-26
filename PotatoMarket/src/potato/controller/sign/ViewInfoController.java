package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.sign.ViewInfoService;

public class ViewInfoController implements IController {

	ViewInfoService service = new ViewInfoService();

	@Override
	public boolean process() {

		UserData userdata = service.viewInfo();

		while (true) {
			System.out.println();
			System.out.println("\t\t내 정보 확인하기");
			System.out.println("▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾");

			System.out.println();
			if (userdata != null) {
				System.out.println(userdata);
				System.out.println();
				break;
			}
		}
		return false;
	}
}
