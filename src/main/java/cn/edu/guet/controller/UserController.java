package cn.edu.guet.controller;

import cn.edu.guet.common.Result;
import cn.edu.guet.dt.UserDto;
import cn.edu.guet.mapper.MenuMapper;
import cn.edu.guet.model.Employee;
import cn.edu.guet.model.Menu;
import cn.edu.guet.model.User;
import cn.edu.guet.service.IEmployeeService;
import cn.edu.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/*
Controller把普通的pojo标记为一个控制器（就能接收请求、返回数据）
 */
@RestController
@RequestMapping("user")
public class UserController {
    /*
    自动装配（自动注入）：UserController依赖IUserService，那么Spring会自动装配
     */
    @Autowired
    IUserService userService;
    @Autowired
    MenuMapper menuMapper;

    /**
     * gson（慢）
     * fastjson（漏洞多，速度慢）
     * jackson
     * @param
     * @param
     * @return user的信息（json格式），我们的login方法上使用了@ResponseBody注解后，会自动返回json数据
     */
    @PostMapping("login")
    public Result login(String user_name, String password){
        System.out.println("username: "+user_name);
        System.out.println("password: "+password);
        User user=userService.login(user_name,password);
        if(user!=null){
            return Result.succ(user);
        }else{
            return Result.fail("请求失败");
        }
    }
    @GetMapping("getMenu")
    public Result getMenu(String username){
        return Result.succ(userService.getMenu(username));
    }
}