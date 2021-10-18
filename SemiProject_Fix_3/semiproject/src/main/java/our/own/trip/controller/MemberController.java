package our.own.trip.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	

}
	

