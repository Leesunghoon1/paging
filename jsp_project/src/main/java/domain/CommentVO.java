package domain;

public class CommentVO {
	private int con;
	private int bno;
	private String writer;
	private String content;
	private String regdate;
	
	public CommentVO() {
		
	}
	
	public CommentVO(int bno, String writer, String content){
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}
	
	
	

	public CommentVO(int con, int bno, String writer, String content, String regdate) {
		this.con = con;
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public CommentVO(int con, String content) {
		this.con = con;
		this.content = content;
	}

	
	@Override
	public String toString() {
		return "CommentVO [con=" + con + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
	
	
	

}
