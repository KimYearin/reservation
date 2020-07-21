package kr.or.connect.reservation.dto;

public class Product_image {
	private Integer id;// '상품 이미지 id',
	private Integer product_id;// '상품 id',
	private String type;// '이미지 type, th: 썸네일, ma: 메인, et: 기타 (etc)',
	private Integer file_id;// 'file id',

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

}
