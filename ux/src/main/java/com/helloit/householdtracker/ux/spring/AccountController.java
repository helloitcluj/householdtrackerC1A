package com.helloit.householdtracker.ux.spring;


import com.helloit.householdtracker.common.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(path = "account")
public class AccountController {

    public static final String CURRENT_PRINCIPAL_TAG = "CurrentPrincipal";
    public static final String SUCCESS = "account/success";
    public static final String ERROR = "account/error";
    public static final String MESSAGE_TAG = "message";
    public static final String FAILED_TO_AUTHENTICATE = "Failed to authenticate!";
    public static final String THE_ACCOUNT_ALREADY_EXISTS = "The account already exists!";
    public static final String NOT_SUCH_CASE = "Not such case!";
    public static final String THE_RETYPED_PASSWORD_DOESN_T_MATCH = "The retyped password doesn't match!";

    @Autowired
    private IAccountService accountService;

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String login(final ModelMap model, final HttpSession session, final String userName, final String password) {
        final String result;


        if (accountService.authenticate(userName, password)) {
            result = "redirect:/";
            session.setAttribute(CURRENT_PRINCIPAL_TAG, userName);
        } else {
            result = ERROR;
            model.addAttribute(MESSAGE_TAG, FAILED_TO_AUTHENTICATE);
        }

        return result;
    }
    @RequestMapping(path = "loginAjax", method = RequestMethod.POST)
    public @ResponseBody  String loginAjax(final HttpSession session, final String userName, final String password) {
        final String result;


        if (accountService.authenticate(userName, password)) {
            result = null;
            session.setAttribute(CURRENT_PRINCIPAL_TAG, userName);
        } else {
            result = FAILED_TO_AUTHENTICATE;


        }

        return result;
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public String create(final ModelMap model, final HttpSession session, final String userName, final String password,
                         final String retypedPassword) {
        final String result;


        final IAccountService.CreationOutcomes authenticate = accountService.createAccount(userName, password, retypedPassword);
        switch (authenticate) {
            case SUCCESS:
                result = SUCCESS;
                break;
            case EXISTING_ACCOUNT:
                result = ERROR;
                model.addAttribute(MESSAGE_TAG, THE_ACCOUNT_ALREADY_EXISTS);
                break;
            case RETYPED_PASSWORD_DO_NOT_MATCH:
                result = ERROR;
                model.addAttribute(MESSAGE_TAG, THE_RETYPED_PASSWORD_DOESN_T_MATCH);
                break;
            default:
                throw new UnsupportedOperationException(NOT_SUCH_CASE);
        }

        return result;
    }

}