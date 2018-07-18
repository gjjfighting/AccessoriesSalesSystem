package kehaofei.com.ui.wmspanel;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.EventObject;
import java.util.Vector;

import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.ui_model.EditTable;
import kehaofei.com.ui_model.SelectTable;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ContextValue;
import kehaofei.com.utils.ControlFactory;
import kehaofei.com.utils.MathUtil;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class SalesTicketInfoPanel extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static Integer width=0;
	ScrollPaneLayout gbl_contentPane = new ScrollPaneLayout();
	private JPopupMenu m_popupMenu;
	
	private SalesTicketInfoModel salesTicketInfo;
	private int rowIndex;
	private JTable tableButtom;

	/**
	 * Create the panel.
	 * @param salesTicketInfo 
	 */
	public SalesTicketInfoPanel(SalesTicketInfoModel salesTicketInfo) {
//		ControlFactory.CUSTOMER_INFO.LoadCustomerInfoVector();
		
		this.salesTicketInfo = salesTicketInfo;//界面数据实体
		
		if(ContextValue.SalesTicketInfoListData.size() == 0){
//			ContextValue.SalesTicketInfoListData.add(new Object[]{"","",1,Boolean.FALSE,"","","","","","","",1,0.00,""});
			ContextValue.SalesTicketInfoListData.add(new Object[]{"","","","合计：",Boolean.FALSE,"","","","","","","","",0.00,""});
		}
		
		
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("SendReceiveState")));

		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		table = new EditTable(ContextValue.SalesTicketInfoListObj).getTable(ContextValue.SalesTicketInfoListData);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setWidth(0);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
		
		// 设置表格第二列的列宽
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(3).setWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		
		
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		table.getColumnModel().getColumn(4).setWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
				
				table.getEditorComponent().addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						int focusedRowIndex = table.getSelectedRow();
						int focusedColIndex = table.getSelectedColumn();
						
						System.out.println("addKeyListener单元格编辑中。。。。。。"+table.getValueAt(focusedRowIndex, focusedColIndex));						
						System.out.println("addKeyListener单元格数据："+((JTextField)table.getEditorComponent()).getText());
						
						switch(focusedColIndex){
							case 11:
							{
								try {
									if(((JTextField)table.getEditorComponent()).getText() ==null 
											|| "".equals(((JTextField)table.getEditorComponent()).getText())){
										((JTextField)table.getEditorComponent()).setText("0");
										table.setValueAt(0, focusedRowIndex, focusedColIndex);
									}else
									
									if(((JTextField)table.getEditorComponent()).getText()!=null && table.getValueAt(focusedRowIndex, 12)!=null){
										
										table.setValueAt(((JTextField)table.getEditorComponent()).getText(),focusedRowIndex,focusedColIndex);
										
										BigDecimal mun = MathUtil.mul_BigDecimal(((JTextField)table.getEditorComponent()).getText(), table.getValueAt(focusedRowIndex, 12));
										table.setValueAt(mun, focusedRowIndex, 13);
										
										BigDecimal total = new BigDecimal(Double.toString(0.00));
										
										for(int i=0; i<table.getRowCount()-1; i++){
											Object price = table.getValueAt(i, 13).toString();
											
											total = MathUtil.add_BigDecimal(price, total);
										}
										
										table.setValueAt(total, table.getRowCount()-1, 13);
									}
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
									JOptionPane.showMessageDialog(null, "数据格式有误");
								}
							}break;
							case 12:
							{
								try {
									if(((JTextField)table.getEditorComponent()).getText() ==null 
											|| "".equals(((JTextField)table.getEditorComponent()).getText())){
										((JTextField)table.getEditorComponent()).setText("0");
										table.setValueAt(0, focusedRowIndex, focusedColIndex);
									}else
									if(((JTextField)table.getEditorComponent()).getText()!=null && table.getValueAt(focusedRowIndex, 11)!=null){
										
										table.setValueAt(((JTextField)table.getEditorComponent()).getText(),focusedRowIndex,focusedColIndex);
										
										BigDecimal mun = MathUtil.mul_BigDecimal(table.getValueAt(focusedRowIndex, 11), ((JTextField)table.getEditorComponent()).getText());
										table.setValueAt(mun, focusedRowIndex, 13);
										
										BigDecimal total = new BigDecimal(Double.toString(0.00));
										
										for(int i=0; i<table.getRowCount()-1; i++){
											Object price = table.getValueAt(i, 13).toString();
											
											total = MathUtil.add_BigDecimal(price, total);
										}
										
										table.setValueAt(total, table.getRowCount()-1, 13);
									}
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
									JOptionPane.showMessageDialog(null, "数据格式有误");
								}
							}break;
							default :
							{
								
							}break;
						}
					
						SwingUtilities.invokeLater(new Runnable(){
							@Override  
						    public void run() {
								 /*****初始化事件***/
								table.repaint();
								table.revalidate();
								
							}
						});
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub	
				
			}
		});
		
        
        table.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("表格失去焦点：：："+e.getComponent().getX()+","+e.getComponent().getY());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				if(table.getEditorComponent() !=null){
				table.getEditorComponent().addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
						/*if(e.getKeyChar() != KeyEvent.VK_ENTER){
							System.out.println("键值：：：：："+((JTextField)table.getEditorComponent()).getText());
							((JTextField)table.getEditorComponent()).setText(String.valueOf(e.getKeyChar()));
						}*/
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
						int focusedRowIndex = table.getSelectedRow();
						int focusedColIndex = table.getSelectedColumn();
						
						System.out.println("focusGained单元格编辑中。。。。。。"+table.getValueAt(focusedRowIndex, focusedColIndex));						
						System.out.println("focusGained单元格数据："+((JTextField)table.getEditorComponent()).getText());
						
						switch(focusedColIndex){
							case 11:
							{
								try {
									if(((JTextField)table.getEditorComponent()).getText() ==null 
											|| "".equals(((JTextField)table.getEditorComponent()).getText())){
										((JTextField)table.getEditorComponent()).setText("0");
										table.setValueAt(0, focusedRowIndex, focusedColIndex);
									}else
									if(((JTextField)table.getEditorComponent()).getText()!=null && table.getValueAt(focusedRowIndex, 12)!=null){
										
										table.setValueAt(((JTextField)table.getEditorComponent()).getText(),focusedRowIndex,focusedColIndex);
										
										BigDecimal mun = MathUtil.mul_BigDecimal(((JTextField)table.getEditorComponent()).getText(), table.getValueAt(focusedRowIndex, 12));
										table.setValueAt(mun, focusedRowIndex, 13);
										
										BigDecimal total = new BigDecimal(Double.toString(0.00));
										
										for(int i=0; i<table.getRowCount()-1; i++){
											Object price = table.getValueAt(i, 13).toString();
											
											total = MathUtil.add_BigDecimal(price, total);
										}
										
										table.setValueAt(total, table.getRowCount()-1, 13);
									}
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
									JOptionPane.showMessageDialog(null, "数据格式有误");
								}
							}break;
							case 12:
							{
								try {
									if(((JTextField)table.getEditorComponent()).getText() ==null 
											|| "".equals(((JTextField)table.getEditorComponent()).getText())){
										((JTextField)table.getEditorComponent()).setText("0");
										table.setValueAt(0, focusedRowIndex, focusedColIndex);
									}
									table.setValueAt(((JTextField)table.getEditorComponent()).getText(),focusedRowIndex,focusedColIndex);
									
									BigDecimal mun = MathUtil.mul_BigDecimal(table.getValueAt(focusedRowIndex, 11), ((JTextField)table.getEditorComponent()).getText());
									table.setValueAt(mun, focusedRowIndex, 13);
									
									BigDecimal total = new BigDecimal(Double.toString(0.00));
									
									for(int i=0; i<table.getRowCount()-1; i++){
										Object price = table.getValueAt(i, 13).toString();
										
										total = MathUtil.add_BigDecimal(price, total);
									}
									
									table.setValueAt(total, table.getRowCount()-1, 13);
									/*else
									if(((JTextField)table.getEditorComponent()).getText()!=null && table.getValueAt(focusedRowIndex, 11)!=null){
										
										
									}*/									
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
									JOptionPane.showMessageDialog(null, "数据格式有误");
								}
							}break;
							default :
							{
								
							}break;
						}
					
						SwingUtilities.invokeLater(new Runnable(){
							@Override  
						    public void run() {
								 /*****初始化事件***/
								table.repaint();
								table.revalidate();
								
							}
						});
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				}
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON3) {
					
					//通过点击位置找到点击为表格中的行  
					int focusedRowIndex = table.rowAtPoint(e.getPoint());
					if (focusedRowIndex == -1) {
						return;
					}
					// 将表格所选项设为当前右键点击的行
					table.setRowSelectionInterval(focusedRowIndex,focusedRowIndex);
					// 弹出菜单
					
//					createPopupMenu();
//					
//					m_popupMenu.show(table, e.getX(), e.getY());
				}
				
				if (e.getButton() == MouseEvent.BUTTON1) {//左键单击
					
					//通过点击位置找到点击为表格中的行  
					final int focusedRowIndex = table.rowAtPoint(e.getPoint());
					final int focusedColIndex = table.columnAtPoint(e.getPoint());
					if (focusedRowIndex == -1) {
						return;
					}
					

					/*TableCellEditor editer = table.getCellEditor(focusedRowIndex, focusedColIndex);					
					
					
					editer.addCellEditorListener(new CellEditorListener() {
						
						@Override
						public void editingStopped(ChangeEvent e) {
							// TODO Auto-generated method stub
							System.out.println("停止编辑"+focusedRowIndex+"      "+focusedColIndex);
							
							switch(focusedColIndex){
								case 11:
								case 12:
								{
									try {
										if(table.getValueAt(focusedRowIndex, 11)!=null && table.getValueAt(focusedRowIndex, 12)!=null){
											BigDecimal mun = MathUtil.mul_BigDecimal(table.getValueAt(focusedRowIndex, 11), table.getValueAt(focusedRowIndex, 12));
											table.setValueAt(mun, focusedRowIndex, 13);
											
											BigDecimal total = new BigDecimal(Double.toString(0.00));
											for(int i=0; i<table.getRowCount()-1; i++){
												Object price = table.getValueAt(i, 13).toString();
												
												total = MathUtil.add_BigDecimal(price, total);
											}
											
											table.setValueAt(total, table.getRowCount()-1, 13);
										}else if(
												table.getValueAt(focusedRowIndex, 11) ==null || "".equals(table.getValueAt(focusedRowIndex, 11)) ||
												table.getValueAt(focusedRowIndex, 12) ==null || "".equals(table.getValueAt(focusedRowIndex, 12))){
											table.setValueAt(1, focusedRowIndex, 12);
										}
									} catch (Exception e2) {
										// TODO: handle exception
									}
								}break;
								default :
								{
									
								}break;
							}
						}
						
						@Override
						public void editingCanceled(ChangeEvent e) {
							// TODO Auto-generated method stub
							System.out.println("editingCanceled");
						}
					});*/
					
					if(focusedColIndex == 3 && focusedRowIndex<table.getRowCount()-1){
						table.setRowSelectionAllowed(true);						
						table.setRowSelectionInterval(focusedRowIndex,focusedRowIndex);
					}else{
						table.setRowSelectionAllowed(false);
					}
					// 将表格所选项设为当前右键点击的行
//					if((Boolean)table.getValueAt(focusedRowIndex, 4)){
//						
//						table.setValueAt(Boolean.FALSE, focusedRowIndex, 4);
//					}else{
//						table.setValueAt(Boolean.TRUE, focusedRowIndex, 4);
//					}
					
					SwingUtilities.invokeLater(new Runnable(){
						@Override  
					    public void run() {
							 /*****初始化事件***/
							table.repaint();
							table.revalidate();
							
						}
					});					
				}
			}
		});
		
		setViewportView(table);
		
		setVisible(true);
		
//		tableButtom = new JTable();
//		setViewportView(table);		
//		setVisible(true);
	}

}
