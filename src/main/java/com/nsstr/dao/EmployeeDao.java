package com.nsstr.dao;

import com.nsstr.pojo.Department;
import com.nsstr.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "AA", "1234545@qq.com", 1, new Department(101, "yibu")));
        employees.put(1002, new Employee(1002, "BB", "1234545@qq.com", 0, new Department(102, "erbu")));
        employees.put(1003, new Employee(1003, "CC", "1234545@qq.com", 1, new Department(103, "sanbu")));
        employees.put(1004, new Employee(1004, "DD", "1234545@qq.com", 0, new Department(104, "sibu")));
        employees.put(1005, new Employee(1005, "EE", "1234545@qq.com", 1, new Department(105, "wubu")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }

}













