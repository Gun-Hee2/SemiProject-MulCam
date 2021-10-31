package our.own.trip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import our.own.trip.dao.ReplyDao;
import our.own.trip.dto.BbsReplyDto;
import our.own.trip.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDao dao;

	@Override
	public boolean shareWriteReply(BbsReplyDto bbs) {
		
		return dao.shareWriteReply(bbs);
	}

	@Override
	public List<BbsReplyDto> getsharereplyList(BbsReplyDto bbs) {
		
		return dao.getsharereplyList(bbs);
	}
	
	@Override
	public List<BbsReplyDto> getreviewreplyList(BbsReplyDto bbs) {
		
		return dao.getsharereplyList(bbs);
	}
	
	
	

}
