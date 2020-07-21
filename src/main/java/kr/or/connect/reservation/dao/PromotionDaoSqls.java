package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	//프로모션 정보 가져오기
	public static final String GET_PROMOTION = "select new.id, new.product_id, save_file_name from file_info , (select file_id, promotion.id, promotion.product_id from promotion join product_image on  promotion.product_id = product_image.product_id where product_image.type=\"th\") as new where file_info.id = new. file_id";
	//카테고리별 정보 가져오기
	public static final String FRONT_INFO = "select productId, save_file_name, new.description, place_name, content , display_info.id as displayId from  file_info, (select file_id, description, content, product.id as productId from product join product_image on  product.id = product_image.product_id  where product_image.type=\"th\" and category_id=:category) as new, display_info where file_info.id = new.file_id and display_info.product_id=productId limit :start, :end";
	/*
	//전체정보 가져오기
	public static final String FRONT_INFO_ALL = "select  product.id, file_info.save_file_name, product.description, display_info.place_name, product.content from (select product_id, file_id from product_image where type=\"th\") as image ,file_info  , product , display_info where image.file_id = file_info.id and product.id = image.product_id and display_info.product_id = product.id and  image.product_id = display_info.product_id";
	*/
	public static final String FRONT_INFO_ALL = "select productId, save_file_name, new.description, place_name, content , display_info.id as displayId from  file_info, (select file_id, description, content, product.id as productId from product join product_image on  product.id = product_image.product_id  where product_image.type=\"th\") as new, display_info where file_info.id = new.file_id and display_info.product_id=productId limit :start, :end";



}

