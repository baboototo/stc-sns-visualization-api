package com.stc.sns.visualization.jpa.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BigTpcTxtAnalRepository extends JpaRepository<BigTpcTxtAnal, String>, BigTpcTxtAnalRepositoryCustom {
    
}
