package com.duongvantien.service.impl;

import com.duongvantien.dao.EmployeeDAO;
import com.duongvantien.model.Employee;
import com.duongvantien.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tienduongvan on 22/02/2017.
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public int addEmployee(Employee employee) {
        return this.employeeDAO.addEmployee(employee);
    }

    public List<Employee> getListEmployee() {
        return this.employeeDAO.getListEmployee();
    }

    public Employee getEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    public int updateEmployee(Employee employee) {
        return this.employeeDAO.updateEmployee(employee);
    }

    public int deleteEmployee(int id) {
        return this.employeeDAO.deleteEmployee(id);
    }
}
