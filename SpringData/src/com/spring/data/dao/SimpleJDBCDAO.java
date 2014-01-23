package com.spring.data.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJDBCDAO extends  SimpleJdbcDaoSupport{
	
	public int getCircleCount() {

		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForInt(sql);
	}

	
	

}
