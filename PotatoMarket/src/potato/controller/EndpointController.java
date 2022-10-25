package potato.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import potato.domain.Session;
import potato.util.InputString;

/**
 * 프로그램 종료 할 때, 파일화 작업(자동 로그인 때문에)이 필요해서 만든 클래스
 */
public class EndpointController implements IController {

	@Override
	public boolean process() {
		System.out.println("로그아웃 하겠습니까?");
		System.out.print("0. 예 / 그외. 아니오>>");
		
		int tryInput = InputString.inputInt();
		
		if(tryInput == 0) {
			Session.getInstance().destroySession();
		}
		
		ObjectOutputStream outStream = null;
		
		try { 
			outStream = new ObjectOutputStream(new FileOutputStream("session.ser"));
			if(Session.getInstance().isLogin()) {
				Session.getInstance().updateSession();
				outStream.writeObject(Session.getInstance().getLoginData());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("프로그램이 정상 종료되었습니다.");
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		}
		return true;
	}
}
