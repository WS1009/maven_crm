package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-13 下午7:15:25
 * @version 1.0
 */
public class VisitAction extends ActionSupport implements ModelDriven<Visit> {

	private Visit visit = new Visit();

	public Visit getModel() {
		return visit;
	}

	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 1 到新增的页面
	public String toAddPage() {
		// 查询所有客户
		List<Customer> listCustomer = customerService.findAll();
		// 查询所有用户
		List<User> listUser = userService.findAll();

		// 放到域对象中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}

	//2 新增方法
	public String addVisit() {
		visitService.addVisit(visit);
		return "addVisit";
	}
	
	//3 拜访列表
	public String list(){
		List<Visit> list=visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}
