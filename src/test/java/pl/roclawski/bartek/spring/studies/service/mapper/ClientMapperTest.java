package pl.roclawski.bartek.spring.studies.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pl.roclawski.bartek.spring.studies.repository.ClientEntity;
import pl.roclawski.bartek.spring.studies.web.model.ClientModel;

class ClientMapperTest {

    public static final String CLIENT_NAME_BART = "Bart";
    public static final String CLIENT_ADDRESS_EZG = "EZG";
    public static final String CLIENT_PHONE_NUMBER_42 = "42 121212";

    @Test
    void fromClientModelToClientEntity() {
        // given
        ClientModel clientModel = new ClientModel(CLIENT_NAME_BART, CLIENT_ADDRESS_EZG, CLIENT_PHONE_NUMBER_42);
        ModelMapper modelMapper = new ModelMapper();

        // when
        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(clientModel.getName(), clientEntity.getName(), "The value is not "
                        + clientModel.getName()),
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
        ClientModel clientModel = modelMapper.map(clientEntity, ClientModel.class);

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
}