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
    private List<String> legend;
    private List<BaseChartVO> series;

    public BaseResultChartVO(String type, List<BaseChartVO> series) {
        this.type = type;
        this.series = series;
        this.createLegendData();
    }

    private void createLegendData() {
        if (this.series != null) {
            this.legend = new ArrayList<>();
            this.series.forEach(baseChartVO -> {
                this.legend.add(baseChartVO.getName());
            });
        }
    }
}
