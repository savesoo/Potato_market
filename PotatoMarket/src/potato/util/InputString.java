package potato.util;

import java.util.Scanner;

/**
 * Scanner 관련 입력 처리는 해당 클래스를 호출해주시면 됩니다.
 * 정규식 표현이나 예외 처리를 할 경우 별도의 static 함수 생성 후 작업(되도록이면 공통적으로 처리 가능하게!
 */
public class InputString {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static int inputInt() {
		int result = -1;
		try {
			result = Integer.parseInt(scan.nextLine());
		} catch(Exception e) {
			System.out.println("입력 형식이 잘못 되었습니다. 숫자 형식으로 다시 입력해주세요.");
		}
		return result;
	}

}
