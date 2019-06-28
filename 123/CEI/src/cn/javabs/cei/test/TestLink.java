package cn.javabs.cei.test;

import cn.javabs.cei.entity.Link;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestLink {
    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
    @Test

    public  void fun() throws SQLException {

        Link link = new Link();


    }
}
