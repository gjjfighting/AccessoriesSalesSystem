package kehaofei.com.utils;

import org.springframework.beans.factory.annotation.Autowired;

import kehaofei.com.mybatisfactory.SpringBeanFactory;
import kehaofei.com.sm.controller.CustomerInfoController;
import kehaofei.com.sm.controller.GoodsInfoController;
import kehaofei.com.sm.controller.SalesTicketInfoController;

/**
 * 提供统一的数据库操作实例
 * @author XCCD
 * <li>TODO	
 * <li>2016-12-26 下午2:55:49
 * <li>
 */
public class ControlFactory {
	
	
	
	
	/**
	 * GoodsInfoList 商品信息数据实例
	 */
	//@Autowired
	public static GoodsInfoController goodsInfoController;
			//(GoodsInfoController) SpringBeanFactory.getInstance().getBean("goodsInfoController");
	
	/**
	 * CustomerInfo 客户信息操作实例
	 */
	
	/*@Autowired*/
	public static CustomerInfoController customerInfoController ;/*= 
			(CustomerInfoController) SpringBeanFactory.getInstance().getBean("customerInfoController");*/
	
	
	/**
	 * 销售单 信息操作实例
	 */
	/*@Autowired*/
	public static SalesTicketInfoController salesTicketInfoController ;/*= 
			(SalesTicketInfoController) SpringBeanFactory.getInstance().getBean("salesTicketInfoController");*/
	static{
		
		goodsInfoController = (GoodsInfoController) SpringBeanFactory.applicationContext.getBean("goodsInfoController");
		customerInfoController = (CustomerInfoController) SpringBeanFactory.applicationContext.getBean("customerInfoController");
		salesTicketInfoController =(SalesTicketInfoController) SpringBeanFactory.applicationContext.getBean("salesTicketInfoController");
	}
	
}
