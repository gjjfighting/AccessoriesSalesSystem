package kehaofei.com.ui.optionSalesTicket;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kehaofei.com.ui_model.SelectTable;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ContextValue;
import kehaofei.com.utils.ControlFactory;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class SelectGoodsInfoPanel extends JScrollPane {

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
	public SelectGoodsInfoPanel() {
		ControlFactory.goodsInfoController.LoadGoodsInfoVector();
		
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("SendReceiveState")));

		setVerticalScrollBar(new JScrollBar());
		getVerticalScrollBar().setUnitIncrement(20);

		table = new SelectTable(ContextValue.GoodsInfoListObj).getTable(ContextValue.GoodsInfoListData);
		
		// 设置表格第二列的列宽
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setMaxWidth(40);
		table.getColumnModel().getColumn(2).setWidth(40);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		
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
							
							createPopupMenu();
							
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
							if((Boolean)table.getValueAt(focusedRowIndex, 2)){//是否已经选中
								for(int i=0; i<ContextValue.STI_SelectedGoodsData.size(); i++){
									
									if(ContextValue.GoodsInfoListData.get(focusedRowIndex)[0]
											.equals(ContextValue.STI_SelectedGoodsData.get(i)[0])){
										ContextValue.STI_SelectedGoodsData.remove(i);
									}
								}
								table.setValueAt(Boolean.FALSE, focusedRowIndex, 2);
							}else{
								boolean flag = true;
								//第一步判断销售单中是否已经存在此商品
								for(int i=0; i<ContextValue.SalesTicketInfoListData.size(); i++){
									
									if(ContextValue.GoodsInfoListData.get(focusedRowIndex)[0]
											.equals(ContextValue.SalesTicketInfoListData.get(i)[2])){
										flag = false;
										JOptionPane.showMessageDialog(SelectGoodsInfoPanel.this, "该商品已经添加");
										return;
									}
								}
								
								if(flag){//销售单中不存在商品再判断选择列表中是否存在商品
									for(int i=0; i<ContextValue.STI_SelectedGoodsData.size(); i++){
										
										if(ContextValue.GoodsInfoListData.get(focusedRowIndex)[0]
												.equals(ContextValue.STI_SelectedGoodsData.get(i)[0])){
											flag = false;
											JOptionPane.showMessageDialog(SelectGoodsInfoPanel.this, "该商品已经添加");
											return;
										}
									}
								}
								
								ContextValue.STI_SelectedGoodsData.add(ContextValue.GoodsInfoListData.get(focusedRowIndex));
								table.setValueAt(Boolean.TRUE, focusedRowIndex, 2);
							}
//							table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
//							table.addRowSelectionInterval(focusedRowIndex, focusedRowIndex);
							SwingUtilities.invokeLater(new Runnable(){
								@Override  
							    public void run() {
									 /*****初始化事件***/
									table.repaint();
									table.revalidate();
									
									SelectedGoodsInfoPanel.table.repaint();
									SelectedGoodsInfoPanel.table.revalidate();
									
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
	
	private void createPopupMenu() {  
        m_popupMenu = new JPopupMenu();  
          
        JMenuItem saveMenItem = new JMenuItem();
        saveMenItem.setText("点抄数据");  
        saveMenItem.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
                //该操作需要做的事  
            }
        });  
        m_popupMenu.add(saveMenItem);
    }

}
