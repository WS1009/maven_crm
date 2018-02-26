package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.Visit;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-13 下午7:16:27 
 * @version 1.0 
 */
public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao{

	//添加客户拜访方法
	public void addVisit(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	@SuppressWarnings("all")
	public List<Visit> findAll() {
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}

}
