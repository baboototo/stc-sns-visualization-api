package com.stc.sns.visualization.jpa.domain;

import com.stc.sns.visualization.jpa.domain.user.Account;
import com.stc.sns.visualization.jpa.domain.user.AccountRepository;
import com.stc.sns.visualization.jpa.domain.user.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
@RunWith(SpringRunner.class)
public class AccountCreateTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void createAccount() {
        Account account = new Account("kisd", "qwe123", "강덕승", UserRole.USER, "2");

        accountRepository.save(account);
    }
}
