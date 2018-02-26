package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;
import org.springframework.transaction.annotation.Transactional;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-5 下午9:06:46 
 * @version 1.0 
 */
@Transactional
public class UserService {
	private UserDao  userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		//调用dao里面的方法
		return userDao.loginUser(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}


	

}
