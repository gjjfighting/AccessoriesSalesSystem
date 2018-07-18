package kehaofei.com.ui.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JDesktopPane;
import kehaofei.com.mybatisfactory.SpringBeanFactory;
import kehaofei.com.ui.panel.BtnMenuGroupPanel;
import kehaofei.com.ui.wmspanel.SalesTicketInfoWindow;
import kehaofei.com.utils.Constant_Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @author XCCD
 * <li>TODO	商品信息数据管理软件主界面
 * <li>2017-6-2 上午11:41:16
 * <li>
 */
public class WMSMainFrame extends JFrame {

	/**
	 * @parameter log 日志类定义
	 */
	static Logger log = Logger.getLogger(WMSMainFrame.class.getSimpleName());
	
	private static final long serialVersionUID = 1L;
    
	public static JFrame window;
	
    public static Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
    public static Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
    public static int screenWidth = screenSize.width; // 获取屏幕的宽
    public static int screenHeight = screenSize.height; // 获取屏幕的高
    
    public static JSplitPane splitPane  = null;
    
    public static JSplitPane splitPane_1  = null;
    
//    SerialSetDialog serialSet =  new SerialSetDialog();

	public JPanel btnPanel;

	private ButtonGroup cg;

	private JPanel viewPanel;

	private static GridBagConstraints gbc_BtnGroupPane = null;
	public static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private static JTextField textField_8;

	protected static BtnMenuGroupPanel btnGroupPanel = null;
	
