package potato.process.command;

import potato.controller.EndpointController;

public class MainCommand extends AbsCommand {

	public MainCommand(){
		command.put(5, new EndpointController());
	}
}
