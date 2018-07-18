package kehaofei.com.sm.Service.impl;

import java.awt.print.PrinterException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.sun.org.apache.xml.internal.resolver.readers.XCatalogReader;

import kehaofei.com.sm.Service.ISalesTicketDetailsService;
import kehaofei.com.sm.Service.ISalesTicketInfoService;
import kehaofei.com.sm.mapping.CustomerInfoMapper;
import kehaofei.com.sm.mapping.SalesTicketDetailsMapper;
import kehaofei.com.sm.mapping.SalesTicketInfoMapper;
import kehaofei.com.sm.model.SalesTicketDetailsModel;
import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.utils.ByteUtils;


//@Service
@Transactional
public class SalesTicketDetailsServiceImpl implements ISalesTicketDetailsService {
	
//	@Resource
	private SalesTicketDetailsMapper salesTicketDetailsMapper;
	

	public SalesTicketDetailsMapper getSalesTicketDetailsMapper() {
		return salesTicketDetailsMapper;
	}

	public void setSalesTicketDetailsMapper(
			SalesTicketDetailsMapper salesTicketDetailsMapper) {
		this.salesTicketDetailsMapper = salesTicketDetailsMapper;
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketDetailsService#getInfoById(kehaofei.com.sm.model.SalesTicketDetailsModel)
	 */
	@Override
	public List<SalesTicketDetailsModel> getInfoById(
			SalesTicketDetailsModel salesTicketDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketDetailsService#addSalesTicketDetails(kehaofei.com.sm.model.SalesTicketDetailsModel)
	 * 插入销售明细数据
	 */
	@Override
	public SalesTicketDetailsModel addSalesTicketDetails(
			SalesTicketDetailsModel salesTicketDetails) {
		// TODO Auto-generated method stub
		salesTicketDetailsMapper.save(salesTicketDetails);
		
		return salesTicketDetails;
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketDetailsService#batchSave(java.util.List)
	 */
	@Override
	public void batchSave(List<SalesTicketDetailsModel> salesTicketDetails) {
		// TODO Auto-generated method stub
		salesTicketDetailsMapper.batchSave(salesTicketDetails);
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketDetailsService#saveAndUpdate(java.util.List)
	 * 新增或者修改明细数据
	 */
	@Override
	public void saveAndUpdate(List<SalesTicketDetailsModel> salesTicketDetails) {
		// TODO Auto-generated method stub
		for(SalesTicketDetailsModel model :salesTicketDetails){
			if(model.getXs_no() == null){//新增
				salesTicketDetailsMapper.save(model);
			}else{//更新
				salesTicketDetailsMapper.update(model);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketDetailsService#batchDelete(java.util.List)
	 * 
	 * 批量删除数据
	 */
	@Override
	public void batchDelete(Object[] xs_noArr) {
		// TODO Auto-generated method stub
		
		Integer[] array = new Integer[xs_noArr.length];
		for(int i= 0; i<xs_noArr.length; i++){
			if(xs_noArr[i] != null){
				array[i] = Integer.valueOf(xs_noArr[i].toString());
			}
			
		}		
		salesTicketDetailsMapper.batchDelete(array);
	}
	
}
