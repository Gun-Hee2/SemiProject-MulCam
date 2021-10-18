package our.own.trip.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import our.own.trip.dao.BbsDao;
import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.service.BbsService;


@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDao dao;

	

	@Override
	public List<BbsDto> getshareList(BbsParam param) {
		
		return dao.getshareList(param);
	}
	
	

	@Override
	public List<BbsDto> getreviewList(BbsParam param) {
		
		return dao.getreviewList(param);
	}



	@Override
	public int getshareAllBbs(BbsParam param) {
		
		return dao.getshareAllBbs(param);
	}
	
	@Override
	public int getreviewAllBbs(BbsParam param) {
		
		return dao.getreviewAllBbs(param);
	}

	@Override
	public boolean shareWriteBbs(BbsDto bbs) {
		
		return dao.shareWriteBbs(bbs);
	}
	
	

	@Override
	public boolean reviewWriteBbs(BbsDto bbs) {
		
		return dao.reviewWriteBbs(bbs);
	}



	@Override
	public void readcount(BbsDto bbs) {
		
		dao.readcount(bbs);
		
	}

	@Override
	public BbsDto getBbs(int sseq) {
		
		return dao.getBbs(sseq);
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		
		return dao.updateBbs(dto);
	}

	@Override
	public boolean deleteBbs(int sseq) {
		
		return dao.deleteBbs(sseq);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
