package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseMapper<UserBean> {

    public UserBean queryUserName(String userName);

    public  void deleteUser(Integer id);

    public  void addUser(UserBean userBean);

    public  Integer queryCount();

    public UserBean togoUser(Integer id);

    public List<UserBean> queryUser(UserBean userBean);

    public void updateUser(UserBean userBean);


}
