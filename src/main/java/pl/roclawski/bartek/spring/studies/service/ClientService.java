package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.spring.studies.repository.ClientEntity;
import pl.roclawski.bartek.spring.studies.repository.ClientRepository;
import pl.roclawski.bartek.spring.studies.service.mapper.ClientMapper;
import pl.roclawski.bartek.spring.studies.web.model.ClientModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClientService {
    public static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientModel> list() {
        LOGGER.info("list()");
        List<ClientEntity> clientEntities = clientRepository.findAll();

        List<ClientModel> clientModels = clientMapper.transferEntityListToModelList(clientEntities); //fixme change name to
        LOGGER.info("list() = " + clientModels);

        // TODO: 25.03.2023 finish this!
        return clientModels;
    }

    public void create() {
        LOGGER.info("account()");

    }

}
