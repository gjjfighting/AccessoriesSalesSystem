package kehaofei.com.utils.test;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class PrintTestFrame extends JFrame implements ActionListener {

	public static void main(String[] args) {
		JFrame frame = new PrintTestFrame();
		frame.show();
	}

	public PrintTestFrame() {
		setTitle("PrintTest");
		setSize(300, 300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = getContentPane();
		canvas = new PrintPanel();
		contentPane.add(canvas, "Center");
		JPanel buttonPanel = new JPanel();
		printButton = new JButton("Print");
		buttonPanel.add(printButton);
		printButton.addActionListener(this);
		pageSetupButton = new JButton("Page  setup");
		buttonPanel.add(pageSetupButton);
		pageSetupButton.addActionListener(this);
		contentPane.add(buttonPanel, "North");
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == printButton) {
			PrinterJob printJob = PrinterJob.getPrinterJob();
			if (pageFormat == null)
				pageFormat = printJob.defaultPage();
			printJob.setPrintable(canvas, pageFormat);
			if (printJob.printDialog()) {
				try {
					printJob.print();
				} catch (PrinterException exception) {
					JOptionPane.showMessageDialog(this, exception);
				}
			}
		} else if (source == pageSetupButton) {
			PrinterJob printJob = PrinterJob.getPrinterJob();
			if (pageFormat == null)
				pageFormat = printJob.defaultPage();
			pageFormat = printJob.pageDialog(pageFormat);
		}
	}

	private JButton printButton;
	private JButton pageSetupButton;
	private PrintPanel canvas;
	private PageFormat pageFormat;
}

class PrintPanel extends JPanel implements Printable {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawPage(g2);
	}

	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {
		if (page >= 1)
			return Printable.NO_SUCH_PAGE;
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.black);
		g2.translate(pf.getImageableX(), pf.getImageableY());
		g2.draw(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf
				.getImageableHeight()));
		drawPage(g2);
		return Printable.PAGE_EXISTS;
	}

	public void drawPage(Graphics2D g2) {
		FontRenderContext context = g2.getFontRenderContext();
		Font f = new Font("Serif", Font.PLAIN, 72);
		GeneralPath clipShape = new GeneralPath();
		TextLayout layout = new TextLayout("Hello", f, context);
		AffineTransform transform = AffineTransform.getTranslateInstance(0, 72);
		Shape outline = layout.getOutline(transform);
		clipShape.append(outline, false);
		layout = new TextLayout("World", f, context);
		transform = AffineTransform.getTranslateInstance(0, 144);
		outline = layout.getOutline(transform);
		clipShape.append(outline, false);
		g2.draw(clipShape);
		g2.clip(clipShape);
		final int NLINES = 50;
		Point2D p = new Point2D.Double(0, 0);
		for (int i = 0; i < NLINES; i++) {
			double x = (2 * getWidth() * i) / NLINES;
			double y = (2 * getHeight() * (NLINES - 1 - i)) / NLINES;
			Point2D q = new Point2D.Double(x, y);
			g2.draw(new Line2D.Double(p, q));
		}
	}
	
	/**
	02. * 打印模版
	03. *
	04. * @param imgWidth 图片的宽度
	05. * @param imgHeight 图片的高度
	06. * @param x 起始x轴
	07. * @param y 起始y轴
	08. * @param rowHeight 每行的高度
	09. * @param dataStart 数据缩进
	10. * @param firstWidth 第一列间距x坐标
	11. * @param secondWidth 第二列间距x坐标
	12. * @param thirdWidth 第三列间距x坐标
	13. * @param fourWidth 第四列间距x坐标
	14. * @param tb 实体对象
	15. * @return BufferedImage
	16. *(参数自己定，我的是340, 200, 0, 0, 20, 10, 60, 190, 250, 340, tb)
	17. */
	/*private BufferedImage createTbGraphics(int imgWidth, int imgHeight, int x, int y, int rowHeight,
	int dataStart, int firstWidth, int secondWidth, int thirdWidth, int fourWidth,
	Tb tb) {
	//空白面板 也可是张图片
	BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = null;
	
	try {
	
	g = image.createGraphics();// 得到图形上下文
	g.setBackground(Color.WHITE);//设置背景色
	g.fillRect(x, y, imgWidth, imgHeight);//填充整个屏幕
	g.setColor(Color.BLACK);//设置画笔颜色
	// g.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));// 设置字体 这种以及“非国产”是乱码 有办法解决的话也可为实线， 我认为乱码是因为条码打印机的缘故，这样就要二次开发打印机，所以我没要这种方法
	g.setFont(new Font("微软雅黑", Font.TYPE1_FONT, 12));// 设置字体 还可设置为Font.ITALIC 就这两种条码打印机打印出来的的线是实体线
	// g.setFont(new Font("simsun", Font.TYPE1_FONT, 12));// jvm里 想将字体格式simsun存入jvm里直接调用，打印出来也不成
	
	g.drawLine(x, y, imgWidth, y);// 第一条横线
	
	 g.drawLine(x, y, x, rowHeight);//竖线
	// g.drawString(new String("名称".getBytes("utf-8"),"utf-8"), dataStart, rowHeight - 5);
	 g.drawString("名称", dataStart, rowHeight - 5);
	g.drawLine(firstWidth, y, firstWidth, rowHeight);
	g.drawString(tb.getName() == null ? "" : tb.getName() , firstWidth + dataStart, rowHeight - 5);
	g.drawLine(imgWidth - 1, y, imgWidth - 1, rowHeight);
	
	g.drawLine(x, rowHeight, imgWidth, rowHeight); //横线
	g.drawLine(x, rowHeight, x, rowHeight * 2);
	 g.drawString("代码", dataStart, rowHeight * 2 - 5); // * 2代表第二行
	g.drawLine(firstWidth, rowHeight, firstWidth, rowHeight * 2);
	g.drawString(tb.getCode() == null ? "" : tb.getCode() , firstWidth + dataStart, rowHeight * 2 - 5);
	g.drawLine(secondWidth, rowHeight, secondWidth, rowHeight * 2);
	
	//其他数据....
	
	//最后一条线
	g.drawLine(x, imgHeight - 1, imgWidth, imgHeight - 1);
	
	//在指定坐标(198,61)处 写入二维码或其它图片
//	g.drawImage(ImageIO.read(getServletContext().getResourceAsStream(t.getPicUrl())), null, 198, 61);
	g.dispose();
	} catch (IOException e) {
	e.printStackTrace();
	}
	
	return image;
	} */

}