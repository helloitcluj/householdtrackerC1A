package com.helloit.householdtracker.ux.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@Controller
@RequestMapping("register")
public class RegisterController {

    private static final Logger LOGGER = LogManager.getLogger(RegisterController.class);

    private static final String MESSAGE_PARAMETER_TAG = "message";
    private static final String HELLO_VIEW_TAG = "register";
    private static final String SAMPLE_TEXT = "Szia HelloIT ";

    //@Resource
    ///public IAccountRepository accountRepository;

    //@Transactional
    @RequestMapping(method = RequestMethod.POST)
    public String printWelcome(String name, final ModelMap model) {

        LOGGER.info(name);

        /*final Account entity = new Account();
        entity.setName("hello");
        entity.setPassword("world");
        final Account savedEntity = accountRepository.save(entity);*/

        //model.addAttribute(MESSAGE_PARAMETER_TAG, SAMPLE_TEXT);

        return HELLO_VIEW_TAG;
    }
}
