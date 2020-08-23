package cn.edu.guet.service;

import cn.edu.guet.model.Menu;
import cn.edu.guet.model.User;

import java.util.List;

public interface IUserService {
    User login(String user_name, String password);
    List<Menu> getMenu(String user_name);
    List<User> viewUser();
}
