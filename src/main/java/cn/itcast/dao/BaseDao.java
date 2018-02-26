package cn.itcast.dao;

import java.util.List;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-13 下午9:07:17 
 * @version 1.0 
 */

/**
 * 泛型类
 * 
 * @author Administrator
 * 
 * @param <T>
 *            代表任意的类型
 */
public interface BaseDao<T> {
	// 添加
	void add(T t);
	// 修改
	void update(T t);
	// 删除
	void delete(T t);
	// 根据id查询
	T findOne(int id);
	// 查询所有
	List<T> findAll();
}
