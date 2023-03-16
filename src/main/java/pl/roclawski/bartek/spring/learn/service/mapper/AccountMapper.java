package pl.roclawski.bartek.spring.learn.service.mapper;

import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.roclawski.bartek.spring.learn.repository.AccountEntity;
import pl.roclawski.bartek.spring.learn.repository.AccountRepository;
import pl.roclawski.bartek.spring.learn.service.AccountService;
import pl.roclawski.bartek.spring.learn.web.model.AccountModel;

import java.util.logging.Logger;

@Component
public class AccountMapper {

    public static final Logger LOGGER = Logger.getLogger(AccountMapper.class.getName());

//    private final AccountEntity accountEntity; // FIXME: 05.03.2023 which dependency to choose 

//    private final AccountRepository accountRepository;

//    public AccountMapper(AccountEntity accountEntity) {
//        this.accountEntity = accountEntity;
//    }

//    public AccountMapper(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public AccountEntity from(AccountModel accountModel) {
        LOGGER.info("from(" + accountModel + ")");

//        String name = accountModel.getName();
//        String department = accountModel.getDepartment();
//
//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setName(name);
//        accountEntity.setDepartment(department);

        ModelMapper modelMapper = new ModelMapper();
        AccountEntity accountEntity = modelMapper.map(accountModel, AccountEntity.class);

        LOGGER.info("from(...) = " + accountEntity);
        return accountEntity;
    }

    public AccountModel from(AccountEntity accountEntity) {
        LOGGER.info("from(" + accountEntity + ")");

//        String name = accountEntity.getName();
//        String department = accountEntity.getDepartment();
//
//        AccountModel accountModel = new AccountModel();
//        accountModel.setName(name);
//        accountModel.setDepartment(department);

        ModelMapper modelMapper = new ModelMapper();
        AccountModel accountModel = modelMapper.map(accountEntity, AccountModel.class);

        LOGGER.info("from(...) = " + accountModel);
        return accountModel;
    }

    // TODO: 10.03.2023 Drugi from zmodyfikować z wykorzystaniem modelMapper
}

// TODO: 10.03.2023 Umieścić projekt na github
//  dopisać testy jednostkowe dla AccountMapper, test dla czystej Javy, i dla Spring framework, tak jak w teście dla Repository
//  zrobić dla wszystkich metod publicznych loggery na wejściu i wyjściu
//  w POM zmienić learn na studies (1 commit) oraz pakiety (2 commit)

// TODO: 03.03.2023 Dokończyć implementację metody from(), która przypisuje/mapuje
//  pola z AccountModel na pola z AccountEntity, tak jak w metodzie account() w AccountService


// TODO: 10.03.2023 https://modelmapper.org/getting-started/