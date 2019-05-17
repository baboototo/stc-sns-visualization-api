package com.stc.sns.visualization.mybatis.domain;

import lombok.Getter;

@Getter
public enum ChartType {

    PIE("pid");

    private String chartName;

    ChartType(String chartName) {
        this.chartName = chartName;
    }
}
