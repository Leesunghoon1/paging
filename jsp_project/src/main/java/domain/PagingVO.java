package domain;

public class PagingVO {
	
	private int pageNo; //현재 화면에 출력되는 페이지네이션 번호
	private int qty; //한 페이지당 보여줄 게시글 수
	
	//검색 멤버변수를 추가
	private String type; //어떤 검색을 할지
	private String keyword;//검색어
	
	public PagingVO() { //페이지네이션을 클릭하기 전 기본리스트 출력값
		this(1,10);
	}
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	public int getPageStart() {
		return (pageNo-1)*qty; 
	}
	
	//type이 여러개 들어올때 값을 배열로 리턴
	public String[] getTypeToArray() {
		return(this.type == null) ? new String[] {} : this.type.split("");
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
