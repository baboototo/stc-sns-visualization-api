package com.stc.sns.visualization.jpa.domain.channel;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.stc.sns.visualization.jpa.domain.channel.QBigMclsChnl.bigMclsChnl;

@Repository
public class BigMclsChnlRepositoryImpl extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BigMclsChnlRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(BigMclsChnl.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }


    /**
     * SNS 중분류 채널 조회
     * @param chnlLclsCd
     * @return
     */
    public List<String> findByMclsCd(String chnlLclsCd) {
        return this.jpaQueryFactory.select(bigMclsChnl.chnlMclsCd)
                .from(bigMclsChnl)
                .where(bigMclsChnl.chnlLclsCd.eq(chnlLclsCd)).fetch();

    }
}
