package cn.edu.guet.mapper;

import cn.edu.guet.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> viewEmployee();
    void addEmployee(@Param("emp_id")String emp_id,@Param("emp_name")String emp_name,@Param("sex")String sex,
                     @Param("phone")String phone,@Param("email") String email,@Param("birthday") Date birthday,
                     @Param("dept_id") String dept_id,@Param("pos_id") String pos_id,@Param("role_id") String role_id);
    void deleteEmployee(@Param("emp_id") String emp_id);
    void updateEmp_name(@Param("emp_id")String emp_id,@Param("emp_name") String emp_name);
    void updateSex(@Param("emp_id")String emp_id,@Param("sex") String sex);
    void updatePhone(@Param("emp_id")String emp_id,@Param("phone") String phone);
    void updateEmail(@Param("emp_id")String emp_id,@Param("email") String email);
    void updateBirthday(@Param("emp_id")String emp_id,@Param("birthday") Date birthday);
    void updateDept_id(@Param("emp_id")String emp_id,@Param("dept_id")String dept_id);
    void updatePos_id(@Param("emp_id")String emp_id,@Param("pos_id")String pos_id);
    void updateRole_id(@Param("emp_id")String emp_id,@Param("role_id")String role_id);
}