package kehaofei.com.sm.model;

import java.math.BigDecimal;
import java.util.List;

import kehaofei.com.utils.ByteUtils;

/**
 * 
 * @author XCCD
 * <li>TODO	销售单信息
 * <li>2017-5-31 下午2:18:01
 * <li>
 */
public class SalesTicketInfoModel {
	
	/**xs_hao 主键**/
	private String xs_hao;//销售单号
	/**kehu_no 客户编号**/
	private String kehu_no;//客户编号		
	/**kehu_name 客户姓名**/
	private String kehu_name;
	/**kehu_pinyin 客户pinyin**/
	private String kehu_pinyin;
	/**kehu_tel 客户电话**/
	private String kehu_tel;
	/**xs_date 日期**/
	private String xs_date;//日期	
	/**xs_user 销售人员**/
	private String xs_user;	
	/**xs_moneyall 销售总价**/
	private BigDecimal xs_moneyall;
	
	private List<SalesTicketDetailsModel> salesTicketDetails;	
	
	/**
	 * @return the kehu_tel
	 */
	public String getKehu_tel() {
		return kehu_tel;
	}
	/**
	 * @param kehu_tel the kehu_tel to set
	 */
	public void setKehu_tel(String kehu_tel) {
		this.kehu_tel = kehu_tel;
	}
	/**
	 * @return the kehu_pinyin
	 */
	public String getKehu_pinyin() {
		return kehu_pinyin;
	}
	/**
	 * @param kehu_pinyin the kehu_pinyin to set
	 */
	public void setKehu_pinyin(String kehu_pinyin) {
		this.kehu_pinyin = kehu_pinyin;
	}
	/**
	 * @return the kehu_name
	 */
	public String getKehu_name() {
		return kehu_name;
	}
	/**
	 * @param kehu_name the kehu_name to set
	 */
	public void setKehu_name(String kehu_name) {
		this.kehu_name = kehu_name;
	}
	/**
	 * @return the salesTicketDetails
	 */
	public List<SalesTicketDetailsModel> getSalesTicketDetails() {
		return salesTicketDetails;
	}
	/**
	 * @param salesTicketDetails the salesTicketDetails to set
	 */
	public void setSalesTicketDetails(
			List<SalesTicketDetailsModel> salesTicketDetails) {
		this.salesTicketDetails = salesTicketDetails;
	}
	
	public String getXs_hao() {
		return xs_hao;
	}
	public void setXs_hao(String xs_hao) {
		this.xs_hao = xs_hao;
	}
	public String getKehu_no() {
		return kehu_no;
	}
	public void setKehu_no(String kehu_no) {
		this.kehu_no = kehu_no;
	}
	public String getXs_date() {
		/*if(xs_date != null){
			xs_date = ByteUtils.dateFormat(xs_date, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
		}*/
		return xs_date;
	}
	public void setXs_date(String xs_date) {
		if(xs_date != null){
			xs_date = xs_date.split(" ")[0];
		}
		this.xs_date = xs_date;
	}
	public String getXs_user() {
		return xs_user;
	}
	public void setXs_user(String xs_user) {
		this.xs_user = xs_user;
	}
	public BigDecimal getXs_moneyall() {
		return xs_moneyall;
	}
	public void setXs_moneyall(BigDecimal xs_moneyall) {
		this.xs_moneyall = xs_moneyall;
	}
	@Override
	public String toString() {
		return "SalesTicketInfoModel [xs_hao=" + xs_hao + ", kehu_no="
				+ kehu_no + ", kehu_name=" + kehu_name + ", kehu_pinyin="
				+ kehu_pinyin + ", kehu_tel=" + kehu_tel + ", xs_date="
				+ xs_date + ", xs_user=" + xs_user + ", xs_moneyall="
				+ xs_moneyall + ", \n\nsalesTicketDetails=\n"
				+ salesTicketDetails + "]";
	}
	
	
	
	
}
