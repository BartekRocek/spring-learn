package pl.roclawski.bartek.spring.learn.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.roclawski.bartek.spring.learn.repository.AccountEntity;
import pl.roclawski.bartek.spring.learn.web.model.AccountModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpringAccountMapperTest {

    public static final String ACCOUNT_NAME_JOHN = "John";
    public static final String ACCOUNT_DEPARTMENT_IT = "IT";
    public static final long ACCOUNT_ID_125 = 125L;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void test() {
        // given
//        AccountMapper accountMapper = new AccountMapper();
        AccountModel accountModel = new AccountModel();
        accountModel.setId(ACCOUNT_ID_125);
        accountModel.setName(ACCOUNT_NAME_JOHN);
        accountModel.setDepartment(ACCOUNT_DEPARTMENT_IT);

        // when
        AccountEntity accountEntity = accountMapper.from(accountModel);

        // then
        Assertions.assertAll(
                () -> assertNotNull(accountEntity, "The entity is null"),
                () -> assertEquals(ACCOUNT_ID_125, accountEntity.getId(), "Account IDs are not equal"),
                () -> assertEquals(ACCOUNT_NAME_JOHN, accountEntity.getName(), "Account names are not equal"),
                () -> assertEquals(ACCOUNT_DEPARTMENT_IT, accountEntity.getDepartment(), "Account departments are not equal")

        );

    }

}
