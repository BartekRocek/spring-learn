package pl.roclawski.bartek.spring.studies.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.roclawski.bartek.spring.studies.repository.DrummerEntity;
import pl.roclawski.bartek.spring.studies.web.model.DrummerModel;

import java.util.logging.Logger;

@Component
public class DrummerMapper {

    public static final Logger LOGGER = Logger.getLogger(DrummerMapper.class.getName());

    public DrummerEntity from(DrummerModel drummerModel) {
        LOGGER.info("from(" + drummerModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        DrummerEntity drummerEntity = modelMapper.map(drummerModel, DrummerEntity.class);

        LOGGER.info("from(...) = " + drummerEntity);
        return drummerEntity;
    }

    public DrummerModel from(DrummerEntity drummerEntity) {
        LOGGER.info("from(" + drummerEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        DrummerModel drummerModel = modelMapper.map(drummerEntity, DrummerModel.class);

        LOGGER.info("from(...) = " + drummerModel);
        return drummerModel;
    }

}
