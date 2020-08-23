package cn.edu.guet.service.impl;

import cn.edu.guet.exception.addException;
import cn.edu.guet.exception.deleteException;
import cn.edu.guet.exception.updateException;
import cn.edu.guet.mapper.EmployeeMapper;
import cn.edu.guet.mapper.UserMapper;
import cn.edu.guet.model.Employee;
import cn.edu.guet.model.User;
import cn.edu.guet.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    @Transactional()
    public List<Employee> viewEmployee(){
        return employeeMapper.viewEmployee();
    }

    @Override
    public void addEmployee(Employee employee) throws addException{
        String emp_id=employee.getEmp_id();
        String emp_name=employee.getEmp_name();
        String sex=employee.getSex();
        String phone=employee.getPhone();
        String email=employee.getEmail();
        String date=employee.getBirthday();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birthday= null;
        try {
            birthday = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dept_id=employee.getDept_id();
        String pos_id=employee.getPos_id();
        String role_id=employee.getRole_id();
        String user_name=employee.getEmp_id();
        String password=user_name;
        try {
            employeeMapper.addEmployee(emp_id,emp_name,sex,phone,email,birthday,dept_id,pos_id,role_id);
            userMapper.addUser(emp_id,user_name,password);
        }catch (Exception e){
            e.printStackTrace();
            throw new addException("添加员工失败");
        }
    }

    @Override
    public void deleteEmployee(String emp_id) throws deleteException{
        try {
            userMapper.deleteUser(emp_id);
            employeeMapper.deleteEmployee(emp_id);
        }catch (Exception e){
            e.printStackTrace();
            throw new deleteException("删除员工失败");
        }

    }

    @Override
    public void updateEmployee(Employee employee) throws updateException {
        try {
            String emp_id=employee.getEmp_id();
            if (emp_id!=null){
                String emp_name=employee.getEmp_name();
                String sex=employee.getSex();
                String phone=employee.getPhone();
                String email=employee.getEmail();
                String date=employee.getBirthday();
                String dept_id=employee.getDept_id();
                String pos_id=employee.getPos_id();
                String role_id=employee.getRole_id();
                User user=employee.getUser();
                if (emp_name!=null){
                    System.out.println("aaaaaaaaaa"+emp_name);
                    employeeMapper.updateEmp_name(emp_id,emp_name);
                }
                if (sex!=null){
                    employeeMapper.updateSex(emp_id,sex);
                }
                if (phone!=null){
                    employeeMapper.updatePhone(emp_id,phone);
                }
                if (email!=null){
                    employeeMapper.updateEmail(emp_id,email);
                }
                if (date!=null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    try {
                        employeeMapper.updateBirthday(emp_id, sdf.parse(date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (dept_id!=null){
                    employeeMapper.updateDept_id(emp_id,dept_id);
                }
                if (pos_id!=null){
                    employeeMapper.updatePos_id(emp_id,pos_id);
                }
                if (role_id!=null){
                    employeeMapper.updateRole_id(emp_id,role_id);
                }
                if (user!=null){
                    String user_name=user.getUser_name();
                    String password=user.getPassword();
                    if (user_name!=null){
                        userMapper.updateUser_name(emp_id,user_name);
                    }
                    if (password!=null){
                        userMapper.updatePassword(emp_id,user_name);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new updateException("修改员工失败");
        }

    }
}