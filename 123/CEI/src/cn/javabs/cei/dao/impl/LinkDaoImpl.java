package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.LinkDao;
import cn.javabs.cei.entity.Link;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class LinkDaoImpl  implements LinkDao {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public int addLink(Link link) {


        try {
            return qr.update("insert into link(id,path,name) values(?,?,?)",
            link.getId(),link.getPath(),link.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public int delLink(int id) {
        try {
            return qr.update("delete from link where id = ?",id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateLink(Link link) {
        try {
            return qr.update("update link set path = ?,name=? where id = ?",
                    link.getPath(),link.getName(),link.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Link getLinkById(int id) {
        try {
            Link link = qr.query("select * from link where id=?", new BeanHandler<Link>(Link.class), id);
            System.out.println("linkdao_findByid   link ="+link);
            return  link;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public List<Link> getAllLink() {


        try {
             List<Link> links = qr.query("select * from link", new BeanListHandler<Link>(Link.class));
            return links;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
