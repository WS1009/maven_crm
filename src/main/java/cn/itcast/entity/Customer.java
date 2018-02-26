package cn.itcast.entity;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Customer {
	//客户id
	private Integer cid;
	//客户名称
	private String custName;
	//客户级别
//	private String custLevel;
	//客户来源
	private String custSource;
	//联系电话  010-45634
	private String custPhone;
	//手机  013425176891
	private String custMobile;
	//表示所属级别
	private Dict dictCustLevel;
	
	//一个客户里面的所有的拜访记录
	private Set<Visit> setCusVisit=new HashSet<Visit>();
	
	public Set<Visit> getSetCusVisit() {
		return setCusVisit;
	}
	public void setSetCusVisit(Set<Visit> setCusVisit) {
		this.setCusVisit = setCusVisit;
	}
	//表示客户的所有联系人
	private Set<LinkMan> setLinkMan=new HashSet<LinkMan>();
	
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
//	public String getCustLevel() {
//		return custLevel;
//	}
//	public void setCustLevel(String custLevel) {
//		this.custLevel = custLevel;
//	}
	public String getCustSource() {
		return custSource;
	}
	public Dict getDictCustLevel() {
		return dictCustLevel;
	}
	public void setDictCustLevel(Dict dictCustLevel) {
		this.dictCustLevel = dictCustLevel;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	
	
	
}
