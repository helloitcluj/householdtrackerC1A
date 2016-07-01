package com.helloit.householdtracker.ux.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private static final String HOME = "homepage";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {

        return HOME;
    }


}