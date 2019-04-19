package com.stc.sns.visualization.domain.topic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.stc.sns.visualization.domain.topic.QBigTpcMst.bigTpcMst;


@Repository
public class BigTpcMstRepositoryImpl extends QuerydslRepositorySupport implements BigTpcMstRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BigTpcMstRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigTpcMst.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<BigTpcMst> findAllByAskNum(String askNum) {
        return jpaQueryFactory.selectFrom(bigTpcMst)
                .where(bigTpcMst.askNum.eq(askNum))
                .fetch();
    }
}
