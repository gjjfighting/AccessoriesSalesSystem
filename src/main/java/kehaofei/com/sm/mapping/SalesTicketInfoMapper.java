package kehaofei.com.sm.mapping;

import java.util.List;

import kehaofei.com.sm.model.SalesTicketInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	mybatis 对应于销售单数据信息   映射接口
 * <li>2016-11-16 下午3:10:10
 * <li>{@link SalesTicketInfoMapper}
 */
public interface SalesTicketInfoMapper {
	
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	List<SalesTicketInfoModel> queryAll();
	
	/**
	 * 
	 * <li>TODO	保存
	 * @param salesTicketInfo
	 */
	void save(SalesTicketInfoModel salesTicketInfo);
	
	/**
	 * 
	 * <li>TODO	更新数据
	 * @param salesTicketInfo
	 * @return
	 */
	int update(SalesTicketInfoModel salesTicketInfo);
	
	
	/**
	 * 
	 * <li>TODO	根据id查询对应的数据
	 * @param xs_hao
	 * @return
	 */
	List<SalesTicketInfoModel> queryBySome(SalesTicketInfoModel model);


	/**
	 * <li>获取最后一条数据
	 * @author XCCD
	 * @return
	 */
	SalesTicketInfoModel queryLast();
	
	
	/**
	 * 主从结构一起关联查询
	 * @author XCCD
	 * @param xs_hao
	 * @return
	 */
	List<SalesTicketInfoModel> getInfoById(SalesTicketInfoModel salesTicketInfo);

	/**
	 * 查询今日销售订单列表
	 * @author XCCD
	 * @param model
	 * @return
	 */
	List<SalesTicketInfoModel> getXSKeyList(SalesTicketInfoModel model);
	
	/**
	 * 查询数据中已有的年份数据表
	 * @author XCCD
	 * @param dataStr
	 * @return
	 */
	List<String> queryDate(String dataStr);

}
