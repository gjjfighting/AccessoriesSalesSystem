package kehaofei.com.ui.main;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.Logger;

import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.ui.optionSalesTicket.OpenSalesTicketDialog;
import kehaofei.com.ui.optionSalesTicket.SelectSalesTicketInfoPanel;
import kehaofei.com.ui.wmspanel.SalesTicketHeadPanel;
import kehaofei.com.utils.ByteUtils;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ControlFactory;

/**
 * 空面板
 * @author XCCD
 *
 */
public class LeftView_TreePanel extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	private JTree meterTree;
	DefaultMutableTreeNode root = getRoot();
	public static Map<Integer, DefaultMutableTreeNode> map = new Hashtable<Integer, DefaultMutableTreeNode>();	    

	/**
	 * Create the panel.
	 */
	public LeftView_TreePanel() {
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("ParamSet")));
//		setVerticalScrollBar(new JScrollBar());
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getVerticalScrollBar().setUnitIncrement(20);
		
		meterTree = new JTree();

	    meterTree.setModel(new DefaultTreeModel(root));
	    meterTree.getSelectionModel().setSelectionMode(
		DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);
		
//		meterTree.setToolTipText("\u8868\u6570\u636E\u5217\u8868");
		meterTree.setShowsRootHandles(true);

		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
		
		meterTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("当前选中的行：：："+e.getPath());
				
				
				if(e.getPath().getPathCount()>1){//捕捉非根目录点击事件
					String date="";//查询条件---日期
					Object[] arrays = e.getPath().getPath();
					for(int i =1; i<arrays.length; i++){
						switch(i){
							case 1:{
								date += String.valueOf(arrays[i]).substring(0,4);
							}break;
							case 2:{
								date += (String.valueOf(arrays[i]).substring(0,2));
							}break;
							
						}
					}
					log.info("|----------------当前选中的日期-----------------|\t"+date);
					SalesTicketInfoModel ticket = new SalesTicketInfoModel();
					ticket.setXs_hao(date);
					ControlFactory.salesTicketInfoController.LoadSalesTicketInfoVector(ticket);
					
					SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
						@Override
						public void run() {
							SelectSalesTicketInfoPanel.table.repaint();
							SelectSalesTicketInfoPanel.table.revalidate();
						}
					});
					
				}
				
				
			}
		});
		
		setViewportView(meterTree);
		
		setVisible(true);
	}
	
	/**
	 * 创建节点树
	 * @author XCCD
	 * @return
	 */
	private DefaultMutableTreeNode getRoot()  {
		// TODO Auto-generated method stub
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("销售单数据列表");
//	    List<String> list = ControlFactory.salesTicketInfoController.queryDate("2017");	    
	    /*for(String node : list){
	    	DefaultMutableTreeNode children = null;			
	    	children = new DefaultMutableTreeNode(node);
	    	root.add(children);
	    }*/
	    
	    for(int i=2004; i<=Integer.valueOf(ByteUtils.getNowTimeStr("yyyy")); i++){
	    	DefaultMutableTreeNode children = null;			
	    	children = new DefaultMutableTreeNode(i+"年份");
	    	root.add(children);
	    	
	    	for(int j=1; j<=12; j++){
	    		DefaultMutableTreeNode children1 = null;
	    		String month = String.valueOf(j).length()%2==0?String.valueOf(j):"0"+j;
		    	children1 = new DefaultMutableTreeNode(month+"月份");
		    	children.add(children1);
	    	}
	    }
//	    initTree1(list,map);
	    return root;
	}


//	public static void initTree1(List<String> list,
//			Map<Integer, DefaultMutableTreeNode> map) {
//		for (String node : list) {
//			DefaultMutableTreeNode children = null;
//				
//			children = new DefaultMutableTreeNode(node);
//
//			map.get(meterLibrary.getMeter_type()).add(children);
//						
//		}
//	}

}
