package our.own.trip.service;

import java.util.HashMap;
import java.util.List;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getshareList(BbsParam param);
	
	List<BbsDto> getreviewList(BbsParam param);
	
	int getshareAllBbs(BbsParam param);
	
	int getreviewAllBbs(BbsParam param);
	
	boolean shareWriteBbs(BbsDto bbs);
	
	boolean reviewWriteBbs(BbsDto bbs);
	
	void readcount(BbsDto bbs);
	
	BbsDto getBbs(int sseq);

	boolean updateBbs(BbsDto dto);
	
	boolean deleteBbs(int sseq);
	
	
}
