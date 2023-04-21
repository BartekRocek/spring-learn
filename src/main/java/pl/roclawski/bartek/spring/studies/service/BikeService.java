package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.spring.studies.repository.BikeEntity;
import pl.roclawski.bartek.spring.studies.repository.BikeRepository;
import pl.roclawski.bartek.spring.studies.service.mapper.BikeMapper;
import pl.roclawski.bartek.spring.studies.web.model.BikeModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BikeService {
    public static final Logger LOGGER = Logger.getLogger(BikeService.class.getName());

    private final BikeRepository bikeRepository;

    private final BikeMapper bikeMapper;

    public BikeService(BikeRepository bikeRepository, BikeMapper bikeMapper) {
        this.bikeRepository = bikeRepository;
        this.bikeMapper = bikeMapper;
    }

    public List<BikeModel> list() {
        LOGGER.info("list()");
        List<BikeEntity> bikeEntities = bikeRepository.findAll();

        List<BikeModel> bikeModels = bikeMapper.fromList(bikeEntities);

        LOGGER.info("list() = " + bikeModels);
        return bikeModels;
    }

    public BikeModel create(BikeModel bikeModel) {
        LOGGER.info("create(" + bikeModel + ")");

        BikeEntity bikeEntity = bikeMapper.from(bikeModel);
        BikeEntity savedBikeEntity = bikeRepository.save(bikeEntity);
        BikeModel mappedBikeModel = bikeMapper.from(savedBikeEntity);

        LOGGER.info("create(...) = " + mappedBikeModel);
        return mappedBikeModel;
    }

    public BikeModel read(Long id) {
        Optional<BikeEntity> optionalBikeEntity = bikeRepository.findById(id);
        LOGGER.info("optionalBikeEntityEntity = " + optionalBikeEntity);

        return null;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        bikeRepository.deleteById(id);
    }
}
