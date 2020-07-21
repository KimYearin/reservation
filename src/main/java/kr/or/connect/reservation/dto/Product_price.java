package kr.or.connect.reservation.dto;

import java.util.Date;

public class Product_price {
	
	private Integer id; // '상품 가격 id'
	private Integer product_id;// '상품 id',
	private String price_type_name;// '성인(A), 청소년(Y), 유아(B), 셋트(S), 장애인(D), 지역주민(C), 어얼리버드(E) 기타 다른 유형이 있다면 위와 겹치지 않게 1자로 정의하여 기입, VIP(V), R석(R), B석(B), S석(S), 평일(D)',
	private Integer price;// '상품 가격',
	private double discount_rate;// '할인율',
	private Date create_date;//'등록일',
	private Date modify_date;// '수정일',
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getPrice_type_name() {
		return price_type_name;
	}
	public void setPrice_type_name(String price_type_name) {
		this.price_type_name = price_type_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	
	
	
	
}
