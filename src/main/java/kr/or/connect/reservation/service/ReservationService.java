package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.dto.File_info;
import kr.or.connect.reservation.dto.FrontForm;
import kr.or.connect.reservation.dto.Product_price;
import kr.or.connect.reservation.dto.Promotion;

public interface ReservationService {
	public static final Integer LIMIT = 4;
	//category별 front정보 가져오기
	public List<FrontForm> getFrontInfo(int category, int start, int end); 
	//category별 개수
	public int categoryCount(int num);
	
	//caegory id, name 가져오기
	public List<Category> getCategory();
	//전체 정보 가져오기
	public List<FrontForm> getFrontInfoAll(int start, int end);
	//file_info 삭제하기(실제로 삭제하지는 않고 flag만 바꿔줌)
	public int deleteFileInfo(int id);
	//file_info 삽입
	public File_info insertFileInfo(File_info file);
	//file_info 업데이트
	public int updateFileInfo(File_info file);
	//file_info 객체 한개 가져오기
	public File_info selectFileInfo(int id);
	
	//display_info 객체 한개 가져오기
	public Display_info selectDisplayInfo(int id);
	//display_info 업데이트
	public int updateDisplayInfo(Display_info display);
	
	
	//product_price 객체 한개 가져오기
	public Product_price selectProductPrice(int id);
	//product_price 업데이트
	public int updateProductPrice(Product_price product);
	
	//promotion정보 가져오기
	public List<Promotion> getPromotion();
	
	//전체갯수
	public int totalCount();
	//프로모션갯수
	public int promotionCount();
}
