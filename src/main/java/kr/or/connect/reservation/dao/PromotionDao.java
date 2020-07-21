package kr.or.connect.reservation.dao;



import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;


import kr.or.connect.reservation.dto.FrontForm;
import kr.or.connect.reservation.dto.Promotion;

import static kr.or.connect.reservation.dao.PromotionDaoSqls.*;




@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
			
    }
	
	//프로모션 리스트 가져오기
	public List<Promotion> promotionList(){
		return jdbc.query(GET_PROMOTION, (rs, rowNum)-> new Promotion(rs.getInt("id"), rs.getInt("product_id"), rs.getString("save_file_name")));
	}
	
	
	public List<FrontForm> frontInfo(int category, int start, int end){ //카테고리별 프론트 정보
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("category", category);
		parameters.addValue("start", start);
		parameters.addValue("end", end);
		return jdbc.query(FRONT_INFO, parameters, (rs, rowNum)-> new FrontForm(rs.getInt("productId"), rs.getString("save_file_name"), rs.getString("new.description"), rs.getString("place_name"), rs.getString("content"), rs.getInt("displayId")));
			
	}
	
	public List<FrontForm> frontInfoAll(int start, int end){ //전체 정보
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("start", start);
		parameters.addValue("end", end);
		return jdbc.query(FRONT_INFO_ALL, parameters, (rs, rowNum)-> new FrontForm(rs.getInt("productId"), rs.getString("save_file_name"), rs.getString("new.description"), rs.getString("place_name"), rs.getString("content"), rs.getInt("displayId")));
			
	}
	

}
