package com.stc.sns.visualization.mybatis.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("BaseRequestParamVO")
public class BaseRequestParamVO {
    private String custId;
    private String keyword;
    private String startDate;
    private String endDate;
}
