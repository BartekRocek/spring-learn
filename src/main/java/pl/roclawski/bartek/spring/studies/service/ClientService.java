package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ClientService {
    public static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    public void client() {
        LOGGER.info("account() = ");

    }

}
