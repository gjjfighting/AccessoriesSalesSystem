package kehaofei.com.utils.enumeration;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


/**
 * 提供统一的获取下拉列表数据的方法
 * @author kehao
 *
 */
public class GetContextSelect {
	
	public static JComboBox getCom_Type(JComboBox com_type) {//商品类型
		
		if (com_type == null) {
			com_type = new JComboBox();
			
			for (GoodsTypeEnum gte : GoodsTypeEnum.values()) {  
				com_type.addItem(gte.value);
				
	        }
			com_type.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
			
		}
		return com_type;
	}
	
	public static JComboBox getCom_Unit(JComboBox com_unit) {//商品计量单位
		
		if (com_unit == null) {
			com_unit = new JComboBox();
			
			for (GoodsUnitEnum gue : GoodsUnitEnum.values()) {  
				com_unit.addItem(gue.value);
				
	        }
			com_unit.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
			
		}
		return com_unit;
	}
	
	public static JComboBox getCom_Unit() {//商品计量单位
		
		JComboBox com_unit = new JComboBox();
		
		for (GoodsUnitEnum gue : GoodsUnitEnum.values()) {  
			com_unit.addItem(gue.value);
			
        }
		com_unit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		return com_unit;
	}
	
	public static JComboBox getCom_Disable(JComboBox com_disable) {//启用与禁用状态
		
		if (com_disable == null) {
			com_disable = new JComboBox();
			
			for (OnOrOffEnum gue : OnOrOffEnum.values()) {  
				com_disable.addItem(gue.value);
				
	        }
			com_disable.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
			
		}
		return com_disable;
	}


}
