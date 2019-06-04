package cn.javabs.daoimpl;

import cn.javabs.dao.UserDao;
import cn.javabs.entity.User;
import cn.javabs.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner (DbcpUtil.getDataSource());
    @Override
    public int addUser(User u) {
        try {
            return qr.update("insert into user(username,password,sex) values(?,?,?)"   ,
                    u.getUsername(),u.getPassword(),u.getSex() );
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
