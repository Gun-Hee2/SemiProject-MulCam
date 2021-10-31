package our.own.trip.dao;

import java.util.List;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.dto.MemberDto;

public interface MemberDao {
	
	boolean idcheck(String id);
	
    boolean addmember(MemberDto dto);
	
	MemberDto login(MemberDto mem);
	
    List<BbsDto> getmypageList(BbsParam param);
    
    int getmypageAllBbs(String id);

}
