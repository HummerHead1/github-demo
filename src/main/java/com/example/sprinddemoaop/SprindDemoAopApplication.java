package com.example.sprinddemoaop;

import com.example.sprinddemoaop.dao.Account;
import com.example.sprinddemoaop.dao.AccountDao;
import com.example.sprinddemoaop.dao.MemberDao;
import configuration.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SprindDemoAopApplication {

    public static void main(String[] args) {

        SpringApplication.run(SprindDemoAopApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        AccountDao account = context.getBean("accountDao", AccountDao.class);

        MemberDao member = context.getBean("memberDao", MemberDao.class);

        Account accountJohn = new Account("John","Gold");

        account.addAccount(accountJohn);

        account.accountStart();


        member.addMember();

        member.memberLevel();

        context.close();
    }

}
