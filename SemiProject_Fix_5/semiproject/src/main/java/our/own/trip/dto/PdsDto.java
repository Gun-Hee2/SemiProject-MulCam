package our.own.trip.dto;

import java.io.Serializable;

public class PdsDto implements Serializable{ 

	private int seq;      // 중복되지 않는번호 sequence
	private String id;    // 글을 작성한 작성자 id값
	
	private String title;     // 글 제목
	private String content;   // 글 내용
	
	private int del;            // 삭제 여부
	private int readcount;      // 글의 조회수   
	
	private String filename;      // 업로드하려는 파일의 원래 이름 mytext.txt
	private String newfilename;   // 변환된 파일의 이름 (숫자로 나옴 13456.txt)
	private int downcount;        // 다운로드 수 
	private String regdate;       // 작성한 날짜, 작성일
	
	public PdsDto() {
		
	}

	public PdsDto(int seq, String id, String title, String content, int del, int readcount, String filename,
			String newfilename, int download, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.del = del;
		this.readcount = readcount;
		this.filename = filename;
		this.newfilename = newfilename;
		this.downcount = downcount;
		this.regdate = regdate;
	}

	public PdsDto(String id, String title, String content, String filename, String newfilename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
	}
	
	

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PdsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", del=" + del
				+ ", readcount=" + readcount + ", filename=" + filename + ", newfilename=" + newfilename + ", downcount="
				+ downcount + ", regdate=" + regdate + "]";
	}
    
	
	
	
}
