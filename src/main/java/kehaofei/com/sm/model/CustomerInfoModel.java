package kehaofei.com.sm.model;

/**
 * 
 * @author XCCD
 * <li>TODO	客户信息列表
 * <li>2017-5-31 下午2:42:32
 * <li>
 */
public class CustomerInfoModel {
	
	/**客户编号  主键**/
	public String kehu_no;
	/**kehu_py 客户拼音**/
	public String kehu_py;
	/**kehu_name 客户名称**/
	public String kehu_name;
	
	/**lxr 客户联系人**/
	public String lxr;
	/**tel 客户电话**/
	public String tel;
	/**sj 客户手机号**/
	public String sj;
	/**leibie 客户类别**/
	public String leibie;
	/**adr 客户地址**/
	public String adr;
	/**web 客户网站**/
	public String web;
	/**mail 客户邮箱**/
	public String mail;
	/**cz 客户传真**/
	public String cz;
	/**bank 客户银行账号**/
	public String bank;
	/**province 客户省份证**/
	public String province;
	/**city 客户城市**/
	public String city;
	/**comment 备注**/
	public String comment;
	
	/**kehu_del 删除标识**/
	public String kehu_del;

	/**
	 * @return the kehu_no
	 */
	public String getKehu_no() {
		return kehu_no;
	}

	/**
	 * @param kehu_no the kehu_no to set
	 */
	public void setKehu_no(String kehu_no) {
		this.kehu_no = kehu_no;
	}

	/**
	 * @return the kehu_py
	 */
	public String getKehu_py() {
		return kehu_py;
	}

	/**
	 * @param kehu_py the kehu_py to set
	 */
	public void setKehu_py(String kehu_py) {
		this.kehu_py = kehu_py;
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
	 * @return the lxr
	 */
	public String getLxr() {
		return lxr;
	}

	/**
	 * @param lxr the lxr to set
	 */
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the sj
	 */
	public String getSj() {
		return sj;
	}

	/**
	 * @param sj the sj to set
	 */
	public void setSj(String sj) {
		this.sj = sj;
	}

	/**
	 * @return the leibie
	 */
	public String getLeibie() {
		return leibie;
	}

	/**
	 * @param leibie the leibie to set
	 */
	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	/**
	 * @return the adr
	 */
	public String getAdr() {
		return adr;
	}

	/**
	 * @param adr the adr to set
	 */
	public void setAdr(String adr) {
		this.adr = adr;
	}

	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the cz
	 */
	public String getCz() {
		return cz;
	}

	/**
	 * @param cz the cz to set
	 */
	public void setCz(String cz) {
		this.cz = cz;
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
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
	 * @return the kehu_del
	 */
	public String getKehu_del() {
		return kehu_del;
	}

	/**
	 * @param kehu_del the kehu_del to set
	 */
	public void setKehu_del(String kehu_del) {
		this.kehu_del = kehu_del;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n\tCustomerInfoModel [kehu_no=" + kehu_no + ", kehu_py=" + kehu_py
				+ ", kehu_name=" + kehu_name + ", lxr=" + lxr + ", tel=" + tel
				+ ", sj=" + sj + ", leibie=" + leibie + ", adr=" + adr
				+ ", web=" + web + ", mail=" + mail + ", cz=" + cz + ", bank="
				+ bank + ", province=" + province + ", city=" + city
				+ ", comment=" + comment + ", kehu_del=" + kehu_del + "]";
	}
	
}
