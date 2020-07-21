package kr.or.connect.reservation.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.FrontForm;





public class PromotionTest { //프로모션 이미지 리스트 테스트
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		PromotionDao promotionDao = ac.getBean(PromotionDao.class);
		/*List<Promotion> promotionList = promotionDao.promotionList();
		promotionList.forEach(item -> {System.out.println(item.getId());
									System.out.println(item.getProduct_id());
								 	System.out.println(item.getUrl());}
				);*/
		List<FrontForm> list = promotionDao.frontInfoAll(0, 3);
		list.forEach(item -> {
			System.out.println(item.getId());
		});
	}
}
