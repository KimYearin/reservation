package kr.or.connect.reservation.controller;


import java.io.IOException;
import java.text.ParseException;

import java.util.List;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.reservation.dto.FrontForm;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/")
	public String ImgList( ModelMap model) throws JsonProcessingException {
		
		//시작점 표시
		int start=0;
		model.addAttribute("start", start);
		
		//전체갯수
		int totalCount = reservationService.categoryCount(1)+reservationService.categoryCount(2)+reservationService.categoryCount(3)+reservationService.categoryCount(4)+reservationService.categoryCount(5);
		model.addAttribute("totalCount", totalCount);
		
		//promotion갯수
		int promotionCount = reservationService.promotionCount();
		model.addAttribute("promotionCount", promotionCount);
		
		
		List<Promotion> imgList = reservationService.getPromotion(); //프로모션 이미지
		List<FrontForm> frontList = reservationService.getFrontInfoAll(0, ReservationService.LIMIT); //전체정보
		List<FrontForm> category1 = reservationService.getFrontInfo(1,0, ReservationService.LIMIT); //카테고리별 리스트(일단 임의로 1 부여)
		List<FrontForm> category2 = reservationService.getFrontInfo(2,0, ReservationService.LIMIT); //카테고리별 리스트(일단 임의로 2 부여)
		List<FrontForm> category3 = reservationService.getFrontInfo(3,0, ReservationService.LIMIT); //카테고리별 리스트(일단 임의로 3 부여)
		List<FrontForm> category4 = reservationService.getFrontInfo(4,0, ReservationService.LIMIT); //카테고리별 리스트(일단 임의로 4 부여)
		List<FrontForm> category5 = reservationService.getFrontInfo(5,0, ReservationService.LIMIT); //카테고리별 리스트(일단 임의로 5 부여)
		
		//데이터를 json형태로 변환
		ObjectMapper mapper = new ObjectMapper();
		String json_frontList = mapper.writeValueAsString(frontList);
		String json_category1 = mapper.writeValueAsString(category1);
		String json_category2 = mapper.writeValueAsString(category2);
		String json_category3 = mapper.writeValueAsString(category3);
		String json_category4 = mapper.writeValueAsString(category4);
		String json_category5 = mapper.writeValueAsString(category5);

		
		model.addAttribute("frontList", json_frontList); //전체정보 frontList
		model.addAttribute("imgList", imgList); //프로보션 이미지
		model.addAttribute("category1", json_category1); //카테고리별 리스트(일단 임의로 1 부여)
		model.addAttribute("category2", json_category2); //카테고리별 리스트(일단 임의로 2 부여)
		model.addAttribute("category3", json_category3); //카테고리별 리스트(일단 임의로 3 부여)
		model.addAttribute("category4", json_category4); //카테고리별 리스트(일단 임의로 4 부여)
		model.addAttribute("category5", json_category5); //카테고리별 리스트(일단 임의로 5 부여)
		
		
		
		return "mainpage";
	}
	
	@ResponseBody
	@RequestMapping(path="/getMoreContents", method = RequestMethod.POST)
	//전체리스트 추가정보 가져오기
	public void moreList(HttpServletRequest req, HttpServletResponse res, HttpSession session)throws ParseException, IOException {
		if ("POST".equalsIgnoreCase(req.getMethod())) {
			//ajax를 이용해서 받은 정보(start)
			String msg = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			//System.out.println(msg);
			int start = Integer.parseInt(msg);
			
			//start부터 4개 더 가져오기
			List<FrontForm> resultList = reservationService.getFrontInfoAll(start, ReservationService.LIMIT);
			//System.out.println(resultList);
			
			
			//json형태로 만들기
			ObjectMapper mapper = new ObjectMapper(); 
			String json_addfrontList = mapper.writeValueAsString(resultList);
			//System.out.println(json_addfrontList);
			 
			
			
			//전체갯수
			int totalCount = reservationService.totalCount();
			//System.out.println(totalCount);
			
			
			//전송
			res.setContentType("application/json; charset=utf-8");
			//res.getWriter().write(json_addfrontList.toString());
			res.getWriter().write(Integer.toString(totalCount)+"totalCount");
			res.getWriter().write(json_addfrontList);
			
		}
	}
	
	
	@ResponseBody
	@RequestMapping(path="/getMoreContents2", method = RequestMethod.POST)
	//카테고리별 추가 정보가져오기
	public void moreList2(HttpServletRequest req, HttpServletResponse res, HttpSession session)throws ParseException, IOException {
		if ("POST".equalsIgnoreCase(req.getMethod())) {
			//ajax를 이용해서 받은 정보(start, category)
			String msg = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			//System.out.println(msg);
			String[] str = msg.split(" ");
			int start = Integer.parseInt(str[0]);//시작점
			int categoryNum = Integer.parseInt(str[1]);//카테고리
			
			//start부터 4개 더 가져오기
			List<FrontForm> resultList = reservationService.getFrontInfo(categoryNum, start, ReservationService.LIMIT);
			//System.out.println(resultList);
			
			
			//json으로 만들기
			ObjectMapper mapper = new ObjectMapper(); 
			String json_addfrontList = mapper.writeValueAsString(resultList);
			//System.out.println(json_addfrontList);
			 
			
			//카테고리별 갯수
			int totalCount = reservationService.categoryCount(categoryNum);
			//System.out.println(totalCount);
			
			
			//전송
			res.setContentType("application/json; charset=utf-8");
			//res.getWriter().write(json_addfrontList.toString());
			res.getWriter().write(Integer.toString(totalCount)+"totalCount");
			res.getWriter().write(json_addfrontList);
			
		}
	}
}
