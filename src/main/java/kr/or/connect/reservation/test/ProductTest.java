package kr.or.connect.reservation.test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Category;


public class ProductTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductDao productDao = ac.getBean(ProductDao.class);
		//product 전체개수
		/*
		 * System.out.println(productDao.selectCount()); 
		 * System.out.println(productDao.categoryCount(2));
		 */
		
		//file_info 삭제
		/* System.out.println(productDao.deleteFile_info(1)); */ 
		
		//file_info 삽입
		/*
		 * File_info file = new File_info(); file.setContent_type("new");
		 * file.setFile_name("me"); file.setSave_file_name("secret");
		 * file.setDelete_flag(0); System.out.println(productDao.insertFileInfo(file));
		 */
		
		/*
		 * //file_info 수정 
		 * int modifyCount = productDao.modifyFileInfo(190, "you");
		 * System.out.println(modifyCount);
		 */
		
		/*
		//display_info 가져오기
		Display_info display = productDao.selectDisplay(1);
		System.out.println(display.getTel());*/
		
		/*
		//file_info update 테스트
		File_info file = new File_info();
		file.setId(190);
		file.setFile_name("nanana");
		file.setContent_type("new");
		file.setModify_date(new Date());
		file.setSave_file_name("secret");
		int count = productDao.updateFileInfo(file);
		System.out.println(count);*/
		
		/*
		//display_info update 테스트
		Display_info display = new Display_info();
		display.setModify_date(new Date());
		display.setEmail("change");
		display.setId(60);
		display.setProduct_id(1);
		display.setOpening_hours("you");
		display.setPlace_lot("haha");
		display.setPlace_name("fd");
		display.setPlace_street("dd");
		display.setTel("010");
		display.setHomepage("");
		display.setCreate_date(new Date());
		int updateCount = productDao.updateDisplayInfo(display);
		System.out.println(updateCount);*/
		
		/*
		//product_price update 테스트
		Product_price product = new Product_price();
		product.setCreate_date(new Date());
		product.setDiscount_rate(10);
		product.setId(97);
		product.setModify_date(new Date());
		product.setPrice(000);
		product.setPrice_type_name("R");
		product.setProduct_id(50);
		int updateCount = productDao.updateProductPrice(product);
		System.out.println(updateCount);*/
		
		//select_category 테스트
		List<Category> list = productDao.categoryList();
		list.get(0).setCount(3);
		System.out.println(list.get(0).getId());
		System.out.println(list.get(0).getName());
		System.out.println(list.get(0).getCount());
	}

}
