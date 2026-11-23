package com.nit.day2;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ProductDao bean = context.getBean("dao", ProductDao.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("               Welcome to Shopping Details");
		while(true) 
		{
			System.out.println();
			System.out.println();
			System.out.println("   Choose the Following Opeartions");
			System.out.println("    Press 1 for insert Data");
			System.out.println("    Press 2 for count the Records");
			System.out.println("    Press 3 for Product Name ");
			System.out.println("    Press 4 for Product Details");
			System.out.println("    Press 5 for All Product Details");
			System.out.println("    Press 6 for Update Product Price");
			System.out.println("    Press 7 for Delete The Product ");
			System.out.println("    Press 8 for Exist");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1 : System.out.println("Enter the Product Details.");
					ProductBo bo=new ProductBo();
					System.out.println("Enter the Id");
					int id=sc.nextInt();
					System.out.println("Enter the Product Name");
					String name=sc.next();
					System.out.println("Enter the About");
					String about=sc.next();
					System.out.println("Enter the Price");
					double price=sc.nextDouble();
					bo.setId(id);
					bo.setName(name);
					bo.setAbout(about);
					bo.setPrice(price);
					int data = bean.insertData(bo);
					if(data> 0)
					{
						System.out.println("SuccesFully  Data Inserted..!");
					}
					else
					{
						System.out.println("Data is not Inserted..1");
					}
					break;
			case 2:
					int countOfProducts = bean.countOfProducts();
					System.out.println("Total Record in DataBase : "+countOfProducts +" Records  ");
					break;
			case 3: 
					System.out.println("Enter the Product Id");
					int productId=sc.nextInt();
					String productName = bean.getProductNameByID(productId);
					System.out.println("Product Name is :  "+productName);
					break;
			case 4:
					System.out.println("Enter the Product Id");
					int productId1=sc.nextInt();
					ProductBo allProductDetailsById = bean.getAllProductDetailsById(productId1);
					System.out.println("Product Deatails :");
					System.out.println(allProductDetailsById);
					break;
			case 5:
					System.out.println(" ALL Product Details");
					List<ProductBo> allProductDetails = bean.getAllProductDetails();
					allProductDetails.stream().forEach(System.out::println);
					break;
			case 6:
					System.out.println("Enter the Product Id");
					int productId3=sc.nextInt();
					System.out.println("Enter the Product Price");
					double productPrice1 =sc.nextDouble();
					int updateProductPriceById = bean.updateProductPriceById(productPrice1, productId3);
					if(updateProductPriceById>0)
					{
						System.out.println("Succesfully update price");
					}
					else
					{
						System.out.println("Not Update Price ,Some issues");
					}
					break;
			case 7:
					System.out.println("Enter the Product Id");
					int productId4=sc.nextInt();
					int deleteProductById = bean.deleteProductById(productId4);
					if(deleteProductById>0)
					{
						System.out.println("Record Deleted Succesfully");
					}
					else
					{
						System.out.println("Record is not Deleted ..!");
					}
					break;
			case 8:
					System.out.println("                  Thank you, Visit Again..! ");
					System.exit(0);
					break;
			}
		}	
	}
}