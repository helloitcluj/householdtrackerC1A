package com.helloit.householdtracker;

import com.helloit.householdtracker.ux.entities.Accounts;
import org.junit.Test;

public class
AccountTest {

    @Test
    public void testAccount() {

        final Accounts entity = new Accounts();
        entity.setName("hello");
        entity.setPassword("world");
    }
}
