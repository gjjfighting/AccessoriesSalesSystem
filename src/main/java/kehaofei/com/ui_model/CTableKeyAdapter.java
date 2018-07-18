package kehaofei.com.ui_model;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 表格单元格单点编辑适配器
 * @author XCCD
 * <li>TODO	
 * <li>2017-7-13 上午10:00:34
 * <li>
 */
public class CTableKeyAdapter extends KeyAdapter {
	JTable table;

	public CTableKeyAdapter(JTable pTable) {
		table = pTable;
	}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_DOWN){
			System.out.println("下方向键："+table.getSelectedRow()+":"+table.getSelectedColumn());
		}
		int row;
		int column;
		row = table.getSelectedRow();
		column = table.getSelectedColumn();
		boolean bFirstTimeEdit;
		bFirstTimeEdit = false;
		Component editorComp;
		editorComp = table.getEditorComponent();
		if (editorComp == null) {
			bFirstTimeEdit = true;
		} else {
			if (editorComp instanceof JTextField) {
				if (((JTextField) editorComp).getText() == null) {
					if (table.getValueAt(row, column) == null) {
						bFirstTimeEdit = true;
					}
				} else {
					if (((JTextField) editorComp).getText().equals(
							table.getValueAt(row, column))) {
						bFirstTimeEdit = true;
					}
				}
			}
		}

		if (editorComp == null) {
			table.editCellAt(table.getSelectedRow(), table.getSelectedColumn());
		}
		editorComp = table.getEditorComponent();

		if (editorComp != null) {
			if (bFirstTimeEdit) {
				if (editorComp instanceof JTextField) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER) {
						((JTextField) editorComp).setText(null);
					}
					
				}
			}
			editorComp.requestFocus();
		}
	}
	
	
}
