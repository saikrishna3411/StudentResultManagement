package com.nit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	
	private JdbcTemplate template;
	
	private final String QUERY_FOR_COUNTALLPRODUCTS="select count(*) from emp";

	@Autowired
	public ProductDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public int getAllProductCount() {
		return	template.queryForObject(QUERY_FOR_COUNTALLPRODUCTS, Integer.class);
	}
	
	
	

}
