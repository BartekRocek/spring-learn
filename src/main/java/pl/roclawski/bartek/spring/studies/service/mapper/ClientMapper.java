package pl.roclawski.bartek.spring.studies.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.roclawski.bartek.spring.studies.repository.ClientEntity;
import pl.roclawski.bartek.spring.studies.web.model.ClientModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    public static final Logger LOGGER = Logger.getLogger(ClientMapper.class.getName());

    public ClientEntity from(ClientModel clientModel) {
        LOGGER.info("from(" + clientModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);

        LOGGER.info("from(...) = " + clientEntity);
        return clientEntity;

    }

    public ClientModel from(ClientEntity clientEntity) {
        LOGGER.info("from(" + clientEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ClientModel clientModel = modelMapper.map(clientEntity, ClientModel.class);

        LOGGER.info("from(...) = " + clientModel);
        return clientModel;

    }

    public List<ClientModel> transferEntityListToModelList(List<ClientEntity> clientEntities) {
//    public List<ClientModel> transferListModelToEntityList(List<ClientEntity> clientEntities) {
        // // FIXME: 28.03.2023 should the name not be transferListEntityToListEntity
        LOGGER.info("transferListModelToListEntity(" + clientEntities + ")");

        return clientEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

    }

}
