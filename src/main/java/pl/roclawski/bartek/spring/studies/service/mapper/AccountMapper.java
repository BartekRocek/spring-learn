package pl.roclawski.bartek.spring.studies.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.roclawski.bartek.spring.studies.repository.AccountEntity;
import pl.roclawski.bartek.spring.studies.web.model.AccountModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public static final Logger LOGGER = Logger.getLogger(AccountMapper.class.getName());

    public AccountEntity from(AccountModel accountModel) {
        LOGGER.info("from(" + accountModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        AccountEntity accountEntity = modelMapper.map(accountModel, AccountEntity.class);

        LOGGER.info("from(...) = " + accountEntity);
        return accountEntity;
    }

    public AccountModel from(AccountEntity accountEntity) {
        LOGGER.info("from(" + accountEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        AccountModel accountModel = modelMapper.map(accountEntity, AccountModel.class);

        LOGGER.info("from(...) = " + accountModel);
        return accountModel;
    }

    public List<AccountModel> fromList(List<AccountEntity> accountEntities) {
        LOGGER.info("fromList(" + accountEntities + ")");

        return accountEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

    }
}