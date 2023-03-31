package pl.roclawski.bartek.spring.studies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.studies.service.AccountService;
import pl.roclawski.bartek.spring.studies.web.model.AccountModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {

    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String listView(ModelMap modelMap) {
        LOGGER.info("listView()");

        List<AccountModel> accountModels = accountService.list();
        modelMap.addAttribute("accounts", accountModels);
        return "accounts";
    }

    @GetMapping(value = "/create")
    public String accountView() {
        LOGGER.info("accountView()");

        return "account";
    }

    @PostMapping
    public String account(AccountModel accountModel) {
        LOGGER.info("account(" + accountModel + ")");

        accountService.create(accountModel);

        return "account";
    }

}

// TODO: 17.03.2023 Stworzyć wszystkie warstwy (controller, service, mapper i repository)
//  dla dowolnego nowego modelu (drummer) w tym projekcie
//  https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
//  https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#getting-started.introducing-spring-boot
//  https://docs.spring.io/spring-framework/docs/current/reference/html/overview.html#overview

// TODO: 31.03.2023 rozpropagować widok z listą kont do projektu Translation Job 