package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-8 下午8:45:03
 * @version 1.0
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan=new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//1到新增联系人页面的方法
	public String toAddPage(){
		//1.1 查询所有客户，把所有客户list集合传递到页面显示（放到域对象中）
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	

	/**
	 * 文件上传
	 * 需要上传文件
	 * 需要上传文件名称
	 * （1）在action里面成员变量的位置定义这个变量
	 * -一个表示上传文件的
	 * -一个表示文件的名称
	 * （2）生成这两个变量的get和set方法
	 * (3)上传文件的mime类型，不需要自己设置
	 */
	//上传文件，名称为表单里面的name值
	private File upload;
	//上传文件的名称,名称为表单里面的name值再加上FileName
	private String uploadFileName;
	//生成这两个变量的get和set方法
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	//2添加数据到数据库的方法
	public String addLinkMan() throws IOException{
		//判断用户是否需要上传文件
		if (upload!=null) {
			//上传文件----  E:\MyFile\ssh_img
			//1 在服务器文件夹里面创建文件
			File serverFile = new File("E:\\MyFile\\ssh_img"+"\\"+uploadFileName);
			//2 把上传文件复制到服务器文件夹里面
			FileUtils.copyFile(upload, serverFile);
			//3 上传文件的大小在Struts2配置文件中使用常量配置
			
		}
		
		
		/**
		 * 可以封装联系人的基本信息
		 * 但是cid是客户的id值不能直接封装的
		 * 把cid封装到LinkMan实体类里面的customer对象里面
		 */
		//1 原始方式实现
//		String scid = ServletActionContext.getRequest().getParameter("cid");
//		int cid=Integer.parseInt(scid);
//		//创建customer对象
//		Customer customer = new Customer();
//		customer.setCid(cid);
//		linkMan.setCustomer(customer);
		
		//2 简化方式实现
		linkManService.addLinkMan(linkMan);
		return"addLinkMan";
	}
	
	//3 联系人列表的方法
	public String list(){
		List<LinkMan> list=linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	//4 到修改联系人页面的方法
	public String showLinkMan(){
		int linkid = linkMan.getLinkid();
		LinkMan linkman=linkManService.findOne(linkid);
		//需要所有客户的list集合
		List<Customer> listCustomer = customerService.findAll();
		
		//放到域对象中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkman", linkman);
		request.setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	//5 修改联系人
	public String updateLinkMan(){
		linkManService.updateLinkMan(linkMan);
		return "updateLinkMan";
	}
	
	//6 到联系人添加的页面
	public String toSelectPage(){
		//查询所有的客户，把它传到页面的下拉列表中
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	public String moreCondition(){
		//调用方法得到结果
		List<LinkMan> list=linkManService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
}
