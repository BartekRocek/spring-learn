package pl.roclawski.bartek.spring.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String account(
            AccountModel accountModel, // dane przyjmowane z frontendu
                          ModelMap modelMap) { // dane przesyłane do frontendu
        LOGGER.info("account(" + accountModel + ")");
        accountService.account(accountModel);
        modelMap.addAttribute("account", accountModel); //przesyłanie do frontendu ??
        modelMap.addAttribute("hello", "hello world"); //przesyłanie do frontendu ??

        return "account.html";
    }

}

// TODO: 17.03.2023 Stworzyć wszystkie warstwy (controller, service, mapper i repository)
//  dla dowolnego nowego modelu (drummer) w tym projekcie
//  https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
//  https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#getting-started.introducing-spring-boot
//  https://docs.spring.io/spring-framework/docs/current/reference/html/overview.html#overview