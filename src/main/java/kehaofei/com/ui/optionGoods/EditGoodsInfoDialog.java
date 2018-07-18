package kehaofei.com.ui.optionGoods;

import java.awt.Color;
import java.awt.Component;
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

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import kehaofei.com.sm.model.GoodsInfoModel;
import kehaofei.com.ui.main.WMSMainFrame;
import kehaofei.com.ui.wmspanel.GoodsInfoPanel;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ControlFactory;
import kehaofei.com.utils.FirstLetterUtil;
import kehaofei.com.utils.Pinyin4jUtil;
import kehaofei.com.utils.enumeration.GetContextSelect;
import kehaofei.com.utils.enumeration.GoodsTypeEnum;
import kehaofei.com.utils.enumeration.GoodsUnitEnum;
import kehaofei.com.utils.enumeration.OnOrOffEnum;

/**
 * 
 * @author XCCD
 * <li>TODO	商品信息填写界面
 * <li>2017-7-17 下午1:39:48
 * <li>
 */
public class EditGoodsInfoDialog extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(EditGoodsInfoDialog.class.getSimpleName());
	Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	private JTextField text_py;
	private JTextField text_name;
	private JTextField text_code;//规格
	private JTextField text_brand;//品牌
	
	
	GoodsInfoModel goodsInfo;

	private JButton btn_confirm;

	private JButton btn_cancel;

	private JButton btn_update;
	private JTextField text_price1;
	private JTextField text_price2;
	private JTextField text_price3;
	private JTextField text_prodoct;
	private JTextField text_conment;

	private JComboBox com_type;//类型

	private JComboBox com_unit;//商品计量单位

	private JComboBox com_disable;
	private JTextField text_inPrice;
	
	//价格校验
	InputVerifier doubleVerifier = new InputVerifier() {
		public boolean verify(JComponent comp) {
			boolean returnValue;
			JTextField textField = (JTextField) comp;
			try {
				Double.parseDouble(textField.getText());
				returnValue = true;
			} catch (NumberFormatException e) {
				Toolkit.getDefaultToolkit().beep();				
				returnValue = false;
				JOptionPane.showMessageDialog(null, "输入正确的数据");
			}
			return returnValue;
		}
	};

	/**
	 * Create the dialog.
	 * @param applicationModal 
	 * @param over 
	 */
	public EditGoodsInfoDialog(GoodsInfoModel goodsInfo) {
		super(WMSMainFrame.window, ModalityType.APPLICATION_MODAL);
		this.goodsInfo = goodsInfo;
		setBounds(100, 100, 838, 468);
		setResizable(false);
		setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);//设置窗口居中显示
		setTitle("\u7F16\u8F91\u5546\u54C1\u4FE1\u606F");
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 80, 0, 0, 80, 0, 50, 0, 0, 0};
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
		gbc_tabbedPane.gridwidth = 9;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel edit_panel = new JPanel();
		tabbedPane.addTab("\u57FA\u672C\u4FE1\u606F", null, edit_panel, null);
		GridBagLayout gbl_edit_panel = new GridBagLayout();
		gbl_edit_panel.columnWidths = new int[]{30, 0, 100, 0, 0, 100, 0, 0, 100, 30, 0};
		gbl_edit_panel.rowHeights = new int[]{30, 0, 30, 0, 40, 0, 20, 0, 20, 0, 0, 0, 0};
		gbl_edit_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_edit_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		edit_panel.setLayout(gbl_edit_panel);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		edit_panel.add(label, gbc_label);		
		
		text_name = new JTextField();
		text_name.setName("text_name");
		text_name.addKeyListener(this);//监测键盘输入
		GridBagConstraints gbc_text_number = new GridBagConstraints();
		gbc_text_number.insets = new Insets(0, 0, 5, 5);
		gbc_text_number.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_number.gridx = 2;
		gbc_text_number.gridy = 1;
		edit_panel.add(text_name, gbc_text_number);
		text_name.setColumns(10);
		text_name.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 100)));
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u62FC\u97F3\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 1;
		edit_panel.add(label_1, gbc_label_1);
		
		text_py = new JTextField();
		GridBagConstraints gbc_text_name = new GridBagConstraints();
		gbc_text_name.insets = new Insets(0, 0, 5, 5);
		gbc_text_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_name.gridx = 5;
		gbc_text_name.gridy = 1;
		edit_panel.add(text_py, gbc_text_name);
		text_py.setColumns(10);
		text_py.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 100)));
		
		JLabel label_6 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 1;
		edit_panel.add(label_6, gbc_label_6);
		
		com_type = getCom_Type();//商品类型
		GridBagConstraints gbc_com_type = new GridBagConstraints();
		gbc_com_type.insets = new Insets(0, 0, 5, 5);
		gbc_com_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_com_type.gridx = 8;
		gbc_com_type.gridy = 1;
		edit_panel.add(com_type, gbc_com_type);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		edit_panel.add(label_2, gbc_label_2);
		
		text_code = new JTextField();
		GridBagConstraints gbc_text_password = new GridBagConstraints();
		gbc_text_password.insets = new Insets(0, 0, 5, 5);
		gbc_text_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_password.gridx = 2;
		gbc_text_password.gridy = 3;
		edit_panel.add(text_code, gbc_text_password);
		text_code.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u54C1\u724C\uFF1A");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 3;
		edit_panel.add(label_3, gbc_label_3);
		
		text_brand = new JTextField();
		GridBagConstraints gbc_text_address = new GridBagConstraints();
		gbc_text_address.insets = new Insets(0, 0, 5, 5);
		gbc_text_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_address.gridx = 5;
		gbc_text_address.gridy = 3;
		edit_panel.add(text_brand, gbc_text_address);
		text_brand.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u5355\u4F4D\uFF1A");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 7;
		gbc_lblNewLabel_1.gridy = 3;
		edit_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		com_unit = getCom_Unit();//商品计量单位选择
		GridBagConstraints gbc_com_unit = new GridBagConstraints();
		gbc_com_unit.insets = new Insets(0, 0, 5, 5);
		gbc_com_unit.fill = GridBagConstraints.HORIZONTAL;
		gbc_com_unit.gridx = 8;
		gbc_com_unit.gridy = 3;
		edit_panel.add(com_unit, gbc_com_unit);
		
		JLabel label_12 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_12.gridwidth = 10;
		gbc_label_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 4;
		edit_panel.add(label_12, gbc_label_12);
		
		JLabel label_4 = new JLabel("\u5546\u54C1\u8FDB\u4EF7\uFF1A");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 5;
		edit_panel.add(label_4, gbc_label_4);
		
		text_inPrice = new JTextField("0.0");
		text_inPrice.setName("text_inPrice");
		text_inPrice.addKeyListener(this);
		text_inPrice.setInputVerifier(doubleVerifier);
		GridBagConstraints gbc_text_inPrice = new GridBagConstraints();
		gbc_text_inPrice.insets = new Insets(0, 0, 5, 5);
		gbc_text_inPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_inPrice.gridx = 2;
		gbc_text_inPrice.gridy = 5;
		edit_panel.add(text_inPrice, gbc_text_inPrice);
		text_inPrice.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7981\u7528\u6807\u8BC6\uFF1A");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 4;
		gbc_label_5.gridy = 5;
		edit_panel.add(label_5, gbc_label_5);
		
		com_disable = getCom_Disable();
		GridBagConstraints gbc_com_disable = new GridBagConstraints();
		gbc_com_disable.insets = new Insets(0, 0, 5, 5);
		gbc_com_disable.fill = GridBagConstraints.HORIZONTAL;
		gbc_com_disable.gridx = 5;
		gbc_com_disable.gridy = 5;
		edit_panel.add(com_disable, gbc_com_disable);
		
		JLabel label_7 = new JLabel("\u9500\u552E\u4EF7\u4E00\uFF1A");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 7;
		edit_panel.add(label_7, gbc_label_7);
		
		text_price1 = new JTextField("0.0");
		text_price1.setName("text_price1");
		text_price1.addKeyListener(this);
		text_price1.setInputVerifier(doubleVerifier);
		GridBagConstraints gbc_text_price1 = new GridBagConstraints();
		gbc_text_price1.insets = new Insets(0, 0, 5, 5);
		gbc_text_price1.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_price1.gridx = 2;
		gbc_text_price1.gridy = 7;
		edit_panel.add(text_price1, gbc_text_price1);
		text_price1.setColumns(10);
		text_price1.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 100)));
		
		JLabel label_8 = new JLabel("\u9500\u552E\u4EF7\u4E8C\uFF1A");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 4;
		gbc_label_8.gridy = 7;
		edit_panel.add(label_8, gbc_label_8);
		
		text_price2 = new JTextField();
		GridBagConstraints gbc_text_price2 = new GridBagConstraints();
		gbc_text_price2.insets = new Insets(0, 0, 5, 5);
		gbc_text_price2.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_price2.gridx = 5;
		gbc_text_price2.gridy = 7;
		edit_panel.add(text_price2, gbc_text_price2);
		text_price2.setColumns(10);
		
		JLabel label_9 = new JLabel("\u9500\u552E\u4EF7\u4E09\uFF1A");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 7;
		gbc_label_9.gridy = 7;
		edit_panel.add(label_9, gbc_label_9);
		
		text_price3 = new JTextField();
		GridBagConstraints gbc_text_price3 = new GridBagConstraints();
		gbc_text_price3.insets = new Insets(0, 0, 5, 5);
		gbc_text_price3.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_price3.gridx = 8;
		gbc_text_price3.gridy = 7;
		edit_panel.add(text_price3, gbc_text_price3);
		text_price3.setColumns(10);
		
		JLabel label_10 = new JLabel("\u751F\u4EA7\u5382\u5BB6\uFF1A");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 9;
		edit_panel.add(label_10, gbc_label_10);
		
		text_prodoct = new JTextField();
		GridBagConstraints gbc_text_prodoct = new GridBagConstraints();
		gbc_text_prodoct.gridwidth = 7;
		gbc_text_prodoct.insets = new Insets(0, 0, 5, 5);
		gbc_text_prodoct.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_prodoct.gridx = 2;
		gbc_text_prodoct.gridy = 9;
		edit_panel.add(text_prodoct, gbc_text_prodoct);
		text_prodoct.setColumns(10);
		
		JLabel label_11 = new JLabel("\u5907\u6CE8\uFF1A");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 1;
		gbc_label_11.gridy = 10;
		edit_panel.add(label_11, gbc_label_11);
		
		text_conment = new JTextField();
		GridBagConstraints gbc_text_conment = new GridBagConstraints();
		gbc_text_conment.gridwidth = 7;
		gbc_text_conment.insets = new Insets(0, 0, 5, 5);
		gbc_text_conment.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_conment.gridx = 2;
		gbc_text_conment.gridy = 10;
		edit_panel.add(text_conment, gbc_text_conment);
		text_conment.setColumns(10);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		btn_confirm = new JButton("\u786E\u5B9A");
		btn_confirm.setName("btn_confirm");
		btn_confirm.addActionListener(this);
		GridBagConstraints gbc_btn_confirm = new GridBagConstraints();
		gbc_btn_confirm.anchor = GridBagConstraints.NORTH;
		gbc_btn_confirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_btn_confirm.gridx = 1;
		gbc_btn_confirm.gridy = 2;
		getContentPane().add(btn_confirm, gbc_btn_confirm);
		
		btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.setName("btn_cancel");
		btn_cancel.addActionListener(this);
		GridBagConstraints gbc_btn_cancel = new GridBagConstraints();
		gbc_btn_cancel.anchor = GridBagConstraints.NORTH;
		gbc_btn_cancel.gridwidth = 2;
		gbc_btn_cancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_cancel.insets = new Insets(0, 0, 0, 5);
		gbc_btn_cancel.gridx = 4;
		gbc_btn_cancel.gridy = 2;
		getContentPane().add(btn_cancel, gbc_btn_cancel);
		
		btn_update = new JButton("\u5E94\u7528");
		btn_update.setVisible(false);
		GridBagConstraints gbc_btn_update = new GridBagConstraints();
		gbc_btn_update.anchor = GridBagConstraints.NORTH;
		gbc_btn_update.gridwidth = 2;
		gbc_btn_update.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_update.insets = new Insets(0, 0, 0, 5);
		gbc_btn_update.gridx = 6;
		gbc_btn_update.gridy = 2;
		getContentPane().add(btn_update, gbc_btn_update);
		
		setModalityType(ModalityType.APPLICATION_MODAL);//对话框打开后限制父窗口操作	
		
		if(this.goodsInfo != null){//表示修改已有数据
			text_name.setText(this.goodsInfo.getPeij_name());
			text_py.setText(this.goodsInfo.getPeij_py());
			com_type.setSelectedItem(this.goodsInfo.getPeij_lb().trim());
			text_code.setText(this.goodsInfo.getCode());
			text_brand.setText(this.goodsInfo.getBrand());
			com_unit.setSelectedItem(this.goodsInfo.getUnit().trim());
			text_inPrice.setText(this.goodsInfo.getIn_price());
			com_disable.setSelectedItem(this.goodsInfo.getJinyong().trim());
			text_price1.setText(this.goodsInfo.getOut_price1()==null?null:""+this.goodsInfo.getOut_price1());
			text_price2.setText(this.goodsInfo.getOut_price2()==null?null:""+this.goodsInfo.getOut_price2());
			text_price3.setText(this.goodsInfo.getOut_price3()==null?null:""+this.goodsInfo.getOut_price3());
			text_prodoct.setText(this.goodsInfo.getPlace());
			text_conment.setText(this.goodsInfo.getComment());
		}else{
			this.goodsInfo = new GoodsInfoModel();
		}
	}
	
	
	
	public JComboBox getCom_Type() {//商品类型
			
		if (com_type == null) {
			com_type = new JComboBox();
			
			for (GoodsTypeEnum gte : GoodsTypeEnum.values()) {  
				com_type.addItem(gte.value);				
	        }
			com_type.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
			
		}
		return com_type;
	}
	
	public JComboBox getCom_Unit() {//商品计量单位
		
		if (com_unit == null) {
			com_unit = new JComboBox();
			
			for (GoodsUnitEnum gue : GoodsUnitEnum.values()) {  
				com_unit.addItem(gue.value);	
	        }
			com_unit.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
		}
		return com_unit;
	}
	
	public JComboBox getCom_Disable() {//启用与禁用状态
		
		if (com_disable == null) {
			com_disable = new JComboBox();
			
			for (OnOrOffEnum gue : OnOrOffEnum.values()) {  
				com_disable.addItem(gue.value);
				
	        }
			com_disable.setSelectedIndex(1);
			com_disable.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
				}
			});
		}
		return com_disable;
	}
	
	/**
	 * 获取界面数据，为新增或者更新做准备
	 * @author XCCD
	 * @return 
	 */
	private boolean getModelInfo(){

		try {
			if(text_name.getText()!=null && !text_name.getText().trim().equals("")){
				this.goodsInfo.setPeij_name(text_name.getText());
			}else{
				JOptionPane.showMessageDialog(this, "请填写配件名称");
				return false;
			}
			
			if(text_py.getText()!=null && !text_py.getText().trim().equals("")){
				this.goodsInfo.setPeij_py(text_py.getText());
			}else{
				JOptionPane.showMessageDialog(this, "请填写配件拼音");
				return false;
			}
			
			
			this.goodsInfo.setPeij_lb((String) com_type.getSelectedItem());
			this.goodsInfo.setCode(text_code.getText());
			this.goodsInfo.setBrand(text_brand.getText());
			this.goodsInfo.setUnit((String) com_unit.getSelectedItem());
			
			if(text_inPrice.getText() != null && !text_inPrice.getText().trim().equals("") ){
				this.goodsInfo.setIn_price(text_inPrice.getText());
			}
			
			this.goodsInfo.setJinyong((String) com_disable.getSelectedItem());
			
			if(text_price1.getText()!=null && !text_price1.getText().trim().equals("")){
				this.goodsInfo.setOut_price1(new BigDecimal(text_price1.getText()));
			}else{
				JOptionPane.showMessageDialog(this, "请填写销售价格1");
				return false;
			}
			
			if(text_price2.getText()!=null && !text_price2.getText().trim().equals("") ){
				this.goodsInfo.setOut_price2(new BigDecimal(text_price2.getText()));
			}
			
			if(text_price3.getText()!=null && !text_price3.getText().trim().equals("")){					
				this.goodsInfo.setOut_price3(new BigDecimal(text_price3.getText()));
			}
			
			this.goodsInfo.setPlace(text_prodoct.getText());
			this.goodsInfo.setComment(text_conment.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
		return true;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {//输入的键盘数据类型
//		Component component = e.getComponent();
//		JTextField jf = (JTextField)component;
//		
//		String str = jf.getText().trim();
//		if(null == str || "".equals(str)){
//			jf.setText("0");
//		}else if("0.".equals(str)){
//			
//		}	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Component component = e.getComponent();
		String name = component.getName();
		
		JTextField jf = (JTextField)component;//获取对象信息
		
		if(name.equals("text_name")){
			String str = jf.getText().trim();
			text_py.setText(Pinyin4jUtil.getPinYinHeadChar(str));
		}
				
		if(name.equals("text_inPrice")){
		
			String str = jf.getText().trim();
			
			String exp = "^\\d+(.\\d{0,3})?$";//"^[0-9]{0,6}+(.[0-9]{0,3})?$";//小数正则表达式
			Pattern pattern = Pattern.compile(exp);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的价格");				
			}		
		}
		
		if(name.equals("text_price1")){
			
			String str = jf.getText().trim();
			
			String exp = "^\\d+(.\\d{0,3})?$";//"^[0-9]{0,6}+(.[0-9]{0,3})?$";//小数正则表达式
			Pattern pattern = Pattern.compile(exp);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的价格");				
			}		
		}
		if(name.equals("text_price2")){
			
			String str = jf.getText().trim();
			
			String exp = "^\\d+(.\\d{0,3})?$";//"^[0-9]{0,6}+(.[0-9]{0,3})?$";//小数正则表达式
			Pattern pattern = Pattern.compile(exp);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的价格");				
			}		
		}
		if(name.equals("text_price3")){
			
			String str = jf.getText().trim();
			
			String exp = "^\\d+(.\\d{0,3})?$";//"^[0-9]{0,6}+(.[0-9]{0,3})?$";//小数正则表达式
			Pattern pattern = Pattern.compile(exp);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的价格");				
			}		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String className = e.getSource().getClass().getName();
		
		if(className.equals("javax.swing.JButton")){
			JButton bt = (JButton)e.getSource();
			String name = bt.getName();
			if("btn_confirm".equals(name)){//确认更新或者新增
				
				boolean flag = getModelInfo();				
				if(!flag){					
					return;
				}
				if(!ControlFactory.goodsInfoController.queryRepeat(this.goodsInfo)){
					JOptionPane.showMessageDialog(null, "已存在同种类型,相同名称的商品");
					return;
				}
				
				if(this.goodsInfo.getPeij_no() != null){//以主键判定操作是更新还是新增
					ControlFactory.goodsInfoController.update(this.goodsInfo);
				}else{
					String new_id =  ControlFactory.goodsInfoController.queryLast();
					
					this.goodsInfo.setPeij_no(new_id);
					this.goodsInfo.setPeij_del("0");
					ControlFactory.goodsInfoController.insert(this.goodsInfo);
				}
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						
						ControlFactory.goodsInfoController.LoadGoodsInfoVector();
						
						GoodsInfoPanel.table.repaint();
						GoodsInfoPanel.table.revalidate();
						
					}
				});
				
				this.dispose();//操作完成后关闭对话框
				JOptionPane.showMessageDialog(null, "保存成功");
			}
			
			if("btn_cancel".equals(name)){//关闭编辑页面
				this.dispose();//关闭对话框
			}
		}
		
	}

}
