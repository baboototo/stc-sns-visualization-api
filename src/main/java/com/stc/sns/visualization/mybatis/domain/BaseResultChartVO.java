package com.stc.sns.visualization.mybatis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BaseResultChartVO {
    private String type;
    private List<String>        legendData;
    private List<BaseChartVO>   seriesData;

    public BaseResultChartVO(String type, List<BaseChartVO> seriesData) {
        this.type = type;
        this.seriesData = seriesData;
        this.createLegendData();
    }

    private void createLegendData() {
        if (this.seriesData != null) {
            this.legendData = new ArrayList<>();
            this.seriesData.forEach(baseChartVO -> {
                this.legendData.add(baseChartVO.getName());
            });
        }
    }
}
