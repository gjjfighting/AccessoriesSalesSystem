package kehaofei.com.ui_model;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyButtonRenderer extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		
		setForeground(table.getSelectionForeground());

		setBackground(table.getSelectionBackground());

		setText((value == null) ? "" : value.toString());
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
