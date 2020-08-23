package cn.edu.guet.mapper;


import cn.edu.guet.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    Menu getMenuById(String id);
    List<Menu> getAllMenu();
    List<Menu> getChildMenuByPID(String id);
}