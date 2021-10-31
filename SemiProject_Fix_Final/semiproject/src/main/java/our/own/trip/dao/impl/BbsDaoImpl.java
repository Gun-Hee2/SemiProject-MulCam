package our.own.trip.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import our.own.trip.dao.BbsDao;
import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.dto.BbsReplyDto;



@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession session;
	
	String ns = "TripBbs.";
	

	


	@Override
	public List<BbsDto> getshareList(BbsParam param) {
		
		return session.selectList(ns + "sharelist", param);
	}
	
	


	@Override
	public List<BbsDto> getreviewList(BbsParam param) {
		
		return session.selectList(ns + "reviewlist", param);
	}




	@Override
	public int getshareAllBbs(BbsParam param) {
		
		return session.selectOne(ns + "shareAllBbs", param);
	}
	
	@Override
	public int getreviewAllBbs(BbsParam param) {
		
		return session.selectOne(ns + "reviewAllBbs", param);
	}


	@Override
	public boolean shareWriteBbs(BbsDto bbs) {
		int n = session.insert(ns + "sharewriteBbs", bbs);
		return n>0?true:false;
	}
	
	


	@Override
	public boolean reviewWriteBbs(BbsDto bbs) {
		int n = session.insert(ns + "reviewwriteBbs", bbs);
		return n>0?true:false;
	}




	@Override
	public void sharereadcount(BbsDto bbs) {
		session.update(ns + "sharereadcount", bbs);
		
	}
	
	@Override
	public void reviewreadcount(BbsDto bbs) {
		session.update(ns + "reviewreadcount", bbs);
		
	}


	@Override
	public BbsDto sharegetBbs(int sseq) {
		
		return session.selectOne(ns + "sharegetBbs", sseq);
	}
	
	@Override
	public BbsDto reviewgetBbs(int sseq) {
		
		return session.selectOne(ns + "reviewgetBbs", sseq);
	}


	@Override
	public boolean shareupdateBbs(BbsDto dto) {
		int n = session.update(ns + "shareupdateBbs", dto);
		return n>0?true:false;
	}
	
	@Override
	public boolean reviewupdateBbs(BbsDto dto) {
		int n = session.update(ns + "reviewupdateBbs", dto);
		return n>0?true:false;
	}


	@Override
	public boolean sharedeleteBbs(int sseq) {
		int n = session.update(ns + "sharedeleteBbs", sseq);
		return n>0?true:false;
	}
	
	@Override
	public boolean reviewdeleteBbs(int sseq) {
		int n = session.update(ns + "reviewdeleteBbs", sseq);
		return n>0?true:false;
	}



	@Override
	public List<BbsReplyDto> getsharereplyList(BbsDto bbs) {
		
		return session.selectList(ns + "sharereplylist", bbs);
	}
	
	@Override
	public List<BbsReplyDto> getreviewreplyList(BbsDto bbs) {
		
		return session.selectList(ns + "sharereplylist", bbs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








