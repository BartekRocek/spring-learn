package pl.roclawski.bartek.spring.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.learn.service.DashBoardService;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    private static final Logger LOGGER = Logger.getLogger(DashBoardController.class.getName());

    //    @Autowired
    private final DashBoardService dashBoardService;

    public DashBoardController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping
    public String dashboard(String name) {
        LOGGER.info("dashboard(" + name + ")");
        dashBoardService.dashBoard();
        return "dashboard.html";
    }
}
