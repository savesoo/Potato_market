package potato.domain;

public class UserData {

	private String userid;
	private String password;
	private String joindate;
	private String loc;
	private String nickname;
	private boolean deleteuser;
	
	
	public UserData(String userid, String password, String joindate, String loc, String nickname, boolean deleteuser) {
		this.userid = userid;
		this.password = password;
		this.joindate = joindate;
		this.loc = loc;
		this.nickname = nickname;
		this.deleteuser = deleteuser;
	}
	
	// 회원 가입 할 때 사용하는 생성자
	public UserData(String userid, String password, String loc, String nickname) {
		this.userid = userid;
		this.password = password;
		this.loc = loc;
		this.nickname = nickname;
	}
	
	// 회원 정보 수정할 때 사용하는 생성자
	public UserData(String password, String loc, String nickname) {
		this.password = password;
		this.loc = loc;
		this.nickname = nickname;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getJoindate() {
		return joindate;
	}


	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public boolean isDeleteuser() {
		return deleteuser;
	}


	public void setDeleteuser(boolean deleteuser) {
		this.deleteuser = deleteuser;
	}


	@Override
	public String toString() {
		return "\t아이디 : " +userid + "\n" + "\t가입일 : " +joindate + "\n" + "\t거주지역 : " +loc + "\n" + "\t닉네임 : " +nickname;
	}
	
	
	
	
}
