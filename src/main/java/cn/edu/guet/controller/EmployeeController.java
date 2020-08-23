package cn.edu.guet.controller;

import cn.edu.guet.common.Result;
import cn.edu.guet.dt.EmployeeDto;
import cn.edu.guet.exception.updateException;
import cn.edu.guet.model.Employee;
import cn.edu.guet.model.User;
import cn.edu.guet.service.IEmployeeService;
import cn.edu.guet.service.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Controller把普通的pojo标记为一个控制器（就能接收请求、返回数据）
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {


    /*
    自动装配（自动注入）：UserController依赖IUserService，那么Spring会自动装配
     */
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IUserService userService;
     /**
     * gson（慢）
     * fastjson（漏洞多，速度慢）
     * jackson
     * @param
     * @param
     * @return user的信息（json格式），我们的login方法上使用了@ResponseBody注解后，会自动返回json数据
     */
    @PostMapping("viewEmployee")
    public Result viewEmployee(){
        List<Employee> employee=employeeService.viewEmployee();
        List<User> user=userService.viewUser();
        for (int i=0;i<employee.size();i++){
            employee.get(i).setUser(user.get(i));
        }
        return Result.succ(employee);
    }

    @PostMapping("addEmployee")
    public Result addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return Result.succ(200,"添加成功",null);
    }

    @PostMapping("deleteEmployee")
    public Result deleteEmployee(String emp_id){
        employeeService.deleteEmployee(emp_id);
        return Result.succ(200,"删除成功",null);
    }

    @PostMapping("updateEmployee")
    public Result updateEmployee(Employee employee) {
        System.out.println("11111111111111111"+employee.getEmp_id());
        System.out.println("222222222222"+employee.getRole_id());
        System.out.println("3333333333333"+employee.getPhone());
        System.out.println("4444444444444"+employee.getPhone().length());
        if (employee.getEmp_id()!=null&&employee.getEmp_id().length()== 0){
            employee.setEmp_id(null);
        }
        if (employee.getEmp_name()!=null&&employee.getEmp_name().length()== 0){
            employee.setEmp_name(null);
        }
        if (employee.getSex()!=null&&employee.getSex().length()== 0){
            employee.setSex(null);
        }
        if (employee.getPhone()!=null&&employee.getPhone().length()== 0){
            employee.setPhone(null);
        }
        if (employee.getEmail()!=null&&employee.getEmail().length()== 0){
            employee.setEmail(null);
        }
        if (employee.getBirthday()!=null&&employee.getBirthday().length()== 0){
            employee.setBirthday(null);
        }
        if (employee.getDept_id()!=null&&employee.getDept_id().length()== 0){
            employee.setDept_id(null);
        }
        if (employee.getPos_id()!=null&&employee.getPos_id().length()== 0){
            employee.setPos_id(null);
        }
        if (employee.getRole_id()!=null&&employee.getRole_id().length()== 0){
            employee.setRole_id(null);
        }
        if (employee.getUser()!=null){
            User user=new User();
            if (employee.getUser().getUser_name()!=null&&employee.getUser().getUser_name().length()==0){
                user.setUser_name(null);
                employee.setUser(user);
            }
            if (employee.getUser().getPassword()!=null&&employee.getUser().getPassword().length()==0){
                user.setPassword(null);
                employee.setUser(user);
            }
        }
        employeeService.updateEmployee(employee);
        return Result.succ(200,"修改成功",null);
    }
}