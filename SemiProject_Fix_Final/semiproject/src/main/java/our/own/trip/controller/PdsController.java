package our.own.trip.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import our.own.trip.dto.PdsDto;
import our.own.trip.service.PdsService;
import our.own.trip.util.PdsUtil;

@Controller
public class PdsController {
	
	private static Logger logger = LoggerFactory.getLogger(PdsController.class);

	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method = RequestMethod.GET)
	public String pdslist(Model model) {
		logger.info("PdsController pdslist() " + new Date());
		
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist", list);
		
		return "pds/pdslist";
	}
	
	@RequestMapping(value = "pdswrite.do", method = RequestMethod.GET)
	public String pdswrite() {
		logger.info("PdsController pdswrite " + new Date());
		
		return "pds/pdswrite";
	}	
	//파일 업로드 파트
	@RequestMapping(value = "mypdsupload.do", method = RequestMethod.POST)
	public String pdsupload(PdsDto pdsdto,                                          // 매개변수1
			                 @RequestParam(value = "myfileload", required = false)  
	                          MultipartFile myfileload,                             // 매개변수2
	                          HttpServletRequest req) {                             // 매개변수3
	       
		logger.info("PdsController pdsupload " + new Date());

		logger.info(pdsdto.toString());
		
		String filename = myfileload.getOriginalFilename();    // filename(원본) 취득                         
		System.out.println(filename);
		
		// 업로드 경로설정 1) 서버 저장방식(톰캣) <- 진짜 
		
		String fupload = req.getServletContext().getRealPath("/upload"); 
		
		
		// 2) 클라이언트 저장방식이 있음. (개인용pc 폴더)
        //String fupload = "d:\\(pc폴더 경로)
		System.out.println("fupload" + fupload);
		
		// 파일명이 충돌되지 않도록 파일명을 변경해주는 코드
		String newfilename = PdsUtil.setNewFileName(filename);
		System.out.println("newfilename" + newfilename);
		
	    pdsdto.setFilename(filename);
	    pdsdto.setNewfilename(newfilename);
	    
	    File file = new File(fupload + "/" + newfilename);
	 
		try {
			// 폴더에 실제 업로드
			FileUtils.writeByteArrayToFile(file, myfileload.getBytes());
			
			// DB에 저장
			service.uploadPds(pdsdto);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
				
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "pdsdetail.do", method = RequestMethod.GET)
	public String pdsdetail(int seq, Model model) {
		logger.info("PdsController pdsdetail " + new Date());
		
		PdsDto pds = service.getPds(seq);
		model.addAttribute("pds", pds);
		model.addAttribute("content", "pdsdetail");
	
		 return "pds/pdsdetail";
		//   return "member/main";
	}
	
	@RequestMapping(value = "fileDownload.do", method = RequestMethod.GET)
	public String fileDownload(String newfilename, String filename, int seq, 
								Model model, HttpServletRequest req) {		
		// 경로지정 
		// 서버에 대한 경로 
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
		//String fupload = "d:\\(pc폴더 경로)
		
		File downloadFile = new File(fupload + "/" + newfilename); 
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("filename", filename);
		model.addAttribute("seq", seq);
		
		return "downloadView";
		
	}
	
	
}
