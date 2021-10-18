package our.own.trip.dao;

import our.own.trip.dto.MemberDto;

public interface MemberDao {
	
	boolean idcheck(String id);
	
    boolean addmember(MemberDto dto);
	
	MemberDto login(MemberDto mem);

}
