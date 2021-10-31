package our.own.trip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import our.own.trip.dao.PdsDao;
import our.own.trip.dto.PdsDto;
import our.own.trip.service.PdsService;

@Service
public class PdsServiceImpl implements PdsService{

	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> getPdsList() {
		return dao.getPdsList();
	}
	
	@Override
	public boolean uploadPds(PdsDto dto) {		
		return dao.uploadPds(dto);		
	}

	@Override
	public PdsDto getPds(int seq) {		
		return dao.getPds(seq);
	}
	
	
	
}
