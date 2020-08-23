package cn.edu.guet.service;

import cn.edu.guet.exception.addException;
import cn.edu.guet.exception.deleteException;
import cn.edu.guet.exception.updateException;
import cn.edu.guet.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> viewEmployee();
    void addEmployee(Employee employee) throws addException;
    void deleteEmployee(String emp_id) throws deleteException;
    void updateEmployee(Employee employee) throws updateException;
}
