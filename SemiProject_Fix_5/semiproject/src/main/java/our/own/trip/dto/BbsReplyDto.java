package our.own.trip.dto;

import java.io.Serializable;

public class BbsReplyDto implements Serializable{
	
	private int seq;        // 중복되지 않는번호 sequence       
	
	private String id;   // 댓글 작성자
    private String replycontent; // 댓글 내용
    private String wdate;   // 작성한 날짜, 작성일
    
    private int del;        // 삭제 여부
    
    public BbsReplyDto() {
    	
    }

	public BbsReplyDto(int seq, String id, String replycontent, String wdate, int del) {
		super();
		this.seq = seq;
		this.id = id;
		this.replycontent = replycontent;
		this.wdate = wdate;
		this.del = del;
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

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
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

	@Override
	public String toString() {
		return "BbsReplyDto [seq=" + seq + ", id=" + id + ", replycontent=" + replycontent + ", wdate=" + wdate
				+ ", del=" + del + "]";
	}

	

	

	

	
    
    

}
