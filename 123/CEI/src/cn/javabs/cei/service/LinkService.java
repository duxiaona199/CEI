package cn.javabs.cei.service;

import cn.javabs.cei.entity.Link;

import java.util.List;


public interface LinkService {

    int addLink(Link link);
    int delLink(int id);
    int updateLink(Link link);


    Link findLinkById(int id);
    Link findLinkByName(String linkname);
    List<Link> findAllLink();
}
