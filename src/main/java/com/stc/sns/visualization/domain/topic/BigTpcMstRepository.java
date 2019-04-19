package com.stc.sns.visualization.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BigTpcMstRepository extends JpaRepository<BigTpcMst, String>, BigTpcMstRepositoryCustom {
}
