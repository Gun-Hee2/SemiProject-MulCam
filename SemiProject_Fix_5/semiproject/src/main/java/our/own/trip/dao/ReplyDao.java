package our.own.trip.dao;

import java.util.List;

import our.own.trip.dto.BbsReplyDto;

public interface ReplyDao {
	
	boolean shareWriteReply(BbsReplyDto bbs);
	
	List<BbsReplyDto> getsharereplyList(BbsReplyDto bbs);
	
	List<BbsReplyDto> getreviewreplyList(BbsReplyDto bbs);

}
