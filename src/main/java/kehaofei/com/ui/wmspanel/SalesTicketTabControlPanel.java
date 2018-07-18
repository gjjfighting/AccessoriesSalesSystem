package kehaofei.com.ui.wmspanel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;

import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.ui.wmspanel.*;
import kehaofei.com.utils.Constant_Properties;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class SalesTicketTabControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static SalesTicketInfoPanel salesTicketInfoPanel;

	private GridBagConstraints gbc_BtnGroupPane;

	private SalesTicketHeadPanel salesTicketHeadPanel;
	
	public static SalesTicketInfoModel salesTicketInfo = null;

	/**
	 * Create the panel.
	 */
	public SalesTicketTabControlPanel() {
		
//		this.salesTicketInfo = new SalesTicketInfoModel();
		
		salesTicketInfoPanel = new SalesTicketInfoPanel(this.salesTicketInfo);
		salesTicketHeadPanel = new SalesTicketHeadPanel(this.salesTicketInfo);
//		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("ParamSet")));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {95};
		gridBagLayout.rowHeights = new int[] {40, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		gbc_BtnGroupPane = new GridBagConstraints();
		gbc_BtnGroupPane.gridwidth = 13;
		gbc_BtnGroupPane.insets = new Insets(0, 0, 0, 2);
		gbc_BtnGroupPane.fill = GridBagConstraints.BOTH;
		gbc_BtnGroupPane.gridx = 0;
		gbc_BtnGroupPane.gridy = 0;
		add(salesTicketHeadPanel, gbc_BtnGroupPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add("数据信息列表", salesTicketInfoPanel);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 5, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		add(tabbedPane, gbc_tabbedPane);
		
		
		salesTicketInfoPanel.addMouseListener(new MouseListener() {
			
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
				switch(e.getButton()){
				
					case MouseEvent.BUTTON3://单点右键
					{
					
					}break;
					
					case MouseEvent.BUTTON1://单点左键
					{
						if (SalesTicketInfoPanel.table.isEditing()){ 
							SalesTicketInfoPanel.table.getCellEditor().stopCellEditing();
						}
					}break;
				}
			}
		});
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
	}

}
