package potato.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import potato.domain.Session;

public class EndpointProcess implements IProcess {

	@Override
	public boolean work() {
		ObjectOutputStream outStream = null;
		
		try { 
			outStream = new ObjectOutputStream(new FileOutputStream("session.ser"));
			if(Session.getInstance().isLogin())
				outStream.writeObject(Session.getInstance().getLoginData());
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
			
			System.exit(0);
		}
		return true;
	}
}
