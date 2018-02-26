package cn.itcast.entity;
/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-13 下午6:41:27 
 * @version 1.0 
 * 这是拜访的实体类
 */
public class Visit {
private Integer vid;
private String vaddress;
private String vcontent;
//表述所属的客户
private Customer customer;

public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
//表示每个拜访记录所属的用户
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public String getVaddress() {
	return vaddress;
}
public void setVaddress(String vaddress) {
	this.vaddress = vaddress;
}
public String getVcontent() {
	return vcontent;
}
public void setVcontent(String vcontent) {
	this.vcontent = vcontent;
}

}
