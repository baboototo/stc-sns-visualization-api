package com.stc.sns.visualization.domain.topic;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@IdClass(BigDlyTpcAnalId.class)
@Table(name = "BIG_DLY_TPC_ANAL", schema = "STC_MDR")
public class BigDlyTpcAnal {
    @Id
    @Column(name = "BASE_DATE")
    private String baseDate;

    @Id
    @Column(name = "CHNL_LCLS_CD")
    private String chnlLclsCd;

    @Id
    @Column(name = "CHNL_MCLS_CD")
    private String chnlMclsCd;

    @Id
    @Column(name = "CHNL_SCLS_CD")
    private String chnlSclsCd;

    @Column(name = "DOC_CLC_CNT")
    private Long docClcCnt;

    @Column(name = "SYS_RGST_DT")
    private Time sysRgstDt;

    @Builder
    public BigDlyTpcAnal(String baseDate, String chnlLclsCd, String chnlMclsCd, String chnlSclsCd, Long docClcCnt, Time sysRgstDt) {
        this.baseDate = baseDate;
        this.chnlLclsCd = chnlLclsCd;
        this.chnlMclsCd = chnlMclsCd;
        this.chnlSclsCd = chnlSclsCd;
        this.docClcCnt = docClcCnt;
        this.sysRgstDt = sysRgstDt;
    }
}
