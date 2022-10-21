package potato.process.sign;

import potato.domain.LoginData;
import potato.domain.Session;
import potato.process.IProcess;
import potato.service.UserService;
import potato.util.InputString;

public class SignIn implements IProcess {
	
	private UserService service = new UserService();

	@Override
	public boolean work() {
		String id, password;
		int tryInput;
		boolean result = false;
		
		while(true) {
			System.out.println("로그인");
			System.out.println("======================");
			System.out.print("id를 입력해주세요:>>");
			id = InputString.scan.nextLine();
			System.out.print("pw을 입력해주세요:>>");
			password = InputString.scan.nextLine();
			System.out.println("======================");
			
			// 로그인 프로세스 따라 할 게 있음
			LoginData data = new LoginData(id, password);
			if(service.signIn(data)) { // 로그인 시도 성공일 경우 break;
				result = true;
				Session.getInstance().createSession(data);
				
				break;
			}

			System.out.println("로그인에 실패했습니다. 다시 로그인 하겠습니까?");
			System.out.print("0. 돌아가기 / 그외. 재시도>>");
			tryInput = InputString.inputInt();
			if(tryInput == 0) {
				break;
			}
		}
		
		return result;
	}
}
