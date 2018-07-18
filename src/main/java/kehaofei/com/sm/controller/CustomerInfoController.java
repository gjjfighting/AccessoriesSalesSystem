package kehaofei.com.sm.controller;

import java.util.List;
import java.util.Vector;

import kehaofei.com.sm.Service.ICustomerInfoService;
import kehaofei.com.sm.Service.impl.CustomerInfoServiceImpl;
import kehaofei.com.sm.model.CustomerInfoModel;
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
//@Component("customerInfoController")
public class CustomerInfoController {
    
	
    private ICustomerInfoService customerInfoService;
	
	
//	private Vector<Object[]> vector;
	
	public ICustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	public void setCustomerInfoService(ICustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	/**
     * 初始化客户信息列表界面
     * @author XCCD
     * @return
     */
    public void LoadCustomerInfoVector(){
        List<CustomerInfoModel> customerInfoList = customerInfoService.loadCustomerInfoList();
        
        ContextValue.CustomerInfoListData.clear();
        for(int i=0; i<customerInfoList.size(); i++){
        	Object[] obj = new Object[]{
        			customerInfoList.get(i).getKehu_no(),
            		i+1,
            		Boolean.FALSE, 
            		customerInfoList.get(i).getKehu_py(),
            		customerInfoList.get(i).getKehu_name(),
            		customerInfoList.get(i).getLxr()==null?"":customerInfoList.get(i).getLxr(),
            		customerInfoList.get(i).getTel()==null?"":customerInfoList.get(i).getTel(),
            		customerInfoList.get(i).getSj()==null?"":customerInfoList.get(i).getSj(),
            		customerInfoList.get(i).getLeibie()==null?"":customerInfoList.get(i).getLeibie(),
            		customerInfoList.get(i).getAdr()==null?"":customerInfoList.get(i).getAdr(),
            		customerInfoList.get(i).getWeb()==null?"":customerInfoList.get(i).getWeb(),
            		customerInfoList.get(i).getMail()==null?"":customerInfoList.get(i).getMail(),
            		customerInfoList.get(i).getCz()==null?"":customerInfoList.get(i).getCz(),
            		customerInfoList.get(i).getBank()==null?"":customerInfoList.get(i).getBank(),
            		customerInfoList.get(i).getProvince()==null?"":customerInfoList.get(i).getProvince(),
            		customerInfoList.get(i).getCity()==null?"":customerInfoList.get(i).getCity(),
            		customerInfoList.get(i).getComment()==null?"":customerInfoList.get(i).getComment()
        	};
        	ContextValue.CustomerInfoListData.add(obj);
        }
    }
    
    /**
     * 集中器列表
     * @author XCCD
     * @return
     */
    public Vector<Object[]> ListCustomerInfoVector(){
        List<CustomerInfoModel> customerInfoList = customerInfoService.loadCustomerInfoList();
        
        Vector<Object[]> vector = new Vector<Object[]>();
        for(int i=0; i<customerInfoList.size(); i++){
        	Object[] obj = new Object[]{
        			customerInfoList.get(i).getKehu_no(),
            		i+1,
            		Boolean.FALSE, 
            		customerInfoList.get(i).getKehu_py(),
            		customerInfoList.get(i).getKehu_name(),
            		customerInfoList.get(i).getLxr()==null?"":customerInfoList.get(i).getLxr(),
            		customerInfoList.get(i).getTel()==null?"":customerInfoList.get(i).getTel(),
            		customerInfoList.get(i).getSj()==null?"":customerInfoList.get(i).getSj(),
            		customerInfoList.get(i).getLeibie()==null?"":customerInfoList.get(i).getLeibie(),
            		customerInfoList.get(i).getAdr()==null?"":customerInfoList.get(i).getAdr(),
            		customerInfoList.get(i).getWeb()==null?"":customerInfoList.get(i).getWeb(),
            		customerInfoList.get(i).getMail()==null?"":customerInfoList.get(i).getMail(),
            		customerInfoList.get(i).getCz()==null?"":customerInfoList.get(i).getCz(),
            		customerInfoList.get(i).getBank()==null?"":customerInfoList.get(i).getBank(),
            		customerInfoList.get(i).getProvince()==null?"":customerInfoList.get(i).getProvince(),
            		customerInfoList.get(i).getCity()==null?"":customerInfoList.get(i).getCity(),
            		customerInfoList.get(i).getComment()==null?"":customerInfoList.get(i).getComment()
        	};
        	vector.add(obj); 
        }       
        return vector;
    }
    
    public List<CustomerInfoModel> showCustomerInfoList(){
        return customerInfoService.loadCustomerInfoList();
    }
    
    public void insert(CustomerInfoModel customerInfo){
    	customerInfoService.insert(customerInfo);
    }
    
    public boolean update(CustomerInfoModel customerInfo){
    	return customerInfoService.update(customerInfo); 
    }
    
    public boolean delete(String kehu_no){
    	return customerInfoService.delete(kehu_no);
    }
    
    public CustomerInfoModel queryById(String kehu_no){
    	return customerInfoService.queryById(kehu_no);
    }

    /* <li>判断是否已经存在数据
    * <li> 没有重复返回true,反之返回false
    * @author XCCD
    * @param goodsInfo
    * @return
    */
	public boolean queryRepeat(CustomerInfoModel customerInfo) {
		List<CustomerInfoModel> list = customerInfoService.queryRepeat(customerInfo);
		if (list == null || list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
    
	public List<CustomerInfoModel> queryBySome(CustomerInfoModel customerInfo) {
		
		List<CustomerInfoModel> customerInfoList = customerInfoService.queryBySome(customerInfo);
        
        ContextValue.CustomerInfoListData.clear();
        for(int i=0; i<customerInfoList.size(); i++){
        	Object[] obj = new Object[]{
        			customerInfoList.get(i).getKehu_no(),
            		i+1,
            		Boolean.FALSE, 
            		customerInfoList.get(i).getKehu_py(),
            		customerInfoList.get(i).getKehu_name(),
            		customerInfoList.get(i).getLxr()==null?"":customerInfoList.get(i).getLxr(),
            		customerInfoList.get(i).getTel()==null?"":customerInfoList.get(i).getTel(),
            		customerInfoList.get(i).getSj()==null?"":customerInfoList.get(i).getSj(),
            		customerInfoList.get(i).getLeibie()==null?"":customerInfoList.get(i).getLeibie(),
            		customerInfoList.get(i).getAdr()==null?"":customerInfoList.get(i).getAdr(),
            		customerInfoList.get(i).getWeb()==null?"":customerInfoList.get(i).getWeb(),
            		customerInfoList.get(i).getMail()==null?"":customerInfoList.get(i).getMail(),
            		customerInfoList.get(i).getCz()==null?"":customerInfoList.get(i).getCz(),
            		customerInfoList.get(i).getBank()==null?"":customerInfoList.get(i).getBank(),
            		customerInfoList.get(i).getProvince()==null?"":customerInfoList.get(i).getProvince(),
            		customerInfoList.get(i).getCity()==null?"":customerInfoList.get(i).getCity(),
            		customerInfoList.get(i).getComment()==null?"":customerInfoList.get(i).getComment()
        	};
        	ContextValue.CustomerInfoListData.add(obj);
        }
		
		return customerInfoList;
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询最后一条数据，生成新数据id，提供给使用者
	 * @author XCCD
	 * @return
	 */
	public String queryLast() {
		// TODO Auto-generated method stub
		
		CustomerInfoModel lastModel = customerInfoService.queryLast();
		String ID = lastModel.getKehu_no();
		int id = Integer.parseInt(ID)+1;
		String new_id = "000000".substring(0, 6-String.valueOf(id).length())+id;
		return new_id;
	}

}
