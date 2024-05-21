package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        SessionFactory factory=cfg.buildSessionFactory();
        User u1=new User();
        u1.setUid(133);
        u1.setuName("Arish");
        
        Bank b1=new Bank();
        b1.setBid(15846);
        b1.setBname("Axis Bank");
        u1.setBank(b1);
        
        User u2=new User();
        u2.setUid(134);
        u2.setuName("Akshat");
        
        Bank b2=new Bank();
        b2.setBid(15848);
        b2.setBname("Kotak Bank");
        u2.setBank(b2);
        
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        session.save(u1);
        session.save(u2);
        session.save(b1);	
        session.save(b2);
        
        t.commit();
        session.close();
//        factory.close();
        System.out.println("Data is Saved.");
    }
}
