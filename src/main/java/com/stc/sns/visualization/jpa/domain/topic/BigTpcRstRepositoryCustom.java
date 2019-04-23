package com.stc.sns.visualization.jpa.domain.topic;

import java.util.List;

public interface BigTpcRstRepositoryCustom {

    List<BigTpcRst> findAllByClcDocNum(String clcDocNum);

}
