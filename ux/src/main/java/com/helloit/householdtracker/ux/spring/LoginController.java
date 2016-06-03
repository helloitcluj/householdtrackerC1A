package com.helloit.householdtracker.ux.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 5/25/2016.
 */

@Service
@Controller
@RequestMapping("login")

public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    private static final String MESSAGE_PARAMETER_TAG = "message";
    private static final String Login_Page = "login";
    private static final String SAMPLE_TEXT = "Szia HelloIT ";

    @RequestMapping(method = RequestMethod.POST)

    public String printWelcome(String name, final ModelMap model) {

        LOGGER.info(name);


        return Login_Page;
    }
}

