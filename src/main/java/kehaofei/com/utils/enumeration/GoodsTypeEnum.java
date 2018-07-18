package kehaofei.com.utils.enumeration;

/**
 * 
 * @author XCCD
 * <li>TODO	商品类型选项枚举列表
 * <li>2017-1-13 下午1:53:10
 * <li>
 */
public enum GoodsTypeEnum{
	
	type1(0x01,  "本"),type2(0x02, "电动"),type3(0x03, "垫"),
	type4(0x04, "杆"),type5(0x05, "管"),type6(0x06, "胶管"),
	type7(0x07, "接头"),type8(0x08, "开关"),type9(0x09, "配件"),
	type10(0x0A, "喷枪"),type11(0x0B, "喷头"),type12(0x0C, "皮碗"),
	type13(0x0D, "书"),type14(0x0E, "整机");

	
	public Integer key;
	public String value;
	//构造方法
	private GoodsTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	// 普通方法  
    public static String getValue(int key) {  
        for (GoodsTypeEnum rt : GoodsTypeEnum.values()) {  
            if (rt.getKey() == key) {  
                return rt.value;  
            }  
        }  
        return null;  
    }
    //获取key值
    public static Integer getKey(String value) {  
        for (GoodsTypeEnum rt : GoodsTypeEnum.values()) {  
            if (rt.getValue().equals(value)) {  
                return rt.key;  
            }  
        }  
        return null;  
    } 
    
	/**
	 * @return the key
	 */
	public Integer getKey() {
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
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}		
	
}
