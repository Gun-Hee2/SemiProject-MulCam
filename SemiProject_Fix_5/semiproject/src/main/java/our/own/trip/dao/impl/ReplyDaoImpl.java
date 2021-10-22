package our.own.trip.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import our.own.trip.dao.ReplyDao;
import our.own.trip.dto.BbsReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	SqlSession session;

	String ns = "TripReply.";

	@Override
	public boolean shareWriteReply(BbsReplyDto bbs) {
		int n = session.insert(ns + "writesharereply", bbs);
		return n>0?true:false;
	}

	@Override
	public List<BbsReplyDto> getsharereplyList(BbsReplyDto bbs) {
		
		return session.selectList(ns + "replylist", bbs);
	}
	
	@Override
	public List<BbsReplyDto> getreviewreplyList(BbsReplyDto bbs) {
		
		return session.selectList(ns + "replylist", bbs);
	}
	
	
	
	

}
