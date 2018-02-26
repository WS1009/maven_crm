package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.LinkManDao;
import cn.itcast.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-8 下午8:45:40
 * @version 1.0
 */
@Transactional
public class LinkManService {
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void addLinkMan(LinkMan linkMan) {
		linkManDao.addLinkMan(linkMan);
	}

	public List<LinkMan> listLinkMan() {
		return linkManDao.listLinkMan();
	}

	public LinkMan findOne(int linkid) {
		return linkManDao.findOne(linkid);
	}

	public void updateLinkMan(LinkMan linkMan) {
		linkManDao.updateLinkMan(linkMan);
	}

	public List<LinkMan> findCondition(LinkMan linkMan) {
		return linkManDao.findCondition(linkMan);
	}
}
