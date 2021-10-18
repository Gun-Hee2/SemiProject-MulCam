package our.own.trip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import our.own.trip.dao.MemberDao;
import our.own.trip.dto.MemberDto;
import our.own.trip.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public boolean idcheck(String id) {
		
		return dao.idcheck(id);
	}
	

	@Override
	public boolean addmember(MemberDto dto) {
	
		return dao.addmember(dto);
	}

	@Override
	public MemberDto login(MemberDto mem) {
		
		return dao.login(mem);
	}

}
