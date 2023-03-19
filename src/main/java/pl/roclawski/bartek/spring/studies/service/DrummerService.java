package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.spring.studies.repository.DrummerEntity;
import pl.roclawski.bartek.spring.studies.repository.DrummerRepository;
import pl.roclawski.bartek.spring.studies.service.mapper.DrummerMapper;
import pl.roclawski.bartek.spring.studies.web.model.DrummerModel;

import java.util.logging.Logger;

@Service
public class DrummerService {
    public static final Logger LOGGER = Logger.getLogger(DrummerService.class.getName());

    private final DrummerRepository drummerRepository;

    private final DrummerMapper drummerMapper;

    public DrummerService(DrummerRepository drummerRepository, DrummerMapper drummerMapper) {
        this.drummerRepository = drummerRepository;
        this.drummerMapper = drummerMapper;
    }

    public DrummerModel drummer(DrummerModel drummerModel) {
        LOGGER.info("drummer(" + drummerModel + ")");

        DrummerEntity drummerEntity = drummerMapper.from(drummerModel);
        DrummerEntity savedDrummerEntity = drummerRepository.save(drummerEntity);
        DrummerModel mappedDrummerModel = drummerMapper.from(drummerEntity);

        LOGGER.info("drummer(...) = " + mappedDrummerModel);
        return mappedDrummerModel;
    }
}
