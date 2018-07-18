package kehaofei.com.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author XCCD
 * <li>TODO	界面语言适配器
 * <li>2016-12-29 下午4:41:05
 * <li>
 */
public class Constant_Properties {
	
	public static Locale local = Locale.getDefault();
	
    public static String basename = "kehaofei.com.resource.myproperties";
    
    public static ResourceBundle myResource = ResourceBundle.getBundle(basename,local);
	
	public static final String ProgramTitle = "库存销售管理系统";
	

}
