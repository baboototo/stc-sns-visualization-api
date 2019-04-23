package com.stc.sns.visualization.security;

import com.stc.sns.visualization.jpa.domain.user.Account;
import com.stc.sns.visualization.jpa.domain.user.UserRole;
import com.stc.sns.visualization.security.jwt.JwtFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
@RunWith(SpringRunner.class)
public class JwtFactoryTest {

    private static final Logger log = LoggerFactory.getLogger(JwtFactoryTest.class);

    private AccountContext context;

    @Autowired
    private JwtFactory factory;

    @Before
    public void setUp() {
        Account account = new Account("baboototo", "qwe123", "곽재영", UserRole.USER);
        log.error("userid: {}, password: {}, role: {}", account.getUserId(), account.getPassword(), account.getUserRole());
        this.context = AccountContext.fromAccountModel(account);
    }

    @Test
    public void TEST_JWT_GENERATE() {
        log.error(factory.generateToken(this.context));
    }
}
