package kehaofei.com.sm.Service;

import java.util.List;

import kehaofei.com.sm.model.GoodsInfoModel;

/**
 * 
 * @author XCCD
 * <li>TODO	 商品信息service层接口
 * <li>2017-5-31 下午4:20:25
 * <li>
 */
public interface IGoodsInfoService {

	List<GoodsInfoModel> loadGoodsInfoList();	
	
	GoodsInfoModel queryLast();
	
	void insert(GoodsInfoModel goodsInfo);
	
	boolean update(GoodsInfoModel goodsInfo);
	
	boolean delete(String peij_no);
	
	GoodsInfoModel queryById(String peij_no);

	/**
	 * 根据不同条件查询数据
	 * @author XCCD
	 * @param goodsInfo
	 * @return
	 */
	List<GoodsInfoModel> queryBySome(GoodsInfoModel goodsInfo);

	/**
	 * 查询是否存在重复
	 * @author XCCD
	 * @param goodsInfo 
	 * @return
	 */
	List<GoodsInfoModel> queryRepeat(GoodsInfoModel goodsInfo);

}
