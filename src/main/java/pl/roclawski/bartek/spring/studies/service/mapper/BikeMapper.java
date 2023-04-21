package pl.roclawski.bartek.spring.studies.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.roclawski.bartek.spring.studies.repository.BikeEntity;
import pl.roclawski.bartek.spring.studies.web.model.BikeModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class BikeMapper {

    public static final Logger LOGGER = Logger.getLogger(BikeMapper.class.getName());

    public BikeEntity from(BikeModel bikeModel) {
        LOGGER.info("from(" + bikeModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        BikeEntity bikeEntity = modelMapper.map(bikeModel, BikeEntity.class);

        LOGGER.info("from(...)" + bikeEntity);
        return bikeEntity;
    }

    public BikeModel from(BikeEntity bikeEntity) {
        LOGGER.info("from(" + bikeEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        BikeModel bikeModel = modelMapper.map(bikeEntity, BikeModel.class);

        LOGGER.info("from(...)" + bikeModel);
        return bikeModel;
    }

    public List<BikeModel> fromList(List<BikeEntity> bikeEntities) {
        LOGGER.info("fromList(" + bikeEntities + ")");

        return bikeEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
