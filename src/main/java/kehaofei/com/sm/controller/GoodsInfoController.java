package kehaofei.com.sm.controller;

import java.util.List;
import java.util.Vector;

import kehaofei.com.sm.Service.IGoodsInfoService;
import kehaofei.com.sm.model.GoodsInfoModel;
import kehaofei.com.utils.ContextValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author XCCD
 * <li>TODO	连接客户端的信息数据操作类
 * <li>2016-11-16 下午3:18:18
 * <li>
 */
//@Component("goodsInfoController")
public class GoodsInfoController {
    
//	@Autowired
    private IGoodsInfoService goodsInfoService;
	
	
//	private Vector<Object[]> vector;
	
	public IGoodsInfoService getGoodsInfoService() {
		return goodsInfoService;
	}

	public void setGoodsInfoService(IGoodsInfoService goodsInfoService) {
		this.goodsInfoService = goodsInfoService;
	}

	/**
     * 初始化商品信息列表界面
     * @author XCCD
     * @return
     */
    public void LoadGoodsInfoVector(){
        List<GoodsInfoModel> goodsInfoList = goodsInfoService.loadGoodsInfoList();
        
        ContextValue.GoodsInfoListData.clear();
        for(int i=0; i<goodsInfoList.size(); i++){
        	Object[] obj = new Object[]{
        			goodsInfoList.get(i).getPeij_no(),
            		i+1,
            		Boolean.FALSE, 
            		goodsInfoList.get(i).getPeij_py(),
            		goodsInfoList.get(i).getPeij_name(),
            		goodsInfoList.get(i).getPeij_lb(),
            		goodsInfoList.get(i).getCode()==null?"":goodsInfoList.get(i).getCode(),
            		goodsInfoList.get(i).getBrand()==null?"":goodsInfoList.get(i).getBrand(),
            		goodsInfoList.get(i).getUnit()==null?"":goodsInfoList.get(i).getUnit(),
            		goodsInfoList.get(i).getIn_price()==null?"":goodsInfoList.get(i).getIn_price(),
            		goodsInfoList.get(i).getOut_price1()==null?"":goodsInfoList.get(i).getOut_price1(),
            		goodsInfoList.get(i).getOut_price2()==null?"":goodsInfoList.get(i).getOut_price2(),
            		goodsInfoList.get(i).getOut_price3()==null?"":goodsInfoList.get(i).getOut_price3(),
            		goodsInfoList.get(i).getPlace()==null?"":goodsInfoList.get(i).getPlace(),
            		goodsInfoList.get(i).getJinyong()==null?"":goodsInfoList.get(i).getJinyong(),
            		goodsInfoList.get(i).getComment()==null?"":goodsInfoList.get(i).getComment()
        	};
        	ContextValue.GoodsInfoListData.add(obj);
        }
    }
    
    /**
     * 集中器列表
     * @author XCCD
     * @return
     */
    public Vector<Object[]> ListGoodsInfoVector(){
        List<GoodsInfoModel> goodsInfoList = goodsInfoService.loadGoodsInfoList();
        
        Vector<Object[]> vector = new Vector<Object[]>();
        for(int i=0; i<goodsInfoList.size(); i++){
        	Object[] obj = new Object[]{
        		goodsInfoList.get(i).getPeij_no(),
        		i+1,
        		Boolean.FALSE, 
        		goodsInfoList.get(i).getPeij_py(),
        		goodsInfoList.get(i).getPeij_name(),
        		goodsInfoList.get(i).getPeij_lb(),
        		goodsInfoList.get(i).getCode()==null?"":goodsInfoList.get(i).getCode(),
        		goodsInfoList.get(i).getBrand()==null?"":goodsInfoList.get(i).getBrand(),
        		goodsInfoList.get(i).getUnit()==null?"":goodsInfoList.get(i).getUnit(),
        		goodsInfoList.get(i).getIn_price()==null?"":goodsInfoList.get(i).getIn_price(),
        		goodsInfoList.get(i).getOut_price1()==null?"":goodsInfoList.get(i).getOut_price1(),
        		goodsInfoList.get(i).getOut_price2()==null?"":goodsInfoList.get(i).getOut_price2(),
        		goodsInfoList.get(i).getOut_price3()==null?"":goodsInfoList.get(i).getOut_price3(),
        		goodsInfoList.get(i).getPlace()==null?"":goodsInfoList.get(i).getPlace(),
        		goodsInfoList.get(i).getJinyong()==null?"":goodsInfoList.get(i).getJinyong(),
        		goodsInfoList.get(i).getComment()==null?"":goodsInfoList.get(i).getComment()
//        		ControlFactory.TYPECODETABLE.QueryByTypeCode(goodsInfoList.get(i).getMeter_type()),
//        		goodsInfoList.get(i).getMeter_conn_status()==0?"离线":"在线",
//        		ByteUtils.dateFormat(goodsInfoList.get(i).getMeter_add_time()),
//        		ByteUtils.dateFormat(goodsInfoList.get(i).getMeter_update_time())
        	};
        	vector.add(obj); 
        }       
        return vector;
    }
    
