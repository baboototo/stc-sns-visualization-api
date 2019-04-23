package com.stc.sns.visualization.jpa.domain.channel;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class BigLclsChnlRepositoryImpl extends QuerydslRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public BigLclsChnlRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigLclsChnl.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
