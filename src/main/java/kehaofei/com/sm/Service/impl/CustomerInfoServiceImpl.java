package kehaofei.com.sm.Service.impl;

import java.util.List;

import javax.annotation.Resource;

import kehaofei.com.sm.Service.ICustomerInfoService;
import kehaofei.com.sm.mapping.CustomerInfoMapper;
import kehaofei.com.sm.model.CustomerInfoModel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author XCCD
 * <li>TODO	客户信息Service层，访问数据持久层
 * <li>2017-6-2 下午3:52:33
 * <li>
 */
//@Service
@Transactional
public class CustomerInfoServiceImpl implements ICustomerInfoService {

//	@Resource
	private CustomerInfoMapper customerInfoMapper;
	

	public CustomerInfoMapper getCustomerInfoMapper() {
		return customerInfoMapper;
	}

	public void setCustomerInfoMapper(CustomerInfoMapper customerInfoMapper) {
		this.customerInfoMapper = customerInfoMapper;
	}

	//	@Override
	public List<CustomerInfoModel> loadCustomerInfoList() {
		// TODO Auto-generated method stub
		return customerInfoMapper.queryAll();
	}

	@Override
	public void insert(CustomerInfoModel customerInfo) {
		// TODO Auto-generated method stub
		customerInfoMapper.save(customerInfo);
	}

	@Override
	public boolean update(CustomerInfoModel customerInfo) {
		// TODO Auto-generated method stub
		int ret= customerInfoMapper.update(customerInfo);
		if(ret > 0){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ICustomerInfoService#queryRepeat(kehaofei.com.sm.model.CustomerInfoModel)
	 */
	@Override
	public List<CustomerInfoModel> queryRepeat(CustomerInfoModel customerInfo) {
		// TODO Auto-generated method stub
		return customerInfoMapper.queryRepeat(customerInfo);
	}

	@Override
	public boolean delete(String kehu_no) {
		// TODO Auto-generated method stub
		int ret= customerInfoMapper.delete(kehu_no);
		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public CustomerInfoModel queryById(String kehu_no) {
		// TODO Auto-generated method stub
		return customerInfoMapper.queryById(kehu_no);
	}

	/* (non-Javadoc)
	 * @see xiaocheng.com.sm.Service.IcustomerInfoService#queryBySome(xiaocheng.com.sm.model.ConcentratorMeterLibrary)
	 */
	@Override
	public List<CustomerInfoModel> queryBySome(
			CustomerInfoModel customerInfo) {
		// TODO Auto-generated method stub
		
		return customerInfoMapper.queryBySome(customerInfo);
		
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ICustomerInfoService#queryLast()
	 */
	@Override
	public CustomerInfoModel queryLast() {
		// TODO Auto-generated method stub
		return customerInfoMapper.queryLast();
	}
	
	
	

}
