package cn.edu.guet.service;

import cn.edu.guet.model.Menu;

import java.util.List;

public interface IMenuService {
    Menu getMenuById(String id);
    List<Menu> getAllMenu();
}
