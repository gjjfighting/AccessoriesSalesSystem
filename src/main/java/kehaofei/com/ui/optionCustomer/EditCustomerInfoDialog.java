package kehaofei.com.ui.optionCustomer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import kehaofei.com.sm.model.CustomerInfoModel;
import kehaofei.com.ui.main.WMSMainFrame;
import kehaofei.com.ui.wmspanel.CustomerInfoPanel;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ControlFactory;
import kehaofei.com.utils.Pinyin4jUtil;
import kehaofei.com.utils.enumeration.GetContextSelect;
import kehaofei.com.utils.enumeration.GoodsTypeEnum;
import kehaofei.com.utils.enumeration.GoodsUnitEnum;
import kehaofei.com.utils.enumeration.OnOrOffEnum;

public class EditCustomerInfoDialog extends JDialog implements ActionListener, KeyListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(EditCustomerInfoDialog.class.getSimpleName());
	Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	private JTextField text_py;
	private JTextField text_name;
	private JTextField text_tel;//规格
	private JTextField text_sj;//品牌
	
	
	CustomerInfoModel customerInfo;

	private JButton btn_confirm;

	private JButton btn_cancel;

	private JButton btn_update;
	private JTextField text_cz;
	private JTextField text_bank;
	private JTextField text_province;
	private JTextField text_adr;
	private JTextField text_conment;
	private JTextField text_city;
	private JTextField text_email;
	private JTextField text_web;
	private JTextField text_lxr;
	private JTextField text_leibie;

	/**
	 * Create the dialog.
	 * @param applicationModal 
	 * @param over 
	 */
	public EditCustomerInfoDialog(CustomerInfoModel customerInfo) {
		super(WMSMainFrame.window, ModalityType.APPLICATION_MODAL);
		this.customerInfo = customerInfo;
		setBounds(100, 100, 838, 468);
//		setResizable(false);
		setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);//设置窗口居中显示
		setTitle("\u7F16\u8F91\u5BA2\u6237\u4FE1\u606F");
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 80, 0, 0, 80, 0, 50, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{30, 0, 30, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6B64\u5904\u7F16\u8F91\u5BA2\u6237\u57FA\u672C\u4FE1\u606F");
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
		gbl_edit_panel.columnWidths = new int[]{30, 0, 80, 0, 0, 80, 0, 0, 80, 30, 0};
		gbl_edit_panel.rowHeights = new int[]{30, 0, 30, 0, 40, 0, 20, 0, 20, 0, 0, 0, 0};
		gbl_edit_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_edit_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		edit_panel.setLayout(gbl_edit_panel);
		
		JLabel label = new JLabel("\u5BA2\u6237\u540D\u79F0\uFF1A");
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
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u62FC\u97F3\uFF1A");
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
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 1;
		edit_panel.add(label_6, gbc_label_6);
		
		text_lxr = new JTextField();
		GridBagConstraints gbc_text_lxr = new GridBagConstraints();
		gbc_text_lxr.insets = new Insets(0, 0, 5, 5);
		gbc_text_lxr.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_lxr.gridx = 8;
		gbc_text_lxr.gridy = 1;
		edit_panel.add(text_lxr, gbc_text_lxr);
		text_lxr.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		edit_panel.add(label_2, gbc_label_2);
		
		text_tel = new JTextField();
		text_tel.setName("text_tel");
		text_tel.addFocusListener(this);
		GridBagConstraints gbc_text_tel = new GridBagConstraints();
		gbc_text_tel.insets = new Insets(0, 0, 5, 5);
		gbc_text_tel.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_tel.gridx = 2;
		gbc_text_tel.gridy = 3;
		edit_panel.add(text_tel, gbc_text_tel);
		text_tel.setColumns(10);
		
		JLabel label_3 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 3;
		edit_panel.add(label_3, gbc_label_3);
		
		text_sj = new JTextField();
		text_sj.setName("text_sj");
		text_sj.addFocusListener(this);
		GridBagConstraints gbc_text_sj = new GridBagConstraints();
		gbc_text_sj.insets = new Insets(0, 0, 5, 5);
		gbc_text_sj.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_sj.gridx = 5;
		gbc_text_sj.gridy = 3;
		edit_panel.add(text_sj, gbc_text_sj);
		text_sj.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BA2\u6237\u7C7B\u522B\uFF1A");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 7;
		gbc_lblNewLabel_1.gridy = 3;
		edit_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		text_leibie = new JTextField();
		GridBagConstraints gbc_text_leibie = new GridBagConstraints();
		gbc_text_leibie.insets = new Insets(0, 0, 5, 5);
		gbc_text_leibie.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_leibie.gridx = 8;
		gbc_text_leibie.gridy = 3;
		edit_panel.add(text_leibie, gbc_text_leibie);
		text_leibie.setColumns(10);
		
		JLabel label_12 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_12.gridwidth = 10;
		gbc_label_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 4;
		edit_panel.add(label_12, gbc_label_12);
		
		JLabel label_4 = new JLabel("\u57CE\u5E02\uFF1A");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 5;
		edit_panel.add(label_4, gbc_label_4);
		
		text_city = new JTextField();
		GridBagConstraints gbc_text_city = new GridBagConstraints();
		gbc_text_city.insets = new Insets(0, 0, 5, 5);
		gbc_text_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_city.gridx = 2;
		gbc_text_city.gridy = 5;
		edit_panel.add(text_city, gbc_text_city);
		text_city.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7F51\u7AD9\uFF1A");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 4;
		gbc_label_5.gridy = 5;
		edit_panel.add(label_5, gbc_label_5);
		
		text_web = new JTextField();
		GridBagConstraints gbc_text_web = new GridBagConstraints();
		gbc_text_web.insets = new Insets(0, 0, 5, 5);
		gbc_text_web.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_web.gridx = 5;
		gbc_text_web.gridy = 5;
		edit_panel.add(text_web, gbc_text_web);
		text_web.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE\u7BB1\uFF1A");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 7;
		gbc_lblNewLabel_2.gridy = 5;
		edit_panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		text_email = new JTextField();
		GridBagConstraints gbc_text_email = new GridBagConstraints();
		gbc_text_email.insets = new Insets(0, 0, 5, 5);
		gbc_text_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_email.gridx = 8;
		gbc_text_email.gridy = 5;
		edit_panel.add(text_email, gbc_text_email);
		text_email.setColumns(10);
		
		JLabel label_7 = new JLabel("\u4F20\u771F\uFF1A");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 7;
		edit_panel.add(label_7, gbc_label_7);
		
		text_cz = new JTextField();
		GridBagConstraints gbc_text_cz = new GridBagConstraints();
		gbc_text_cz.insets = new Insets(0, 0, 5, 5);
		gbc_text_cz.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_cz.gridx = 2;
		gbc_text_cz.gridy = 7;
		edit_panel.add(text_cz, gbc_text_cz);
		text_cz.setColumns(10);
		
		JLabel label_8 = new JLabel("\u94F6\u884C\u8D26\u53F7\uFF1A");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 4;
		gbc_label_8.gridy = 7;
		edit_panel.add(label_8, gbc_label_8);
		
		text_bank = new JTextField();
		GridBagConstraints gbc_text_bank = new GridBagConstraints();
		gbc_text_bank.insets = new Insets(0, 0, 5, 5);
		gbc_text_bank.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_bank.gridx = 5;
		gbc_text_bank.gridy = 7;
		edit_panel.add(text_bank, gbc_text_bank);
		text_bank.setColumns(10);
		
		JLabel label_9 = new JLabel("\u7701\u4EFD\uFF1A");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 7;
		gbc_label_9.gridy = 7;
		edit_panel.add(label_9, gbc_label_9);
		
		text_province = new JTextField();
		GridBagConstraints gbc_text_province = new GridBagConstraints();
		gbc_text_province.insets = new Insets(0, 0, 5, 5);
		gbc_text_province.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_province.gridx = 8;
		gbc_text_province.gridy = 7;
		edit_panel.add(text_province, gbc_text_province);
		text_province.setColumns(10);
		
		JLabel label_10 = new JLabel("\u5730\u5740\uFF1A");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 9;
		edit_panel.add(label_10, gbc_label_10);
		
		text_adr = new JTextField();
		GridBagConstraints gbc_text_adr = new GridBagConstraints();
		gbc_text_adr.gridwidth = 3;
		gbc_text_adr.insets = new Insets(0, 0, 5, 5);
		gbc_text_adr.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_adr.gridx = 2;
		gbc_text_adr.gridy = 9;
		edit_panel.add(text_adr, gbc_text_adr);
		text_adr.setColumns(10);
		
		JLabel label_11 = new JLabel("\u5907\u6CE8\uFF1A");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 5;
		gbc_label_11.gridy = 9;
		edit_panel.add(label_11, gbc_label_11);
		
		text_conment = new JTextField();
		GridBagConstraints gbc_text_conment = new GridBagConstraints();
		gbc_text_conment.gridwidth = 3;
		gbc_text_conment.insets = new Insets(0, 0, 5, 5);
		gbc_text_conment.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_conment.gridx = 6;
		gbc_text_conment.gridy = 9;
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
		gbc_btn_cancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_cancel.anchor = GridBagConstraints.NORTH;
		gbc_btn_cancel.gridwidth = 2;
		gbc_btn_cancel.insets = new Insets(0, 0, 0, 5);
		gbc_btn_cancel.gridx = 3;
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
		
		if(this.customerInfo != null){//表示修改已有数据
			text_name.setText(this.customerInfo.getKehu_name());
			text_py.setText(this.customerInfo.getKehu_py());
			text_lxr.setText(this.customerInfo.getLxr().trim());
			text_tel.setText(this.customerInfo.getTel());
			text_sj.setText(this.customerInfo.getSj());
			text_leibie.setText(this.customerInfo.getLeibie().trim());
			text_city.setText(this.customerInfo.getCity());
			text_web.setText(this.customerInfo.getWeb().trim());
			text_email.setText(this.customerInfo.getMail());
			text_cz.setText(this.customerInfo.getCz());
			text_bank.setText(this.customerInfo.getBank());
			text_province.setText(this.customerInfo.getProvince());
			text_adr.setText(this.customerInfo.getAdr());
			text_conment.setText(this.customerInfo.getComment());
		}else{
			this.customerInfo = new CustomerInfoModel();
		}
	}
	
	/**
	 * 获取界面数据，为新增或者更新做准备
	 * @author XCCD
	 */
	private boolean getModelInfo(){		
		
		try {
			if(text_name.getText()!=null && !text_name.getText().trim().equals("")){
				this.customerInfo.setKehu_name(text_name.getText());
			}else{
				JOptionPane.showMessageDialog(this, "请填写客户名称");
				return false;
			}
			
			if(text_py.getText()!=null && !text_py.getText().trim().equals("")){
				this.customerInfo.setKehu_py(text_py.getText());
			}else{
				JOptionPane.showMessageDialog(this, "请填写客户拼音");
				return false;
			}

			this.customerInfo.setLxr(text_lxr.getText());
			this.customerInfo.setTel(text_tel.getText());
			this.customerInfo.setSj(text_sj.getText());
			this.customerInfo.setLeibie(text_leibie.getText());
			
			if(text_city.getText() != null && !text_city.getText().trim().equals("") ){
				this.customerInfo.setCity(text_city.getText());
			}
			this.customerInfo.setWeb(text_web.getText());
			this.customerInfo.setMail(text_email.getText());
			
			if(text_cz.getText()!=null && !text_cz.getText().trim().equals("")){
				this.customerInfo.setCz(text_cz.getText());
			}
			
			if(text_bank.getText()!=null && !text_bank.getText().trim().equals("") ){
				this.customerInfo.setBank(text_bank.getText());
			}
			
			if(text_province.getText()!=null && !text_province.getText().trim().equals("")){					
				this.customerInfo.setProvince(text_province.getText());
			}
			
			this.customerInfo.setAdr(text_adr.getText());
			this.customerInfo.setComment(text_conment.getText());
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
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
				if(!ControlFactory.customerInfoController.queryRepeat(customerInfo)){
					JOptionPane.showMessageDialog(null, "当前客户名称已存在");
					return;
				}
				
				if(customerInfo.getKehu_no() != null){//以主键判定操作是更新还是新增
					ControlFactory.customerInfoController.update(customerInfo);
				}else{
					String new_id =  ControlFactory.customerInfoController.queryLast();
					
					customerInfo.setKehu_no(new_id);
					customerInfo.setKehu_del("0");
					ControlFactory.customerInfoController.insert(customerInfo);
				}
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						
						ControlFactory.customerInfoController.LoadCustomerInfoVector();
						CustomerInfoPanel.table.repaint();
						CustomerInfoPanel.table.revalidate();
						
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		/*
		Component component = e.getComponent();
		String name = component.getName();
		
		JTextField jf = (JTextField)component;//获取对象信息
		
		if(name.equals("text_sj")){
			
			String str = jf.getText();
			if(str.equals("")){
				return;
			}			
			String regex_phone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
			
			String regex_tel = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
			
			Pattern pattern = Pattern.compile(regex_phone);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(""str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的电话号码");				
			}	
		}
		
		if(name.equals("text_tel")){
			
			String str = jf.getText();
			if(str.equals("")){
				return;
			}
			
			String regex_phone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
			
			String regex_tel = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
			
			Pattern pattern = Pattern.compile(regex_tel);
			boolean flag = pattern.matcher(str).matches();
			if (flag) {
				
			} else {
				jf.setText(""str.substring(0, str.length()-1));
				JOptionPane.showMessageDialog(this, "请输入正确的电话号码");				
			}	
		}*/
	}

}
