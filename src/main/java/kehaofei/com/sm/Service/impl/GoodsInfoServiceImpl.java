package kehaofei.com.sm.Service.impl;

import java.util.List;

import javax.annotation.Resource;

import kehaofei.com.sm.Service.IGoodsInfoService;
import kehaofei.com.sm.mapping.GoodsInfoMapper;
import kehaofei.com.sm.model.GoodsInfoModel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//@Service
@Transactional
public class GoodsInfoServiceImpl implements IGoodsInfoService {
//	@Resource
	private GoodsInfoMapper goodsInfoMapper;
	

	public GoodsInfoMapper getGoodsInfoMapper() {
		return goodsInfoMapper;
	}

	public void setGoodsInfoMapper(GoodsInfoMapper goodsInfoMapper) {
		this.goodsInfoMapper = goodsInfoMapper;
	}

	@Override
	public List<GoodsInfoModel> loadGoodsInfoList() {
		// TODO Auto-generated method stub
		return goodsInfoMapper.queryAll();
	}
	
	@Override
	public GoodsInfoModel queryLast(){
		return goodsInfoMapper.queryLast();
	}

	@Override
	public void insert(GoodsInfoModel goodsInfo) {
		// TODO Auto-generated method stub
		goodsInfoMapper.save(goodsInfo);
	}

	@Override
	public boolean update(GoodsInfoModel goodsInfo) {
		// TODO Auto-generated method stub
		int ret= goodsInfoMapper.update(goodsInfo);
		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String peij_no) {
		// TODO Auto-generated method stub
		int ret= goodsInfoMapper.delete(peij_no);
		if(ret > 0){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see kehaofei.com.sm.Service.IGoodsInfoService#queryRepeat()
	 * 查询重复数据
	 */
	@Override
	public List<GoodsInfoModel> queryRepeat(GoodsInfoModel goodsInfo) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.queryRepeat(goodsInfo);
	}

	@Override
	public GoodsInfoModel queryById(String peij_no) {
		// TODO Auto-generated method stub
		return goodsInfoMapper.queryById(peij_no);
	}

	/* (non-Javadoc)
	 * @see xiaocheng.com.sm.Service.IGoodsInfoService#queryBySome(xiaocheng.com.sm.model.ConcentratorMeterLibrary)
	 */
	@Override
	public List<GoodsInfoModel> queryBySome(GoodsInfoModel goodsInfo) {
		// TODO Auto-generated method stub
		
		return goodsInfoMapper.queryBySome(goodsInfo);
	}
	
	

}
