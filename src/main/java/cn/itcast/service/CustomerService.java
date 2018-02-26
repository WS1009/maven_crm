package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-6 下午7:12:15
 * @version 1.0
 */
@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		customerDao.add(customer);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findOne(int cid) {
		return customerDao.findOne(cid);
	}

	public void delete(Customer c) {
		customerDao.delete(c);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	//封装分页数据到pagebean对象里面 
	public PageBean listpage(Integer currentPage) {
		//创建pagebean对象
		PageBean pageBean = new PageBean();
		
		//当前页
		pageBean.setCurrentPage(currentPage);
		
		//总记录数
		int totalCount=customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//每页显示的记录数
		int pageSize=6;
		pageBean.setPageSize(pageSize);
		
		//总页数
		//总记录数除以每页记录数
		//1、能够整除
		int totalPage=0;
		if (totalCount%pageSize==0) {//能够整除
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin=(currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<Customer> list=customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<Customer> findCondition(Customer customer) {
		return customerDao.findCondition(customer);
	}

	public List<Customer> findMoreCondition(Customer customer) {
		return customerDao.findMoreCondition(customer);
	}

	public List<Dict> findAllDictLevel() {
		return customerDao.findAllDictLevel();
	}

	public List findCountSource() {
		return customerDao.findCountSource();
	}

	public List findCountLevel() {
		return customerDao.findCountLevel();
	}
}
