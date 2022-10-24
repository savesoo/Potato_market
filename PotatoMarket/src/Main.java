import potato.process.MainProcess;

/**
 * 최초 실행되는 부분
 * 처리 해야할 것 -> config 파일 불러오기, session 데이터 불러와서 자동 로그인 단계로 넘기기
 */
public class Main {
	
	public static void main(String[] args) {
		MainProcess.getInstance().initialize();
		
		MainProcess.getInstance().loginProcess();
		
		// -> 여기에 이제 분기점이 들어갑니다
		// 들어가는 info(게시글 보기 / 판매 내역 보기 / 구매 내역 보기 / 회원 정보)
		
		MainProcess.getInstance().endpointProcess();
	}
}
