package com.stc.sns.visualization.mybatis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("BaseChartVO")
public class BaseChartVO {
    private String name;
    private Long value;
}
