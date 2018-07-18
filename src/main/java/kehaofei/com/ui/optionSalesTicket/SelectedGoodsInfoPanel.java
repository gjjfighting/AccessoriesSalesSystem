package kehaofei.com.ui.optionSalesTicket;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kehaofei.com.ui_model.SelectTable;
import kehaofei.com.utils.ContextValue;
import kehaofei.com.utils.ControlFactory;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class SelectedGoodsInfoPanel extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static Integer width=0;
	ScrollPaneLayout gbl_contentPane = new ScrollPaneLayout();
	private JPopupMenu m_popupMenu;

	/**
	 * Create the panel.
	 */
	public SelectedGoodsInfoPanel() {
		
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("SendReceiveState")));

		setVerticalScrollBar(new JScrollBar());
		getVerticalScrollBar().setUnitIncrement(20);

		table = new SelectTable(ContextValue.STI_SelectedGoodsObj).getTable(ContextValue.STI_SelectedGoodsData);
		
		// 设置表格第二列的列宽
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(40);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		table.getColumnModel().getColumn(2).setWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
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
				
				int clickTimes = e.getClickCount();
				if (clickTimes == 2) {//double clicked be used
					System.out.println("Doublc Clicked!");
				}else{//single clicked be used 
				
					switch(e.getButton()){
					
						case MouseEvent.BUTTON3://单点右键
						{
							//通过点击位置找到点击为表格中的行  
							int focusedRowIndex = table.rowAtPoint(e.getPoint());
							if (focusedRowIndex == -1) {
								return;
							}
							// 将表格所选项设为当前右键点击的行
							table.setRowSelectionInterval(focusedRowIndex,focusedRowIndex);
							// 弹出菜单
							
							m_popupMenu.show(table, e.getX(), e.getY());
						}break;
						
						case MouseEvent.BUTTON1://单点左键
						{
							//通过点击位置找到点击为表格中的行  
							int focusedRowIndex = table.rowAtPoint(e.getPoint());
							if (focusedRowIndex == -1) {
								return;
							}
							if(table.getSelectedColumn() == 2){
								return;
							}
							// 将表格所选项设为当前右键点击的行
							if((Boolean)table.getValueAt(focusedRowIndex, 2)){
								table.setValueAt(Boolean.FALSE, focusedRowIndex, 2);
								ContextValue.STI_SelectedGoodsData.remove(focusedRowIndex);
							}else{
								
							}
							SwingUtilities.invokeLater(new Runnable(){
								@Override  
							    public void run() {
									 /*****初始化事件***/
									table.repaint();
									table.revalidate();
									
									SelectGoodsInfoPanel.table.repaint();
									SelectGoodsInfoPanel.table.revalidate();
									
								}
							});	
						}break;
					
					}
				}
			}
		});
		
		
		setViewportView(table);
		
		setVisible(true);
	}

}
