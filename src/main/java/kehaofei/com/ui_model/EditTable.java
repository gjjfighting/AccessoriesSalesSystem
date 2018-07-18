package kehaofei.com.ui_model;

import java.awt.Rectangle;
import java.math.BigDecimal;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import kehaofei.com.utils.enumeration.GetContextSelect;

/**
 * 动态table界面初始化
 * @author XCCD
 *
 */
public class EditTable extends JTable{  
    /** 
     * 序列化 
     */  
    private static final long serialVersionUID = 1L;  
    private int myRow = -1, myCol = -1;  
    TableCellEditor myEditor;  
    private Object[] columnNames;
    private TableModel model;
    private Object[] objs;
    private JTable table;
    
    public EditTable(Object[] objs){   	
    	this.objs = objs;
    }
    public EditTable(TableModel model){
    	super();
    	this.model=model;
    
    }
    public void setComboCell(int r, int c, TableCellEditor ce) {  
        this.myRow = r;  
        this.myCol = c;  
        this.myEditor = ce;  
    }  
  
    @Override  
    public TableCellEditor getCellEditor(int row, int column) {  
        if (row == myRow && column == myCol && myEditor != null)  
            return myEditor;  
        return super.getCellEditor(row, column);  
    }  
    
	@SuppressWarnings("serial")
	public JTable getTable(Vector<Object[]> rowData) {
		
		columnNames = objs;
		
		// 初始化表模型，利用DefaultTableModel来生成TableModel的接口
		model = new EditTableModelDefine(rowData, columnNames);

		// 初始化JTable
		table = new JTable(model);
		table.setRowHeight(25);
		table.setRowSelectionAllowed(false);
		
		// 设置表格第一列的列宽
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(0);
		firsetColumn.setMaxWidth(0);
		firsetColumn.setMinWidth(0);
		
		//隐藏第一列ID列
		table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		
		//隐藏第一列ID列
//		table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
//		table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		
		table.putClientProperty(
		   "Quaqua.Table.style", "striped"
		);		
		table.setBounds(new Rectangle(1, 1));
		
		
		table.getColumnModel().getColumn(10).setCellEditor(new DefaultCellEditor(GetContextSelect.getCom_Unit()));
		
//		JTextField text = new JTextField("测试单元格"); 
//		table.getColumnModel().getColumn(9).setCellEditor(new MyTextEditor());
		
//		table.getColumnModel().getColumn(2).setCellRenderer(new MyTextRenderer());
//		
//		table.getColumnModel().getColumn(1).setCellRenderer(new MyButtonRenderer());
		
		
		table.addKeyListener(new CTableKeyAdapter(table));

		TableCellEditor tableCellEditor = table.getDefaultEditor(String.class);
		TableCellEditor tce_int= table.getDefaultEditor(Integer.class);
		TableCellEditor tce_big= table.getDefaultEditor(BigDecimal.class);
		if (tableCellEditor != null) {
			if (tableCellEditor instanceof DefaultCellEditor) {
				((DefaultCellEditor) tableCellEditor).setClickCountToStart(1);
			}		
		}
		if(tce_int != null){
			if (tce_int instanceof DefaultCellEditor) {
				((DefaultCellEditor) tce_int).setClickCountToStart(1);
			}
		}

		if(tce_big != null){
			if (tce_big instanceof DefaultCellEditor) {
				((DefaultCellEditor) tce_big).setClickCountToStart(1);
			}
		}
		
		
		return table;
   }
	
}  
