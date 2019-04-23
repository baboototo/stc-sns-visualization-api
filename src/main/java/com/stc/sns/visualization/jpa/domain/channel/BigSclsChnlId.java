package com.stc.sns.visualization.jpa.domain.channel;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class BigSclsChnlId implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CHNL_LCLS_CD")
    private String chnlLclsCd;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CHNL_MCLS_CD")
    private String chnlMclsCd;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CHNL_SCLS_CD")
    private String chnlSclsCd;

}
