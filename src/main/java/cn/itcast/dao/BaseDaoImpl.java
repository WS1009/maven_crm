package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.Customer;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-13 下午9:13:25
 * @version 1.0
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class pClass;

	//构造方法
	public BaseDaoImpl() {
		//第一步，得到当前运行类的class
		Class clazz = this.getClass();
		
		//第二步 得到运行类父类的参数化类型 BaseDaoImpl<Customer>
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype=(ParameterizedType) type; 
		
		//第三步 得到实际类型参数 <Customer>里面的 Customer
		Type[] types = ptype.getActualTypeArguments();
		//Type接口的实现类是Class
		Class tclass = (Class) types[0];
		this.pClass=tclass;
		
	}
	
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}


	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	// 根据id查询
	@SuppressWarnings("all")
	public T findOne(int id) {
		// 不能写T.class
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	// 查询所有
	@SuppressWarnings("all")
	public List<T> findAll() {
		//使用Class类中的getSimpleName()得到类的名称,注意from后面要加 空格
		return  (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

}
