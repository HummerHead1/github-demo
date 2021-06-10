package com.example.sprinddemoaop.dao;

import java.util.List;

public interface AccountDao {

    void addAccount(Account account);

    List<Account> findAccounts();

    List<Account> findAllSilverAccounts();
}
