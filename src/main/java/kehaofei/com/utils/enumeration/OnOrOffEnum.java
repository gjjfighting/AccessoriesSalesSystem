package kehaofei.com.utils.enumeration;

/**
 * 
 * @author XCCD
 * <li>TODO	禁用启用状态
 * <li>2017-1-13 下午1:53:10
 * <li>
 */
public enum OnOrOffEnum{
	
	onOff1(0x01,  "是"),onOff2(0x02, "否");

	
	public Integer key;
	public String value;
	//构造方法
	private OnOrOffEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	// 普通方法  
    public static String getValue(int key) {  
        for (OnOrOffEnum rt : OnOrOffEnum.values()) {  
            if (rt.getKey() == key) {  
                return rt.value;  
            }  
        }  
        return null;  
    }
    //获取key值
    public static Integer getKey(String value) {  
        for (OnOrOffEnum rt : OnOrOffEnum.values()) {  
            if (rt.getValue().equals(value)) {  
                return rt.key;  
            }  
        }  
        return null;  
    } 
    
	/**
	 * @return the key
	 */
	private Integer getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Integer key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	private String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}		
	
}
