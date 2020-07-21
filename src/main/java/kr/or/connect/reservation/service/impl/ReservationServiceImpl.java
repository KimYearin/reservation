package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.dto.File_info;
import kr.or.connect.reservation.dto.FrontForm;
import kr.or.connect.reservation.dto.Product_price;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.dao.ProductDao;

@Service
public class ReservationServiceImpl implements ReservationService {

	// PromotionDao사용(Bean자동으로 등록), repository로 부터 가져오기
	@Autowired
	PromotionDao promotionDao;

	@Autowired
	ProductDao productDao;
	

	@Override
	@Transactional
	//category별 개수
	public int categoryCount(int num) {
		int categorycounts = productDao.categoryCount(num);
		return categorycounts;
	}
	
	@Override
	@Transactional
	//전채갯수
	public int totalCount() {
		int totalcounts = productDao.selectCount();
		return totalcounts;
	}
	
	@Override
	@Transactional // ReadOnly
	// 전체정보
	public List<FrontForm> getFrontInfoAll(int start, int end) {
		List<FrontForm> frontlistAll = promotionDao.frontInfoAll(start, end);
		return frontlistAll;
	}

	@Override
	@Transactional // ReadOnly
	// 카테고리별 정보
	public List<FrontForm> getFrontInfo(int category, int start, int end) {
		List<FrontForm> categoryList = promotionDao.frontInfo(category, start, end);
		return categoryList;
	}

	@Override
	@Transactional(readOnly = false)
	// 삭제하면 delete_flage가 1로 바뀜
	public int deleteFileInfo(int id) {
		int deleteCount = productDao.deleteFile_info(id);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly = false)
	// file_info 삽입 + 삽입하면서 create_date, modify_date 설정
	public File_info insertFileInfo(File_info file) {
		file.setCreate_date(new Date());
		file.setModify_date(new Date());
		int id = productDao.insertFileInfo(file);
		file.setId(id);

		return file;
	}

	@Override
	@Transactional(readOnly = false)
	// file_info 업데이트
	public int updateFileInfo(File_info file) {
		file.setModify_date(new Date());
		int updateCount = productDao.updateFileInfo(file);
		return updateCount;
	}

	@Override
	@Transactional
	// file_info 한건 조회하기
	public File_info selectFileInfo(int id) {
		File_info file = productDao.selectFileInfo(id);
		return file;
	}

	@Override
	@Transactional
	// display_info 한건 조회하기
	public Display_info selectDisplayInfo(int id) {
		Display_info display = productDao.selectDisplay(id);
		return display;
	}

	@Override
	@Transactional(readOnly = false)
	// display_info 업데이트
	public int updateDisplayInfo(Display_info display) {
		int updateCount = productDao.updateDisplayInfo(display);
		return updateCount;
	}

	@Override
	@Transactional
	// product_price 한건 조회하기
	public Product_price selectProductPrice(int id) {
		Product_price productPrice = productDao.selectProductPrice(id);
		return productPrice;
	}

	@Override
	@Transactional(readOnly = false)
	//product_price 업데이트
	public int updateProductPrice(Product_price product) {
		int updateCount = productDao.updateProductPrice(product);
		return updateCount;
	}

	@Override
	@Transactional
	//카테고리 정보 가져오기
	public List<Category> getCategory() {
		List<Category> list = productDao.categoryList();
		for(int i=0; i<list.size(); i++) {
			list.get(i).setCount(productDao.categoryCount(i+1));
		}
		
		return list;
	}

	

	@Override
	@Transactional
	//promotion 정보 가져오기
	public List<Promotion> getPromotion() {
		List<Promotion> list = promotionDao.promotionList();
		return list;
	}

	
	@Override
	@Transactional
	//promotion 갯수
	public int promotionCount() {
		int promotionNum = productDao.promotionCount();
		return promotionNum;
	}

	

}
