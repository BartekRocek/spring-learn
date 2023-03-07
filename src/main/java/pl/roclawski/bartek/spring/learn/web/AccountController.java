package pl.roclawski.bartek.spring.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.learn.service.AccountService;
import pl.roclawski.bartek.spring.learn.web.model.AccountModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {

    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //    public String account(String name, String department) {
    //        LOGGER.info("account(" + name + ", " + department + ")");
    @GetMapping // http://localhost:8080/accounts?name=John&department=Sales
    public String account(AccountModel accountModel) {
        LOGGER.info("account(" + accountModel + ")");
        accountService.account(accountModel);

        return "account.html";
    }

}
