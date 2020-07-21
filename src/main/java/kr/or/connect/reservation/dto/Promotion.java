package kr.or.connect.reservation.dto;

public class Promotion {
	private Integer id;// '프로모션 id',
	private Integer product_id;// '프로모션id',
	private String url;//상품 썸네일 이미지
	
	public Promotion(int id, int product_id, String url) {
		this.id = id;
		this.product_id = product_id;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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

}
