package com.stc.sns.visualization.jpa.domain.channel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "BIG_TPC_MST")
public class BigTpcMst implements Serializable {
    @Id
    @Column(name = "ASK_NUM")
    private String askNum;

    @Basic
    @Column(name = "RGTT_ID")
    private String rgttId;

    @Basic
    @Column(name = "SYS_RGST_DT")
    private Time sysRgstDt;

    @Basic
    @Column(name = "CUST_ID")
    private String custId;

    @Basic
    @Column(name = "API_PRVD_NM")
    private String apiPrvdNm;

    @Basic
    @Column(name = "API_TYPE_CD")
    private String apiTypeCd;

    @Basic
    @Column(name = "ASK_STRT_DATE")
    private String askStrtDate;

    @Basic
    @Column(name = "ASK_END_DATE")
    private String askEndDate;

    @Basic
    @Column(name = "ASK_TYPE_NM")
    private String askTypeNm;

    @Basic
    @Column(name = "ASK_NM")
    private String askNm;

    @Basic
    @Column(name = "PRT_ASK_CNT")
    private Long prtAskCnt;

    @Basic
    @Column(name = "MAX_PRT_CNT")
    private Long maxPrtCnt;

    @Basic
    @Column(name = "SRT_TYPE_CD")
    private String srtTypeCd;

    @Basic
    @Column(name = "USE_YN")
    private String useYn;
}
