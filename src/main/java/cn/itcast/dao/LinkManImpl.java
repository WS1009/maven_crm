package cn.itcast.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.LinkMan;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-8 下午8:46:38 
 * @version 1.0 
 */
public class LinkManImpl extends HibernateDaoSupport implements LinkManDao{

	//添加联系人的方法
	public void addLinkMan(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}

	//联系人列表的方法
	@SuppressWarnings("all")
	public List<LinkMan> listLinkMan() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	//根据ID查询联系人
	public LinkMan findOne(int linkid) {
		return this.getHibernateTemplate().get(LinkMan.class, linkid);
	}

	//修改联系人的方法
	public void updateLinkMan(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}

	//多条件组合查询-->hql语句拼接的方式实现
//	@SuppressWarnings("all")
//	public List<LinkMan> findCondition(LinkMan linkMan) {
//		String sql="from LinkMan where 1=1";
//		List<Object> p=new ArrayList<Object>();
//		if (linkMan.getLkmName()!=null&&!linkMan.getLkmName().equals("")) {
//			sql+=" and lkmName=?";
//			p.add(linkMan.getLkmName());
//		}
//		//判断是否选择客户
//		if (linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0) {
//			sql+=" and customer.cid=?";
//			p.add(linkMan.getCustomer().getCid());
//		}
//		
//		return (List<LinkMan>) this.getHibernateTemplate().find(sql, p.toArray());
//	}
	
	//多条件组合查询-->使用离线对象的方式实现
	@SuppressWarnings("all")
	public List<LinkMan> findCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if (linkMan.getLkmName()!=null&&!linkMan.getLkmName().equals("")) {
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		if (linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0) {
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}
}
