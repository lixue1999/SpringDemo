package cn.edu.guet.service.impl;

import cn.edu.guet.mapper.MenuMapper;
import cn.edu.guet.mapper.UserMapper;
import cn.edu.guet.model.Menu;
import cn.edu.guet.model.User;
import cn.edu.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;
    @Override
    public User login(String user_name, String password){
        return userMapper.login(user_name,password);
    }

    @Override
    public List<Menu> getMenu(String user_name){
        List<Menu> menuList=userMapper.getMenu(user_name);
        for (int i=0;i<menuList.size();i++){
            menuList.get(i).setChildMenus(menuMapper.getChildMenuByPID(menuList.get(i).getId()));
        }
        return menuList;
    }

    @Override
    public List<User> viewUser() {
        return userMapper.viewUser();
    }
}
