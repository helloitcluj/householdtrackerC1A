package com.helloit.householdtracker.ux.spring;


import com.helloit.householdtracker.common.entities.Account;
import com.helloit.householdtracker.common.repository.IAccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    public static final String CURRENT_PRINCIPAL_TAG = "CurrentPrincipal";
    private static final String HOME = "homepage";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String create(final ModelMap model, final HttpSession session) {
        final String result;

        final Object currentPrincipal = session.getAttribute(CURRENT_PRINCIPAL_TAG);

        if (currentPrincipal != null) {
            result = HOME;
        } else {
            result = "redirect:/account/login_account.html";
        }


        return result;
    }


}