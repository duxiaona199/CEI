package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.LinkDao;
import cn.javabs.cei.dao.impl.LinkDaoImpl;
import cn.javabs.cei.entity.Link;
import cn.javabs.cei.service.LinkService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public class LinkServiceImpl implements LinkService {


    LinkDao linkDao = (LinkDao) new LinkDaoImpl();
    @Override
    public int addLink(Link link) {
        return linkDao.addLink(link);
    }

    @Override
    public int delLink(int id) {
        return linkDao.delLink(id);
    }

    @Override
    public int updateLink(Link link) {
        return linkDao.updateLink(link);
    }

    @Override
    public Link findLinkById(int id) {
        return linkDao.getLinkById(id);
    }

    @Override
    public Link findLinkByName(String linkname) {
        return null;
    }


    @Override
    public List<Link> findAllLink() {
         return linkDao.getAllLink();
    }
}
