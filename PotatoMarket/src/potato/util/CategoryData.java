package potato.util;

import java.util.HashMap;
import java.util.Map;

// 출력 가독성을 위해 생성
public class CategoryData {
	
	// 카테고리 숫자로 선택, 문자열로 출력
	public static Map<Integer, String> names ;
	
	static {
		names = new HashMap<>();
		names.put(1, "생활 용품");
		names.put(2, "패션/잡화");
		names.put(3, "전자 제품");
		names.put(4, "도서");
		names.put(5, "반려동물 용품");
		names.put(6, "기타");
	}
	
	// 판매 상태 문자열로 표시
	public static String isSaleString(boolean isSale) {
		return isSale ? "판매중" : "판매완료";
	}
	
}
