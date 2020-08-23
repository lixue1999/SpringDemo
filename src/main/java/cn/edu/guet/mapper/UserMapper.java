package cn.edu.guet.mapper;

import cn.edu.guet.model.Menu;
import cn.edu.guet.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User login(@Param("user_name") String user_name, @Param("password") String password);
    List<User> viewUser();
    void addUser(@Param("emp_id") String emp_id,@Param("user_name") String user_name,@Param("password") String password);
    void deleteUser(@Param("emp_id") String emp_id);
    List<Menu> getMenu(@Param("user_name") String user_name);
    void updateUser_name(@Param("emp_id") String emp_id,@Param("user_name")String user_name);
    void updatePassword(@Param("emp_id") String emp_id,@Param("password")String password);
}
