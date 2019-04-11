package com.stc.sns.visualization;

import com.stc.sns.visualization.domain.user.Account;
import com.stc.sns.visualization.domain.user.AccountRepository;
import com.stc.sns.visualization.domain.user.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class StcSnsVisualizationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StcSnsVisualizationApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner bootstrapTestAccount(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            Account account = new Account("baboototo", "qwe123", "STC", UserRole.USER);
//            account.setPassword(passwordEncoder.encode("1234"));
//
//            accountRepository.save(account);
//        };
//    }
}
