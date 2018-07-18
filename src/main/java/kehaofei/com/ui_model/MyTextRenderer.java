package kehaofei.com.ui_model;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class MyTextRenderer extends JTextField implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
//		table.editCellAt(row, column);
		
		 if(isSelected){
			 System.out.println("MyTextRenderer----单元格被选中");
             setForeground(table.getForeground());             
             super.setBackground(table.getBackground());
	    }else{
             setForeground(table.getForeground());
             setBackground(table.getBackground());
	    }
		 setText((value == null) ? "" : value.toString());
		 setFocusable(true);
		 setEditable(true);
		 setEnabled(true);
		 setVisible(true);
		return this;
	}

	
	/**
	 * @author XCCD
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
