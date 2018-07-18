package kehaofei.com.sm.Service;

import java.util.List;

import kehaofei.com.sm.model.CustomerInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	 商品信息service层接口
 * <li>2017-5-31 下午4:20:25
 * <li>
 */
public interface ICustomerInfoService {

	List<CustomerInfoModel> loadCustomerInfoList();	
	
	void insert(CustomerInfoModel customerInfo);
	
	boolean update(CustomerInfoModel customerInfo);
	
	boolean delete(String kehu_no);
	
	CustomerInfoModel queryById(String kehu_no);

	/**
	 * 根据不同条件查询数据
	 * @author XCCD
	 * @param customerInfo
	 * @return
	 */
	List<CustomerInfoModel> queryBySome(CustomerInfoModel customerInfo);

	CustomerInfoModel queryLast();

	List<CustomerInfoModel> queryRepeat(CustomerInfoModel customerInfo);

}
