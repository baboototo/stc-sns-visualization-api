package com.stc.sns.visualization.domain.topic;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class BigDlyTpcAnalId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "BASE_DATE")
    @Id
    private String baseDate;

    @EqualsAndHashCode.Include
    @Column(name = "CHNL_LCLS_CD")
    @Id
    private String chnlLclsCd;

    @EqualsAndHashCode.Include
    @Column(name = "CHNL_MCLS_CD")
    @Id
    private String chnlMclsCd;

    @EqualsAndHashCode.Include
    @Column(name = "CHNL_SCLS_CD")
    @Id
    private String chnlSclsCd;

    @Builder
    public BigDlyTpcAnalId(String baseDate, String chnlLclsCd, String chnlMclsCd, String chnlSclsCd) {
        this.baseDate = baseDate;
        this.chnlLclsCd = chnlLclsCd;
        this.chnlMclsCd = chnlMclsCd;
        this.chnlSclsCd = chnlSclsCd;
    }
}
