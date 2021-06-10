package com.example.sprinddemoaop.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class MemberDao {

    public boolean addMember(){
        System.out.println("Adding new MEMBER into the database!");

        return true;
    }
    public boolean memberLevel(){
        System.out.println("VIP MEMBER level");

        return true;
    }
}
