package kr.or.connect.reservation.dao;



public class ProductDaoSqls {
	//전체 product 개수
	public static final String SELECT_ALL = "select count(productId) from  file_info, (select file_id, description, content, product.id as productId from product join product_image on  product.id = product_image.product_id  where product_image.type=\"th\") as new, display_info where file_info.id = new.file_id and display_info.product_id=productId";
	//카테고리별 product 개수
	public static final String SELECT_GROUP_BY = "select count(productId) from  file_info, (select file_id, description, content, product.id as productId from product join product_image on  product.id = product_image.product_id  where product_image.type=\"th\" and category_id=:category) as new, display_info where file_info.id = new.file_id and display_info.product_id=productId";
	//category id, name
	public static final String SELECT_CATEGORY = "SELECT * FROM book.category"; 
	// promotion 갯수 
	public static final String PROMOTION_COUNT = "select count(*) from promotion";
	
	
	
	
	//file_info 삭제
	public static final String DELETE_FILE_INFO = "UPDATE file_info SET delete_flag=1 WHERE id=:id;";
	//file_info 업데이트
	public static final String UPDATE_FILE_INFO = "update file_info set file_name=:file_name , save_file_name = :save_file_name, content_type = :content_type, create_date = :create_date, delete_flag = 1, modify_date = :modify_date where id=:id";
	//file_info 한건 조회하기
	public static final String SELECT_FILE_INFO = "SELECT * FROM file_info where id=:id";
	
	//display_info 한건 조회하기
	public static final String SELECT_DISPLAY_INFO = "SELECT * FROM display_info where id=:id";
	//display_info 업데이트
	public static final String UPDATE_DISPLAY_INFO = "update display_info set product_id = :product_id, opening_hours = :opening_hours, place_name = :place_name, place_lot = :place_lot, place_street = :place_street, tel = :tel, homepage=:homepage, email=:email, create_date = :create_date, modify_date=:modify_date where id=:id";

	//product_price 한건 조회하기
	public static final String SELECT_PRODUCT_PRICE = "select * from product_price where id=:id";
	//product_price 업데이트
	public static final String UPDATE_PRODUCT_PRICE = "update product_price set product_id = :product_id, price_type_name=:price_type_name, price = :price, discount_rate = :discount_rate, create_date = :create_date, modify_date = :modify_date where id=:id";

}
