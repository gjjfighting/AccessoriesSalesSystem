package kehaofei.com.ui_model;

import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * 动态table界面初始化
 * @author XCCD
 *
 */
public class SelectTable extends JTable{  
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
    
    public SelectTable(Object[] objs){   	
    	this.objs = objs;
    }
    public SelectTable(TableModel model){
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
		model = new TableModelDefine(rowData, columnNames);

		// 初始化JTable
		table = new JTable(model);
		table.setRowHeight(25);
		
		// 设置表格第一列的列宽
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(0);
		firsetColumn.setMaxWidth(0);
		firsetColumn.setMinWidth(0);
		
		//隐藏第一列ID列
		table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		
		table.putClientProperty(
		   "Quaqua.Table.style", "striped"
		);
		
		table.setBounds(new Rectangle(1, 1));
		
		// 为表格添加监听器
		/*table.addMouseListener(new MouseAdapter()

		  {

		   public void mouseClicked(MouseEvent e)

		   {
		    if (e.getClickCount() == 2)

		    // 实现双击
		    {

		     int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置

		     int col = ((JTable) e.getSource()).columnAtPoint(e
		       .getPoint()); // 获得列位置
		     String cellVal = (String) (model.getValueAt(row, col)); // 获得点击单元格数据
//		     txtboxRow.setText((row + 1) + "");
//		     txtboxCol.setText((col + 1) + "");

//		     txtboxContent.setText(cellVal);

		    } else
		     return;
		   }
		  });*/
		
		return table;
   }
	
}  
