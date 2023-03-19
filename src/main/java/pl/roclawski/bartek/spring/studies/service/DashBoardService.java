package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DashBoardService {

    private static final Logger LOGGER = Logger.getLogger(DashBoardService.class.getName());

    public void dashBoard() {
        LOGGER.info("dashBoard() = ");
    }
}
