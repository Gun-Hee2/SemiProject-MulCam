package our.own.trip.service;

import java.util.List;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsReplyDto;

public interface ReplyService {
	
	boolean shareWriteReply(BbsReplyDto bbs);
	
	List<BbsReplyDto> getsharereplyList(BbsReplyDto bbs);
	
	List<BbsReplyDto> getreviewreplyList(BbsReplyDto bbs);

}
