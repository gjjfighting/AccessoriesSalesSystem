package kehaofei.com.ui.panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import kehaofei.com.mybatisfactory.SpringBeanFactory;
import kehaofei.com.ui.main.TabControlPanel;
import kehaofei.com.ui.main.WMSMainFrame;
import kehaofei.com.ui.wmspanel.CustomerInfoWindow;
import kehaofei.com.ui.wmspanel.GoodsInfoWindow;
import kehaofei.com.ui.wmspanel.SalesTicketInfoWindow;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ContextValue;

/**
 * 
 * @author XCCD
 *
 */
public class BtnMenuGroupPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int index=1;
	
	public static JButton btn2;

	public static JButton btn3;

	public static JButton btn4;

	public static JButton btn5;

	public static JButton btn;

	public static JButton btn1;
	
	
	public static GoodsInfoWindow goodsInfoWindow;

	public static CustomerInfoWindow customerInfoWindow;
	
	public static SalesTicketInfoWindow salesTicketInfoWindow;

	private Window window;
	
	
	/**
	 * Create the panel.
	 * @param up 
	 * @param down 
	 */
	public BtnMenuGroupPanel() {
//		goodsInfoWindow = new GoodsInfoWindow();		
		
		
		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("FunctionBlock")));
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0};
		gbl_btnPanel.rowHeights = new int[]{0, 0, 0};
		gbl_btnPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.8, 0.2, Double.MIN_VALUE};
		setLayout(gbl_btnPanel);
		
		btn = new JButton("销售订单");	
		btn.setName("SalesOrder");
		btn.addActionListener(this);
		GridBagConstraints gbc_controlbtn = new GridBagConstraints();
		gbc_controlbtn.gridwidth = 1;
		gbc_controlbtn.gridheight = 1;
		gbc_controlbtn.insets = new Insets(5, 5, 0, 5);
		gbc_controlbtn.fill = GridBagConstraints.BOTH;
		gbc_controlbtn.gridx = 0;
		gbc_controlbtn.gridy = 0;
		add(btn, gbc_controlbtn);
		
		btn1 = new JButton("商品管理");
		btn1.setName("GoodsInfo");
		btn1.addActionListener(this);
		GridBagConstraints gbc_controlbtn1 = new GridBagConstraints();
		gbc_controlbtn1.gridwidth = 1;
		gbc_controlbtn1.gridheight = 1;
		gbc_controlbtn1.insets = new Insets(5, 0, 0, 5);
		gbc_controlbtn1.fill = GridBagConstraints.BOTH;
		gbc_controlbtn1.gridx = 1;
		gbc_controlbtn1.gridy = 0;
		add(btn1, gbc_controlbtn1);
		
		btn4 = new JButton("客户管理");
		btn4.setName("CustomerInfo");
		btn4.addActionListener(this);
		GridBagConstraints gbc_controlbtn4 = new GridBagConstraints();
		gbc_controlbtn4.gridwidth = 1;
		gbc_controlbtn4.gridheight = 1;
		gbc_controlbtn4.insets = new Insets(5, 0, 0, 5);
		gbc_controlbtn4.fill = GridBagConstraints.BOTH;
		gbc_controlbtn4.gridx = 2;
		gbc_controlbtn4.gridy = 0;
		add(btn4, gbc_controlbtn4);
		
		
		btn2 = new JButton("备用入口");//数据路由转发帧信息
		btn2.setVisible(false);
		btn2.addActionListener(this);
		GridBagConstraints gbc_controlbtn2 = new GridBagConstraints();
		gbc_controlbtn2.gridwidth = 1;
		gbc_controlbtn2.gridheight = 1;
		gbc_controlbtn2.insets = new Insets(5, 0, 0, 5);
		gbc_controlbtn2.fill = GridBagConstraints.BOTH;
		gbc_controlbtn2.gridx = 3;
		gbc_controlbtn2.gridy = 0;
		add(btn2, gbc_controlbtn2);
		
		btn3 = new JButton("备用入口");
		btn3.setVisible(false);
		btn3.addActionListener(this);
		GridBagConstraints gbc_controlbtn3 = new GridBagConstraints();
		gbc_controlbtn3.gridwidth = 1;
		gbc_controlbtn3.gridheight = 1;
		gbc_controlbtn3.insets = new Insets(5, 0, 0, 5);
		gbc_controlbtn3.fill = GridBagConstraints.BOTH;
		gbc_controlbtn3.gridx = 4;
		gbc_controlbtn3.gridy = 0;
		add(btn3, gbc_controlbtn3);
		
		btn5 = new JButton("备用入口");
		btn5.setVisible(false);
		btn5.addActionListener(this);
		GridBagConstraints gbc_controlbtn5 = new GridBagConstraints();
		gbc_controlbtn5.gridwidth = 1;
		gbc_controlbtn5.gridheight = 1;
		gbc_controlbtn5.insets = new Insets(5, 0, 0, 5);
		gbc_controlbtn5.fill = GridBagConstraints.BOTH;
		gbc_controlbtn5.gridx = 5;
		gbc_controlbtn5.gridy = 0;
		add(btn5, gbc_controlbtn5);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton bt = (JButton) e.getSource();
		
		String name = bt.getName();
		
		/*switch(name){
		case "GoodsInfo":
			{
				WMSMainFrame.desktopPane.add(new GoodsInfoWindow());
			}break;
		}*/
		
		//
		if("GoodsInfo".equals(name)){
			if(goodsInfoWindow == null || goodsInfoWindow.isClosed()){
				System.out.println("内窗口已经关闭");
				ContextValue.GoodsInfoListData.clear();
				goodsInfoWindow = new GoodsInfoWindow();
				
				WMSMainFrame.desktopPane.add(goodsInfoWindow, index++);

				try {
					goodsInfoWindow.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
			
			}
			
			try {
				goodsInfoWindow.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WMSMainFrame.desktopPane.updateUI();
			WMSMainFrame.desktopPane.revalidate();
		}
		if("CustomerInfo".equals(name)){
			if(customerInfoWindow == null || customerInfoWindow.isClosed()){
				System.out.println("内窗口已经关闭");
				ContextValue.CustomerInfoListData.clear();
				customerInfoWindow = new CustomerInfoWindow();
				WMSMainFrame.desktopPane.add(customerInfoWindow, index++);
				
				try {
					customerInfoWindow.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				
			}
			try {
				customerInfoWindow.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WMSMainFrame.desktopPane.updateUI();
			WMSMainFrame.desktopPane.revalidate();
		}
		
		if("SalesOrder".equals(name)){
			if(salesTicketInfoWindow == null || salesTicketInfoWindow.isClosed()){
				System.out.println("内窗口已经关闭");
				ContextValue.SalesTicketInfoListData.clear();
				salesTicketInfoWindow = new SalesTicketInfoWindow();
				WMSMainFrame.desktopPane.add(salesTicketInfoWindow, index++);
				
				try {
					salesTicketInfoWindow.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}else{
				
			}
			try {
				
				salesTicketInfoWindow.setSelected(true);				
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WMSMainFrame.desktopPane.updateUI();
			WMSMainFrame.desktopPane.revalidate();
		}
		
	}

}
