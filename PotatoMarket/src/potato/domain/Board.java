package potato.domain;

import potato.util.CategoryData;

public class Board {
	
	// DTO : 데이터 전송 객체, 계층간 상호작용 도와줌 
	
	private int boardid;
	private String userid;
	private int category;
	private String product;
	private int saleprice;
	private boolean salestatus;
	private String writedate;
	private String tradeloc;
	
	public Board(int boardid, String userid, int category, String product, int saleprice, boolean salestatus,
			String writedate, String tradeloc) {
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


	public Board() {
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public boolean isSalestatus() {
		return salestatus;
	}

	public void setSalestatus(boolean salestatus) {
		this.salestatus = salestatus;
	}

	public String getTradeloc() {
		return tradeloc;
	}

	public void setTradeloc(String tradeloc) {
		this.tradeloc = tradeloc;
	}

	@Override
	public String toString() {
		return "================================================================= \n [게시글 번호] "
				+ boardid + "\n [ 카테고리 ] " + CategoryData.categoryNames.get(category) 
				+ "\n [ 판매자 ] " + userid + "\n [ 상품명 ] " + product
				+ " [ 판매금액 ] " + saleprice + " [ 판매상태 ] " + CategoryData.isSaleString(salestatus) 
				+ " [거래 희망지역] " + tradeloc + "\n [ 작성일시 ] " + writedate ;
	}
	
	
	
	

}
