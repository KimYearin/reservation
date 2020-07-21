package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.FrontForm;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired ReservationService reservationService;
	
	//카테고리 API
	@GetMapping(path="/categories")
	public Map<String, Object> categoryAPI(){
		List<Category> list = reservationService.getCategory();
		Map<String, Object> map = new HashMap<>();
		map.put("items", list);
		return map;
	}
	
	//상품 API
	@GetMapping(path="/products")

	public Map<String, Object> productAPI1(@RequestParam (name="categoryId", required=false, defaultValue="0")int categoryId, @RequestParam (name="start", required=false, defaultValue="0") int  start){
		List<FrontForm> list;
		if(categoryId==0) {
			list = reservationService.getFrontInfoAll(start, ReservationService.LIMIT);
		} else {
			list = reservationService.getFrontInfo(categoryId, start, ReservationService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("items", list);
		if(categoryId==0) {
			map.put("totalCount", reservationService.totalCount());
		} else {
			map.put("totalCount", reservationService.categoryCount(categoryId));
		}
		
		return map;
	}
	
	
	//프로모션 API
	@GetMapping(path="/promotions")
	public Map<String, Object> promotionAPI(){
		List<Promotion> list = reservationService.getPromotion();
		Map<String, Object> map = new HashMap<>();
		map.put("items", list);
		return map;
	}
	
}

