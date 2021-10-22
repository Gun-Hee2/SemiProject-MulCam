package our.own.trip.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import our.own.trip.dao.MemberDao;
import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "TripMember.";

	@Override
	public boolean idcheck(String id) {
		int n = sqlSession.selectOne(namespace + "idcheck", id);
		return n>0?true:false;
	}

	@Override
	public boolean addmember(MemberDto dto) {
		int n = sqlSession.insert(namespace + "addmember", dto);
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto mem) {
		return sqlSession.selectOne(namespace + "login", mem);
	}

	@Override
	public List<BbsDto> getmypageList(BbsParam param) {
		
		return sqlSession.selectList(namespace + "mypagelist", param);
	}

	@Override
	public int getmypageAllBbs(String id) {
		
		return sqlSession.selectOne(namespace + "mypageAllBbs", id);
	}
	
	
	
	

}
