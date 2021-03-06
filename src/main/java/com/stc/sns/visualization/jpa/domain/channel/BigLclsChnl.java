package com.stc.sns.visualization.jpa.domain.channel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BIG_LCLS_CHNL")
public class BigLclsChnl implements Serializable {

    @Id
    @Column(name = "CHNL_LCLS_CD", nullable = false)
    private String chnlLclsCd;

    @Column(name = "CHNL_LCLS_NM", nullable = false)
    private String chnlLclsNm;

    @Column(name = "DSP_ORD", nullable = false)
    private Long dspOrd;

    @Column(name = "CHNL_LCLS_NM1", nullable = false)
    private String chnlLclsNm1;

}
