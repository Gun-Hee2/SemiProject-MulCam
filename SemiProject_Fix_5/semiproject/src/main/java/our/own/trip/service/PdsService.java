package our.own.trip.service;

import java.util.List;

import our.own.trip.dto.PdsDto;

public interface PdsService {

	
	List<PdsDto> getPdsList();
	
	boolean uploadPds(PdsDto dto);
	PdsDto getPds(int seq);
}
