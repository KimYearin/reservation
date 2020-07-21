package kr.or.connect.reservation.dto;

import java.util.Date;

public class Display_info {
	private Integer id;// '전시정보id',
	private Integer product_id;// 'product id',
	private String opening_hours;// '전시 시간',
	private String place_name;// '장소 명 ex>세종문화회관',
	private String place_lot;// '지번 주소',
	private String place_street;// '도로명 주소',
	private String tel;// '문의전화번호',
	private String homepage;// '홈페이지',
	private String email;// '문의email',
	private Date create_date;// '생성시간',
	private Date modify_date;// '수정시간',

	/*
	  public Display_info(Integer id, Integer product_id, String opening_hours, String place_name, String place_lot, String place_street, String tel,String homepage,String email, Date create_date, Date modify_date ) 
	  {
		  this.id = id;
		  this.product_id = product_id;
		  this.opening_hours = opening_hours;
		  this.place_name = place_name;
		  this.place_lot = place_lot; 
		  this.place_street = place_street; 
		  this.tel = tel; 
		  this.homepage = homepage; 
		  this.email = email;
		  this.create_date = create_date; 
		  this.modify_date = modify_date; 
		  }
	 */
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

	public String getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_lot() {
		return place_lot;
	}

	public void setPlace_lot(String place_lot) {
		this.place_lot = place_lot;
	}

	public String getPlace_street() {
		return place_street;
	}

	public void setPlace_street(String place_street) {
		this.place_street = place_street;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
