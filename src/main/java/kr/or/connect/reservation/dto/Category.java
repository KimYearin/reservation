package kr.or.connect.reservation.dto;

public class Category {
	private Integer id;// '카테고리 id',
	private String name;// '카테고리 이름',
	private Integer count;//category에 속한 전시상품수
	
	public Category(int id, String name) { //기본 생성자
		this.id = id;
		this.name = name;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
