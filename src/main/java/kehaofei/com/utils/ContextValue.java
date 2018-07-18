package kehaofei.com.utils;

import java.util.Vector;

public class ContextValue {
	

	/**
	 * 商品信息列表信息数据
	 */
	public static Object[] GoodsInfoListObj = 
			new Object[]{"ID", "序号", "选项", "拼音", "商品名称", "类别", "规格", "品牌", "单位", "进价", "销售价一", "销售价二", "销售价三", "厂家地址", "是否禁用", "备注"};	
	public static Vector<Object[]> GoodsInfoListData = new Vector<Object[]>();
	
	
	/**
	 * 客户信息列表数据
	 */
	public static Object[] CustomerInfoListObj = 
			new Object[]{"ID", "序号", "选项", "拼音", "客户名称", "联系人", "电话", "手机号", "客户类别", "地址", "网站", "邮箱", "传真", "银行账号", "省份", "城市", "备注"};
	public static Vector<Object[]> CustomerInfoListData = new Vector<Object[]>();
	
	/**
	 * 销售单列表数据
	 */
	public static Object[] SalesTicketInfoListObj = 
			new Object[]{"ID","XS_HAO","GOODS_ID", "序号", "选项", "拼音", "商品名称", "类别", "品牌", "规格", "单位", "售价", "销售数量", "总金额", "备注"};
	public static Vector<Object[]> SalesTicketInfoListData = new Vector<Object[]>();
	
	
	
	
	/**
	 * 销售单选择的商品信息数据
	 */
	public static Object[] STI_GoodsListObj = 
			new Object[]{"ID", "序号", "选项", "拼音", "商品名称", "类别", "规格", "品牌", "单位", "进价", "销售价一", "销售价二", "销售价三", "厂家地址", "是否禁用", "备注"};
	public static Vector<Object[]> STI_GoodsListData = new Vector<Object[]>();
	
	public static Object[] STI_SelectedGoodsObj = 
			new Object[]{"ID", "序号", "选项", "拼音", "商品名称", "类别", "规格", "品牌", "单位", "进价", "销售价一", "销售价二", "销售价三"};
	public static Vector<Object[]> STI_SelectedGoodsData = new Vector<Object[]>();
	
	
	/**
	 * 销售单列表数据
	 */
	public static Object[] SelectSalesTicketInfoListObj = 
			new Object[]{"销售单号","序号", "选项", "销售单号", "客户名称", "销售时间", "销售金额", "联系人", "联系电话"};
	public static Vector<Object[]> SelectSalesTicketInfoListData = new Vector<Object[]>();
	
	
	

}
