package potato.domain;

public class HistoryData {

	private String userid;
	private int boardid;
	private int orderid;

	public HistoryData(String userid, int boardid, int orderid) {
		super();
		this.userid = userid;
		this.boardid = boardid;
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public int getBoardid() {
		return boardid;
	}

	public int getOrderid() {
		return orderid;
	}

	@Override
	public String toString() {
		return "HistoryData [userid=" + userid + ", boardid=" + boardid + ", orderid=" + orderid + "]";
	} 

}
