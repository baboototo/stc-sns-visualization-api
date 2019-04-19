package com.stc.sns.visualization.domain.topic;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class BigTpcTxtAnalId implements Serializable {
    @EqualsAndHashCode.Include
    @Column(name = "CLC_DOC_NUM")
    @Id
    private String clcDocNum;

    @EqualsAndHashCode.Include
    @Column(name = "WRD_NM")
    @Id
    private String wrdNm;

}
