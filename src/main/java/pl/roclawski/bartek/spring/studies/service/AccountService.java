package pl.roclawski.bartek.spring.studies.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.spring.studies.repository.AccountEntity;
import pl.roclawski.bartek.spring.studies.repository.AccountRepository;
import pl.roclawski.bartek.spring.studies.service.mapper.AccountMapper;
import pl.roclawski.bartek.spring.studies.web.model.AccountModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountService {
    public static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountModel> list() {
        LOGGER.info("list()");
        List<AccountEntity> accountEntities = accountRepository.findAll();

        List<AccountModel> accountModels = accountMapper.fromList(accountEntities);
        LOGGER.info("list() = " + accountModels);
        return accountModels;
    }

    public AccountModel create(AccountModel accountModel) {
        LOGGER.info("create(" + accountModel + ")");
//        String name = accountModel.getName();
//        String department = accountModel.getDepartment();
//
//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setName(name);
//        accountEntity.setDepartment(department);

        AccountEntity accountEntity = accountMapper.from(accountModel);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        AccountModel mappedAccountModel = accountMapper.from(savedAccountEntity);

        LOGGER.info("create(...) = " + mappedAccountModel);
        return mappedAccountModel;
    }

    public AccountModel read(Long id) {


        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(id);
        LOGGER.info("optionalAccountEntity = " + optionalAccountEntity);
        return null; //// FIXME: 13.04.2023 ?????
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        accountRepository.deleteById(id);

    }
}

// TODO: 24.03.2023 Zrobić test dla metody list() z AccountService


// TODO: 24.02.2023 Napisać test jednostkowy dla AccountService
//  Testowany serwis jest komponentem Springowym
//  Należy pamiętać jak testować komponenty Springowe, patrz AccountRepositoryTest