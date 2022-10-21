package potato.process;

import java.util.HashMap;
import java.util.Map;

import potato.process.sign.SignIn;
import potato.process.sign.SignUp;

public class LoginCommand {
	public Map<Integer, IProcess> command;
	
	public LoginCommand() {
		command = new HashMap<>();
		command.put(1, new SignIn());
		command.put(2, new SignUp());
		command.put(3, new EndpointProcess());
	}
}
