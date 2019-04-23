
package com.stc.sns.visualization.jpa.domain.topic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.stc.sns.visualization.jpa.domain.topic.QBigTpcRst.bigTpcRst;


@Repository
public class BigTpcRstRepositoryImpl extends QuerydslRepositorySupport implements BigTpcRstRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BigTpcRstRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigTpcRst.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<BigTpcRst> findAllByClcDocNum(String clcDocNum) {
        return jpaQueryFactory.selectFrom(bigTpcRst)
                .where(bigTpcRst.clcDocNum.eq(clcDocNum))
                .fetch();
    }
}
