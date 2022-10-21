package potato.process.sign;

import potato.process.IProcess;

public class SignUp implements IProcess {

	@Override
	public boolean work() {
		System.out.println("회원가입");
		return true;
	}
}
