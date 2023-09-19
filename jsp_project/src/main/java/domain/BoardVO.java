package domain;

public class BoardVO {
//	crate table board(
//	bno int not null auto_increment,
//	title varchar(200) not null,
//	writer varchar(100) not null,
//	content text,
//	regdate datetime default now(),
//	moddate datetime default now(),
//	primary key(bno));
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int count;
	private String image_File;
	
	
	


	public BoardVO() {} //기본생성자

	public BoardVO(String title, String writer, String content) { // 값 집어넣을때 필요한 생성자
		
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardVO(int bno, String title, String writer, String regdate) { // 리스트 확인 할때 필요한 생성자
		
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
	}

	public BoardVO(int bno, String title, String content) { // 업데이트 할때 필요한 생성자
		
		this.bno = bno;
		this.title = title;
		this.content = content;
	}

	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate) {
		//전체 생성자
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
	}
	
	
	public BoardVO(int bno, String title, String writer, String content, 
			String regdate, String moddate, int count, String image_File) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.count = count;
		this.image_File = image_File;
	}

	
	public String getImage_File() {
		return image_File;
	}

	public void setImage_File(String image_File) {
		this.image_File = image_File;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + ", count=" + count + ", image_File=" + image_File + "]";
	}
	
	
	
	

}
