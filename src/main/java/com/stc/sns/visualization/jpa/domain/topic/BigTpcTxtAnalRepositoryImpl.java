
package com.stc.sns.visualization.jpa.domain.topic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


@Repository
public class BigTpcTxtAnalRepositoryImpl extends QuerydslRepositorySupport implements BigTpcTxtAnalRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BigTpcTxtAnalRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigTpcTxtAnal.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }


}
