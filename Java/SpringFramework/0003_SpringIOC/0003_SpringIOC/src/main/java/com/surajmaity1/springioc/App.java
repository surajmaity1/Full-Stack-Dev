package com.surajmaity1.springioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args )
    {
    	// BeanFactory
    	//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	// ApplicationContext
    	
    	/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Human human1 = (Human) applicationContext.getBean("human") ;
        human1.speak();
        System.out.println(human1.age);
        
        // Spring Container as a singleton and prototype
        // Note: only one object will be created as it is prototype in spring
        Human human2 = (Human) applicationContext.getBean("human") ;
        human2.speak();
        human2.age =32;
        System.out.println(human2.age);
        
        
        Human human3 = (Human) applicationContext.getBean("human") ;
        human3.speak();
        System.out.println(human3.age); */
    	
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    	Human human1 = (Human) applicationContext.getBean("human") ;
        
    	System.out.println(human1.getAge());
    	
    	human1.speak();
        
        
        
    }
}
