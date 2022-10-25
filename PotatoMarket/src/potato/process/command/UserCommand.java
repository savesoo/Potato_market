package potato.process.command;

import java.util.HashMap;

import potato.controller.sign.DeleteMemController;
import potato.controller.sign.EditMemController;
import potato.controller.sign.ViewInfoController;

public class UserCommand extends AbsCommand {

	public UserCommand() {
		command = new HashMap<>();
		command.put(1, new ViewInfoController());	// 회원 정보 보기
		command.put(2, new EditMemController());	// 회원 정보 수정
		// command.put(3, new DeleteMemController());	// 회원 탈퇴 는 보류
		
	}
}
