package kehaofei.com.ui.optionSalesTicket;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JDialog;
import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.stmt.GooGooStatementCache;


import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import kehaofei.com.sm.model.GoodsInfoModel;
import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.ui.main.WMSMainFrame;
import kehaofei.com.ui.wmspanel.GoodsInfoPanel;
import kehaofei.com.ui.wmspanel.SalesTicketInfoPanel;
import kehaofei.com.ui_model.EditTable;
import kehaofei.com.ui_model.SelectTable;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ContextValue;
import kehaofei.com.utils.ControlFactory;
import kehaofei.com.utils.MathUtil;
import kehaofei.com.utils.enumeration.GetContextSelect;
import kehaofei.com.utils.enumeration.GoodsTypeEnum;
import kehaofei.com.utils.enumeration.GoodsUnitEnum;
import kehaofei.com.utils.enumeration.OnOrOffEnum;
import javax.swing.JTable;

public class SelectGoodsDialog extends JDialog implements ActionListener, KeyListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(SelectGoodsDialog.class.getSimpleName());
	Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	
	
	SalesTicketInfoModel salesTicketInfo;
	private SelectedGoodsInfoPanel table;

	private SelectGoodsInfoPanel select_table;
	private JTextField text_pinyin;
	private JTextField text_name;
	private JTextField text_leibie;

	private JButton button_insert;

	private JButton button_cancel;

	private JButton button_query;

	/**
	 * Create the dialog.
	 * @param applicationModal 
	 * @param over 
	 */
	public SelectGoodsDialog(SalesTicketInfoModel salesTicketInfo) {
		super(WMSMainFrame.window, ModalityType.APPLICATION_MODAL);
		this.salesTicketInfo = salesTicketInfo;
		setBounds(100, 100, 1012, 640);
//		setResizable(false);
		setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);//设置窗口居中显示
		setTitle("\u7F16\u8F91\u5546\u54C1\u4FE1\u606F");
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_contentPane.rowHeights = new int[]{30, 0, 0, 0, 0, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0,Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("此处用于选择添加销售单的商品信息");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridwidth = 15;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel("\u62FC\u97F3\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);
		
		text_pinyin = new JTextField();
		text_pinyin.addKeyListener(this);
		GridBagConstraints gbc_text_pinyin = new GridBagConstraints();
		gbc_text_pinyin.insets = new Insets(0, 0, 5, 5);
		gbc_text_pinyin.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_pinyin.gridx = 2;
		gbc_text_pinyin.gridy = 2;
		getContentPane().add(text_pinyin, gbc_text_pinyin);
		text_pinyin.setColumns(10);
		
		JLabel label_1 = new JLabel("\u540D\u79F0\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		getContentPane().add(label_1, gbc_label_1);
		
		text_name = new JTextField();
		text_name.addKeyListener(this);
		GridBagConstraints gbc_text_name = new GridBagConstraints();
		gbc_text_name.insets = new Insets(0, 0, 5, 5);
		gbc_text_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_name.gridx = 4;
		gbc_text_name.gridy = 2;
		getContentPane().add(text_name, gbc_text_name);
		text_name.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u522B\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 5;
		gbc_label_2.gridy = 2;
		getContentPane().add(label_2, gbc_label_2);
		
		text_leibie = new JTextField();
		text_leibie.addKeyListener(this);
		GridBagConstraints gbc_text_leibie = new GridBagConstraints();
		gbc_text_leibie.insets = new Insets(0, 0, 5, 5);
		gbc_text_leibie.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_leibie.gridx = 6;
		gbc_text_leibie.gridy = 2;
		getContentPane().add(text_leibie, gbc_text_leibie);
		text_leibie.setColumns(10);
		
		button_query = new JButton("\u67E5\u8BE2");
		button_query.setName("QUERY");
		button_query.addActionListener(this);
		GridBagConstraints gbc_button_query = new GridBagConstraints();
		gbc_button_query.insets = new Insets(0, 0, 5, 5);
		gbc_button_query.gridx = 7;
		gbc_button_query.gridy = 2;
		getContentPane().add(button_query, gbc_button_query);
		
		button_insert = new JButton("\u5BFC\u5165");
		button_insert.setName("button_insert");
		button_insert.addActionListener(this);
		GridBagConstraints gbc_button_insert = new GridBagConstraints();
		gbc_button_insert.insets = new Insets(0, 0, 5, 5);
		gbc_button_insert.gridx = 12;
		gbc_button_insert.gridy = 3;
		getContentPane().add(button_insert, gbc_button_insert);
		
		button_cancel = new JButton("\u9000\u51FA");
		button_cancel.setName("button_cancel");
		button_cancel.addActionListener(this);
		GridBagConstraints gbc_button_cancel = new GridBagConstraints();
		gbc_button_cancel.insets = new Insets(0, 0, 5, 5);
		gbc_button_cancel.gridx = 13;
		gbc_button_cancel.gridy = 3;
		getContentPane().add(button_cancel, gbc_button_cancel);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 6;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 4;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel select_panel = new JPanel();
		tabbedPane.addTab("\u5546\u54C1\u5217\u8868", null, select_panel, null);
		GridBagLayout gbl_select_panel = new GridBagLayout();
		gbl_select_panel.columnWidths = new int[]{30, 0, 100, 0, 0, 100, 0, 0, 0, 30, 0};
		gbl_select_panel.rowHeights = new int[]{30, 0, 30, 0, 40, 0, 20, 0, 20, 0, 0, 0, 0};
		gbl_select_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_select_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		select_panel.setLayout(gbl_select_panel);
		
		select_table = new SelectGoodsInfoPanel();
		select_table.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		select_table.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		select_table.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		select_table.table.setRowSelectionAllowed(false);
				//new SelectTable(ContextValue.GoodsInfoListObj).getTable(ContextValue.GoodsInfoListData);
		GridBagConstraints gbc_select_table = new GridBagConstraints();
		gbc_select_table.gridheight = 16;
		gbc_select_table.gridwidth = 10;
		gbc_select_table.insets = new Insets(0, 0, 5, 5);
		gbc_select_table.fill = GridBagConstraints.BOTH;
		gbc_select_table.gridx = 0;
		gbc_select_table.gridy = 0;
		select_panel.add(select_table, gbc_select_table);
		
		
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane1 = new GridBagConstraints();
		gbc_tabbedPane1.gridwidth = 6;
		gbc_tabbedPane1.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane1.gridx = 8;
		gbc_tabbedPane1.gridy = 4;
		getContentPane().add(tabbedPane1, gbc_tabbedPane1);
		
		JPanel edit_panel = new JPanel();
		tabbedPane1.addTab("\u5DF2\u9009\u4FE1\u606F", null, edit_panel, null);
		GridBagLayout gbl_edit_panel = new GridBagLayout();
		gbl_edit_panel.columnWidths = new int[]{30, 0, 100, 0, 0, 100, 0, 0, 0, 30, 0};
		gbl_edit_panel.rowHeights = new int[]{30, 0, 30, 0, 40, 0, 20, 0, 20, 0, 0, 0, 0};
		gbl_edit_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_edit_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		edit_panel.setLayout(gbl_edit_panel);
		
		table = new SelectedGoodsInfoPanel();
				//new SelectTable(ContextValue.STI_GoodsListObj).getTable(ContextValue.STI_GoodsListData);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 12;
		gbc_table.gridwidth = 10;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		edit_panel.add(table, gbc_table);
		
		setModalityType(ModalityType.APPLICATION_MODAL);//对话框打开后限制父窗口操作	
		
	}
	
	/**
	 * 提取查询条件
	 * @author XCCD
	 */
	private GoodsInfoModel getTextInfo(){
		GoodsInfoModel good = new GoodsInfoModel();
		if(text_pinyin.getText() != null && !text_pinyin.getText().trim().equals("") ){
			good.setPeij_py(text_pinyin.getText());
		}
		if(text_name.getText() != null && !text_name.getText().trim().equals("") ){
			good.setPeij_name(text_name.getText());
		}
		if(text_leibie.getText() != null && !text_leibie.getText().trim().equals("") ){
			good.setPeij_lb(text_leibie.getText());
		}
			
		return good;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String className = e.getSource().getClass().getName();
		
		if(className.equals("javax.swing.JButton")){
			JButton bt = (JButton)e.getSource();
			String name = bt.getName();
			if("button_insert".equals(name)){//确认更新或者新增
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						
						
						int index=1;
						if(ContextValue.SalesTicketInfoListData.size()==1){
							index =1;
						}else{
							index =1 + (Integer) ContextValue.SalesTicketInfoListData.get(ContextValue.SalesTicketInfoListData.size()-2)[3];
						}
						
						ContextValue.SalesTicketInfoListData.remove(ContextValue.SalesTicketInfoListData.size()-1);
						int i=0;
						for( ; i<ContextValue.STI_SelectedGoodsData.size(); i++){
							
							Object[] objData = new Object[]{
									"",//销售明细id
									"",//销售单的Id
									ContextValue.STI_SelectedGoodsData.get(i)[0],//商品id
									index,
									Boolean.FALSE,
									ContextValue.STI_SelectedGoodsData.get(i)[3],
									ContextValue.STI_SelectedGoodsData.get(i)[4],
									ContextValue.STI_SelectedGoodsData.get(i)[5],
									ContextValue.STI_SelectedGoodsData.get(i)[7],
									ContextValue.STI_SelectedGoodsData.get(i)[6],//规格
									ContextValue.STI_SelectedGoodsData.get(i)[8],//单位
									ContextValue.STI_SelectedGoodsData.get(i)[10],//单价
									1,
									ContextValue.STI_SelectedGoodsData.get(i)[10],//这里是单件商品总价
									""};
							ContextValue.SalesTicketInfoListData.add(objData);
							index ++;
						}
						
						
						BigDecimal total = new BigDecimal(Double.toString(0.00));
						for(Object[] obArr:ContextValue.SalesTicketInfoListData){
							total = MathUtil.add_BigDecimal(obArr[13], total);
						}
						
						
						if(i == ContextValue.STI_SelectedGoodsData.size()){
							ContextValue.SalesTicketInfoListData.add(new Object[]{"","","","合计：",null,"","","","","","","","",total,""});
						}
						ContextValue.STI_SelectedGoodsData.clear();//添加完清空选中项
						
						
						SwingUtilities.invokeLater(new Runnable(){
							@Override  
						    public void run() {
								
								SalesTicketInfoPanel.table.repaint();
								SalesTicketInfoPanel.table.revalidate();
								
							}
						});
					}
				});
				
				this.dispose();//操作完成后关闭对话框
			}
			
			if("button_cancel".equals(name)){//关闭编辑页面
				this.dispose();//关闭对话框
			}
			
			if("QUERY".equals(name)){
				GoodsInfoModel good = getTextInfo();
				ControlFactory.goodsInfoController.queryBySome(good);
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						SelectGoodsInfoPanel.table.repaint();
						SelectGoodsInfoPanel.table.revalidate();
					}
				});
			}
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		 int k = e.getKeyCode();
         if(k == e.VK_ENTER){//回车事件
        	 //回车
        	 GoodsInfoModel good = getTextInfo();
				ControlFactory.goodsInfoController.queryBySome(good);
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						SelectGoodsInfoPanel.table.repaint();
						SelectGoodsInfoPanel.table.revalidate();
					}
				});
         }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
