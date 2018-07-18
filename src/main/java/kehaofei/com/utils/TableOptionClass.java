package kehaofei.com.utils;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class TableOptionClass {
	
	/**
	 * 根据需要隐藏对应的table列
	 * @author XCCD
	 * @param table
	 * @param column
	 */
	public static void HiddenTableColumn(JTable table, Integer column){
		// 设置表格第一列的列宽
		TableColumn firsetColumn = table.getColumnModel().getColumn(column);
		firsetColumn.setPreferredWidth(0);
		firsetColumn.setMaxWidth(0);
		firsetColumn.setWidth(0);
		firsetColumn.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
	}
	
	/**
	 * 设置table指定行可编辑
	 * @param table
	 * @param column
	 */
	public static void SetEditTableColumn(JTable table, Integer column){
		// 设置表格第一列的列宽
		TableColumn firsetColumn = table.getColumnModel().getColumn(column);
		firsetColumn.setPreferredWidth(0);
		firsetColumn.setMaxWidth(0);
		firsetColumn.setWidth(0);
		firsetColumn.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
	}

}
