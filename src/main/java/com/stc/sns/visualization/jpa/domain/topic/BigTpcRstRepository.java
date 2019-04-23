package com.stc.sns.visualization.jpa.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BigTpcRstRepository extends JpaRepository<BigTpcRst, String>, BigTpcRstRepositoryCustom {
    
}
