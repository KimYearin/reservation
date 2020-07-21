package kr.or.connect.reservation.dto;

public class Display_info_image {
	private Integer id;// '전시정보 이미지 id',
	private Integer display_info_id;// '전시정보 id',
	private Integer file_id;// 'file id',

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDisplay_info_id() {
		return display_info_id;
	}

	public void setDisplay_info_id(Integer display_info_id) {
		this.display_info_id = display_info_id;
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

}
