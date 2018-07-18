package kehaofei.com.ui.wmspanel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTabbedPane;

import kehaofei.com.ui.wmspanel.*;
import kehaofei.com.utils.Constant_Properties;

/**
 * 选项卡面板界面
 * @author XCCD
 *
 */
public class CustomerTabControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static CustomerInfoPanel customerInfoPanel;

	private GridBagConstraints gbc_BtnGroupPane;

	private CustomerQueryPanel QueryMsgPanel;

	/**
	 * Create the panel.
	 */
	public CustomerTabControlPanel() {
		customerInfoPanel = new CustomerInfoPanel();
		QueryMsgPanel = new CustomerQueryPanel();
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
		add(QueryMsgPanel, gbc_BtnGroupPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add("数据信息列表", customerInfoPanel);
//		tabbedPane.add("操作数据", new UpPanel());//显示详细操作指令及数据记录
//		tabbedPane.add("操作指令", new DownPanel());//只记录对应的数据帧
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 5, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		add(tabbedPane, gbc_tabbedPane);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
	}

}
