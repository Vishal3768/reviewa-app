package com.vishal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class);
    SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
    void add(Employee employee){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();

    }

    public Employee getEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee emp=session.get(Employee.class,id);
        transaction.commit();
        session.close();
        return emp;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees=new ArrayList<>();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        employees=session.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
        transaction.commit();
        session.close();
        if(employees.isEmpty()){
            return null;
        }
        return employees;
    }

    public Employee updateEmployee(int id,Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (session.get(Employee.class, id) == null) {
            session.update(employee);
        } else {
            transaction.commit();
            session.close();
            return null;
        }
        transaction.commit();
        session.close();
        return employee;
    }

    public void deleteEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
        }
        transaction.commit();
        session.close();
    }

    public BigInteger employeeCount(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select count(*) from employee");
        BigInteger count = (BigInteger) query.uniqueResult();
        transaction.commit();
        session.close();
        return  count;
    }

//    public void addDepartment(Department department) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(department);
//        transaction.commit();
//        session.close();
//    }

}
