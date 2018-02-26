package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.LinkMan;

/** 
 *
 * @author  WS
 * @date 创建时间：2017-6-8 下午8:45:58 
 * @version 1.0 
 */
public interface LinkManDao {

	void addLinkMan(LinkMan linkMan);

	List<LinkMan> listLinkMan();

	LinkMan findOne(int linkid);

	void updateLinkMan(LinkMan linkMan);

	List<LinkMan> findCondition(LinkMan linkMan);

}
