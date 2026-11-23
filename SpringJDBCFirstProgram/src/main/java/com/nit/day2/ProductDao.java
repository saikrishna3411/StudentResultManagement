package com.nit.day2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ProductDao {
	
	private JdbcTemplate template;

	@Autowired
	public ProductDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	//For Insert Data into DataBase
	private static final String 
	QUERY_FOR_INSERT_PRODUCT_DATA="insert into product(id,name,about,price) values(?,?,?,?)";
	
	
	public int insertData(ProductBo product) {
		return template.update(QUERY_FOR_INSERT_PRODUCT_DATA,new Object [] { product.getId(),product.getName(),product.getAbout(),product.getPrice()} );
	}
	
	//Counting the records in database
	private static final String
	QUERY_FOR_COUNT_OF_PRODUCTS="select count(1) from product";
	
	public int countOfProducts() {
		return template.queryForObject(QUERY_FOR_COUNT_OF_PRODUCTS, Integer.class);
	}
	
	//getProductName by Id
	
	private static final String
	QUERY_FOR_NAME_OF_PRODUCT_BY_ID="Select name from product where id=?";
	
	public String getProductNameByID(int id) {
		return template.queryForObject(QUERY_FOR_NAME_OF_PRODUCT_BY_ID,String.class,new Object [] {id});
	}
	
	
	//get the AllProductDetails by id
	
	private static final String
	QUERY_FOR_ALL_PRODUCT_DETAILS_BY_ID="select id,name,about,price from product where id=?";
	
	public ProductBo getAllProductDetailsById(int id) {
		return template.queryForObject(QUERY_FOR_ALL_PRODUCT_DETAILS_BY_ID, new Object [] {id}, (rs,row)->{
			ProductBo bo=new ProductBo();
			bo.setId(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAbout(rs.getString(3));
			bo.setPrice(rs.getDouble(4));
			return bo;
		});
	}
	
	//getAllDetailsOfProduct
	
	private static final String
	QUERY_FOR_ALL_PRODUCT_DETAILS="select * from product";
	
	public List<ProductBo> getAllProductDetails(){
		return template.query(QUERY_FOR_ALL_PRODUCT_DETAILS, (rs,row)->{
			ProductBo bo=new ProductBo();
			bo.setId(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setAbout(rs.getString(3));
			bo.setPrice(rs.getDouble(4));
			return bo;
		});
	}
	
	//update price by id
	private static final String
	QUERY_FOR_UPDATE_PRODUCT_PRICE_BY_ID="update product set price=? where id=?";
	
	public int updateProductPriceById(double price ,int id) {
		return template.update(QUERY_FOR_UPDATE_PRODUCT_PRICE_BY_ID, new Object [] {price,id});
	}
	
	//delete the product
	
	private static final String 
	QUERY_FOR_DELETE_PRODUCT_BY_ID="delete from product where id=?";
	
	public int deleteProductById(int id) {
		return template.update(QUERY_FOR_DELETE_PRODUCT_BY_ID,new Object [] {id});
	}


	

}
