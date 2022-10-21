import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import potato.domain.LoginData;
import potato.domain.Session;

/**
 * initialize 시켜야 함
 * @author Aram
 *
 */
public class Process {
	private static Process instance = null;
	private JSONObject config = null;
	private Process() {}
	
	public static Process getInstance() {
		if(instance == null) {
			instance = new Process();
		}
		
		return instance;
	}
	
	/**
	 * 최초 실행시 필요한 작업
	 */
	public void initialize() {
		JSONParser parser = new JSONParser();
		FileReader fr = null;
		try {
			fr = new FileReader("config.json");
			Object obj = parser.parse(fr);
			config = (JSONObject) obj;	
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			
			System.exit(0); // config파일 불러오기 실패할 경우 db를 실행할 수 없으므로 종료 시켜야 함
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		Session session = Session.getInstance(); 
		ObjectInputStream inStream = null;
		
		try {
			inStream = new ObjectInputStream(new FileInputStream("session.ser"));
			
			if(inStream != null) {
				session.createSession((LoginData)inStream.readObject());
			}
		} catch (Exception e) {
			
			e.getStackTrace();
			// 기본 로그인 데이터 없는 거니까 굳이 오류 표시 x
		} finally {
			if(inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 아니 함수 명 바꾸고 싶다
	public void offSystem() {
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
		}
	}
	
	public Object getConfigValue(String key) {
		return config.get(key);
	}
}
