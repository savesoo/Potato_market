package potato.process.command;

import java.util.HashMap;

import potato.controller.sign.UserUpdateController;
import potato.controller.sign.UserInfoController;

public class UserCommand extends AbsCommand {

	public UserCommand() {
		command = new HashMap<>();
		command.put(1, new UserInfoController());	// 회원 정보 보기
		command.put(2, new UserUpdateController());	// 회원 정보 수정
		// command.put(3, new DeleteMemController());	// 회원 탈퇴 는 보류
		
	}
}
