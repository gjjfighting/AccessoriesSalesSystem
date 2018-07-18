package kehaofei.com.sm.controller;

import java.util.List;

import kehaofei.com.mybatisfactory.SpringBeanFactory;
import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.utils.ControlFactory;

public class testMain {

	/**
	 * @author XCCD
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesTicketInfoModel salesTicketInfo = new SalesTicketInfoModel();
		salesTicketInfo.setXs_hao("20170715");
		
		
		SalesTicketInfoController c = (SalesTicketInfoController) SpringBeanFactory.getInstance().getBean("salesTicketInfoController");
		
		List<SalesTicketInfoModel> list =  c.getInfoById(salesTicketInfo);
		
		System.out.println(list);

	}

}
