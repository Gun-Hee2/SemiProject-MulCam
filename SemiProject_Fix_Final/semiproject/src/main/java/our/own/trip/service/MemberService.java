package our.own.trip.service;

import java.util.List;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.dto.MemberDto;

public interface MemberService {
	
	boolean idcheck(String id);
	
	boolean addmember(MemberDto dto);
	
	MemberDto login(MemberDto mem);
	
    List<BbsDto> getmypageList(BbsParam param);
    
    int getmypageAllBbs(String id);

}
