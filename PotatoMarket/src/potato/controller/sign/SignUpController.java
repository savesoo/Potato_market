package potato.controller.sign;

import potato.controller.IController;
import potato.domain.UserData;
import potato.service.CheckIdService;
import potato.service.InsertMemService;
import potato.util.EncryptString;
import potato.util.InputString;

public class SignUpController implements IController {

	private InsertMemService service = new InsertMemService();
	private CheckIdService service2 = new CheckIdService();

	
	@Override
	public boolean process() {
		while (true) {
			System.out.println();
			System.out.println("·.̩₊̣.̩✧*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩⋆·̩̩.̩̥·̩̩⋆*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩✧·.̩₊̣.̩‧ ");
			System.out.println("\t   감 자 마 켓");
			System.out.println("   감자마켓은 동네 직거래 마켓이에요.");
			System.out.println("      회원가입을 시작해보세요!");
			System.out.println("·.̩₊̣.̩✧*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩⋆·̩̩.̩̥·̩̩⋆*̣̩˚̣̣⁺̣‧.₊̣̇.‧⁺̣˚̣̣*̣̩✧·.̩₊̣.̩‧ ");
			System.out.println();
			String userid = service2.checkId();
			System.out.print("비밀번호를 설정해주세요 >>");
			String password = InputString.inputDefaultString();

			try {
				password = EncryptString.encryptAES256(password);
			} catch (Exception e) {
				System.out.println("프로그램 에러.");
				return false;
			}

			System.out.print("거주지역을 설정해주세요 >>");
			String loc = InputString.inputDefaultString();
			System.out.print("닉네임을 설정해주세요 >> ");
			String nickname = InputString.inputDefaultString();

			int result = service.signUp(new UserData(userid, password, loc, nickname));

			if (result > 0) {
				System.out.println("회원가입에 성공했습니다.");
				break;
				
			} else {
				System.out.println("회원가입에 실패했습니다.");
				System.out.println("다시 회원가입이 진행됩니다.");

			}

		}
		return true;
	}
}
