package kehaofei.com.mybatisfactory;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring
 * @author XCCD
 *
 */
public class SpringBeanFactory{
	
	private static URL springPath = SpringBeanFactory.class.getClass().getResource("/mybatis-spring.xml");
	private SpringBeanFactory() {
		
	}
	public static ApplicationContext  applicationContext = getInstance();
	
	public static ApplicationContext getInstance() {
		
        if (applicationContext == null) {    
            synchronized (SpringBeanFactory.class) {
               if (applicationContext == null) {
            	   applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis-spring.xml");   
               }    
            }    
        }    
        return applicationContext;
    } 
}
