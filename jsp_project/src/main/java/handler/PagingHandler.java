package handler;

import domain.PagingVO;

public class PagingHandler {//jsp에서 list 하단에 나올 페이지네이션 핸들링 클래스

	private int startPage; //현재 화면에서 보여줄 시작 페이지네이션 번호 <=이전 (1), 2, 3, 4, 5 다음=>
	
	private int endPage; //현재 화면에서 보여줄 마지막 페이지네이션 번호 <=이전 1, 2, 3, 4, (5) 다음=>
	
	private int realEndPage; //마지막 실제 전체 페이지 번호
	
	private boolean prev, next; //이전, 다음페이지 존재 여부
	
	private int totalCount; //전체 글 수
	
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		//list.jsp에서 페이지번호버튼을 누르면 pageNo와qty를 받아 생성된 pagingVO와 totalcount를
		//boardController를 통해 받아온다

		this.pgvo=pgvo;
		this.totalCount=totalCount;
		
		// 1~10까지는 마지막 페이지가 10, 11~20 마지막 페이지 20, 21~30 마지막 페이지 30
				//페이지번호(1) / 한 화면의 게시글 수(10) * 한 화면의 게시글 수(10)
				// 1 / 10 = 0.1 * 10 = 10 / 0.1 을 1로 만들어야됨
				// 2 / 10 = 0.2 * 10 = 10 / 0.2 을 2로 만들어야됨
		
		this.endPage = //어떤걸 눌러도 end페이지가 나와야하는 공식 
				(int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) 

				* pgvo.getQty();
		
		this.startPage = this.endPage - 9;
		
		//게시글 수 = 11개 1,2
		//전체 게시글 수/한 화면의 게시글 수
		//나머지가 생기면 무조건 1페이지 더 생겨야함.
		//페이지네이션의 마지막 페이지
		
		
		//ex) totalCount=42,qty=10
		//42/10 = 4.2 (ceil)-> realEndPage=5
		this.realEndPage=(int)Math.ceil(totalCount/(double)pgvo.getQty());
		//(double)pgvo.getQty()) 한페이지에 표현되는 개수
		//ex)realEndPage=7 endPage=1/10 = 0.1 (ceil)->1 * 10 = 10 일때
		//endPage는realEndPage를 넘으면 안되므로 endPage에 realEndPage를 대입
		
		
		if(this.realEndPage < this.endPage)
			this.endPage=this.realEndPage;
		
		//startPage는 1부터 qty값만큼 증가함
		//startPage가 1+qty*n의 값이면 n번째페이지그룹이므로
		//이전페이지그룹버튼을 누를수있게 활성화할 prev변수를 true로만들수있게 구현
		
		this.prev=this.startPage > 1; //존재여부 1, 11, 21 스타트페이지 는 2가 될수없음	
		this.next=this.endPage < this.realEndPage; //endPage가 realEndPage보다 작으면 다음페이지그룹이 존재함
		// endPage가 realEndPage 페이지보다 많으면 다음으로 갈수있는 클릭버튼 생성
		
		
				
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}
}
