package cn.edu.guet;


import cn.edu.guet.common.Result;
import cn.edu.guet.model.User;
import cn.edu.guet.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    IUserService userService;
    @Test
    public void login(){
        String username="wzz";
        System.out.println(username);
        String password="wzz";
        System.out.println(password);
        User user = userService.login(username,password);
        System.out.println("aaaaaaaaa"+user.getEmp_id());
        System.out.println(user.getUser_name());
        Result result=Result.succ(user);
        System.out.println(result);
    }
}