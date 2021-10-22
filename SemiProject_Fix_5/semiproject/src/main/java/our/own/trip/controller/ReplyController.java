package our.own.trip.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsReplyDto;
import our.own.trip.service.ReplyService;

@Controller
public class ReplyController {
	
private static Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	ReplyService service;
	
	@RequestMapping(value = "sharereplylist.do", method = RequestMethod.POST)
	public String sharereplylist(BbsReplyDto BbsReplyDto, BbsDto dto, String name, Model model) {
		logger.info("ReplyController sharereplylist " + new Date());
		
		
		System.out.println(BbsReplyDto);
		
		int seq = BbsReplyDto.getSeq();
		
		System.out.println(seq);
		
		List<BbsReplyDto> list = service.getsharereplyList(BbsReplyDto);
		
		System.out.println(list);
		
		model.addAttribute("seq", seq);
		
		model.addAttribute("dto", dto);
		
		model.addAttribute("name", name);
		
		model.addAttribute("list", list);
	
		return "bbs/sharebbsdetail"; // 각 해당되는 디테일로 이동
		
	}
	
	@RequestMapping(value = "writesharereply.do", method = RequestMethod.POST)
	public String writesharereply(BbsReplyDto bbs, int seq, BbsDto dto, String name, Model model) {
		logger.info("ReplyController writesharereply " + new Date());
		
		System.out.println(bbs.toString());
		System.out.println(dto.toString());
		System.out.println(name);
		
		
		boolean b = service.shareWriteReply(bbs);
		
		System.out.println(b);
		
		model.addAttribute("BbsReplyDto", bbs);
		
		model.addAttribute("bbs", dto);
		
		model.addAttribute("name", name);
		
		if(b == true) {
			return "forward:/sharereplylist.do";
		}
		
		
		return "forward:/sharereplylist.do"; // 각 해당되는 디테일로 이동
		
		
	}
	
	@RequestMapping(value = "reviewreplylist.do", method = RequestMethod.POST)
	public String reviewreplylist(BbsReplyDto BbsReplyDto, BbsDto dto, String name, Model model) {
		logger.info("ReplyController reviewreplylist " + new Date());
		
		
		System.out.println(BbsReplyDto);
		
		int seq = BbsReplyDto.getSeq();
		
		System.out.println(seq);
		
		List<BbsReplyDto> list = service.getsharereplyList(BbsReplyDto);
		
		System.out.println(list);
		
		model.addAttribute("seq", seq);
		
		model.addAttribute("dto", dto);
		
		model.addAttribute("name", name);
		
		model.addAttribute("list", list);
	
		return "bbs/reviewbbsdetail"; // 각 해당되는 디테일로 이동
		
	}
	
	@RequestMapping(value = "writereviewreply.do", method = RequestMethod.POST)
	public String writereviewreply(BbsReplyDto bbs, int seq, BbsDto dto, String name, Model model) {
		logger.info("ReplyController writereviewreply " + new Date());
		
		System.out.println(bbs.toString());
		System.out.println(dto.toString());
		System.out.println(name);
		
		
		boolean b = service.shareWriteReply(bbs);
		
		System.out.println(b);
		
		model.addAttribute("BbsReplyDto", bbs);
		
		model.addAttribute("bbs", dto);
		
		model.addAttribute("name", name);
		
		if(b == true) {
			return "forward:/reviewreplylist.do";
		}
		
		
		return "forward:/reviewreplylist.do"; // 각 해당되는 디테일로 이동
		
		
	}
	

}
