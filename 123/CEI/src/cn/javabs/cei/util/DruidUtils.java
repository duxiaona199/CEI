package cn.javabs.cei.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {

    private  static DataSource dataSource = null;

    static String myFile = "druid.properties";

    static {


        try {
            InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream(myFile);
            Properties p = new Properties();
            p.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

         public static DataSource getDataSource(){
                return  dataSource;
         }

         public static Connection getConnection(){
             try {
                 return  dataSource.getConnection();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
}
