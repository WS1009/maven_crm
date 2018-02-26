package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.User;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-5 下午9:08:03
 * @version 1.0
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	// 在bean.xml中使用简化写法
	// private HibernateTemplate hibernateTemplate;
	//
	// public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	// this.hibernateTemplate = hibernateTemplate;
	// }

	// 登录的方法
	@SuppressWarnings("all")
	public User loginUser(User user) {
		// 调用方法可以得到hibernateTemplate对象
		// HibernateTemplate hibernateTemplate2 = this.getHibernateTemplate();
		// 登录的查询操作
		// 根据用户名和密码进行查询,使用HQL
		String sql = "from User where username=? and password=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql, user.getUsername(), user.getPassword());
		// 判断
		if (list != null && list.size() != 0) {
			// 返回user对象
			User u = list.get(0);
			// 查询之后没有结果，list中没有值
			return u;
		}
		return null;

	}

	//查询所有的用户
	@SuppressWarnings("all")
	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

}
