package pl.roclawski.bartek.spring.studies.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.roclawski.bartek.spring.studies.repository.ClientEntity;
import pl.roclawski.bartek.spring.studies.web.model.ClientModel;

import java.util.List;

@SpringBootTest
class ClientMapperTest {

    public static final String CLIENT_NAME_BART = "Bart";
    public static final String CLIENT_ADDRESS_EZG = "EZG";
    public static final String CLIENT_PHONE_NUMBER_42 = "42 121212";
    public static final String CLIENT_NAME_ANN = "Ann";
    public static final String CLIENT_ADDRESS_WAW = "WAW";
    public static final String CLIENT_PHONE_NUMBER_22 = "22 552255";

    @Autowired
    private ClientMapper clientMapper;

    @Test
    void fromClientModelToClientEntity() {
        // given
        ClientModel clientModel = new ClientModel(CLIENT_NAME_BART, CLIENT_ADDRESS_EZG, CLIENT_PHONE_NUMBER_42);
//        ModelMapper modelMapper = new ModelMapper();

        // when
//        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);
        ClientEntity clientEntity = clientMapper.from(clientModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(clientModel.getName(), clientEntity.getName(), "The name values" +
                        "are not equal"),
                () -> Assertions.assertNotNull(clientEntity, "The clientEntity is null")
        );
    }

    @Test
    void fromClientEntityToClientModel() {
        // given
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(2L);
        clientEntity.setName(CLIENT_NAME_BART);
        clientEntity.setAddress(CLIENT_ADDRESS_EZG);
        clientEntity.setPhoneNumber(CLIENT_PHONE_NUMBER_42);
        ModelMapper modelMapper = new ModelMapper();

        // when
        ClientModel clientModel = modelMapper.map(clientEntity, ClientModel.class); // FIXME: 31.03.2023 Fix this as per 1st test!

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(clientModel.getName(), CLIENT_NAME_BART,
                        "The name value is not " + CLIENT_NAME_BART),
                () -> Assertions.assertEquals(clientModel.getAddress(), CLIENT_ADDRESS_EZG,
                        "The address value is not " + CLIENT_ADDRESS_EZG),
                () -> Assertions.assertEquals(clientModel.getPhoneNumber(), CLIENT_PHONE_NUMBER_42,
                        "The phone number value is not " + CLIENT_PHONE_NUMBER_42)

        );
    }


    @Test
    void transferListEntityToModelList() {
        // given
        ClientEntity clientEntityOne = new ClientEntity();
        clientEntityOne.setId(2L);
        clientEntityOne.setName(CLIENT_NAME_BART);
        clientEntityOne.setAddress(CLIENT_ADDRESS_EZG);
        clientEntityOne.setPhoneNumber(CLIENT_PHONE_NUMBER_42);

        ClientEntity clientEntityTwo = new ClientEntity();
        clientEntityTwo.setId(3L);
        clientEntityTwo.setName(CLIENT_NAME_ANN);
        clientEntityTwo.setAddress(CLIENT_ADDRESS_WAW);
        clientEntityTwo.setPhoneNumber(CLIENT_PHONE_NUMBER_22);

        List<ClientEntity> clientEntities = List.of(clientEntityOne, clientEntityTwo);
        ModelMapper modelMapper = new ModelMapper();
        ClientModel clientModel = new ClientModel();

        // when
        List<ClientModel> clientModelList = clientEntities.stream()
                .map(clientEntity -> modelMapper.map(clientEntity, ClientModel.class))// FIXME: 31.03.2023 Fix this as per 1st test!
                .toList();
        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(clientModelList.size(), clientEntities.size(),
                        "The lists are not of the same size"),
                () -> Assertions.assertEquals(clientModelList.get(0).getName(), clientEntities.get(0).getName(),
                        "The name value is not " + CLIENT_NAME_BART)
        );

    }
}