package kehaofei.com.ui.wmspanel;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kehaofei.com.sm.model.GoodsInfoModel;
import kehaofei.com.ui.optionGoods.EditGoodsInfoDialog;
import kehaofei.com.ui_model.SelectTable;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ContextValue;
import kehaofei.com.utils.ControlFactory;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class GoodsInfoPanel extends JScrollPane {
	
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
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
	public GoodsInfoPanel() {
		ControlFactory.goodsInfoController.LoadGoodsInfoVector();
		
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("SendReceiveState")));

//		setVerticalScrollBar(new JScrollBar());
		getVerticalScrollBar().setUnitIncrement(20);

		table = new SelectTable(ContextValue.GoodsInfoListObj).getTable(ContextValue.GoodsInfoListData);
		
		// 设置表格第二列的列宽
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setWidth(0);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		for(int i =3; i<table.getColumnCount(); i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
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
					try {
						GoodsInfoModel gim = new GoodsInfoModel();
						Integer count = GoodsInfoPanel.table.getRowCount();
						
						int index = GoodsInfoPanel.table.getSelectedRow();
						
						if(index == -1){
							JOptionPane.showMessageDialog(null, "没有选择数据");
							return;
						}else{
							gim = ControlFactory.goodsInfoController.queryById(
									(String) GoodsInfoPanel.table.getValueAt(index, 0));
						}
						
						//进入商品信息编辑界面
						EditGoodsInfoDialog egid = new EditGoodsInfoDialog(gim);
						egid.setVisible(true);
					} catch (Exception e2) {
						// TODO: handle exception
						log.info("|------ 商品信息 ------|\t 更新数据初始化失败"+e2);
					}
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
							
//							createPopupMenu();
//							
//							m_popupMenu.show(table, e.getX(), e.getY());
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
							}else{
								table.setValueAt(Boolean.TRUE, focusedRowIndex, 2);
							}
							
							SwingUtilities.invokeLater(new Runnable(){
								@Override  
							    public void run() {
									 /*****初始化事件***/
									table.repaint();
									table.revalidate();
									
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
	
/*	private void createPopupMenu() {  
        m_popupMenu = new JPopupMenu();  
          
        JMenuItem saveMenItem = new JMenuItem();
        saveMenItem.setText("点抄数据");  
        saveMenItem.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
                //该操作需要做的事  
            }
        });  
        m_popupMenu.add(saveMenItem);
    }*/

}
