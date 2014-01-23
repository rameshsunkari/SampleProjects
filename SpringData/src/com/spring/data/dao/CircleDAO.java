package com.spring.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.data.model.Circle;

@Component
public class CircleDAO {

	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public int getCircleCount() {

		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	 
	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	public Circle getCircleById(int circleId){
		String sql = "SELECT * FROM circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
		
	}
	
	public List<Circle> getAllCircles(){
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	/*public Circle getCircle(int circleId) {

		Connection con = null;
		Circle circle = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			System.out.println("Connection Acquired");
			ps = con.prepareStatement("select * from circle where id= ?");
			ps.setInt(1, circleId);

			rs = ps.executeQuery();
			if (rs.next())
				circle = new Circle(circleId, rs.getString("name"));

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				System.out.println(e);
			}

		}

		return circle;

	}*/

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate =  new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES (?,?)";
//		jdbcTemplate.update(sql, circle.getId(), circle.getName());
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void insertCircleNamedParams(Circle circle){
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES (:id,:name)";
		SqlParameterSource namedParams = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql,namedParams);
	}
	
	public void simpleJdbcInsert(Circle circle){
		String sql = "INSERT INTO CIRCLE(ID, NAME) VALUES (:id,:name)";
		SqlParameterSource namedParams = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		simpleJdbcTemplate.update(sql,namedParams);
	}
	
	public void createTriangleTable(){
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet resultSet, int arg1) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			 return circle;
		}
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
