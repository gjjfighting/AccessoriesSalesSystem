package kehaofei.com.ui.optionSalesTicket;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import kehaofei.com.sm.model.SalesTicketInfoModel;
import kehaofei.com.ui.wmspanel.SalesTicketHeadPanel;

/**
 * 使用了原始的分页方式去渲染JTextArea，提供了打印预览机制。
 * <p>
 * 事实上，我们还可以通过其他方式打印JTextArea：
 * <ol>
 * <li>{@code Component.print(Graphics g);} or
 * {@code Component.printAll(Graphics g);}</li>
 * <li>{@code Component.paint(Graphics g);} or
 * {@code Component.paintAll(Graphics g);} whose rending may be slightly
 * different to the previous method (for example, <code>JFrame</code>)</li>
 * <li>{@code JTable.print();} or {@code JTextComponent.print();} provide
 * especially powerful and convenient printing mechanism</li>
 * </ol>
 * 
 * @author Gaowen
 */
public class PrintUIComponent implements 
		Printable {
	private static final long serialVersionUID = 4797002827940419724L;

	public PrinterJob job;
	private int[] pageBreaks = null;// array of page break line positions
	private Header header;
	private Frame frame;
	

	public PrintUIComponent() {
		initPrinterJob();
	}
	

	public void initPrinterJob() {
		job = PrinterJob.getPrinterJob();
		job.setJobName("Print SalesTickets");// 出现在系统打印任务列表
		job.setPrintable(this);
	}

	public void excuteJob(String name){
		if (name.equals("PRINT")) {
			pageBreaks = null;// reset pagination
			boolean ok = job.printDialog();
			if (ok) {
				try {
					job.print();
				} catch (PrinterException ex) {
					/* The job did not successfully complete */
					ex.printStackTrace();
				}
			}
		} else if (name.equals("PRINTVIEW")) {
			pageBreaks = null;// reset pagination
			createAndShowPreviewDialog();
		}
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		/*
		 * It is safe to use a copy of this graphics as this will not involve
		 * changes to it.
		 */
		Graphics2D g2 = (Graphics2D) graphics.create();

		/* Calculate "pageBreaks" */
		Font font = new Font("宋体", Font.PLAIN, 12);
		FontMetrics metrics = g2.getFontMetrics(font);
		int lineHeight = metrics.getHeight();
		
		//	    通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。  
//	    Paper p = new Paper();  
//	    p.setSize(590,840);//纸张大小   
//	    p.setImageableArea(0,0, 595,842);//A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72  
//	    pageFormat.setPaper(p);  

		
		int preIndex = 6+pageIndex*8;
				//4 + (pageIndex+1)*3;
		
		if (pageBreaks == null || pageIndex <= pageBreaks.length-2) {//需要增加表头，所以每一次都需要计算页面张数
			int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);
			int numBreaks = (SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().size() + preIndex + 1) / linesPerPage;
			pageBreaks = new int[numBreaks];
			for (int b = 0; b < numBreaks; b++) {
				pageBreaks[b] = (b + 1) * linesPerPage;
			}
		}

		/* Condition to exit printing */
		if (pageIndex > pageBreaks.length) {
			return NO_SUCH_PAGE;
		}

		/* (0,0) is outside the imageable area, translate to avoid clipping */
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		/* Draw each line that is on this page */
		int y = 0;
		int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
		int end = (pageIndex == pageBreaks.length) ? (SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().size() + preIndex + 2)
				: pageBreaks[pageIndex];
				
		
		/*if(pageIndex == 0)*/
		
		
		//这里绘制表格
		for (int line = start; line < end && (line-preIndex)<SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().size(); ) {
			
			if(line < start+6){//表头数据
				{//销售单头部信息
					y += lineHeight;
					y += lineHeight;
					g2.setFont(new Font("宋体", Font.BOLD, 18));
					FontRenderContext context = g2.getFontRenderContext();
					// 获取字体的像素范围对象    
					Rectangle2D stringBounds = font.getStringBounds("销  售  清  单", context);
					double fontWidth = stringBounds.getWidth();	
					int startTitle = (int) ((pageFormat.getWidth()-fontWidth)/2);
					//System.out.println("起始位置："+startTitle);
					
					g2.drawString("销  售  清  单", (int)(pageFormat.getImageableWidth()/9)*4-20, y);
					
					
					y += lineHeight;
					g2.setFont(new Font("宋体", Font.PLAIN, 10));
					String message = SalesTicketHeadPanel.text_message.getText();			
					g2.drawString(message, 20, y-2);
					
					g2.setFont(new Font("宋体", Font.PLAIN, 12));
					y += lineHeight;
					y += lineHeight;
//					y += 8;
					g2.drawString("销售日期："+SalesTicketHeadPanel.salesTicketInfo.getXs_date(), 20, y-5);
					g2.drawString("客户："+SalesTicketHeadPanel.salesTicketInfo.getKehu_name(), (int)(pageFormat.getImageableWidth()/9)*7, y-5);
					
				}				
				
				{//明细表格表头
					
					g2.setFont(new Font("宋体", Font.PLAIN, 12));
					g2.drawLine(20, y, (int) pageFormat.getImageableWidth()-20, y);//第一条横线
					int x = 20;
					y += lineHeight;
					
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawLine(x, y, (int) pageFormat.getImageableWidth()-20, y);//表格里面的横线
					
					g2.drawString("序号", x+5, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9)-30;
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("商品名称", x+25, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9)+30;
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("类别", x+20, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9);
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("品牌", x+20, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9);
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("单位", x+10, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9)-20;
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("数量", x+15, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9)-10;
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("单价", x+20, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9);
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("金额", x+20, y-2);
					x =x+(int)(pageFormat.getImageableWidth()/9);
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawString("备注", x+20, y-2);
					x = x+(int)(pageFormat.getImageableWidth()/9);
					g2.drawLine(x-8, y-lineHeight, x-8, y);//绘制竖向分割线			
				
					g2.drawLine(20, y, (int) pageFormat.getImageableWidth()-20, y);//第一条横线
					
					
				}
				line = line+ 6;
			}
			
			//表格数据
			if(line >= start+6 && (line < (end - 2) || (line-preIndex) == SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().size()-1)){
				//System.out.println("当前序号："+(line-preIndex));
				int x = 20;
				y += lineHeight;
				
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawLine(x, y, (int) pageFormat.getImageableWidth()-20, y);//表格里面的横线
				
				g2.drawString(String.valueOf(line-preIndex+1), x+10, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9)-30;
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_name(), x+5, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9)+30;
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_pjlb(), x+20, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9);
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				String getXs_brand = SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_brand();
				g2.drawString(getXs_brand==null?"":getXs_brand, x+8, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9);
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_unit(), x+15, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9)-20;
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(String.valueOf(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_num()), x+15, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9)-10;
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(String.valueOf(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_price()), x+20, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9);
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				g2.drawString(SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getXs_money().toString(), x+10, y-2);
				x =x+(int)(pageFormat.getImageableWidth()/9);
				g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
				
				String getComment = SalesTicketHeadPanel.salesTicketInfo.getSalesTicketDetails().get(line-preIndex).getComment();		
				g2.drawString(getComment==null?"":getComment, x+10, y-2);
				x = x+(int)(pageFormat.getImageableWidth()/9);
				g2.drawLine(x-8, y-lineHeight, x-8, y);//绘制竖向分割线
				
				line++;
			}
			
			
			if(line >= (end -2)){

				if(pageIndex == pageBreaks.length ){//表格底部
					g2.drawLine(20, y, (int) pageFormat.getImageableWidth()-20, y);//第一条横线

					int x =20;
					y += lineHeight;
					
					g2.drawLine(x, y-lineHeight, x, y);//绘制竖向分割线
					
					g2.drawLine(x, y, (int) pageFormat.getImageableWidth()-20, y);//表格里面的横线
					
					g2.setFont(new Font("宋体", Font.PLAIN, 12));
					g2.drawString("合  计：", (int)(pageFormat.getImageableWidth()/9)*5, y-2);
					
					g2.drawString(SalesTicketHeadPanel.salesTicketInfo.getXs_moneyall().toString(), (int)(pageFormat.getImageableWidth()/9)*7, y-2);
					x = (int)(pageFormat.getImageableWidth());
					g2.drawLine(x-19, y-lineHeight, x-19, y);//绘制竖向分割线

					
				}
				
				int postion  = y + lineHeight;
				if(y + 2*lineHeight >= pageFormat.getImageableHeight()){
					System.out.println("页面超出范围");
				}else{
					postion =(int) pageFormat.getImageableHeight()-2;
				}
				
				String pageFoot = "第"+(pageIndex+1)+"页";
				
				// 获取字体的像素范围对象    
				FontRenderContext context = g2.getFontRenderContext();
				Rectangle2D stringBounds = font.getStringBounds(pageFoot, context);
				double fontWidth = stringBounds.getWidth();	
				int startTitle = (int) ((pageFormat.getWidth()-fontWidth)/2);
				
				g2.setFont(new Font("宋体", Font.PLAIN, 10));
				g2.drawString(pageFoot, startTitle/*(int)(pageFormat.getImageableWidth()/13)*6*/, postion);
				
				line +=2;
			}			
			
		}
		
		/* dispose of the graphics copy */
		g2.dispose();

		/* Tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	//打印预览对话框
	public void createAndShowPreviewDialog() {
		JDialog previewDialog = new JDialog(frame, "预览窗口", true);
		JPanel contentPane = new JPanel(new BorderLayout());
		PreviewArea previewArea = new PreviewArea();
		previewArea.addMouseListener(new PreviewAreaMouseAdapter(previewArea));
		JScrollPane scrollPane = new JScrollPane(previewArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		header = new Header(previewArea);
		contentPane.add(header, BorderLayout.NORTH);
		previewDialog.setContentPane(contentPane);
		previewDialog.setSize(650, 950);
		previewDialog
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		previewDialog.setVisible(true);
	}

	//初始化打印预览界面头部信息
	private class Header extends Component {
		private static final long serialVersionUID = -1741188309769027249L;
		private PreviewArea previewArea;
		private boolean paintable;

		private Header(PreviewArea previewArea) {
			this.previewArea = previewArea;
		}

		private void setPaintable(boolean paintable) {
			this.paintable = paintable;
		}

		@Override
		public void paint(Graphics g) {
			if (paintable) {
				g.setColor(Color.GRAY);
				g.drawString(
						String.valueOf(previewArea.getPageIndex() + 1)
								+ "/"
								+ String.valueOf(pageBreaks.length + 1)
								+ " pages (单击鼠标左键到下一页，右键到上一页)",
						10, 15);
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(super.getPreferredSize().width, 20);
		}
	}

	private class PreviewArea extends Component {
		private static final long serialVersionUID = -6384174997251439843L;
		private PageFormat pageFormat;
		private int pageIndex;
		private int w;
		private int h;
		private final int marginX = 10;
		private final int marginY = 10;

		private PreviewArea() {
			
//		    通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。  
		    Paper p = new Paper();  
		    p.setSize(590,840);//纸张大小   
		    p.setImageableArea(0,0, 590,840);//A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		    PageFormat pageFormatView = new PageFormat();
			pageFormatView.setPaper(p);
			pageFormat = job.pageDialog(pageFormatView);
			pageIndex = 0;
			w = (int) pageFormat.getWidth();
			h = (int) pageFormat.getHeight();
		}

		private int getPageIndex() {
			return pageIndex;
		}

		private void setPageIndex(int pageIndex) {
			this.pageIndex = pageIndex;
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(w + 2 * marginX, h + 2 * marginY);
		}

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.translate(marginX, marginY);
			g2.drawRect(0, 0, w, h);
			int ix = (int) (pageFormat.getImageableX() - 1);
			int iy = (int) (pageFormat.getImageableY() - 1);
			int iw = (int) (pageFormat.getImageableWidth() + 1);
			int ih = (int) (pageFormat.getImageableHeight() + 1);
			g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND, 10f, new float[] { 5, 5 }, 0f));
//			g2.drawRect(ix, iy, iw, ih);
			try {
				
				PrintUIComponent.this.print(g2, pageFormat, pageIndex);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
			g2.dispose();
			header.setPaintable(true);
			header.repaint();
		}
	}

	private class PreviewAreaMouseAdapter extends MouseAdapter {
		private PreviewArea previewArea;

		private PreviewAreaMouseAdapter(PreviewArea previewArea) {
			this.previewArea = previewArea;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int currentIndex = previewArea.getPageIndex();
			if (e.getButton() == MouseEvent.BUTTON1) {
				/* next page */
				if (currentIndex < pageBreaks.length) {
					previewArea.setPageIndex(currentIndex + 1);
					previewArea.repaint();
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				/* previous page */
				if (currentIndex > 0) {
					previewArea.setPageIndex(currentIndex - 1);
					previewArea.repaint();
				}
			}
		}
	}
}