package com.stc.sns.visualization.jpa.domain.topic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BIG_TPC_RST", schema = "STC_MDR")
public class BigTpcRst {
    @Id
    @Column(name = "CLC_DOC_NUM")
    private String clcDocNum;

    @Column(name = "ASK_NUM")
    private String askNum;

    @Column(name = "DOC_NUM")
    private String docNum;

    @Column(name = "BASE_DATE")
    private String baseDate;

    @Column(name = "CHNL_LCLS_CD")
    private String chnlLclsCd;

    @Column(name = "CHNL_MCLS_CD")
    private String chnlMclsCd;

    @Column(name = "CHNL_SCLS_CD")
    private String chnlSclsCd;

    @Column(name = "TTL_NM")
    private String ttlNm;

    @Column(name = "SRC_LINK_NM")
    private String srcLinkNm;

    @Column(name = "LINK_NM")
    private String linkNm;

    @Column(name = "RSLT_DESC")
    private String rsltDesc;

    @Column(name = "POST_DATE")
    private String postDate;

    @Column(name = "CTGR_NM")
    private String ctgrNm;

    @Column(name = "CTGR_LINK_NM")
    private String ctgrLinkNm;

    @Column(name = "USE_YN")
    private String useYn;

    @Column(name = "SPLT_FNSH_YN")
    private String spltFnshYn;

    @Column(name = "SYS_RGST_DT")
    private Time sysRgstDt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLC_DOC_NUM")
    private List<BigTpcTxtAnal> bigTpcTxtAnals;

}
