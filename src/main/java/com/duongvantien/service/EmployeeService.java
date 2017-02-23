package com.duongvantien.service;

import com.duongvantien.model.Employee;

import java.util.List;

/**
 * Created by tienduongvan on 22/02/2017.
 *
 */
public interface EmployeeService {
    public int addEmployee(Employee employee);
    public List<Employee> getListEmployee();
    public Employee getEmployeeById(int id);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(int id);
}
