package com.fh.service.Impl;

import com.fh.bean.UserBean;
import com.fh.dao.UserDao;
import com.fh.service.UserService;
import com.fh.utiles.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserBean queryUserName(String userName) {
        return userDao.queryUserName(userName);
    }

    public PageBean<UserBean> queryUser(UserBean userBean) {
        Integer count = userDao.queryCount();
        userBean.setRecodsFilterd(count);
        userBean.setRecodsFilterd(count);
        List<UserBean> list = userDao.queryUser(userBean);
        userBean.setData(list);
        return userBean;
    }

    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    public void addUser(UserBean userBean) {
        userDao.addUser(userBean);
    }

    public UserBean togoUser(Integer id) {
        return userDao.togoUser(id);
    }

    public void updateUser(UserBean userBean) {
        userDao.updateUser(userBean);
    }
}
