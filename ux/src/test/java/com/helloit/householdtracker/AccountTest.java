package com.helloit.householdtracker;

import com.helloit.householdtracker.common.entities.Account;
import org.junit.Assert;
import org.junit.Test;

public class
AccountTest {

    @Test
    public void testAccount() {

        final Account entity = new Account();
        entity.setName("hello");
        entity.setPassword("world");
    }
}
