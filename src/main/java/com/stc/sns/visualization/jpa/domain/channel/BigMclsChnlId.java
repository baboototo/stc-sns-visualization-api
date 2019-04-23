package com.stc.sns.visualization.jpa.domain.channel;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class BigMclsChnlId implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CHNL_LCLS_CD")
    public String chnlLclsCd;


    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CHNL_MCLS_CD")
    public String chnlMclsCd;
}
