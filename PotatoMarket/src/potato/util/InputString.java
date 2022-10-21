package potato.util;

import java.util.Scanner;

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
