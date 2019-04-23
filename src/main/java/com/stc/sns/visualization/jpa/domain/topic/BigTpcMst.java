package com.stc.sns.visualization.jpa.domain.topic;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BIG_TPC_MST", schema = "STC_MDR")
public class BigTpcMst {

    @Id
    @Column(name = "ASK_NUM")
    private String askNum;

    @Column(name = "RGTT_ID")
    private String rgttId;

    @Column(name = "SYS_RGST_DT")
    private Time sysRgstDt;

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "API_PRVD_NM")
    private String apiPrvdNm;

    @Column(name = "API_TYPE_CD")
    private String apiTypeCd;

    @Column(name = "ASK_STRT_DATE")
    private String askStrtDate;

    @Column(name = "ASK_END_DATE")
    private String askEndDate;

    @Column(name = "ASK_TYPE_NM")
    private String askTypeNm;

    @Column(name = "ASK_NM")
    private String askNm;

    @Column(name = "PRT_ASK_CNT")
    private Long prtAskCnt;

    @Column(name = "MAX_PRT_CNT")
    private Long maxPrtCnt;

    @Column(name = "SRT_TYPE_CD")
    private String srtTypeCd;

    @Column(name = "USE_YN")
    private String useYn;

    @Builder
    public BigTpcMst(String askNum, String rgttId, Time sysRgstDt, String custId, String apiPrvdNm, String apiTypeCd, String askStrtDate, String askEndDate, String askTypeNm, String askNm, Long prtAskCnt, Long maxPrtCnt, String srtTypeCd, String useYn) {
        this.askNum = askNum;
        this.rgttId = rgttId;
        this.sysRgstDt = sysRgstDt;
        this.custId = custId;
        this.apiPrvdNm = apiPrvdNm;
        this.apiTypeCd = apiTypeCd;
        this.askStrtDate = askStrtDate;
        this.askEndDate = askEndDate;
        this.askTypeNm = askTypeNm;
        this.askNm = askNm;
        this.prtAskCnt = prtAskCnt;
        this.maxPrtCnt = maxPrtCnt;
        this.srtTypeCd = srtTypeCd;
        this.useYn = useYn;
    }
}
