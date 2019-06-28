package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Link;

import java.util.List;

public interface LinkDao {
    int addLink(Link link);

    int delLink(int id);

    int updateLink(Link link);

    Link getLinkById(int id);



    List<Link> getAllLink();
}
