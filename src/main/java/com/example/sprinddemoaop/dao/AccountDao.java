package com.example.sprinddemoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

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

    public void addAccount(Account account){
        System.out.println("Adding new account " + account.getName() + " into the database.");
    }
    public void accountStart(){
        System.out.println("STARTING the new account");
    }
}
