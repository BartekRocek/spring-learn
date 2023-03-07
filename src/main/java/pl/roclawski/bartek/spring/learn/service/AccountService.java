package pl.roclawski.bartek.spring.learn.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.spring.learn.repository.AccountEntity;
import pl.roclawski.bartek.spring.learn.repository.AccountRepository;
import pl.roclawski.bartek.spring.learn.service.mapper.AccountMapper;
import pl.roclawski.bartek.spring.learn.web.model.AccountModel;

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

    public AccountModel account(AccountModel accountModel) {
        LOGGER.info("account(" + accountModel + ")");
//        String name = accountModel.getName();
//        String department = accountModel.getDepartment();
//
//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setName(name);
//        accountEntity.setDepartment(department);

        AccountEntity accountEntity = accountMapper.from(accountModel);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        AccountModel mappedAccountModel = accountMapper.from(savedAccountEntity);

        return mappedAccountModel;
    }
}

// TODO: 24.02.2023 Napisać test jednostkowy dla AccountService
//  Testowany serwis jest komponentem Springowym
//  Należy pamiętać jak testować komponenty Springowe, patrz AccountRepositoryTest