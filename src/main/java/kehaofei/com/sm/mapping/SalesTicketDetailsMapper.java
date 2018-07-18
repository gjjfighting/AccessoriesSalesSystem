package kehaofei.com.sm.mapping;

import java.util.List;

import kehaofei.com.sm.model.SalesTicketDetailsModel;

/**
 * 
 * @author XCCD
 * <li>TODO	mybatis 映射接口
 * <li>2016-11-16 下午3:10:10
 * <li>{@link SalesTicketDetailsMapper}
 */
public interface SalesTicketDetailsMapper {
	
	/**
	 * 查询所有的商品信息
	 * @return
	 */
	List<SalesTicketDetailsModel> queryAll();
	
	/**
	 * 
	 * <li>TODO	保存
	 * @param salesTicketDetails
	 * @return 
	 */
	void save(SalesTicketDetailsModel salesTicketDetails);

	void batchSave(List<SalesTicketDetailsModel> salesTicketDetails);

	/**
	 * 更新明细数据
	 * @author XCCD
	 * @param model
	 */
	void update(SalesTicketDetailsModel model);

	void batchDelete(Integer[] xs_noArr);


}
