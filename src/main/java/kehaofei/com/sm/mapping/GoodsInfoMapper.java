package kehaofei.com.sm.mapping;

import java.util.List;

import kehaofei.com.sm.model.GoodsInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	mybatis 映射接口
 * <li>2016-11-16 下午3:10:10
 * <li>{@link GoodsInfoMapper}
 */
public interface GoodsInfoMapper {
	
	/**
	 * 查询所有的商品信息
	 * @return
	 */
	List<GoodsInfoModel> queryAll();
	
	/**
	 * 查询获取最后一条数据
	 * @return
	 */
	GoodsInfoModel queryLast();
	
	/**
	 * 
	 * <li>TODO	保存
	 * @param goodsInfo
	 */
	void save(GoodsInfoModel goodsInfo);
	
	/**
	 * 
	 * <li>TODO	更新数据
	 * @param socketConnInfo
	 * @return
	 */
	int update(GoodsInfoModel goodsInfo);
	
	/**
	 * 
	 * <li>TODO	根据商品编号删除商品信息，逻辑删除。修改删除标记
	 * @param peij_no
	 * @return
	 */
	int delete(String peij_no);
	
	/**
	 * 
	 * <li>TODO	根据id查询对应的数据
	 * @param peij_no
	 * @return
	 */
	GoodsInfoModel queryById(String peij_no);

	/**
	 * <li>根据条件查询结果
	 * @author XCCD
	 * @param goodsInfo
	 * @return
	 */
	List<GoodsInfoModel> queryBySome(GoodsInfoModel goodsInfo);
	
	/**
	 * <li>查询是否存在已有数据
	 * @author XCCD
	 * @param goodsInfo
	 * @return
	 */
	List<GoodsInfoModel> queryRepeat(GoodsInfoModel goodsInfo);
}
