package com.stc.sns.visualization.jpa.domain.channel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigLclsChnlRepository extends JpaRepository<BigLclsChnl, String> {
}