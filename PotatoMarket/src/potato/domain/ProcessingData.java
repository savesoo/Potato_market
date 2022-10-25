package potato.domain;

public class ProcessingData {
	
	private int boardid;
	private String userid;
	private int category;
	private String product;
	private int saleprice;
	private boolean salestatus;
	private int writedate;
	private String tradeloc;
	
	
	public ProcessingData(int boardid, String userid, int category, String product, int saleprice, boolean salestatus,
			int writedate, String tradeloc) {
		super();
		this.boardid = boardid;
		this.userid = userid;
		this.category = category;
		this.product = product;
		this.saleprice = saleprice;
		this.salestatus = salestatus;
		this.writedate = writedate;
		this.tradeloc = tradeloc;
	}
	public int getBoardid() {
		return boardid;
	}
	public String getUserid() {
		return userid;
	}
	public int getCategory() {
		return category;
	}
	public String getProduct() {
		return product;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public boolean isSalestatus() {
		return salestatus;
	}
	public int getWritedate() {
		return writedate;
	}
	public String getTradeloc() {
		return tradeloc;
	}
	@Override
	public String toString() {
		return "ProcessingData [boardid=" + boardid + ", userid=" + userid + ", category=" + category + ", product="
				+ product + ", saleprice=" + saleprice + ", salestatus=" + salestatus + ", writedate=" + writedate
				+ ", tradeloc=" + tradeloc + "]";
	}
	
	
	
	

}
