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

import kehaofei.com.sm.Service.ISalesTicketInfoService;
import kehaofei.com.sm.mapping.CustomerInfoMapper;
import kehaofei.com.sm.mapping.SalesTicketDetailsMapper;
import kehaofei.com.sm.mapping.SalesTicketInfoMapper;
import kehaofei.com.sm.model.SalesTicketDetailsModel;
import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.utils.ByteUtils;


//@Service
@Transactional
public class SalesTicketInfoServiceImpl implements ISalesTicketInfoService {
	
//	@Resource
	private SalesTicketInfoMapper salesTicketInfoMapper;	
//	@Resource
	private SalesTicketDetailsMapper salesTicketDetailsMapper;

	public SalesTicketInfoMapper getSalesTicketInfoMapper() {
		return salesTicketInfoMapper;
	}


	public void setSalesTicketInfoMapper(SalesTicketInfoMapper salesTicketInfoMapper) {
		this.salesTicketInfoMapper = salesTicketInfoMapper;
	}


	public SalesTicketDetailsMapper getSalesTicketDetailsMapper() {
		return salesTicketDetailsMapper;
	}


	public void setSalesTicketDetailsMapper(
			SalesTicketDetailsMapper salesTicketDetailsMapper) {
		this.salesTicketDetailsMapper = salesTicketDetailsMapper;
	}


	/**
	 * 查询订单
	 */
	@Override
	public List<SalesTicketInfoModel> getInfoById(
			SalesTicketInfoModel salesTicketInfo) {
		// TODO Auto-generated method stub
		return salesTicketInfoMapper.getInfoById(salesTicketInfo);
	}
	
	
	@Override
	public List<SalesTicketInfoModel> queryBySome(
			SalesTicketInfoModel salesTicketInfo) {
		// TODO Auto-generated method stub
		return salesTicketInfoMapper.queryBySome(salesTicketInfo);
	}


	/**
	 * 新增数据插入操作
	 * @author XCCD
	 * @param salesTicketInfo
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public SalesTicketInfoModel addSalesTicketInfo(SalesTicketInfoModel salesTicketInfo){
		try {
			salesTicketInfoMapper.save(salesTicketInfo);//保存销售单信息
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//异常回滚
		}
		
		return salesTicketInfo;
		
	}

	/* 
	 * 查表获取今日最近一条销售单
	 * (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketInfoService#getXSKeyList()
	 */
	@Override
	public SalesTicketInfoModel getXSKeyList() {
		// TODO Auto-generated method stub
		
		SalesTicketInfoModel model = new SalesTicketInfoModel();
		model.setXs_hao(ByteUtils.getNowTimeStr("yyyyMMdd"));
		
		List<SalesTicketInfoModel> list = salesTicketInfoMapper.getXSKeyList(model);
		
		if(list.size()==0){
			return null;
		}else {
			return list.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketInfoService#update(kehaofei.com.sm.model.SalesTicketInfoModel)
	 * 
	 * 更新销售单信息
	 */
	@Override
	public void update(SalesTicketInfoModel salesTicketInfo) {
		// TODO Auto-generated method stub
		salesTicketInfoMapper.update(salesTicketInfo);
	}


	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.ISalesTicketInfoService#queryDate(java.lang.String)
	 * 查询日期列表数据
	 */
	@Override
	public List<String> queryDate(String dataStr) {
		// TODO Auto-generated method stub
		return salesTicketInfoMapper.queryDate(dataStr);
	}

	
}
