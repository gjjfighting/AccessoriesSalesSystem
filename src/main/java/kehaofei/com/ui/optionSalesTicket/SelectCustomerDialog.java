package kehaofei.com.ui.optionSalesTicket;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JDialog;
import org.apache.log4j.Logger;

import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import kehaofei.com.sm.model.CustomerInfoModel;
import kehaofei.com.ui.main.WMSMainFrame;
import kehaofei.com.ui.wmspanel.SalesTicketHeadPanel;
import kehaofei.com.utils.ByteUtils;
import javax.swing.JTable;


/**
 * 
 * @author XCCD
 * <li>TODO	用于销售单查询选择客户信息
 * <li>2017-7-11 下午5:09:21
 * <li>
 */
public class SelectCustomerDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(SelectCustomerDialog.class.getSimpleName());
	Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	public static SelectCustomerInfoPanel table;
	
	int tableIndex = -1;

	/**
	 * Create the dialog.
	 * @param customerInfoList 
	 * @param applicationModal 
	 * @param over 
	 */
	public SelectCustomerDialog(List<CustomerInfoModel> customerInfoList) {
		super(WMSMainFrame.window, ModalityType.APPLICATION_MODAL);;
		setBounds(100, 100, 838, 468);
//		setResizable(false);
		setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);//设置窗口居中显示
		setTitle("\u7F16\u8F91\u5546\u54C1\u4FE1\u606F");
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 80, 0, 0, 50, 0, 50, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{30, 0, 30, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6B64\u5904\u7F16\u8F91\u5546\u54C1\u57FA\u672C\u4FE1\u606F");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.gridwidth = 9;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel edit_panel = new JPanel();
		tabbedPane.addTab("\u57FA\u672C\u4FE1\u606F", null, edit_panel, null);
		GridBagLayout gbl_edit_panel = new GridBagLayout();
		gbl_edit_panel.columnWidths = new int[]{30, 0, 100, 0, 0, 100, 0, 0, 0, 30, 0};
		gbl_edit_panel.rowHeights = new int[]{30, 0, 30, 0, 40, 0, 20, 0, 20, 0, 0, 0, 0};
		gbl_edit_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_edit_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		edit_panel.setLayout(gbl_edit_panel);
		
		table = new SelectCustomerInfoPanel(customerInfoList, this);
		table.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.table.requestFocusInWindow();
//		table.table.getSelectionModel().setSelectionInterval(0, 0);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 12;
		gbc_table.gridwidth = 10;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		edit_panel.add(table, gbc_table);
		
		setModalityType(ModalityType.APPLICATION_MODAL);//对话框打开后限制父窗口操作	
		
//		addKeyListener(this);
		
		kit.addAWTEventListener(new ImplAWTEventListener(), AWTEvent.KEY_EVENT_MASK);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String className = e.getSource().getClass().getName();
		
		if(className.equals("javax.swing.JButton")){
			JButton bt = (JButton)e.getSource();
			String name = bt.getName();
			if("btn_confirm".equals(name)){//确认更新或者新增
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						
					}
				});
				
				this.dispose();//操作完成后关闭对话框
			}
			
			if("btn_cancel".equals(name)){//关闭编辑页面
				this.dispose();//关闭对话框
			}
		}
		
	}

//	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == e.VK_ENTER) {// 回车事件
			
			if(tableIndex !=-1){
				//通过点击位置找到点击为表格中的行  
				System.out.println(table.customerInfoList);
				SalesTicketHeadPanel.salesTicketInfo.setKehu_no(table.customerInfoList.get(tableIndex).getKehu_no());
				SalesTicketHeadPanel.salesTicketInfo.setKehu_name(table.customerInfoList.get(tableIndex).getKehu_name());
				SalesTicketHeadPanel.salesTicketInfo.setKehu_pinyin(table.customerInfoList.get(tableIndex).getKehu_py());
				SalesTicketHeadPanel.salesTicketInfo.setKehu_tel(table.customerInfoList.get(tableIndex).getTel()/*.trim()==null?customerInfoList.get(focusedRowIndex).getSj():customerInfoList.get(focusedRowIndex).getTel()*/);
				SalesTicketHeadPanel.salesTicketInfo.setXs_date(ByteUtils.getNowTimeStr("yyyy-MM-dd"));
				
				this.dispose();
			}
		}
		
		if(k == e.VK_DOWN){//下方向键							
//			SelectCustomerDialog.table.table.setRowSelectionInterval(0,0);
			table.table.requestFocus();			
			if(tableIndex ==-1){				
				tableIndex = 0;				
				table.table.setRowSelectionInterval(tableIndex,tableIndex);
			}else if(tableIndex < table.table.getRowCount()-1){	
				tableIndex ++;
			}else{
				
			}
			System.out.println("当前选中行"+table.table.getValueAt(tableIndex, 4));
		}
		
		if(k == e.VK_UP){//上方向键							
						
			if(tableIndex ==-1 || tableIndex==0){
				
			}else{				
				tableIndex --;
			}
			System.out.println("当前选中行"+table.table.getValueAt(tableIndex, 4));
		}
		
	}

//	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	class ImplAWTEventListener implements AWTEventListener {  
        @Override  
        public void eventDispatched(AWTEvent event) {  
              if (event.getClass() == KeyEvent.class) {  
                // 被处理的事件是键盘事件.  
                KeyEvent keyEvent = (KeyEvent) event;  
                if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {  
                    //按下时你要做的事情  
                    keyPressed(keyEvent);  
                } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {  
                    //放开时你要做的事情  
                    keyReleased(keyEvent);  
                }  
            }  
        }  
        private void mousePressed(MouseEvent event) {}  
        private void keyReleased(KeyEvent event) {}  
	}

}
