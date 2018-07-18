package kehaofei.com.utils.enumeration;

/**
 * 
 * @author XCCD
 * <li>TODO	商品计量单位选项枚举列表
 * <li>2017-1-13 下午1:53:10
 * <li>
 */
public enum GoodsUnitEnum{
	
	unit1(0x01,  "包"),unit2(0x02, "本"),unit3(0x03, "个"),
	unit4(0x04, "根"),unit5(0x05, "台"),unit6(0x06, "串"),
	unit7(0x07, "付"),unit8(0x08, "斤"),unit9(0x09, "米");

	
	public Integer key;
	public String value;
	//构造方法
	private GoodsUnitEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	// 普通方法  
    public static String getValue(int key) {  
        for (GoodsUnitEnum rt : GoodsUnitEnum.values()) {  
            if (rt.getKey() == key) {  
                return rt.value;  
            }  
        }  
        return null;  
    }
    //获取key值
    public static Integer getKey(String value) {  
        for (GoodsUnitEnum rt : GoodsUnitEnum.values()) {  
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
