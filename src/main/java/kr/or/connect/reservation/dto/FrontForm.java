package kr.or.connect.reservation.dto;

public class FrontForm {
	private Integer id; //product id
	private String save_file_name; //이미지 경로
	private String description; // 제목
	private String place_name; // 장소
	private String content; //작품 설명
	private Integer display_id; // display_id
	
	
	public FrontForm(int id, String save_file_name, String description, String place_name, String content, int display_id){
		this.id = id;
		this.save_file_name = save_file_name;
		this.description = description;
		this.place_name = place_name;
		this.content = content;
		this.display_id = display_id;
	}
	
	public FrontForm(int id, String save_file_name, String description, String place_name, String content){
		this.id = id;
		this.save_file_name = save_file_name;
		this.description = description;
		this.place_name = place_name;
		this.content = content;
		
	}
	
	
	public Integer getDisplay_id() {
		return display_id;
	}

	public void setDisplay_id(Integer display_id) {
		this.display_id = display_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
