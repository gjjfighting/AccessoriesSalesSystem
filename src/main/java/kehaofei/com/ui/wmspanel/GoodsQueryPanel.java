package kehaofei.com.ui.wmspanel;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;


import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.text.MessageFormat;

import kehaofei.com.mybatisfactory.SpringBeanFactory;
import kehaofei.com.sm.model.GoodsInfoModel;
import kehaofei.com.ui.optionGoods.EditGoodsInfoDialog;
import kehaofei.com.ui.panel.BtnMenuGroupPanel;
import kehaofei.com.utils.Constant_Properties;
import kehaofei.com.utils.ControlFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * 
 * @author XCCD
 * <li>TODO	商品信息的查询界面
 * <li>2017-6-1 下午1:48:27
 * <li>
 */
public class GoodsQueryPanel extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(GoodsQueryPanel.class.getSimpleName());
	
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton btnExcel;
	private JButton button_6;
	private Window window;
	
	/**
	 * Create the panel.
	 * @param up 
	 * @param down 
	 */
	public GoodsQueryPanel() {
		
		setBorder(BorderFactory.createTitledBorder(Constant_Properties.myResource.getString("FunctionBlock")));
		log.info("class路径："+this.getClass().getResource("/kehaofei/com/img/add.jpg")+"\n"+
								this.getClass().getResource("/mybatis-spring.xml"));
		
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{10, 70, 70, 70, 70, 70, 70, 70, 40, 40, 40, 40, 40, 40, 60, 0, 0};
		gbl_btnPanel.rowHeights = new int[]{60, 50, 0};
		gbl_btnPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.3, 0.3, Double.MIN_VALUE};
		setLayout(gbl_btnPanel);
	
		
		button_1 = new JButton(
				Constant_Properties.myResource.getString("Add"),
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/add.jpg")));
		button_1.setVerticalTextPosition(JButton.BOTTOM);
		button_1.setHorizontalTextPosition(JButton.CENTER);
//		button_1.setBorderPainted(false);
		button_1.setName("ADD");
		button_1.addActionListener(this);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(5, 0, 10, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		add(button_1, gbc_button_1);

		
		button_2 = new JButton(
				Constant_Properties.myResource.getString("Update"),
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/update.jpg")));
		button_2.setVerticalTextPosition(JButton.BOTTOM);
		button_2.setHorizontalTextPosition(JButton.CENTER);
		button_2.setName("UPDATE");
		button_2.addActionListener(this);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.insets = new Insets(5, 0, 10, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 0;
		add(button_2, gbc_button_2);
		
		button_3 = new JButton(
				Constant_Properties.myResource.getString("Delete"),
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/delete.jpg")));
		button_3.setVerticalTextPosition(JButton.BOTTOM);
		button_3.setHorizontalTextPosition(JButton.CENTER);
		button_3.setName("DELETE");
		button_3.addActionListener(this);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.BOTH;
		gbc_button_3.insets = new Insets(5, 0, 10, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		add(button_3, gbc_button_3);
		
		button_4 = new JButton("预览",
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/preview.jpg")));
		button_4.setVerticalTextPosition(JButton.BOTTOM);
		button_4.setHorizontalTextPosition(JButton.CENTER);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.BOTH;
		gbc_button_4.insets = new Insets(5, 0, 10, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 0;
		add(button_4, gbc_button_4);
		
		button_5 = new JButton("打印",
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/print.jpg")));
		button_5.setVerticalTextPosition(JButton.BOTTOM);
		button_5.setHorizontalTextPosition(JButton.CENTER);
		button_5.setName("PRINT");
		button_5.addActionListener(this);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.BOTH;
		gbc_button_5.insets = new Insets(5, 0, 10, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 0;
		add(button_5, gbc_button_5);
		
		btnExcel = new JButton("EXCEL",
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/excel.jpg")));
		btnExcel.setVerticalTextPosition(JButton.BOTTOM);
		btnExcel.setHorizontalTextPosition(JButton.CENTER);
		GridBagConstraints gbc_btnExcel = new GridBagConstraints();
		gbc_btnExcel.fill = GridBagConstraints.BOTH;
		gbc_btnExcel.insets = new Insets(5, 0, 10, 5);
		gbc_btnExcel.gridx = 6;
		gbc_btnExcel.gridy = 0;
		add(btnExcel, gbc_btnExcel);
		
		button_6 = new JButton("退出",
				new ImageIcon(this.getClass().getResource("/kehaofei/com/img/close.jpg")));
		button_6.setVerticalTextPosition(JButton.BOTTOM);
		button_6.setHorizontalTextPosition(JButton.CENTER);
		button_6.setName("CANCEL");
		button_6.addActionListener(this);
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.BOTH;
		gbc_button_6.insets = new Insets(5, 0, 10, 5);
		gbc_button_6.gridx = 7;
		gbc_button_6.gridy = 0;
		add(button_6, gbc_button_6);
		
		
		label = new JLabel("\u62FC\u97F3\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		textField = new JTextField();
		textField.setName("PINYIN");
		textField.addKeyListener(this);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("名称：");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setName("PINYIN");
		textField_1.addKeyListener(this);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		label_2 = new JLabel("\u7C7B\u522B\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 1;
		add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		textField_2.setName("PINYIN");
		textField_2.addKeyListener(this);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 1;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		label_3 = new JLabel("\u89C4\u683C\uFF1A");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 10;
		gbc_label_3.gridy = 1;
		add(label_3, gbc_label_3);
		
		textField_3 = new JTextField();
		textField_3.setName("PINYIN");
		textField_3.addKeyListener(this);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 11;
		gbc_textField_3.gridy = 1;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		button = new JButton(Constant_Properties.myResource.getString("Query"));
		button.setName("QUERY");
		button.addActionListener(this);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(10, 0, 10, 5);
		gbc_button.gridx = 14;
		gbc_button.gridy = 1;
		add(button, gbc_button);
		
	}
	
	/**
	 * 提取查询条件
	 * @author XCCD
	 */
	private GoodsInfoModel getTextInfo(){
		GoodsInfoModel good = new GoodsInfoModel();
		if(textField.getText() != null && !textField.getText().trim().equals("") ){
			good.setPeij_py(textField.getText());
		}
		if(textField_1.getText() != null && !textField_1.getText().trim().equals("") ){
			good.setPeij_name(textField_1.getText());
		}
		if(textField_2.getText() != null && !textField_2.getText().trim().equals("") ){
			good.setPeij_lb(textField_2.getText());
		}
		if(textField_3.getText() != null && !textField_3.getText().trim().equals("") ){
			good.setCode(textField_3.getText());//商品规格
		}		
		return good;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String className = e.getSource().getClass().getName();
		
		if(className.equals("javax.swing.JCheckBox")){
			JCheckBox jcb = (JCheckBox) e.getSource();
			int rowCount = GoodsInfoPanel.table.getRowCount();
			if(jcb.isSelected()){				
				for(int i = 0; i < rowCount; i++){
					 GoodsInfoPanel.table.setValueAt(true, i, 0);
					 
				}
				GoodsInfoPanel.table.repaint();
				GoodsInfoPanel.table.setVisible(true);
			}
			if(!jcb.isSelected()){
				for(int i = 0; i < rowCount; i++){
					GoodsInfoPanel.table.setValueAt(false, i, 0);
				}
				GoodsInfoPanel.table.repaint();
				GoodsInfoPanel.table.setVisible(true);
			}
		}
		if(className.equals("javax.swing.JButton")){
			JButton bt = (JButton)e.getSource();
			String name = bt.getName();
			
			if("ADD".equals(name)){
				try {
					GoodsInfoModel gim = null;//新增数据传入空参数
					
					EditGoodsInfoDialog egid = new EditGoodsInfoDialog(gim);
					egid.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					log.info("|------ 抄读数据操作 ------|\t 新增数据初始化失败"+e2);
				}
		
			}
			
			if("UPDATE".equals(name)){//更新选中的数据
				try {
					GoodsInfoModel gim = new GoodsInfoModel();
					Integer count = GoodsInfoPanel.table.getRowCount();
					
					int index = GoodsInfoPanel.table.getSelectedRow();
					
					if(index == -1){
						JOptionPane.showMessageDialog(this, "没有选择数据");
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
			}
			
			if(name.equals("CANCEL")){
				try {
					BtnMenuGroupPanel.goodsInfoWindow.setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//打印按钮
			if("PRINT".equals(name)){
				int flag = JOptionPane.showConfirmDialog(this, "是否打印", "确认框", JOptionPane.OK_CANCEL_OPTION);
				switch(flag){
					case JOptionPane.OK_OPTION:
					{
						try {
							MessageFormat headerFormat = new MessageFormat("Page {0}");
							MessageFormat footerFormat = new MessageFormat("- {0} -");
							
							GoodsInfoPanel.table.print(JTable.PrintMode.FIT_WIDTH,
									headerFormat, footerFormat, true, null, false);
						} catch (PrinterException pe) {
							pe.printStackTrace();
							log.error("Error printing: " + pe.getMessage());
						}
					}break;
					case JOptionPane.CANCEL_OPTION:
					{
						
					}break;
				}
				
			}
			if("QUERY".equals(name)){
				GoodsInfoModel good = getTextInfo();
				ControlFactory.goodsInfoController.queryBySome(good);
				
				SwingUtilities.invokeLater(new Runnable() {//更新UI显示界面
					@Override
					public void run() {
						GoodsInfoPanel.table.revalidate();
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
						GoodsInfoPanel.table.revalidate();
					}
				});
         }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