    /**
     * 根据数据库数据生成最新一条数据的主键
     * @author XCCD
     * @return
     */
    public String queryLast(){
    	GoodsInfoModel lastModel = goodsInfoService.queryLast();
    	String ID = lastModel.getPeij_no();
		int id = Integer.parseInt(ID)+1;
		String new_id = "000000".substring(0, 6-String.valueOf(id).length())+id;
    	return new_id;
    }
    
    public List<GoodsInfoModel> showGoodsInfoList(){
        return goodsInfoService.loadGoodsInfoList();
    }
    
    public void insert(GoodsInfoModel goodsInfo){
    	goodsInfoService.insert(goodsInfo);
    }
    
    public boolean update(GoodsInfoModel goodsInfo){
    	return goodsInfoService.update(goodsInfo);
    }
    
    public boolean delete(String peij_no){
    	return goodsInfoService.delete(peij_no);
    }
    
    public GoodsInfoModel queryById(String peij_no){
    	return goodsInfoService.queryById(peij_no);
    }
    
    /**
     * <li>判断是否已经存在数据
     * <li> 没有重复返回true,反之返回false
     * @author XCCD
     * @param goodsInfo
     * @return
     */
    public boolean queryRepeat(GoodsInfoModel goodsInfo){
    	List<GoodsInfoModel> list = goodsInfoService.queryRepeat(goodsInfo);
    	if(list ==null || list.size()==0){
    		return true;
    	}else{
    		return false;
    	}
//        return goodsInfoService.queryRepeat(goodsInfo);
    }
    

	public List<GoodsInfoModel> queryBySome(GoodsInfoModel goodsInfo) {
		
		List<GoodsInfoModel> goodsInfoList = goodsInfoService.queryBySome(goodsInfo);
        
        ContextValue.GoodsInfoListData.clear();
        for(int i=0; i<goodsInfoList.size(); i++){
        	Object[] obj = new Object[]{
        			goodsInfoList.get(i).getPeij_no(),
            		i+1,
            		Boolean.FALSE, 
            		goodsInfoList.get(i).getPeij_py(),
            		goodsInfoList.get(i).getPeij_name(),
            		goodsInfoList.get(i).getPeij_lb(),
            		goodsInfoList.get(i).getCode()==null?"":goodsInfoList.get(i).getCode(),
            		goodsInfoList.get(i).getBrand()==null?"":goodsInfoList.get(i).getBrand(),
            		goodsInfoList.get(i).getUnit()==null?"":goodsInfoList.get(i).getUnit(),
            		goodsInfoList.get(i).getIn_price()==null?"":goodsInfoList.get(i).getIn_price(),
            		goodsInfoList.get(i).getOut_price1()==null?"":goodsInfoList.get(i).getOut_price1(),
            		goodsInfoList.get(i).getOut_price2()==null?"":goodsInfoList.get(i).getOut_price2(),
            		goodsInfoList.get(i).getOut_price3()==null?"":goodsInfoList.get(i).getOut_price3(),
            		goodsInfoList.get(i).getPlace()==null?"":goodsInfoList.get(i).getPlace(),
            		goodsInfoList.get(i).getJinyong()==null?"":goodsInfoList.get(i).getJinyong(),
            		goodsInfoList.get(i).getComment()==null?"":goodsInfoList.get(i).getComment()
        	};
        	ContextValue.GoodsInfoListData.add(obj);
        }
		
		return goodsInfoList;
		// TODO Auto-generated method stub
		
	}

}
