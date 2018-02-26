package cn.itcast.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.sun.org.apache.xml.internal.security.encryption.Transforms;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-6 下午7:13:34
 * @version 1.0
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements
		CustomerDao {

	// 添加客户功能
	// public void add(Customer customer) {
	// this.getHibernateTemplate().save(customer);
	// }

	// 客户列表功能
	// @SuppressWarnings("all")
	// public List<Customer> findAll() {
	// return (List<Customer>)
	// this.getHibernateTemplate().find("from Customer");
	// }

	// 根据id查询
	// public Customer findOne(int cid) {
	// return this.getHibernateTemplate().get(Customer.class, cid);
	// }

	// 删除的功能
	// public void delete(Customer customer) {
	// this.getHibernateTemplate().delete(customer);
	// }

	// 修改的功能
	// public void update(Customer customer) {
	// this.getHibernateTemplate().update(customer);
	// }

	// 查询总记录数
	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(
				"select count(*) from Customer");
		if (list != null && list.size() != 0) {
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	// 分页查询
	// public List<Customer> findPage(int begin, int pageSize) {
	// SessionFactory sessionFactory = this.getSessionFactory();
	// Session session = sessionFactory.getCurrentSession();
	// Query query = session.createQuery("from Customer");
	// query.setFirstResult(begin);
	// query.setMaxResults(pageSize);
	// List list = query.list();
	// if (list != null && list.size() != 0) {
	// return list;
	// }
	// return null;
	// }

	// 分页查询
	@SuppressWarnings("all")
	public List<Customer> findPage(int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate()
				.findByCriteria(detachedCriteria, begin, pageSize);
		if (list != null && list.size() != 0) {
			return list;
		}
		return null;
	}

	// 条件查询：第一种方式
	// public List<Customer> findCondition(Customer customer) {
	// SessionFactory sessionFactory = this.getSessionFactory();
	// Session session = sessionFactory.getCurrentSession();
	// Query query = session.createQuery("from Customer where custName=?");
	// query.setParameter(0, "%"+customer.getCustName()+"%");
	// List<Customer> list = query.list();
	// return list;
	// }

	// 条件查询：第二种方式 调用HibernateTemplate中的find方法实现
	// @SuppressWarnings("all")
	// public List<Customer> findCondition(Customer customer) {
	// List<Customer> list = (List<Customer>)
	// this.getHibernateTemplate().find("from Customer where custName like ?",
	// "%"+customer.getCustName()+"%");
	// return list;
	// }

	// 条件查询：第三种方式 使用离线对象，调用HibernateTemplate中的find方法实现
	// 常用此方法
	@SuppressWarnings("all")
	public List<Customer> findCondition(Customer customer) {
		// 创建离线对象
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Customer.class);
		// 设置实体类那个属性
		detachedCriteria.add(Restrictions.like("custName",
				"%" + customer.getCustName() + "%"));
		// 调用HibernateTemplate中的方法
		List<Customer> list = (List<Customer>) this.getHibernateTemplate()
				.findByCriteria(detachedCriteria);
		return list;
	}

	// 多条件组合查询-->使用hibernate模板里面的find方法实现
	// @SuppressWarnings("all")
	// public List<Customer> findMoreCondition(Customer customer) {
	// // 拼接hql语句
	// String hql = "from Customer where 1=1";
	// //创建list集合，如果值不为空，把值设置到list里面
	// List<Object> p=new ArrayList<Object>();
	// // 判断条件之是否为空，不为空，拼接hql语句
	// if (customer.getCustName() != null
	// && !customer.getCustName().equals("")) {
	// // 拼接语句
	// hql += " and custName=?";
	// //把值设置到list中去
	// p.add(customer.getCustName());
	// }
	//
	// if (customer.getCustLevel() != null
	// && !customer.getCustLevel().equals("")) {
	// // 拼接语句
	// hql += " and custLevel=?";
	// p.add(customer.getCustLevel());
	// }
	//
	// if (customer.getCustSource() != null
	// && !customer.getCustSource().equals("")) {
	// // 拼接语句
	// hql += " and custSource=?";
	// p.add(customer.getCustSource());
	// }
	// // System.out.println("****************hql:"+hql);
	// // System.out.println("******************************p:"+p);
	// return (List<Customer>) this.getHibernateTemplate().find(hql,
	// p.toArray());
	// }

	// 多条件组合查询-->使用离线对象方式实现
	@SuppressWarnings("all")
	public List<Customer> findMoreCondition(Customer customer) {
		// 创建离线对象，指定对那个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 判断条件之是否为空
		if (customer.getCustName() != null&& !customer.getCustName().equals("")) {
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
		
//		if (customer.getCustLevel() != null&& !customer.getCustLevel().equals("")) {
//			criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
//		} 

		if (customer.getCustSource() != null&& !customer.getCustSource().equals("")) {
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	//查询所有级别
	@SuppressWarnings("all")
	public List<Dict> findAllDictLevel() {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//根据客户来源查询
	public List findCountSource() {
		//因为此操作写复杂操作，建议直接调用底层sql实现
		//SQLQuery对象
		//1得到sessionFactory对象
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = getSessionFactory().getCurrentSession();
		//2 创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) AS num,custSource FROM t_customer GROUP BY custSource");
		//3 调用方法得到结果
		//返回list默认每部分为数组形式
		/**
		 * 因为返回值只有连个字段，一个字段为id ，一个名称
		 * 所以说可以返回的数据装换为map结构
		 */
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

	public List findCountLevel() {
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT c.num,d.dname FROM (SELECT COUNT(*) AS num,custLevel FROM t_customer GROUP BY custLevel) c, t_dict d WHERE c.custLevel=d.did");
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

}
