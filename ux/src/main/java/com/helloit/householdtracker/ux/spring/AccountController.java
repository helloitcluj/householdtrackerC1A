package com.helloit.householdtracker.ux.spring;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(path = "account")
public class AccountController {

    public static final String CURRENT_PRINCIPAL_TAG = "CurrentPrincipal";
    private static final String SUCCESS = "account/success";

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String create(final ModelMap model, final HttpSession session, final String userName, final String password) {
        final String result = SUCCESS;

        session.setAttribute(CURRENT_PRINCIPAL_TAG, userName);



        return result;
    }


}