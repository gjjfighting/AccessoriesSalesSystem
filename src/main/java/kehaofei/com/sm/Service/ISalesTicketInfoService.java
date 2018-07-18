package kehaofei.com.sm.Service;

import java.util.List;

import kehaofei.com.sm.model.SalesTicketInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	 商品信息service层接口
 * <li>2017-5-31 下午4:20:25
 * <li>
 */
public interface ISalesTicketInfoService {

	/**
	 * 根据不同条件查询数据
	 * @author XCCD
	 * @param customerInfo
	 * @return
	 */
	List<SalesTicketInfoModel> getInfoById(SalesTicketInfoModel salesTicketInfo);

	/**
	 * 查询当日最新的一条数据
	 * @author XCCD
	 * @return
	 */
	SalesTicketInfoModel getXSKeyList();
	
	SalesTicketInfoModel addSalesTicketInfo(SalesTicketInfoModel salesTicketInfo);

	void update(SalesTicketInfoModel salesTicketInfo);

	List<SalesTicketInfoModel> queryBySome(SalesTicketInfoModel salesTicketInfo);

	List<String> queryDate(String dataStr);

}
