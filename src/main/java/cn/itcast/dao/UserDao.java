package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.User;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-5 下午9:07:25 
 * @version 1.0 
 */
public interface UserDao {

	public User loginUser(User user);

	public List<User> findAll();

}
