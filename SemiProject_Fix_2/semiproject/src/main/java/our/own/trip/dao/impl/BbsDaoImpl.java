package our.own.trip.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import our.own.trip.dao.BbsDao;
import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;



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
	public void readcount(BbsDto bbs) {
		session.update(ns + "readcount", bbs);
		
	}


	@Override
	public BbsDto getBbs(int sseq) {
		
		return session.selectOne(ns + "getBbs", sseq);
	}


	@Override
	public boolean updateBbs(BbsDto dto) {
		int n = session.update(ns + "updateBbs", dto);
		return n>0?true:false;
	}


	@Override
	public boolean deleteBbs(int sseq) {
		int n = session.update(ns + "deleteBbs", sseq);
		return n>0?true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








