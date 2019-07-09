package com.stc.sns.visualization.jpa.domain.channel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BigMclsChnlPK implements Serializable {

    @Id
    @Column(name = "CHNL_LCLS_CD", nullable = false)
    private String chnlLclsCd;

    @Id
    @Column(name = "CHNL_MCLS_CD", nullable = false)
    private String chnlMclsCd;


}
