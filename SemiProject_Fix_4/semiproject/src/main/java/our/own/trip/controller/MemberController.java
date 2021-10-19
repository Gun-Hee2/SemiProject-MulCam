package our.own.trip.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import our.own.trip.dto.BbsDto;
import our.own.trip.dto.BbsParam;
import our.own.trip.dto.MemberDto;
import our.own.trip.service.MemberService;



@Controller
public class MemberController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String main() {
        logger.info("MemberController main() " + new Date());
		
		return "member/main"; // main.jsp로 이동
		
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi() " + new Date());
		
		return "member/regi";
	}
	
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("MemberController login() " + new Date());
		
		return "member/login"; // login.jsp로 이동
		
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public String idcheck(String id) {
		logger.info("MemberController idcheck() " + new Date());
		System.out.println(id);
		
		boolean b = service.idcheck(id);
		System.out.println(b);
		
		if(b == true) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String addMember(Model model, MemberDto dto) {
		logger.info("MemberController addmember() " + new Date());
		System.out.println(dto.toString());
		
		String regi = "YES";
		if(dto.getId() == null || dto.getPwd() == null || dto.getName() == null || 
				dto.getEmail() == null || dto.getGender() == null) {
			
			regi = "NO";
			
			model.addAttribute("regi", regi);
			
			return "message/regimessage";
		}else {
			
			boolean b = service.addmember(dto); 
			
			
			if(b != false) {
				regi = "YES";
			}	
			
			
			model.addAttribute("regi", regi);
			
			return "message/regimessage";
		}
		
		
	}
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(MemberDto mem, HttpSession session) {
		logger.info("MemberController loginAf() " + new Date());
		
		MemberDto dto = service.login(mem);
		
		System.out.println(dto);
		
		if(dto != null && dto.getId().equals("") == false) {
			//session에 저장
			session.setAttribute("login", dto);
			
			// bbslist.do로 이동
			
			return "redirect:/main.do"; // controller에서 controller로 이동시
		//	return "forward:/bbslist.do"; // 짐을 갖고 controller에서 controller로 이동시
			
		}else {
			return "redirect:/login.do";
		}
		
		
		
	}
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	public String logout(MemberDto mem, HttpSession session) {
		logger.info("MemberController logout() " + new Date());
		
		session.invalidate();
		
		return "redirect:/main.do";
		
	}
	/*
	@RequestMapping(value = "mypage.do", method = RequestMethod.GET)
	public String mypage() {
		logger.info("MemberController mypage() " + new Date());
		
		return "member/mypage";
	}
	*/
	
	@RequestMapping(value = "mypage.do", method = RequestMethod.GET)
	public String mypagelist(String id, Model model, BbsParam param, HttpSession session) {
		logger.info("BbsController mypagelist() " + new Date());
		
	//	System.out.println(mem);
		System.out.println(id);
		System.out.println(param.toString());
		
		// 현재 페이지
		int pageNumber = 0;
		if(param != null) {
			pageNumber = param.getPageNumber();
		}
		model.addAttribute("mypagepageNumber", pageNumber);
		
		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;
		
		param.setStart(start);
		param.setEnd(end);
		param.setId(id);
		
		System.out.println(start);
		System.out.println(end);
		
		List<BbsDto> list = service.getmypageList(param);
		
		System.out.println(list);
		
		model.addAttribute("mypagebbslist", list);
		
		model.addAttribute("reviewchoice", param.getChoice());
		model.addAttribute("reviewsearch", param.getSearch());
		
		
		
		// 총 글의 수 갖고오기
		int allbbs = service.getmypageAllBbs(id);
		
		System.out.println(allbbs);
		
		// 총 페이지 수
		Integer bbsPage = allbbs / 10;
		if((allbbs % 10) > 0) {
			bbsPage = bbsPage + 1;
		}
		
		System.out.println(bbsPage);
		
		model.addAttribute("mypagebbsPage", bbsPage);
		model.addAttribute("id", id);
		
			
		
		return "member/mypage";
		
	}
	
	

}
	

