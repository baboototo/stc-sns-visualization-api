package com.stc.sns.visualization.mybatis.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Alias("BaseRequestParamVO")
public class BaseRequestParamVO {
    private String custId;
    private String keyword;
    private String subKeyword;
    private String startDate;
    private String endDate;
    private String chnlCd;
    private List<String> excludeKeywords;
    private List<String> analyzeKeywords;
    private List<String> channels;
}