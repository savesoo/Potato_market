package potato.controller.sign;

import potato.util.InputString;

public class PasswordCheckProcess {
	// 확인용 비밀번호 체크
	public static boolean chkPassword(String password) {
		boolean result = true;

		String checkPassword = InputString.inputDefaultString();
		if (!password.equals(checkPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
