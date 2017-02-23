package com.duongvantien.dao.impl;

import com.duongvantien.dao.EmployeeDAO;
import com.duongvantien.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tienduongvan on 22/02/2017.
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public int addEmployee(Employee employee) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer)id;
    }

    public List<Employee> getListEmployee() {
        Session session = this.sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Employee> list = session.createCriteria(Employee.class).list();
        session.close();
        return list;
    }

    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.openSession();
        Employee employee = (Employee) session.load(Employee.class, id);
        return employee;
    }

    @Transactional
    public int updateEmployee(Employee employee) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("AAABBB - "+employee.getId());
        Employee employ = (Employee) session.load(Employee.class, employee.getId());

        employ.setFirstName(employee.getFirstName());
        employ.setFirstName(employee.getLastName());
        employ.setEmail(employee.getEmail());

        session.saveOrUpdate(employ);
        transaction.commit();
        //Serializable id = session.getIdentifier(employee);
        session.close();
        return 1;
    }

    @Transactional
    public int deleteEmployee(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = (Employee)session.load(Employee.class, id);
        session.delete(employee);
        transaction.commit();
        Serializable idE = session.getIdentifier(employee);
        session.close();
        return (Integer)idE;
    }
}
