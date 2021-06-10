package com.example.sprinddemoaop.dao;

import org.aspectj.lang.annotation.After;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Repository
@EnableTransactionManagement(proxyTargetClass = true)
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;


    private String name;
    private String level;

    public String getName() {
        System.out.println("Inside getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("Inside setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println("Inside getLevel()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println("Inside setLevel()");
        this.level = level;
    }

    @Override
    @Transactional
    public void addAccount(Account account) {
        Session session = sessionFactory.openSession();
        System.out.println("Adding new account " + account.getName() + " into the database.");

        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public List<Account> findAccounts() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> accounts = session.createQuery("from Account ").getResultList();
        return accounts;
    }

    @Override
    @Transactional
    public List<Account> findAllSilverAccounts() {
        Session session = sessionFactory.getCurrentSession();
        List<Account> silverAccounts = session.createQuery("from Account a where a.level = 'Silver'").getResultList();
        return silverAccounts;
    }


}
