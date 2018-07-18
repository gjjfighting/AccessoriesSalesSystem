package kehaofei.com.sm.model;

import java.math.BigDecimal;

/**
 * 
 * @author XCCD
 * <li>TODO	商品信息实体结构
 * <li>2017-5-31 下午2:18:01
 * <li>
 */
public class GoodsInfoModel {
	
	/**peij_no 主键**/
	public String peij_no;//配件索引	
	/**peij_py 拼音**/
	public String peij_py;//配件拼音	
	/**peij_name 名称**/
	public String peij_name;//配件名称	
	/**peij_lb 商品类别**/
	public String peij_lb;	
	/**code 规格**/
	public String code;	
	/**brand 品牌**/
	public String brand;	
	/**unit 单位**/
	public String unit;	
	/**in_price 进价**/
	public String in_price;
	/**out_price1 销售价一**/
	public BigDecimal out_price1;
	/**out_price2 销售价二**/
	public BigDecimal out_price2;
	/**out_price3 销售价三**/
	public BigDecimal out_price3;
	
	/**spec **/
	public String spec;
	/**model **/
	public String model;
	/**place 生产厂商**/
	public String place;
	/**export **/
	public String export;
	/**pernum **/
	public Integer pernum;
	/**pack **/
	public String pack;
	/**material **/
	public String material;
	/**roll **/
	public String roll;
	
	
	/**jinyong 禁用/启用标识**/
	public String jinyong;
	/**comment 备注**/
	public String comment;
	/**peij_del 删除标识**/
	public String peij_del;
	
	
	/**sz **/
	public Long sz;
	/**price_zk **/
	public BigDecimal price_zk;
	/**new_price **/
	public BigDecimal new_price;
	/**
	 * @return the peij_no
	 * 主键
	 */
	public String getPeij_no() {
		return peij_no;
	}
	/**
	 * @param peij_no the peij_no to set
	 * 主键
	 */
	public void setPeij_no(String peij_no) {
		this.peij_no = peij_no;
	}
	/**
	 * @return the peij_py
	 */
	public String getPeij_py() {
		return peij_py;
	}
	/**
	 * @param peij_py the peij_py to set
	 */
	public void setPeij_py(String peij_py) {
		this.peij_py = peij_py;
	}
	/**
	 * @return the peij_name
	 */
	public String getPeij_name() {
		return peij_name;
	}
	/**
	 * @param peij_name the peij_name to set
	 */
	public void setPeij_name(String peij_name) {
		this.peij_name = peij_name;
	}
	/**
	 * @return the peij_lb
	 */
	public String getPeij_lb() {
		return peij_lb;
	}
	/**
	 * @param peij_lb the peij_lb to set
	 */
	public void setPeij_lb(String peij_lb) {
		this.peij_lb = peij_lb;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the in_price
	 */
	public String getIn_price() {
		return in_price;
	}
	/**
	 * @param in_price the in_price to set
	 */
	public void setIn_price(String in_price) {
		this.in_price = in_price;
	}
	/**
	 * @return the out_price1
	 */
	public BigDecimal getOut_price1() {
		return out_price1;
	}
	/**
	 * @param out_price1 the out_price1 to set
	 */
	public void setOut_price1(BigDecimal out_price1) {
		this.out_price1 = out_price1;
	}
	/**
	 * @return the out_price2
	 */
	public BigDecimal getOut_price2() {
		return out_price2;
	}
	/**
	 * @param out_price2 the out_price2 to set
	 */
	public void setOut_price2(BigDecimal out_price2) {
		this.out_price2 = out_price2;
	}
	/**
	 * @return the out_price3
	 */
	public BigDecimal getOut_price3() {
		return out_price3;
	}
	/**
	 * @param out_price3 the out_price3 to set
	 */
	public void setOut_price3(BigDecimal out_price3) {
		this.out_price3 = out_price3;
	}
	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}
	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the place
	 * 生产厂商
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 * 生产厂商
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * @return the export
	 */
	public String getExport() {
		return export;
	}
	/**
	 * @param export the export to set
	 */
	public void setExport(String export) {
		this.export = export;
	}
	/**
	 * @return the pernum
	 */
	public Integer getPernum() {
		return pernum;
	}
	/**
	 * @param pernum the pernum to set
	 */
	public void setPernum(Integer pernum) {
		this.pernum = pernum;
	}
	/**
	 * @return the pack
	 */
	public String getPack() {
		return pack;
	}
	/**
	 * @param pack the pack to set
	 */
	public void setPack(String pack) {
		this.pack = pack;
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @return the roll
	 */
	public String getRoll() {
		return roll;
	}
	/**
	 * @param roll the roll to set
	 */
	public void setRoll(String roll) {
		this.roll = roll;
	}
	/**
	 * @return the jinyong
	 */
	public String getJinyong() {
		return jinyong;
	}
	/**
	 * @param jinyong the jinyong to set
	 */
	public void setJinyong(String jinyong) {
		this.jinyong = jinyong;
	}
	/**
	 * 获取备注信息
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the peij_del
	 */
	public String getPeij_del() {
		return peij_del;
	}
	/**
	 * @param peij_del the peij_del to set
	 */
	public void setPeij_del(String peij_del) {
		this.peij_del = peij_del;
	}
	/**
	 * @return the sz
	 */
	public Long getSz() {
		return sz;
	}
	/**
	 * @param sz the sz to set
	 */
	public void setSz(Long sz) {
		this.sz = sz;
	}
	/**
	 * @return the price_zk
	 */
	public BigDecimal getPrice_zk() {
		return price_zk;
	}
	/**
	 * @param price_zk the price_zk to set
	 */
	public void setPrice_zk(BigDecimal price_zk) {
		this.price_zk = price_zk;
	}
	/**
	 * @return the new_price
	 */
	public BigDecimal getNew_price() {
		return new_price;
	}
	/**
	 * @param new_price the new_price to set
	 */
	public void setNew_price(BigDecimal new_price) {
		this.new_price = new_price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * 重写toString
	 */
	@Override
	public String toString() {
		return "GoodsModel [peij_no=" + peij_no + ", peij_py=" + peij_py
				+ ", peij_name=" + peij_name + ", peij_lb=" + peij_lb
				+ ", code=" + code + ", brand=" + brand + ", unit=" + unit
				+ ", in_price=" + in_price + ", out_price1=" + out_price1
				+ ", out_price2=" + out_price2 + ", out_price3=" + out_price3
				+ ", spec=" + spec + ", model=" + model + ", place=" + place
				+ ", export=" + export + ", pernum=" + pernum + ", pack="
				+ pack + ", material=" + material + ", roll=" + roll
				+ ", jinyong=" + jinyong + ", comment=" + comment
				+ ", peij_del=" + peij_del + ", sz=" + sz + ", price_zk="
				+ price_zk + ", new_price=" + new_price + "]";
	}
	
}
