package com.myshop.dao;

import com.myshop.entity.Account;

/**
 * @author Oleksandr Serogin
 */

public interface AccountDAO {

    public Account findAccount(String userName );

}