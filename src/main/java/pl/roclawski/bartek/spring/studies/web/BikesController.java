package pl.roclawski.bartek.spring.studies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.studies.service.BikeService;
import pl.roclawski.bartek.spring.studies.web.model.BikeModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/bikes")
public class BikesController {
    private static final Logger LOGGER = Logger.getLogger(BikesController.class.getName());

    private final BikeService bikeService;

    public BikesController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping
    public String listView(ModelMap modelMap) {
        LOGGER.info("listView()");

        List<BikeModel> bikeModels = bikeService.list();
        modelMap.addAttribute("bikes", bikeModels);
        return "bikes";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView");

        return "bike";
    }

    @PostMapping
    public String create(BikeModel bikeModel) {
        LOGGER.info("create(" + bikeModel + ")");

        bikeService.create(bikeModel);
        return "bike";
    }

    @GetMapping(value = "/read")
    public String readView(Long id) {
        LOGGER.info("readView(" + id + ")");
        BikeModel readBikeModel = bikeService.read(id);
        return "bike";
    }
}
