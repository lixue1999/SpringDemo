package cn.edu.guet;


import cn.edu.guet.common.Result;
import cn.edu.guet.model.Employee;
import cn.edu.guet.model.Menu;
import cn.edu.guet.model.User;
import cn.edu.guet.service.impl.EmployeeServiceImpl;
import cn.edu.guet.service.impl.MenuServiceImpl;
import cn.edu.guet.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class EmployeeTest {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    MenuServiceImpl menuService;
    @Autowired
    UserServiceImpl userService;

    @Test
    public void getAllEmployee(){
        List<Employee> employee=employeeService.viewEmployee();
        for (int i=0;i<employee.size();i++){
            System.out.println(employee.get(i).getEmp_name());
        }
    }
    @Test
    public  void addEmployee(){
        Employee employee=new Employee();
        User user=new User();
        employee.setEmp_id("E0009");
        employee.setEmp_name("qqq");
        employee.setSex("男");
        employee.setPhone("11111111111");
        employee.setEmail("11111@zhangsan.com");
        employee.setBirthday("2010/10/24");
        employee.setDept_id("D0001");
        System.out.println(employee.getDept_id());
        employee.setPos_id("P0001");
        employee.setRole_id("R0001");
        user.setEmp_id("E0009");
        user.setUser_name("qqq");
        user.setPassword("qqq");
        employee.setUser(user);
        System.out.println("bbbbbbbb");
        employeeService.addEmployee(employee);
    }
    @Test
    public void deleteEmployee(){
        String emp_id="E0009";
        employeeService.deleteEmployee(emp_id);
    }
    @Test
    public void updateEmployee(){
        Employee employee=new Employee();
        employee.setEmp_id("E0003");
        employee.setEmp_name("aaa");
        employee.setSex("女");
        employeeService.updateEmployee(employee);
    }
    @Test
    public void getAllMenu(){
        List<Menu> menuList=menuService.getAllMenu();
        for (int i=0;i<menuList.size();i++){
            System.out.println("aaaaaaaaaa"+menuList.get(i).getName());
        }
    }
    @Test
    public void getMenu(){
        String user_name="aa";
        List<Menu> menuList=userService.getMenu(user_name);
        for (int i=0;i<menuList.size();i++){
            System.out.println("aaaaaaaaaa"+menuList.get(i).getName());
            System.out.println("bbbbbbbbbb"+menuList.get(i).getId());
            List<Menu> menus=menuList.get(i).getChildMenus();
            for (int j=0;j<menus.size();j++){
                System.out.println(menus.get(j).getId());
                System.out.println(menus.get(j).getName());
            }
        }
        Result res=Result.succ(menuList);
        System.out.println("ccccccccccc"+res);
    }
}