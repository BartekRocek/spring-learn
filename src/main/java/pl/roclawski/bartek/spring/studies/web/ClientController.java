package pl.roclawski.bartek.spring.studies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.studies.service.ClientService;

import java.util.logging.Logger;

@Controller
@RequestMapping
public class ClientController {
    public static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String listView(ModelMap modelMap) {
        LOGGER.info("modelMap()");

//        clientService
        return null;
    }

}
