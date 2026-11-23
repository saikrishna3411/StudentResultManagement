package com.nit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/nit/application-context.xml");
        
        ProductDao bean = context.getBean("productDao" , ProductDao.class);
        
        System.out.println(bean.getAllProductCount());
        System.out.println(bean);
    }
}
