package kehaofei.com.sm.mapping;

import java.util.List;

import kehaofei.com.sm.model.CustomerInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	mybatis 对应于客户信息数据   映射接口
 * <li>2016-11-16 下午3:10:10
 * <li>{@link CustomerInfoMapper}
 */
public interface CustomerInfoMapper {
	
	/**
	 * 查询所有的商品信息
	 * @return
	 */
	List<CustomerInfoModel> queryAll();
	
	/**
	 * 
	 * <li>TODO	保存
	 * @param customerInfo
	 */
	void save(CustomerInfoModel customerInfo);
	
	/**
	 * 
	 * <li>TODO	更新数据
	 * @param socketConnInfo
	 * @return
	 */
	int update(CustomerInfoModel customerInfo);
	
	/**
	 * 
	 * <li>TODO	根据客户编号删除客户信息，逻辑删除。修改删除标记
	 * @param kehu_no
	 * @return
	 */
	int delete(String kehu_no);
	
	/**
	 * 
	 * <li>TODO	根据id查询对应的数据
	 * @param kehu_no
	 * @return
	 */
	CustomerInfoModel queryById(String kehu_no);

	/**
	 * <li>根据条件查询结果
	 * @author XCCD
	 * @param customerInfo
	 * @return
	 */
	List<CustomerInfoModel> queryBySome(CustomerInfoModel customerInfo);

	/**
	 * <li>获取最后一条数据
	 * @author XCCD
	 * @return
	 */
	CustomerInfoModel queryLast();

	List<CustomerInfoModel> queryRepeat(CustomerInfoModel customerInfo);

}
