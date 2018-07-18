package kehaofei.com.ui_model;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 * 创建自定义表格模型
 * @author XCCD
 *
 */
public class EditTableModelDefine extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Object[]> rowData;
	private Object[] columnNames ;

	public EditTableModelDefine(Vector<Object[]> rowData, Object[] columnNames) {
		super();
		this.rowData = rowData;
		this.columnNames = columnNames;
	}

	public Vector<Object[]> getRowData() {
		return rowData;
	}

	public void setRowData(Vector<Object[]> rowData) {
		this.rowData = rowData;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int column) {
		return (String) columnNames[column];
	}

	public int getRowCount() {
		return rowData.size();
	}

	public Object getValueAt(int row, int column) {
		if(rowData == null || rowData.isEmpty()){
			return null;
		}
		Object[] obj = (Object[]) rowData.get(row);
		return obj[column];
	}

	@SuppressWarnings("rawtypes")
	public Class getColumnClass(int column) {
		if(rowData == null || rowData.isEmpty()){
			return null;
		}
		new MyTextRenderer();
		return /*new MyTextRenderer().getClass();*/(getValueAt(0, column).getClass());
	}

	public void setValueAt(Object value, int row, int column) {
		Object[] obj = (Object[]) rowData.get(row);
		obj[column] = value;
	}

	public boolean isCellEditable(int row, int column) {
		return (((column >5 && column != 13) || column==4) && row<rowData.size()-1);
	}
	
}