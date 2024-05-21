package com.hibernate;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg=new Configuration();
       cfg.configure("hibernate.cfg.xml");
     
       SessionFactory factory= cfg.buildSessionFactory();
       
       Employee emp=new Employee();
       emp.setEmpName("Arish");
       emp.setDesgn("Intern");
       
       Bank b=new Bank();
       b.setBid(581);
       b.setbName("SBI");
       emp.setBank(b);
       
       Employee emp1=new Employee();
       emp1.setEmpName("Adarsh");
       emp1.setDesgn("Full-Time");
       
       Bank b1=new Bank();
       b1.setBid(745);
       b1.setbName("Kotak");
       emp1.setBank(b1);
       
     
       Session session=factory.openSession();
       Transaction t=session.beginTransaction();
       
       session.save(emp);
       session.save(emp1);
       t.commit();
       
       session.close();
       factory.close();
    }
}
