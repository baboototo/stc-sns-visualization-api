package com.stc.sns.visualization.jpa.domain.channel;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.stc.sns.visualization.jpa.domain.channel.QBigTpcMst.bigTpcMst;

@Repository
public class BigTpcMstRepositoryImpl extends QuerydslRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public BigTpcMstRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigTpcMst.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /**
     * 검색 제외 문자 조회
     * @param custId
     * @return
     */
    public List<String> findByExcludeAskNm(String custId) {
        return this.jpaQueryFactory.selectDistinct(bigTpcMst.askNm).from(bigTpcMst)
                .where(bigTpcMst.custId.eq(custId))
                .where(bigTpcMst.useYn.eq("Y"))
                .where(bigTpcMst.apiTypeCd.eq("01")).fetch();
    }

}
