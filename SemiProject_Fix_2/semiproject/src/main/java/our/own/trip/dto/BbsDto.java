package our.own.trip.dto;

import java.io.Serializable;

public class BbsDto implements Serializable {
	
	private int seq;        // 중복되지 않는번호 sequence 
	private int sort;
	private String id;      // 글을 작성한 작성자
	
	private String title;   // 글 제목
    private String content; // 글 내용
    private String wdate;   // 작성한 날짜, 작성일
    
    private int del;        // 삭제 여부
    private int readcount;  // 글의 조회수
    
    public BbsDto() {
		
	}

	public BbsDto(int seq, int sort, String id, String title, String content, String wdate, int del, int readcount) {
		super();
		this.seq = seq;
		this.sort = sort;
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
	}
	
	

	public BbsDto(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", sort=" + sort + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", wdate=" + wdate + ", del=" + del + ", readcount=" + readcount + "]";
	}

	
    
    
    
}








