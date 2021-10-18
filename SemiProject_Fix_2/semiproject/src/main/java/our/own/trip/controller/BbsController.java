package our.own.trip.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.service.BbsService;

@Controller
public class BbsController {
	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "share.do", method = RequestMethod.GET)
	public String sharelist(Model model, BbsParam param) {
		logger.info("BbsController sharelist() " + new Date());
		
		System.out.println(param);
		
		// 현재 페이지
		int pageNumber = 0;
		if(param != null) {
			pageNumber = param.getPageNumber();
		}
		model.addAttribute("sharepageNumber", pageNumber);
		
		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;
		
		param.setStart(start);
		param.setEnd(end);
		
		System.out.println(start);
		System.out.println(end);
		
		
		List<BbsDto> list = service.getshareList(param);
		
		System.out.println(list);
		
		model.addAttribute("sharebbslist", list);
		
		model.addAttribute("sharechoice", param.getChoice());
		model.addAttribute("sharesearch", param.getSearch());
		
		// 총 글의 수 갖고오기
		int allbbs = service.getshareAllBbs(param);
		
		System.out.println(allbbs);
		
		// 총 페이지 수
		Integer bbsPage = allbbs / 10;
		if((allbbs % 10) > 0) {
			bbsPage = bbsPage + 1;
		}
		
		System.out.println(bbsPage);
		
		model.addAttribute("sharebbsPage", bbsPage);
		
		
		return "bbs/sharelist";
		
	}
	
	@RequestMapping(value = "review.do", method = RequestMethod.GET)
	public String reviewlist(Model model, BbsParam param) {
		logger.info("BbsController reviewlist() " + new Date());
		
		System.out.println(param);
		
		// 현재 페이지
		int pageNumber = 0;
		if(param != null) {
			pageNumber = param.getPageNumber();
		}
		model.addAttribute("reviewpageNumber", pageNumber);
		
		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;
		
		param.setStart(start);
		param.setEnd(end);
		
		// 총 글의 수 갖고오기
				int allbbs = service.getreviewAllBbs(param);
				
				System.out.println(allbbs);
				
				
				// 총 페이지 수
				Integer bbsPage = allbbs / 10;
				if((allbbs % 10) > 0) {
					bbsPage = bbsPage + 1;
				}
		
		
		List<BbsDto> list = service.getreviewList(param);
		
		System.out.println(list);
		
		model.addAttribute("reviewbbslist", list);
		
		model.addAttribute("reviewchoice", param.getChoice());
		model.addAttribute("reviewsearch", param.getSearch());
		
		
		
		model.addAttribute("reviewbbsPage", bbsPage);
		
		
		return "bbs/reviewlist";
		
	}
	
	@RequestMapping(value = "sharebbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
		logger.info("BbsController bbswrite " + new Date());
		
		return "bbs/sharebbswrite";
		
	}
	
	@RequestMapping(value = "sharebbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs) {
		logger.info("BbsController bbswriteAf " + new Date());
		
		boolean b = service.shareWriteBbs(bbs);
		
		if(b == true) {
			return "redirect:/share.do";
		}
			
		return "redirect:/share.do";
		
	}
	
	@RequestMapping(value = "reviewbbswrite.do", method = RequestMethod.GET)
	public String reviewbbswrite() {
		logger.info("BbsController bbswrite " + new Date());
		
		return "bbs/reviewbbswrite";
		
	}
	
	@RequestMapping(value = "reviewbbswriteAf.do", method = RequestMethod.POST)
	public String reviewbbswriteAf(BbsDto bbs) {
		logger.info("BbsController bbswriteAf " + new Date());
		
		boolean b = service.reviewWriteBbs(bbs);
		
		if(b == true) {
			return "redirect:/review.do";
		}
			
		return "redirect:/review.do";
		
	}
	
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(BbsDto bbs, String seq, String name, Model model) {
		logger.info("BbsController bbsdetail " + new Date());
		
		System.out.println(bbs);
		
		int sseq = Integer.parseInt(seq);
		
		service.readcount(bbs); // BbsDao의 readcount()메소드에 seq를 넣고 실행하여 readcount를 증가

		BbsDto dto = service.getBbs(sseq); // seq로 dto취득
		
		model.addAttribute("seq", seq);
		
		model.addAttribute("name", name);
		
		model.addAttribute("bbs", dto);
		
		return "bbs/bbsdetail";
		
	}
	
	@RequestMapping(value = "bbsupdate.do", method = RequestMethod.GET)
	public String bbsupdate(BbsDto bbs, String seq, Model model) {
		logger.info("BbsController bbsupdate " + new Date());
		
		int sseq = Integer.parseInt(seq);
		
		System.out.println(bbs);
		
		service.readcount(bbs); // BbsDao의 readcount()메소드에 seq를 넣고 실행하여 readcount를 증가

		BbsDto dto = service.getBbs(sseq); // seq로 dto취득
		
		model.addAttribute("seq", seq);
		
		model.addAttribute("bbs", dto);
		
		return "bbs/bbsupdate";
		
	}
	
	@RequestMapping(value = "bbsupdateAf.do", method = RequestMethod.POST)
	public String bbsupdateAf(BbsDto dto, String updatetitle, String updatecontent, int seq, Model model) {
		logger.info("BbsController bbsupdateAf " + new Date());
		
		BbsDto updto = new BbsDto(seq, updatetitle, updatecontent);
		System.out.println(dto);
		System.out.println(updto);
		
		int sort = dto.getSort();
		
		boolean updateBbs = service.updateBbs(updto);
		
		String update = "YES";
		if(updateBbs == false) {
			update = "NO";
		}
		
		model.addAttribute("update", update);
		model.addAttribute("sort", sort);
		
		return "message/updatemessage";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = RequestMethod.GET)
	public String bbsdelete(BbsDto dto, String seq, Model model) {
		logger.info("BbsController bbsdelete " + new Date());
		System.out.println(seq);
		
		int sort = dto.getSort();
		
		int sseq = Integer.parseInt(seq);
		
		boolean deleteBbs = service.deleteBbs(sseq);
		System.out.println(deleteBbs);
		
		String delete = "YES";
		if(deleteBbs == false) {
			delete = "NO";
		}
		
		model.addAttribute("delete", delete);
		
		model.addAttribute("sort", sort);
		
		return "bbs/bbsdelete";
		
	}
	
	
	
	
	
}
