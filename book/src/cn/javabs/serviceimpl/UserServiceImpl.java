package cn.javabs.serviceimpl;

import cn.javabs.dao.UserDao;
import cn.javabs.daoimpl.UserDaoImpl;
import cn.javabs.entity.User;
import cn.javabs.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public int addUser(User u) {
        int result = userDao.addUser(u);
        return result;
    }
}
