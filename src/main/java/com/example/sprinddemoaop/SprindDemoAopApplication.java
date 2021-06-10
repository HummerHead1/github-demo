package com.example.sprinddemoaop;

import com.example.sprinddemoaop.dao.Account;
import com.example.sprinddemoaop.dao.AccountDaoImpl;
import com.example.sprinddemoaop.dao.Configuration;
import com.example.sprinddemoaop.dao.MemberDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SprindDemoAopApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(SprindDemoAopApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        String user = "root";
        String pass = "Eldar2001";

        String jdbcUrl = "jdbc:mysql://localhost:3306/instructions_shema?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";


        System.out.println("Connecting to database: " + jdbcUrl);


        Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

        System.out.println("SUCCESS!!!");

        myConn.close();

        AccountDaoImpl account = context.getBean("accountDaoImpl", AccountDaoImpl.class);

        MemberDao member = context.getBean("memberDao", MemberDao.class);

        Account accountTom = new Account("Janet","Silver");

        account.findAccounts();
        System.out.println("---------------------------");
        System.out.println(account.findAllSilverAccounts());
        System.out.println("hello world!");

        context.close();
    }

}
