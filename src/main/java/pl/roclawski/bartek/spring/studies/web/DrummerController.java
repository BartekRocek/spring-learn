package pl.roclawski.bartek.spring.studies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.studies.service.AccountService;
import pl.roclawski.bartek.spring.studies.service.DrummerService;
import pl.roclawski.bartek.spring.studies.web.model.DrummerModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/drummers")
public class DrummerController {
    private static final Logger LOGGER = Logger.getLogger(DrummerController.class.getName());

    private final DrummerService drummerService;

    public DrummerController(DrummerService drummerService) {
        this.drummerService = drummerService;
    }

    @GetMapping
    public String drummerView(DrummerModel drummerModel, Model modelMap) {
        LOGGER.info("drummerView(" + drummerModel + ")");

//        drummerService.drummer(drummerModel);
        modelMap.addAttribute("drummer", drummerModel);

        return "drummer";
    }

    @PostMapping
    public String drummer(DrummerModel drummerModel, ModelMap modelMap) {
        LOGGER.info("drummer(" + drummerModel + ")");
//        drummerService.drummer(drummerModel);
        modelMap.addAttribute("drummer", drummerModel);

        return "drummer";
        }


}
