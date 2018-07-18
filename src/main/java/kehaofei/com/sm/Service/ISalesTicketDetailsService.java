package kehaofei.com.sm.Service;

import java.util.List;

import kehaofei.com.sm.model.SalesTicketDetailsModel;
import kehaofei.com.sm.model.SalesTicketInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	 商品信息service层接口
 * <li>2017-5-31 下午4:20:25
 * <li>
 */
public interface ISalesTicketDetailsService {

	/**
	 * 根据不同条件查询数据
	 * @author XCCD
	 * @param customerInfo
	 * @return
	 */
	List<SalesTicketDetailsModel> getInfoById(SalesTicketDetailsModel salesTicketDetails);
	
	SalesTicketDetailsModel addSalesTicketDetails(SalesTicketDetailsModel salesTicketDetails);

	void batchSave(List<SalesTicketDetailsModel> salesTicketDetails);

	void saveAndUpdate(List<SalesTicketDetailsModel> salesTicketDetails);

	void batchDelete(Object[] xs_noArr);

}
