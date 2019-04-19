package com.stc.sns.visualization.domain.topic;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

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

    @Builder
    public BigTpcRst(String clcDocNum, String askNum, String docNum, String baseDate, String chnlLclsCd, String chnlMclsCd, String chnlSclsCd, String ttlNm, String srcLinkNm, String linkNm, String rsltDesc, String postDate, String ctgrNm, String ctgrLinkNm, String useYn, String spltFnshYn, Time sysRgstDt) {
        this.clcDocNum = clcDocNum;
        this.askNum = askNum;
        this.docNum = docNum;
        this.baseDate = baseDate;
        this.chnlLclsCd = chnlLclsCd;
        this.chnlMclsCd = chnlMclsCd;
        this.chnlSclsCd = chnlSclsCd;
        this.ttlNm = ttlNm;
        this.srcLinkNm = srcLinkNm;
        this.linkNm = linkNm;
        this.rsltDesc = rsltDesc;
        this.postDate = postDate;
        this.ctgrNm = ctgrNm;
        this.ctgrLinkNm = ctgrLinkNm;
        this.useYn = useYn;
        this.spltFnshYn = spltFnshYn;
        this.sysRgstDt = sysRgstDt;
    }
}
