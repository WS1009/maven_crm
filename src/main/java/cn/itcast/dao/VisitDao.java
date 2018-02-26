package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Visit;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-13 下午7:16:10 
 * @version 1.0 
 */
public interface VisitDao {

	void addVisit(Visit visit);

	List<Visit> findAll();

}
