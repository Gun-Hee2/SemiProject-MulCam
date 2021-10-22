package our.own.trip.dao;

import java.util.List;

import our.own.trip.dto.PdsDto;

public interface PdsDao {

	
	List<PdsDto> getPdsList();
	
	boolean uploadPds(PdsDto dto);
	PdsDto getPds(int seq);
}
