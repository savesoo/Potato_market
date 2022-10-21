package potato.process;

import java.util.HashMap;
import java.util.Map;

import potato.controller.EndpointController;
import potato.controller.IController;
import potato.controller.sign.SignInController;
import potato.controller.sign.SignUpController;

public class LoginCommand {
	public Map<Integer, IController> command;
	
	public LoginCommand() {
		command = new HashMap<>();
		command.put(1, new SignInController());
		command.put(2, new SignUpController());
		command.put(3, new EndpointController());
	}
}
