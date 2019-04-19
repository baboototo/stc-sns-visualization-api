package com.stc.sns.visualization.domain.channel;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@IdClass(BigMclsChnlId.class)
@Table(name = "BIG_MCLS_CHNL")
public class BigMclsChnl implements Serializable {

    @Id
    @Column(name = "CHNL_LCLS_CD", nullable = false)
    private String chnlLclsCd;

    @Id
    @Column(name = "CHNL_MCLS_CD", nullable = false)
    private String chnlMclsCd;

    @Column(name = "CHNL_MCLS_NM", nullable = false)
    private String chnlMclsNm;

    @Column(name = "DSP_ORD", nullable = false)
    private Long dspOrd;

//    @ManyToOne(fetch = FetchType.EAGER, optional = true)
//    @JoinColumns(value = {
//            @JoinColumn(name = "CHNL_LCLS_CD", updatable = false, insertable = false)
//    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private BigLclsChnl bigLclsChnl;

//    @OneToMany(mappedBy = "bigMclsChnl", fetch = FetchType.LAZY)
//    private List<BigSclsChnl> bigSclsChnls = new ArrayList<>();

    @Builder
    public BigMclsChnl(String chnlLclsCd, String chnlMclsCd, String chnlMclsNm, Long dspOrd) {
        this.chnlLclsCd = chnlLclsCd;
        this.chnlMclsCd = chnlMclsCd;
        this.chnlMclsNm = chnlMclsNm;
        this.dspOrd = dspOrd;
    }
}
