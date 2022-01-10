package com.nsstr.dao;

import com.nsstr.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();

        departments.put(101, new Department(101, "yi"));
        departments.put(102, new Department(102, "er"));
        departments.put(103, new Department(103, "san"));
        departments.put(104, new Department(104, "si"));
        departments.put(105, new Department(105, "wu"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}
