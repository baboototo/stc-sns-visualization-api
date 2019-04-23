package com.stc.sns.visualization.jpa.domain.channel;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@IdClass(BigSclsChnlId.class)
@Table(name = "BIG_SCLS_CHNL", schema = "STC_MDR", catalog = "")
public class BigSclsChnl {
    @Id
    @Column(name = "CHNL_LCLS_CD")
    private String chnlLclsCd;

    @Id
    @Column(name = "CHNL_MCLS_CD")
    private String chnlMclsCd;

    @Id
    @Column(name = "CHNL_SCLS_CD")
    private String chnlSclsCd;

    @Column(name = "CHNL_SCLS_NM")
    private String chnlSclsNm;

    @Column(name = "CLS_DMN")
    private String clsDmn;

    @Column(name = "ABB_DMN")
    private String abbDmn;

    @Column(name = "OPT_DMN")
    private String optDmn;

    @Column(name = "NWS_CHNL_URL")
    private String nwsChnlUrl;

    @Column(name = "DSP_ORD")
    private Long dspOrd;

    @Column(name = "USE_YN")
    private String useYn;

    @Column(name = "RMK")
    private String rmk;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumns(value = {
//            @JoinColumn(name = "CHNL_LCLS_CD", updatable = false, insertable = false),
//            @JoinColumn(name = "CHNL_MCLS_CD", updatable = false, insertable = false)
//    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private BigMclsChnl bigMclsChnl;

    @Builder
    public BigSclsChnl(String chnlLclsCd, String chnlMclsCd, String chnlSclsCd, String chnlSclsNm, String clsDmn, String abbDmn, String optDmn, String nwsChnlUrl, Long dspOrd, String useYn, String rmk) {
        this.chnlLclsCd = chnlLclsCd;
        this.chnlMclsCd = chnlMclsCd;
        this.chnlSclsCd = chnlSclsCd;
        this.chnlSclsNm = chnlSclsNm;
        this.clsDmn = clsDmn;
        this.abbDmn = abbDmn;
        this.optDmn = optDmn;
        this.nwsChnlUrl = nwsChnlUrl;
        this.dspOrd = dspOrd;
        this.useYn = useYn;
        this.rmk = rmk;
    }
}
