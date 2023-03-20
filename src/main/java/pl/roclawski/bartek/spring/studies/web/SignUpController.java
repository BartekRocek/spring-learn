package pl.roclawski.bartek.spring.studies.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.spring.studies.web.model.SignUpModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/signup")
public class SignUpController {
    private static final Logger LOGGER = Logger.getLogger(SignUpController.class.getName());

    @GetMapping
    public String singUpView() {
        LOGGER.info("signUpView()");
        return "signup";
    }

    @PostMapping
//    public String signUp(String login, String password) {
//        LOGGER.info("signUp(" + login + ",   " + password + ")");
    public String signUp(SignUpModel signUpModel) {
        LOGGER.info("signUp(" + signUpModel + ")");


        return "signup";
    }
}
// TODO: 20.03.2023 Rozpropoagować GET-POST na pozostałe controllery w połączeniu z formualrzem HTML 