package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.sign.UserUpdateService;
import potato.util.EncryptString;
import potato.util.InputString;

public class UserUpdateController implements IController {

	private UserUpdateService service = new UserUpdateService();

	public boolean process() {

		boolean result = false;

		while (true) {
			System.out.println();
			System.out.println("회원 정보를 수정합니다.");
			System.out.println();
			String password = null;
			boolean run = true;

			while (run) {
				System.out.print("1-1. 비밀번호를 수정해주세요 >> ");
				password = InputString.inputDefaultString();
				System.out.print("1-2. 한 번 더 입력해주세요 >> ");
				run = PasswordCheckProcess.chkPassword(password);

				try {
					password = EncryptString.encryptAES256(password);
				} catch (Exception e) {
					System.out.println("프로그램 에러.");
					return false;
				}
			}

			System.out.print("2. 거주지역을 수정해주세요 >> ");
			String loc = InputString.inputDefaultString();
			System.out.print("3. 닉네임을 수정해주세요 >> ");
			String nickname = InputString.inputDefaultString();

			UserData userdata = new UserData(password, loc, nickname);
			if (service.editMem(userdata)) {
				System.out.println();
				System.out.println("수정이 완료되었습니다!");
				System.out.println();
				result = true;
				break;

			} else {
				System.out.println("오류가 발생하여 수정이 실패하였습니다.");
				System.out.println("다시 수정을 진행합니다.");
				result = false;

			}
		}
		return result;
	}
}
