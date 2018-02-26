package cn.itcast.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-6 下午7:11:36
 * @version 1.0
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 模型驱动
	private Customer customer = new Customer();

	public Customer getModel() {
		return customer;
	}

	// ioc
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 1到添加页面
	public String toAddPage() {
		//查询所有级别
		List<Dict> listDict=customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
	}

	// 2添加的方法
	public String add() {
		// 添加的逻辑
		customerService.add(customer);
		return "add";
	}

	// 定义list变量,用于值栈操作
	private List<Customer> list;

	// 生成变量的get方法
	public List<Customer> getList() {
		return list;
	}

	// 3客户列表的方法
	public String list() {
		// List<Customer> list=customerService.findAll();
		// 放到域对象中
		// ServletActionContext.getRequest().setAttribute("list", list);

		// 返回的list放到值栈中
		list = customerService.findAll();
		return "list";
	}

	// 4删除的方法
	public String delete() {
		// 使用模型驱动获取表单提交的cid值
		int cid = customer.getCid();
		// 删除的规范写法:首先根据ID查询，然后调用方法删除
		// 根据id查询
		Customer c = customerService.findOne(cid);
		// 判断根据id查询是都为空,解决火狐的二次提交问题
		if (c != null) {
			// 调用方法删除
			customerService.delete(c);
		}
		return "delete";
	}

	// 5修改操作中-根据id查询
	public String showCustomer() {
		// 使用模型驱动获取cid值
		int cid = customer.getCid();
		// 根据id查询
		Customer c = customerService.findOne(cid);
		// 放到域对象中
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
	}

	// 6修改的方法
	public String update() {
		customerService.update(customer);
		return "update";
	}

	// 使用属性封装获取currentPage
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	// 7分页的方法
	public String listpage() {
		// 调用service的方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		// 放到域对象中
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}

	// 8条件查询的方法
	public String listcondition() {
		// 如果输入客户名称，根据客户名称查询
		// 如果不输入任何的内容，查询所有
		if (customer.getCustName() != null && !customer.getCustName().equals("")) {
			// 如果输入客户名称，根据客户名称查询
			List<Customer> list = customerService.findCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		} else {
			// 如果不输入任何的内容，查询所有
			// list();

			// 返回的list放到值栈中
			list = customerService.findAll();
		}
		return "listcondition";
	}
	
	// 9 综合查询
	public String toSelectCustomerPage(){
		return "toSelectCustomerPage";
	}
	
	//10 多条件组合查询
	public String moreCondition(){
		List<Customer> list=customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//11 根据客户来源统计
	public String countSource(){
		List list=customerService.findCountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	//12 根据客户级别统计
	public String countLevel(){
		List list=customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}

}
