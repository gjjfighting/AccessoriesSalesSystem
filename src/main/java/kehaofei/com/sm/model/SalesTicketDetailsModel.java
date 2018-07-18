package kehaofei.com.sm.model;

import java.math.BigDecimal;

/**
 * 
 * @author XCCD
 * <li>TODO	销售单详细信息
 * <li>2017-5-31 下午2:18:01
 * <li>
 */
public class SalesTicketDetailsModel {
	
	/**xs_no 主键**/
	public Integer xs_no;
	/**xs_hao 销售单号**/
	public String xs_hao;
	/**peij_no 配件编号**/
	public String peij_no;//配件主键
	/**ck_name 配件拼音**/
	public String ck_name;	
	/**xs_name 配件名称**/
	public String xs_name;	
	/**xs_code 配件规格**/
	public String xs_code;	
	/**xs_brand 配件品牌**/
	public String xs_brand;	
	/**xs_unit 配件单位**/
	public String xs_unit;
	/**xs_price 配件售价**/
	public BigDecimal xs_price;
	/**xs_num 销售数量**/
	public Integer xs_num;
	/**xs_money 销售金额**/
	public BigDecimal xs_money;
	
	/**comment 配件备注**/
	public String comment;
	/**xs_place 生产厂商**/
	public String xs_place;
	/**xs_spec **/
	public String xs_spec;
	/**xs_model **/
	public String xs_model;
	/**xs_roll **/
	public String xs_roll;
	/**xs_pjlb 配件类别**/
	public String xs_pjlb;
	/**xs_date 销售日期**/
	public String xs_date;
	/**xs_oldprice 配件原价**/
	public BigDecimal xs_oldprice;
	
	
	public Integer getXs_no() {
		return xs_no;
	}
	public void setXs_no(Integer xs_no) {
		this.xs_no = xs_no;
	}
	public String getXs_hao() {
		return xs_hao;
	}
	public void setXs_hao(String xs_hao) {
		this.xs_hao = xs_hao;
	}
	public String getPeij_no() {
		return peij_no;
	}
	public void setPeij_no(String peij_no) {
		this.peij_no = peij_no;
	}
	public String getCk_name() {
		return ck_name;
	}
	public void setCk_name(String ck_name) {
		this.ck_name = ck_name;
	}
	public String getXs_name() {
		return xs_name;
	}
	public void setXs_name(String xs_name) {
		this.xs_name = xs_name;
	}
	public String getXs_code() {
		return xs_code;
	}
	public void setXs_code(String xs_code) {
		this.xs_code = xs_code;
	}
	public String getXs_brand() {
		return xs_brand;
	}
	public void setXs_brand(String xs_brand) {
		this.xs_brand = xs_brand;
	}
	public String getXs_unit() {
		return xs_unit;
	}
	public void setXs_unit(String xs_unit) {
		this.xs_unit = xs_unit;
	}
	public BigDecimal getXs_price() {
		return xs_price;
	}
	public void setXs_price(BigDecimal xs_price) {
		this.xs_price = xs_price;
	}
	public int getXs_num() {
		return xs_num;
	}
	public void setXs_num(int xs_num) {
		this.xs_num = xs_num;
	}
	public BigDecimal getXs_money() {
		return xs_money;
	}
	public void setXs_money(BigDecimal xs_money) {
		this.xs_money = xs_money;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getXs_place() {
		return xs_place;
	}
	public void setXs_place(String xs_place) {
		this.xs_place = xs_place;
	}
	public String getXs_spec() {
		return xs_spec;
	}
	public void setXs_spec(String xs_spec) {
		this.xs_spec = xs_spec;
	}
	public String getXs_model() {
		return xs_model;
	}
	public void setXs_model(String xs_model) {
		this.xs_model = xs_model;
	}
	public String getXs_roll() {
		return xs_roll;
	}
	public void setXs_roll(String xs_roll) {
		this.xs_roll = xs_roll;
	}
	public String getXs_pjlb() {
		return xs_pjlb;
	}
	public void setXs_pjlb(String xs_pjlb) {
		this.xs_pjlb = xs_pjlb;
	}
	public String getXs_date() {
		return xs_date;
	}
	public void setXs_date(String xs_date) {
		this.xs_date = xs_date;
	}
	public BigDecimal getXs_oldprice() {
		return xs_oldprice;
	}
	public void setXs_oldprice(BigDecimal xs_oldprice) {
		this.xs_oldprice = xs_oldprice;
	}
	@Override
	public String toString() {
		return "\tSalesTicketDetailsModel [xs_no=" + xs_no + ", xs_hao=" + xs_hao
				+ ", peij_no=" + peij_no + ", ck_name=" + ck_name
				+ ", xs_name=" + xs_name + ", xs_code=" + xs_code
				+ ", xs_brand=" + xs_brand + ", xs_unit=" + xs_unit
				+ ", xs_price=" + xs_price + ", xs_num=" + xs_num
				+ ", xs_money=" + xs_money + ", comment=" + comment
				+ ", xs_place=" + xs_place + ", xs_spec=" + xs_spec
				+ ", xs_model=" + xs_model + ", xs_roll=" + xs_roll
				+ ", xs_pjlb=" + xs_pjlb + ", xs_date=" + xs_date
				+ ", xs_oldprice=" + xs_oldprice + "]\n";
	}
	
	
}
