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
	public void sharereadcount(BbsDto bbs) {
		
		dao.sharereadcount(bbs);
		
	}
	
	@Override
	public void reviewreadcount(BbsDto bbs) {
		
		dao.reviewreadcount(bbs);
		
	}

	@Override
	public BbsDto sharegetBbs(int sseq) {
		
		return dao.sharegetBbs(sseq);
	}
	
	@Override
	public BbsDto reviewgetBbs(int sseq) {
		
		return dao.reviewgetBbs(sseq);
	}

	@Override
	public boolean shareupdateBbs(BbsDto dto) {
		
		return dao.shareupdateBbs(dto);
	}
	
	@Override
	public boolean reviewupdateBbs(BbsDto dto) {
		
		return dao.reviewupdateBbs(dto);
	}

	@Override
	public boolean sharedeleteBbs(int sseq) {
		
		return dao.sharedeleteBbs(sseq);
	}
	
	@Override
	public boolean reviewdeleteBbs(int sseq) {
		
		return dao.reviewdeleteBbs(sseq);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
