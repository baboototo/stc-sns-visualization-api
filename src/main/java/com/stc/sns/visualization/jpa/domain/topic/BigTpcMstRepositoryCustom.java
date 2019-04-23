package com.stc.sns.visualization.jpa.domain.topic;

import java.util.List;

public interface BigTpcMstRepositoryCustom {

    List<BigTpcMst> findAllByAskNum(String askNum);

}
