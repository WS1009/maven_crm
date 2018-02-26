package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.VisitDao;
import cn.itcast.entity.Visit;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author WS
 * @date 创建时间：2017-6-13 下午7:15:53
 * @version 1.0
 */
@Transactional
public class VisitService {
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		visitDao.addVisit(visit);
	}

	public List<Visit> findAll() {
		return visitDao.findAll();
	}
}
