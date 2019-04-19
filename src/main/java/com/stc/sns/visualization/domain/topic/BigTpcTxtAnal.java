package com.stc.sns.visualization.domain.topic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@IdClass(BigTpcTxtAnalId.class)
@Table(name = "BIG_TPC_TXT_ANAL", schema = "STC_MDR")
public class BigTpcTxtAnal {
    @Id
    @Column(name = "CLC_DOC_NUM")
    private String clcDocNum;

    @Id
    @Column(name = "WRD_NM")
    private String wrdNm;

    @Basic
    @Column(name = "DSP_EXP_CNT")
    private Long dspExpCnt;

    @Basic
    @Column(name = "SYS_RGST_DT")
    private Time sysRgstDt;

}
