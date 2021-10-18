package our.own.trip.service;

import our.own.trip.dto.MemberDto;

public interface MemberService {
	
	boolean idcheck(String id);
	
	boolean addmember(MemberDto dto);
	
	MemberDto login(MemberDto mem);

}