	static int delay = 1000; // milliseconds
	static ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			String s = String
					.format("%tY/%<tm/%<td %<tH:%<tM:%<tS", new Date());
			textField_8.setText(s);
		}
	};
	public static JDesktopPane desktopPane;
    
	/**
	 * Launch the application.
	 * <br>main method to begin the frame
	 */
	public static void main(String[] args) {
		SpringBeanFactory.getInstance();
		
		System.out.println("\n"+System.getProperty("java.library.path"));
		/*System.setProperty("Quaqua.tabLayoutPolicy", "wrap"); 

		if (!System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			try {
				Methods.invokeStatic(JFrame.class,
						"setDefaultLookAndFeelDecorated", Boolean.TYPE,
						Boolean.TRUE);
				Methods.invokeStatic(JDialog.class,
						"setDefaultLookAndFeelDecorated", Boolean.TYPE,
						Boolean.TRUE);
				Methods.invokeStatic(JDesktopPane.class,
						"setDefaultLookAndFeelDecorated", Boolean.TYPE,
						Boolean.TRUE);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
		} catch (Exception e) {
		}*/
		try{
			
			// 设置外形装饰为可装饰
//            JFrame.setDefaultLookAndFeelDecorated(true);
            
//			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
//			
//			// 设置外观
////			UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
////			JFrame.setDefaultLookAndFeelDecorated(true);
////			JDialog.setDefaultLookAndFeelDecorated(true);
//            
//			// 设置主题
//			SubstanceLookAndFeel.setCurrentTheme(new SubstanceBarbyPinkTheme());
//			//皮肤
//			SubstanceLookAndFeel.setSkin(new EbonyHighContrastSkin());
//			// 设置按钮外观
//			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
//			// 设置水印
//			SubstanceLookAndFeel.setCurrentWatermark(new SubstanceStripeWatermark());
//			// 设置边框
//			SubstanceLookAndFeel.setCurrentBorderPainter(new FlatInnerBorderPainter());
//			// 设置渐变渲染
//			SubstanceLookAndFeel.setCurrentGradientPainter(new GlassGradientPainter());
//			// 设置标题
//			SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
//			
			
			UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
			//
			//com.jgoodies.looks.windows.WindowsLookAndFeel
			//com.jgoodies.looks.plastic.PlasticLookAndFeel
			 
			initGlobalFontSetting(new Font("微软雅黑",0,14));//设置字体
			log.info("|------ 初始化字体 ------|");

		}catch(Exception e){
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
	}
	/**
	 * 初始化全局字体
	 * @author XCCD
	 * @param myFont
	 */
	public static void initGlobalFontSetting(Font myFont) {
		FontUIResource fontRes = new FontUIResource(myFont);
		for (Enumeration keys = UIManager.getDefaults().keys(); 
				keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window = new WMSMainFrame();
					window.setResizable(true);
					window.setVisible(true);
					
					new Timer(delay, taskPerformer).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public WMSMainFrame(){
		// TODO Auto-generated constructor stub
		initialize();
	}
	/**
	 * Create the frame.
	 * @return 
	 * 
	 */
	private void initialize(){
		
		gbc_BtnGroupPane = new GridBagConstraints();
		btnGroupPanel = new BtnMenuGroupPanel();
		this.setBounds(1000, 1000, (int)(screenWidth*0.7),(int)(screenHeight*0.7));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 取消frame本身的框架  
//		this.setUndecorated(true);  
//		this.setFocusableWindowState(true);            
//        JRootPane rp = getRootPane();  
//        rp.setWindowDecorationStyle(JRootPane.FRAME);
		
		this.setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);//设置窗口居中显示
		this.setResizable(true);
		this.setVisible(true);
		
		
		
		//处理窗口关闭的事件
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub	

			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.setTitle(Constant_Properties.ProgramTitle);//设置title
		try {

			String src = "/kehaofei/com/img/logo.jpg"; // 图片路径

			Image image = ImageIO.read(this.getClass().getResource(src));

			// 创建图片对象

			setIconImage(image); // 设置图标

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(Color.GRAY));		
		this.setJMenuBar(menuBar);
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		
		//电表功能菜单
		JMenu mnAmmeterFunction = new JMenu(Constant_Properties.myResource.getString("comment"));
		mnAmmeterFunction.setEnabled(false);
		menuBar.add(mnAmmeterFunction);

		
		/********************************************菜单结束**********************************************/
		
		
		//********************************************功能操作区**********************************************/
		btnPanel = new JPanel();
		btnPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnPanel.setSize(getWidth(), getHeight());
		setContentPane(btnPanel);
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_btnPanel.rowHeights = new int[]{100, 0, 5, 0};
		gbl_btnPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.0, 1.0, 0.004, Double.MIN_VALUE};
		btnPanel.setLayout(gbl_btnPanel);
		
		gbc_BtnGroupPane = new GridBagConstraints();
		gbc_BtnGroupPane.gridwidth = 13;
		gbc_BtnGroupPane.insets = new Insets(0, 0, 5, 2);
		gbc_BtnGroupPane.fill = GridBagConstraints.BOTH;
		gbc_BtnGroupPane.gridx = 0;
		gbc_BtnGroupPane.gridy = 0;

		btnPanel.add(btnGroupPanel, gbc_BtnGroupPane);
		
/*************************************************主界面底部，信息展示区**************************************************/
		try {
			URL picURL = this.getClass().getResource("/kehaofei/com/img/Jellyfish.jpg");
			final Image image = ImageIO.read(picURL);		
			desktopPane = new JDesktopPane() {  
				protected void paintComponent(Graphics g) {  
	                // 改为protected void paintComponent(Graphics g) { 亦可  
	                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);  
	            };  
	        }; 
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridwidth = 13;
		gbc_desktopPane.insets = new Insets(0, 0, 5, 5);
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 1;
		btnPanel.add(desktopPane, gbc_desktopPane);		
		btnGroupPanel.salesTicketInfoWindow = new SalesTicketInfoWindow();
//		btnGroupPanel.salesTicketInfoWindow.setMaximumSize(getSize());
		desktopPane.add(btnGroupPanel.salesTicketInfoWindow, 0);		
		try {
			btnGroupPanel.salesTicketInfoWindow.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		viewPanel = new JPanel();
//		viewPanel.setBorder(BorderFactory.createTitledBorder(""));
		GridBagLayout gbl_viewPanel = new GridBagLayout();
		gbl_viewPanel.columnWidths = new int[]{200, 120, 120, 120, 120, 80, 80, 0, 150, 0};
		gbl_viewPanel.rowHeights = new int[]{0, 0};
		gbl_viewPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.7,0.0, Double.MIN_VALUE};
		gbl_viewPanel.rowWeights = new double[]{1.0,Double.MIN_VALUE};
		viewPanel.setLayout(gbl_viewPanel);
		
		GridBagConstraints gbc_view = new GridBagConstraints();
		gbc_view.insets = new Insets(0, 0, 0, 0);
		gbc_view.gridwidth = 13;
		gbc_view.fill = GridBagConstraints.BOTH;
		gbc_view.gridx = 0;
		gbc_view.gridy = 2;
		btnPanel.add(viewPanel, gbc_view);
		
		//----------------------------------------------------------------------------//
		
		textField = new JTextField();
//		textField.setEditable(false);
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.SOUTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 2, 0, 2);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		viewPanel.add(textField, gbc_textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.SOUTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 0, 2);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		viewPanel.add(textField_1, gbc_textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.SOUTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 0, 2);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		viewPanel.add(textField_2, gbc_textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.SOUTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 0, 2);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 0;
		viewPanel.add(textField_3, gbc_textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.SOUTH;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 0, 2);
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 0;
		viewPanel.add(textField_4, gbc_textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.SOUTH;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 0, 2);
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 0;
		viewPanel.add(textField_5, gbc_textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.SOUTH;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 0, 2);
		gbc_textField_6.gridx = 6;
		gbc_textField_6.gridy = 0;
		viewPanel.add(textField_6, gbc_textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.anchor = GridBagConstraints.SOUTH;
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 0, 2);
		gbc_textField_7.gridx = 7;
		gbc_textField_7.gridy = 0;
		viewPanel.add(textField_7, gbc_textField_7);
		
		textField_8 = new JTextField();//时间显示区
		textField_8.setEnabled(false);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.SOUTH;
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.insets = new Insets(0, 0, 0, 2);
		gbc_textField_8.gridx = 8;
		gbc_textField_8.gridy = 0;
		viewPanel.add(textField_8, gbc_textField_8);
		
	}
}
