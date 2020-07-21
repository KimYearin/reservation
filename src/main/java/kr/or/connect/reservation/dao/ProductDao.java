package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import static kr.or.connect.reservation.dao.ProductDaoSqls.*;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.dto.File_info;

import kr.or.connect.reservation.dto.Product_price;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource) // 삽입
				.usingGeneratedKeyColumns("id"); // 삽입할때 id자동으로 생성
	}

	// 전체갯수 구하기
	public int selectCount() {
		return jdbc.queryForObject(SELECT_ALL, Collections.emptyMap(), Integer.class);
	}

	// 카테고리별 개수 구하기
	public int categoryCount(int num) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("category", num);
		return jdbc.queryForObject(SELECT_GROUP_BY, parameters, Integer.class);
	}

	// promotion갯수 구하기
	public int promotionCount() {
		return jdbc.queryForObject(PROMOTION_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	
	// id값 받아서 file_info 삭제(delete_flag 변경)
	public int deleteFile_info(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_FILE_INFO, params);
	}

	// file_info 삽입
	public int insertFileInfo(File_info file) {
		insertAction.withTableName("file_info");
		SqlParameterSource params = new BeanPropertySqlParameterSource(file);
		return insertAction.executeAndReturnKey(params).intValue(); // key(id) 반환
	}

	// file_info update
	public int updateFileInfo(File_info file) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(file);
		return jdbc.update(UPDATE_FILE_INFO, params);
	}

	// file_info 객체 select
	public File_info selectFileInfo(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return (File_info) jdbc.queryForObject(SELECT_FILE_INFO, param,
				new BeanPropertyRowMapper<File_info>(File_info.class));
	}

	// display_info 객체 받기
	public Display_info selectDisplay(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return (Display_info) jdbc.queryForObject(SELECT_DISPLAY_INFO, param,
				new BeanPropertyRowMapper<Display_info>(Display_info.class));
	}

	// display_info 업데이트
	public int updateDisplayInfo(Display_info display) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(display);
		return jdbc.update(UPDATE_DISPLAY_INFO, params);
	}

	// product_price 객체 받기
	public Product_price selectProductPrice(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return (Product_price) jdbc.queryForObject(SELECT_PRODUCT_PRICE, param,
				new BeanPropertyRowMapper<Product_price>(Product_price.class));
	}
	
	// product_price업데이트
	public int updateProductPrice(Product_price product) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return jdbc.update(UPDATE_PRODUCT_PRICE, params);
	}
	
	// category id, name
	public List<Category> categoryList(){
		return jdbc.query(SELECT_CATEGORY, Collections.emptyMap(), (rs, rowNum)-> new Category(rs.getInt("id"), rs.getString("name")));
	}

}
