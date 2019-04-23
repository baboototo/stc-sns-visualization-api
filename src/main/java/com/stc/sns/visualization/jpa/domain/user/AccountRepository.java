package com.stc.sns.visualization.jpa.domain.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);

}
