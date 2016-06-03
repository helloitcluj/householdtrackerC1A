package com.helloit.householdtracker.ux.spring;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
@Service
@Controller
@RequestMapping("op")
=======
/**
 * Created by Administrator on 5/25/2016.
 */

@Service
@Controller
@RequestMapping("login")
>>>>>>> origin/master
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    private static final String MESSAGE_PARAMETER_TAG = "message";
<<<<<<< HEAD
    private static final String HELLO_VIEW_TAG = "op";
    private static final String SAMPLE_TEXT = "Szia HelloIT ";

    //@Resource
    ///public IAccountRepository accountRepository;

    //@Transactional
    @RequestMapping(method = RequestMethod.GET)
=======
    private static final String Login_Page = "login";
    private static final String SAMPLE_TEXT = "Szia HelloIT ";

    @RequestMapping(method = RequestMethod.POST)
>>>>>>> origin/master
    public String printWelcome(String name, final ModelMap model) {

        LOGGER.info(name);

<<<<<<< HEAD

       /* final Account entity = new Account();
        entity.setName("hello");
        entity.setPassword("world");
        final Account savedEntity = accountRepository.save(entity);*/

        //model.addAttribute(MESSAGE_PARAMETER_TAG, SAMPLE_TEXT);

        return HELLO_VIEW_TAG;
    }
}
=======
        return Login_Page;
    }
}
>>>>>>> origin/master
