package com.stc.sns.visualization.mybatis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("DataZoomChartVO")
public class DataZoomChartVO {

    private String xAxis;
    private String series;
    private Long seriesValue;
}
