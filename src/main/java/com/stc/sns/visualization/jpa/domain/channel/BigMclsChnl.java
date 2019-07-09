package com.stc.sns.visualization.jpa.domain.channel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BIG_MCLS_CHNL")
@IdClass(BigMclsChnlPK.class)
public class BigMclsChnl implements Serializable {

    @Id
    @Column(name = "CHNL_LCLS_CD", nullable = false)
    private String chnlLclsCd;

    @Id
    @Column(name = "CHNL_MCLS_CD", nullable = false)
    private String chnlMclsCd;

    @Column(name = "CHNL_MCLS_NM", nullable = false)
    private String chnlMclsNm;

    @Column(name = "DSP_ORD")
    private Long dspOrd;


}
