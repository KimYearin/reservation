package kr.or.connect.reservation.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.FrontForm;

public class CategoryInfo {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDao promotionDao = ac.getBean(PromotionDao.class);
		/*List<FrontForm> frontlist = promotionDao.frontInfo(3); //카테고리별로 다르게 숫자 입력받아서 출력
		for(FrontForm item : frontlist) {
			System.out.println(item.getId());
			System.out.println(item.getSave_file_name());
			System.out.println(item.getDescription());
			System.out.println(item.getPlace_name());
			System.out.println(item.getContent());
			System.out.println();
		}
		*/
	}

}
